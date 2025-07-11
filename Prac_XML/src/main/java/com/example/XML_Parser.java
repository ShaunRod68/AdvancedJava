package com.example;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XML_Parser {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        String xmlFile = "src/main/resources/marvel.xml";
        File inputFile = new File(xmlFile);

        //Parse XML
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newDefaultInstance().newDocumentBuilder();
        Document doc = documentBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();

        System.out.println("Root element"+doc.getDocumentElement().getNodeName());
        NodeList empList = doc.getElementsByTagName("Avenger");

        System.out.println("================");
        for (int i = 0;i<empList.getLength();i++){
            Node singlenode = empList.item(i);

            if(singlenode.getNodeType()==Node.ELEMENT_NODE){
                Element singleElement = (Element) singlenode;
                String id = singleElement.getAttribute("id");
                String name = singleElement.getAttribute("name");
                String Value = singleElement.getTextContent();

                System.out.println("ID:"+id);
                System.out.println("Name:"+name);
                System.out.println("Type:"+Value);
                System.out.println("--------------------------------------");
            }
        }
    }
}
