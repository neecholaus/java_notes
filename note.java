import java.util.ArrayList;

class note {

    ArrayList<String> params = new ArrayList<String>();

    public note(String[] arguments) {
	
	// Store user options
	for(String param: arguments) {
	    params.add(param);
	}
	
    }


    
    public void add(String title, String content) {
	String output = String.format("Creating new note called %s:", title);
	System.out.println(output);
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
