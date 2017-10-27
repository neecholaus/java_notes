import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;



class XMLCalls {


    public void parseXML(String fileName) {
	boolean bTitle = false;
	boolean bContent = false;
	try {

	    FileReader file = new FileReader(fileName);
	    XMLInputFactory factory = XMLInputFactory.newInstance();
	    XMLEventReader eventReader = factory.createXMLEventReader(file);

	    while(eventReader.hasNext()) {
		XMLEvent event = eventReader.nextEvent();
		if(event.getEventType() == XMLStreamConstants.CHARACTERS) {
		    Characters characters = event.asCharacters();
		    System.out.println(characters.getData());   
		} else {
		    System.out.println("n/a");
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
