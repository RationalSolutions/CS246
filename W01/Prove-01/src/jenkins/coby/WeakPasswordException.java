package jenkins.coby;

public class WeakPasswordException extends Exception{
    public WeakPasswordException(){}

    public WeakPasswordException(String msg){
        super(msg);
    }
}
