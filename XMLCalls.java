import java.io.FileNotFoundException;
import java.io.FileReader;
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




class XMLCalls {


    // ADD CALL
    public void XMLAdd(String fileName, String title, String content) {
	try {
	    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	    DocumentBuilder db = dbf.newDocumentBuilder();
	    Document document = db.parse(fileName);
	    Element root = document.getDocumentElement();

	    Collection<String> notes = new ArrayList<String>();
	
	    Element newNote = document.createElement("note");
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (ParserConfigurationException e) {
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
