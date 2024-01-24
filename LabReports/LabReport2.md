#Lab Report 2

##Full Chat Server Code:
```
import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {
    
    String chatHistory = "";
    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            if(chatHistory.equals("")){
                return "No messages yet";
            }else{
                return "Chat History:\n" +chatHistory;
            }
        }else{
            String[] arguments = url.getQuery().split("&");
            String[] param1 = arguments[0].split("=");
            String[] param2 = arguments[1].split("=");
            chatHistory += (param2[1]+": "+param1[1]+"\n");
            return "Added message\nChat History:\n" + chatHistory;
        }
        }
    }
    
class ChatServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}

```
<br>

![Image](../Screenshots/LabReport2/Screenshot_1.png) 
When these arguments are passed into the local server URL, methods are first called in the provided Server.java class (not included above because I didn't write it) that passes the URL through to the Handler class above, calling the `handleRequest()` method with the argument "http://localhost:4000/add-message?s=Hey&user=andrew". `handleRequest()` then executes the `else` block, calling `getQuery()` to isolate the query section of the URL (i.e. everything after the question mark). The message and user parts are then further isolated and concatenated onto the `chatHistory` field, which is displayed on the server. The only field that's changed by this request is `chatHistory` (and the `URI url` parameter which isn't really a field). 

    
