package softuni.exam.service.impl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ForecastImportWrapper;
import softuni.exam.models.dto.ForecastWrapper;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Forecast;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.ForecastRepository;
import softuni.exam.service.CityService;
import softuni.exam.service.ForecastService;
import softuni.exam.util.ValidationUtils;
import softuni.exam.util.XmlParser;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service
public class ForecastServiceImpl implements ForecastService {


    private static final String FORECAST_PATH = "src/main/resources/files/xml/forecasts.xml";

    private ForecastRepository forecastRepository;

    private CityRepository cityRepository;

    private CityService cityService;


   private ModelMapper modelMapper;

    private XmlParser xmlParser;

    private ValidationUtils validationUtils;

    @Autowired
    public ForecastServiceImpl(ForecastRepository forecastRepository, CityRepository cityRepository, CityService cityService, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtils validationUtils) {
        this.forecastRepository = forecastRepository;
        this.cityRepository = cityRepository;
        this.cityService = cityService;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return forecastRepository.count() > 0;
    }

    @Override
    public String readForecastsFromFile() throws IOException {

        return Files.readString(Path.of(FORECAST_PATH));

    }

    @Override
    public String importForecasts() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();


        xmlParser
                .fromFile(FORECAST_PATH, ForecastWrapper.class)
                .getForecast()
                .stream()
                .filter(forecast -> {
                    boolean isValid = validationUtils.isValid(forecast);

                    Optional<City> byId = cityRepository.findById(forecast.getCity());

                    if (byId.isPresent()) {
                        isValid = false;
                    }

                    Forecast fore = forecastRepository.findAllByCityIdAndDayOfWeek(forecast.getCity(), forecast.getDayOfWeek()).orElse(null);
                    if (fore == null) {
                        isValid = false;
                    }

                    sb
                            .append(isValid
                                    ? String.format("Successfully import forecast %s - %.2f",
                                    forecast.getDayOfWeek(), forecast.getMaxTemperature())
                                    : "Invalid forecast")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(forecastSeedDto -> {
                    Forecast forecast = modelMapper.map(forecastSeedDto, Forecast.class);


                    Optional<City> byId = cityRepository.findById(forecastSeedDto.getCity());

                    forecast.setCity(byId.get());


                    return forecast;
                })
                .forEach(forecastRepository::save);

        return sb.toString();

    }
        @Override
        public String exportForecasts () {

        return null;
        }
    }

