import java.util.ArrayList;
import java.io.*;

class note extends XMLCalls {

    String fileName = "notes.xml";
    ArrayList<String> params = new ArrayList<String>();

    public note(String[] arguments) {	
	// Store user options
	for(String param: arguments) {
	    params.add(param);
	}		
    }


    public void write(String title, String content) {	
	
    }




    // ADDING NEW NOTE
    public void add(String title, String content) {
	String output = String.format("Creating new note called %s:", title);
	this.XMLAdd(fileName, title, content);
    }
    

    // REMOVING CURRENT NOTE
    public void remove(String title) {
	System.out.println("Removing note:");
    }
    

    // LIST ALL NOTES
    public void list() {
	System.out.println("Listing all notes:");
	this.XMLList(fileName);
    }
    

    // VIEW SPECIFIC NOTE
    public void view(String title) {
	System.out.println(String.format("Vewing note %s:", title));
    }


    // DISPLAY COMMANDS THAT CAN BE USED
    public void help() {
	System.out.println("Displaying help:");
    }
    




   
    public static void main(String[] args) {	

	note noteCall = new note(args);

	switch (noteCall.params.get(0)) {
	case "add":
	    noteCall.add(noteCall.params.get(1), noteCall.params.get(2));
	    break;
	case "remove":
	    noteCall.remove(noteCall.params.get(1));
	    break;
	case "list":
	    noteCall.list();
	    break;
	case "view":
	    noteCall.view(noteCall.params.get(1));
	    break;
	case "help":
	    noteCall.help();
	    break;
	default:
	    noteCall.list();
	    break;
	}
	
	
    }
    
}
