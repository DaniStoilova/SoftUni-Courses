package softuni.exam.service;



import softuni.exam.models.entity.Car;
import softuni.exam.repository.CarRepository;

import java.io.IOException;


public interface CarService {


    boolean areImported();

    String readCarsFileContent() throws IOException;
	
	String importCars() throws IOException;

    String getCarsOrderByPicturesCountThenByMake();


}
