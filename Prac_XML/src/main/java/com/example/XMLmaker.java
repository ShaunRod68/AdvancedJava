package com.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLmaker {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();

        Element root = document.createElement("Marvel");
        document.appendChild(root);

        Element child = document.createElement("Avengers");
        root.appendChild(child);

        Element grandchild = document.createElement("Avenger");
        grandchild.setAttribute("id", String.valueOf(1));
        grandchild.setAttribute("name","Iron Man");
        grandchild.setTextContent("Human");

        child.appendChild(document.createComment("RED GUY"));
        child.appendChild(grandchild);

        XMLmaker xmLmaker = new XMLmaker();
        xmLmaker.create_grandson(document,child,2,"Captain America","Super Soldier","Blue guy");
        xmLmaker.create_grandson(document,child,3,"Thor","Nurse God","Blonde");



        //Write XML to File
        File dir = new File("src/main/resources");
        File xmlFile = new File(dir,"marvel.xml");
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(xmlFile);

        transformer.transform(source,result);
    }

    private void create_grandson(Document document, Element child, int id, String name, String text,String comment) {
        Element element = document.createElement("Avenger");
        element.setAttribute("id", String.valueOf(id));
        element.setAttribute("name",name);
        element.setTextContent(text);
        child.appendChild(document.createComment(comment));

        child.appendChild(element);
    }
}
