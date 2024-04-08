package com.example.json.constants;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;


import java.io.File;

import java.nio.file.Path;


public enum Utils {
    ;

    public static <T> void resultXmlFile(T wrapperXML, Path path) throws JAXBException,IllegalArgumentException {
        final File file = path.toFile();

        final JAXBContext context = JAXBContext.newInstance(wrapperXML.getClass());
        final Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        marshaller.marshal(wrapperXML, file);
    }
}
