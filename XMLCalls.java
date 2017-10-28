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
		    if(elName.toString() == "note"){
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
