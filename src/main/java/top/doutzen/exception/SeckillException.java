package top.doutzen.exception;

/**
 * Created by DoutzenShum on 2017/8/3.
 */
public class SeckillException extends RuntimeException{
    public SeckillException(String message){
        super(message);
    }

    public SeckillException(String message,Throwable cause){
        super(message, cause);
    }
}
