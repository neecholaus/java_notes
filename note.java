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
	this.XMLRemove(fileName, title);
    }
    

    // LIST ALL NOTES
    public void list() {
	System.out.println("Listing all notes:");
	this.XMLList(fileName);
    }
    

    // VIEW SPECIFIC NOTE
    public void view(String title) {
	System.out.println(String.format("Viewing note %s:", title));
    }


    // DISPLAY COMMANDS THAT CAN BE USED
    public void help() {
	System.out.println("// ==================== JavaNotes Help ==================== \\\\");
	System.out.println("add ----- Use this command to create a new note with the a title");
	System.out.println("          and content parameter following after.");
	System.out.println("          e.g. java note add \"title\" \"content string\"");
	System.out.println("list ---- This command will list out all notes currently stored");
	System.out.println("          in your notes file.");
	System.out.println("          e.g. java note list");
	System.out.println("remove -- Use remove followed by a title parameter to remove");
	System.out.println("          any notes with an exact matching title.");
	System.out.println("          e.g. java note remove \"title\"");
	System.out.println("edit ---- Use edit followed by title and content parameters ");
	System.out.println("          to replace the note with a matching title.");
	System.out.println("          e.g. java note edit \"title\" \"content string\"");
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
