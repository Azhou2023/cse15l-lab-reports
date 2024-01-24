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

    
