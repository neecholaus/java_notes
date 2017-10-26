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
	System.out.println("Adding note:");
    }

    public void remove(String title) {
	System.out.println("Removing note:");
    }

    public void list() {
	System.out.println("Listing all notes:");
    }

    public void view(String title) {
	System.out.println("Vewing note:");
    }
    

    public static void main(String[] args) {	

	note noteCall = new note(args);

	switch (noteCall.params.get(0)) {
	case "add":
	    noteCall.add("title", "content");
	    break;
	case "remove":
	    noteCall.remove("title");
	    break;
	case "list":
	    noteCall.list();
	    break;
	case "view":
	    noteCall.view("title");
	    break;
	default:
	    noteCall.list();
	    break;
	}
	
	
    }
    
}
