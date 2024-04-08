package exam.service.impl;

import exam.model.dto.ShopImport;
import exam.model.dto.ShopWrapper;
import exam.model.entity.Shop;
import exam.model.entity.Town;
import exam.repository.ShopRepository;
import exam.repository.TownRepository;
import exam.service.ShopService;
import exam.util.ValidationUtils;
import exam.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service
public class ShopServiceImpl implements ShopService {

    private static String SHOP_PATH = "src/main/resources/files/xml/shops.xml";

    private ShopRepository shopRepository;

    private TownRepository townRepository;

    private ModelMapper modelMapper;

    private ValidationUtils validationUtils;

    private XmlParser xmlParser;

    public ShopServiceImpl(ShopRepository shopRepository, TownRepository townRepository, ModelMapper modelMapper, ValidationUtils validationUtils, XmlParser xmlParser) {
        this.shopRepository = shopRepository;
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return shopRepository.count() > 0;
    }

    @Override
    public String readShopsFileContent() throws IOException {
        return Files.readString(Path.of(SHOP_PATH));
    }

    @Override
    public String importShops() throws JAXBException, FileNotFoundException {

        StringBuilder sb = new StringBuilder();

        List<ShopImport> shops = xmlParser.fromFile(SHOP_PATH, ShopWrapper.class).getShops();


        for (ShopImport shop : shops) {

        if(!validationUtils.isValid(shop) || this.shopRepository.findFirstByName(shop.getName()).isPresent()){

            sb.append("Invalid shop")
                    .append(System.lineSeparator());

            continue;
        }
            Shop shopToSave = this.modelMapper.map(shop, Shop.class);

            Optional<Town> firstByName = this.townRepository.findFirstByName(shop.getTown().getName());

            shopToSave.setTown(firstByName.get());

            this.shopRepository.save(shopToSave);

        sb.append(String.format("Successfully imported Shop %s - %d",
                shop.getName(),
                shop.getIncome()))
                .append(System.lineSeparator());

        }


        return sb.toString().trim();
    }
}
