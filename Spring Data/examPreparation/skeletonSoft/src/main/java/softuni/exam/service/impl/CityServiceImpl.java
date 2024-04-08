package softuni.exam.service.impl;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CityImportDto;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CityService;
import softuni.exam.util.ValidationUtils;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;



@Service
public class CityServiceImpl implements CityService {

    private static final String CITY_PATH = "src/main/resources/files/json/cities.json";

    private ValidationUtils validationUtil;
    private CityRepository cityRepository;
    private CountryRepository countryRepository;

    private Gson gson;

    private ModelMapper modelMapper;

    public CityServiceImpl(ValidationUtils validationUtil, CityRepository cityRepository, CountryRepository countryRepository, Gson gson, ModelMapper modelMapper) {
        this.validationUtil = validationUtil;

        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return cityRepository.count() > 0;
    }

    @Override
    public String readCitiesFileContent() throws IOException {

        return Files.readString(Path.of(CITY_PATH));
    }

    @Override
    public String importCities() throws IOException {
        StringBuilder sb = new StringBuilder();

        String file = this.readCitiesFileContent();

        CityImportDto[] cityImportDto = gson.fromJson(file, CityImportDto[].class);

        for (CityImportDto city : cityImportDto) {

            Optional<Country> byId = this.countryRepository.findById(city.getCountry());

            if (!validationUtil.isValid(city) || this.cityRepository.findByCityName(city.getCityName()).isPresent() ||
            byId.isEmpty()){
              sb.append("Invalid city")
                      .append(System.lineSeparator());
              continue;
          }

            City city1 = this.modelMapper.map(city, City.class);

            city1.setCountry(byId.get());

            this.cityRepository.save(city1);

          sb.append(String.format("Successfully imported city %s - %d",city.getCityName(),city.getPopulation()))
                    .append(System.lineSeparator());

        }

       return sb.toString();
    }

    @Override
    public City findCityById(Long cityId) {
        return cityRepository.findById(cityId).orElse(null);
    }

}
