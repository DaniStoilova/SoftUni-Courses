package hiberspring.util;

import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

@Component
public class XmlParser {


//    public <T> T fromFile(File file, Class<T> object) throws JAXBException, FileNotFoundException {
//        final JAXBContext context = JAXBContext.newInstance(object);
//        final Unmarshaller unmarshaller = context.createUnmarshaller();
//
//        final FileReader fileReader = new FileReader(file);
//
//        return (T) unmarshaller.unmarshal(fileReader);
//    }
        @SuppressWarnings("unchecked")
        public <T> T fromFile(String filePath, Class<T> tClass) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(tClass);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        return (T) unmarshaller.unmarshal(new File(filePath));
}

}



