package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CountryImportDto;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CountryServiceImpl implements CountryService {

    private static final String COUNTRY_PATH = "src/main/resources/files/json/countries.json";


    private CountryRepository countryRepository;

    private Gson gson;

    private ModelMapper modelMapper;

    private ValidationUtils validationUtil;


    public CountryServiceImpl(CountryRepository countryRepository, Gson gson, ModelMapper modelMapper, ValidationUtils validationUtil) {
        this.countryRepository = countryRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return countryRepository.count() > 0;
    }

    @Override
    public String readCountriesFromFile() throws IOException {

        return Files.readString(Path.of(COUNTRY_PATH));
    }

    @Override
    public String importCountries() throws IOException {

        StringBuilder sb = new StringBuilder();

        String file = this.readCountriesFromFile();

        List<CountryImportDto> countries
                = Arrays.stream(gson.fromJson(file, CountryImportDto[].class))
                .collect(Collectors.toList());


        //CountryImportDto[] countryImportDto = gson.fromJson(file, CountryImportDto[].class);

        for (CountryImportDto country : countries) {

            if (!validationUtil.isValid(country) ||
                    this.countryRepository.findFirstByCountryName(country.getCountryName()).isPresent()){

                sb.append("Invalid country");
                continue;
            }

            Country country1 = this.modelMapper.map(country, Country.class);

            this.countryRepository.save(country1);

            sb.append(String.format("Successfully imported country %s - %s",
                    country.getCountryName(),
                    country.getCurrency()));

        }

        return sb.toString();
    }

}
