import java.util.ArrayList;
import java.io.*;

class note {

    String fileName = "javaNotes.txt";
    ArrayList<String> params = new ArrayList<String>();

    public note(String[] arguments) {
	
	// Store user options
	for(String param: arguments) {
	    params.add(param);
	}
	
    }


    public void write(String title, String content) {
	System.out.println("Calling write()");
	try {
	    FileWriter fileWriter = new FileWriter(fileName);
	    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
	    
	    bufferedWriter.write(title);
	    bufferedWriter.newLine();
	    bufferedWriter.write(content);
	    bufferedWriter.close();
	} catch(IOException ex) {
	    System.out.print("Your note could not be written.\nPlease try again.");
	}
    }


    
    public void add(String title, String content) {
	String output = String.format("Creating new note called %s:", title);
	System.out.println(output);
	write(title, content);
    }
    

    public void remove(String title) {
	System.out.println("Removing note:");
    }
    

    public void list() {
	System.out.println("Listing all notes:");	
    }
    

    public void view(String title) {
	System.out.println(String.format("Vewing note %s:", title));
    }

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
