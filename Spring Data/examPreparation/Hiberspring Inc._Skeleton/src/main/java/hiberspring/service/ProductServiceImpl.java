package hiberspring.service;

import hiberspring.domain.dtos.ProductImport;
import hiberspring.domain.dtos.ProductWrapper;
import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Product;
import hiberspring.repository.BranchRepository;
import hiberspring.repository.ProductRepository;
import hiberspring.util.ValidationUtils;
import hiberspring.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    private static String PRODUCT_PATH = "src/main/resources/files/products.xml";

    private BranchRepository branchRepository;

    private ModelMapper modelMapper;

    private XmlParser xmlParser;

    private ValidationUtils validationUtils;

    private ProductRepository productRepository;

    public ProductServiceImpl(BranchRepository branchRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtils validationUtils, ProductRepository productRepository) {
        this.branchRepository = branchRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtils = validationUtils;
        this.productRepository = productRepository;
    }

    @Override
    public Boolean productsAreImported() {
        return productRepository.count() > 0;
    }

    @Override
    public String readProductsXmlFile() throws IOException {
        return Files.readString(Path.of(PRODUCT_PATH));
    }

    @Override
    public String importProducts() throws JAXBException {

        StringBuilder sb = new StringBuilder();

        List<ProductImport> product = xmlParser.fromFile(PRODUCT_PATH, ProductWrapper.class).getProduct();

        for (ProductImport productImport : product) {

            Optional<Branch> name = branchRepository.findFirstByName(productImport.getBranch());

            if(!validationUtils.isValid(productImport)){

                sb.append("Error: Invalid data.").append(System.lineSeparator());

                continue;
            }

            Product productToSave = this.modelMapper.map(productImport, Product.class);

            productToSave.setBranch(name.get());

            productRepository.save(productToSave);

            sb.append(String.format("Successfully imported Product %s.",
                    productImport.getName())).append(System.lineSeparator());

        }



        return sb.toString().trim();
    }
}
