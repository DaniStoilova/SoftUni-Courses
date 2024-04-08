package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.SellImport;
import softuni.exam.models.dto.SellWrapper;
import softuni.exam.models.entity.Seller;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtils;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {
    private static String SELLER_PATH = "src/main/resources/files/xml/sellers.xml";
    private SellerRepository sellerRepository;

    private ModelMapper modelMapper;

    private XmlParser xmlParser;

    private ValidationUtils validationUtils;

    public SellerServiceImpl(SellerRepository sellerRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtils validationUtils) {
        this.sellerRepository = sellerRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return sellerRepository.count() > 0;
    }

    @Override
    public String readSellersFromFile() throws IOException {
        return Files.readString(Path.of(SELLER_PATH));
    }

    @Override
    public String importSellers() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        List<SellImport> sellImports = xmlParser.fromFile(SELLER_PATH, SellWrapper.class).getSeller();


        for (SellImport sellImport : sellImports) {

            if (!validationUtils.isValid(sellImport)){
                sb.append("Invalid seller")
                        .append(System.lineSeparator());
                continue;
            }

            Seller sellerToSave = this.modelMapper.map(sellImport, Seller.class);

            sellerRepository.save(sellerToSave);

            sb.append(String.format("Successfully import seller %s - %s",
                            sellImport.getLastName(),
                            sellImport.getEmail()))
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
