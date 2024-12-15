package gym.Exception;

public class DuplicateClientException extends Exception {
    String msg;
    public DuplicateClientException(String str){
        this.msg=str;
    }
    public String getMessage() {
        return this.msg;
    }
}
