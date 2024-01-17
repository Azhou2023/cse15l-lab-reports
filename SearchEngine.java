import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.

    ArrayList<String> list = new ArrayList<>();
    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            if(list.size()==0){
                return "No results yet.";
            }else{
            return "All results: " + String.join(", ", list);
            }
        } else if (url.getPath().equals("/add")) {
            String[] parameters = url.getQuery().split("=");
            list.add(parameters[1]);
            return String.format("Added %s!", parameters[1]);
        } else if (url.getPath().equals("/search")){
            String[] parameters = url.getQuery().split("=");
            ArrayList<String> results = new ArrayList<>();
            String query = parameters[1];
            for(int i = 0; i<list.size(); i++){
                if(list.get(i).indexOf(query)!=-1){
                    results.add(list.get(i));
                }
            }
            if(results.size()==0){
                return "No results found";
            }else{
                return String.join(", ", results);
            }
        }
        return "404 Not Found!";
        }
    }


class SearchEngine {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
