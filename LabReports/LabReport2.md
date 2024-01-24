```
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
```
