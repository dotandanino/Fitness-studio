package gym.Exception;

public class ClientNotRegisteredException extends Exception {
    String msg;
    public ClientNotRegisteredException(String str){
        this.msg=str;
    }
    public String getMessage(){
        return(this.msg);
    }
}
