package isntkyu.core.lifecycle;

public class NetworkClient  {

    private String url;

    public NetworkClient() {
        System.out.println("url = " + url);

    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    public void connect() {
        System.out.println("connect= " + url);
    }
    
    public void call(String message) {
        System.out.println("url = " + url + " message = " + message);
    }

    public void disconnect(){
        System.out.println("close = " + url);
    }

    public void init() {
        System.out.println("init");
        connect();
        call("초기화 메시지");
    }

    public void close(){
        System.out.println("close");
        disconnect();
    }
}
