import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.util.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;



class XMLCalls {


    // ADD CALL
    public void XMLAdd(String fileName, String title, String content) {
        try {
	    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	    DocumentBuilder db = dbf.newDocumentBuilder();
	    Document document = db.parse(fileName);
	    Element root = document.getDocumentElement();
	    
	    Element newNote = document.createElement("note");
	    newNote.setAttribute("title", title);
	    Element titleEl = document.createElement("title");
	    titleEl.setTextContent(title);
	    Element contentEl = document.createElement("content");
	    contentEl.setTextContent(content);

	    newNote.appendChild(titleEl);
	    newNote.appendChild(contentEl);
	    root.appendChild(newNote);


	    TransformerFactory transformerFactory = TransformerFactory.newInstance();
	    Transformer transformer = transformerFactory.newTransformer();
	    DOMSource source = new DOMSource(document);
	    StreamResult result = new StreamResult(new File("notes.xml"));

	    transformer.transform(source, result);

	    
	    
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (ParserConfigurationException e) {
	    e.printStackTrace();
	} catch (Exception e) {
	    e.printStackTrace();
	} 
    }


    // REMOVE CALL
    public void XMLRemove(String fileName, String title) {
	try {
	    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	    DocumentBuilder db = dbf.newDocumentBuilder();
	    Document document = db.parse(fileName);

	    // Get all document
	    Element allNotes = document.getDocumentElement();
	    // Get all notes in nodelist
	    NodeList notes = allNotes.getElementsByTagName("note");
	    // Loop through all notes
	    for(int i = 0; i < notes.getLength(); i++) {
		Node node = notes.item(i);
		NamedNodeMap attributes = node.getAttributes();
		// Get current note's attribute(s)
		for(int j = 0; j < attributes.getLength(); j++) {
		    Node attr = attributes.item(j);
		    String attrString = attr.getNodeValue();
		    // Check if attribute matches given title
		    if(attrString.equals(title)) {
			// Remove note if match
			allNotes.removeChild(node);
		    }
		}
	    }

	    DOMSource source = new DOMSource(document);
	    StreamResult result = new StreamResult(new File(fileName));

	    Transformer t = TransformerFactory.newInstance().newTransformer();
	    t.transform(source, result);
	    
	} catch(FileNotFoundException e) {
	    e.printStackTrace();
	} catch(ParserConfigurationException e) {
	    e.printStackTrace();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
    

    // LIST CALL
    public void XMLList(String fileName) {
	try {

	    FileReader file = new FileReader(fileName);
	    XMLInputFactory factory = XMLInputFactory.newInstance();
	    XMLEventReader eventReader = factory.createXMLEventReader(file);
	    while(eventReader.hasNext()) {
		XMLEvent event = eventReader.nextEvent();
		if(event.isStartElement()) {
		    StartElement el = event.asStartElement();
		    String elName = el.getName().getLocalPart();
		    if(elName.toString() == "note") {
			System.out.println("------------------------------------");
		    }
		}
		if(event.isCharacters() && !event.asCharacters().isWhiteSpace()) {
		    System.out.println(event.asCharacters().toString().replaceAll("\\n", ""));	
		}
	    }
	    eventReader.close();
	    
	} catch (XMLStreamException e) {
	    e.printStackTrace();
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}	
    }    

    
    public static void main(String[] args) {
	
    }
    
}
