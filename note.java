import java.util.ArrayList;

class note {
    

    public note() {

    }

    public void add(String title, String content) {

    }

    public void remove(String title) {
	
    }

    public void list() {
	
    }

    public void view(String title) {
	
    }
    

    public static void main(String[] args) {
	ArrayList<String> params = new ArrayList<String>();
	for(String param: args) {
	    params.add(param);
	}
	System.out.println(params);
    }
    
}
