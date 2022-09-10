package com.javarush.task.task33.task3309;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

/* 
Комментарий внутри xml
*/

public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws ParserConfigurationException, JAXBException, TransformerException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setCoalescing(true);
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.newDocument();


        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(obj, doc);

        NodeList nodeList = doc.getElementsByTagName(tagName);

        for(int i = 0; i < nodeList.getLength(); i++){
            Node node = nodeList.item(i);
            //node.getParentNode().insertBefore(doc.createTextNode("\n"), node);
            node.getParentNode().insertBefore(doc.createComment(comment), node);
            //node.getParentNode().insertBefore(doc.createTextNode("\n"), node);

        }

        StringWriter writer = new StringWriter();
        //TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "no");
        transformer.transform(new DOMSource(doc), new StreamResult(writer));


        return writer.toString();
    }

    public static void main(String[] args) throws JAXBException, ParserConfigurationException, TransformerException {
        System.out.println(Solution.toXmlWithComment(new First(), "second", "it's a comment"));

    }
}
