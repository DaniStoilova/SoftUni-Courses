package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dto.LaptopImport;
import exam.model.entity.Laptop;
import exam.model.entity.Shop;
import exam.repository.LaptopRepository;
import exam.repository.ShopRepository;
import exam.service.LaptopService;
import exam.util.ValidationUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LaptopServiceImpl implements LaptopService {

    private static String LAPTOP_PATH = "src/main/resources/files/json/laptops.json";

    private LaptopRepository laptopRepository;

    private ShopRepository shopRepository;


    private ModelMapper modelMapper;

    private ValidationUtils validationUtils;

    private Gson gson;

    public LaptopServiceImpl(LaptopRepository laptopRepository, ShopRepository shopRepository, ModelMapper modelMapper, ValidationUtils validationUtils, Gson gson) {
        this.laptopRepository = laptopRepository;
        this.shopRepository = shopRepository;

        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return laptopRepository.count() > 0;
    }

    @Override
    public String readLaptopsFileContent() throws IOException {
        return Files.readString(Path.of(LAPTOP_PATH));
    }

    @Override
    public String importLaptops() throws IOException {
        StringBuilder sb = new StringBuilder();

        String fileContent = this.readLaptopsFileContent();


        List<LaptopImport> collect = Arrays.stream(gson.fromJson(fileContent, LaptopImport[].class)).collect(Collectors.toList());

        for (LaptopImport laptop : collect) {
            if (!validationUtils.isValid(laptop) ||
            laptopRepository.findFirstByMacAddress(laptop.getMacAddress()).isPresent()){
                sb.append("Invalid Laptop")
                        .append(System.lineSeparator());
                continue;
            }


            Laptop laptopToSave = modelMapper.map(laptop, Laptop.class);

            Optional<Shop> firstByName = this.shopRepository.findFirstByName(laptop.getShop().getName());

            laptopToSave.setShop(firstByName.get());

            this.laptopRepository.save(laptopToSave);

            sb.append(String.format("Successfully imported Laptop %s - %.2f - %d - %d",
                            laptop.getMacAddress(),
                            laptop.getCpuSpeed(),
                            laptop.getRam(),
                            laptop.getStorage()))
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

    @Override
    public String exportBestLaptops() {

        StringBuilder sb = new StringBuilder();

//        List<Laptop> laptops = laptopRepository
//                .findByShop_NameAndShop_Town_NameOrderByCpuSpeedDescRamDescStorageDescMacAddressAsc();
//
//        laptops.forEach(el->
//                sb.append(String.format(
//                        "Laptop - %s\n" +
//                        "*Cpu speed - %.2f\n" +
//                        "**Ram - %d\n" +
//                        "***Storage - %d\n" +
//                        "****Price -%.2f\n" +
//                        "#Shop name - %s\n" +
//                        "##Town - %s\n",
//                        el.getMacAddress(),
//                        el.getCpuSpeed(),
//                        el.getRam(),
//                        el.getStorage(),
//                        el.getPrice(),
//                        el.getShop().getName(),
//                        el.getShop().getTown().getName())));

         laptopRepository
                .findAll().forEach(el->
                sb.append(String.format(
                        "Laptop - %s\n" +
                                "*Cpu speed - %.2f\n" +
                                "**Ram - %d\n" +
                                "***Storage - %d\n" +
                                "****Price -%.2f\n" +
                                "#Shop name - %s\n" +
                                "##Town - %s\n",
                        el.getMacAddress(),
                        el.getCpuSpeed(),
                        el.getRam(),
                        el.getStorage(),
                        el.getPrice(),
                        el.getShop().getName(),
                        el.getShop().getTown().getName())));


        return sb.toString().trim();
    }
}
