package com.example;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class XML_Validator extends DefaultHandler {
    public static void main(String[] args) {
        String xmlFile = "src/main/resources/marvel.xml";

        try {
            XML_Validator validator = new XML_Validator();
            validator.validate(xmlFile);
            System.out.println("Validation Complete");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void validate(String xmlFile) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setValidating(true);
        factory.setNamespaceAware(true);

        SAXParser parser = factory.newSAXParser();
        XMLReader reader = parser.getXMLReader();
        reader.setErrorHandler(this);

        reader.parse(new InputSource(xmlFile));
    }

}
