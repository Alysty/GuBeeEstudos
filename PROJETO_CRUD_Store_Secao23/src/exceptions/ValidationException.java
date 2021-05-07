package exceptions;

import java.util.HashMap;
import java.util.Map;

public class ValidationException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private Map<String,String> errorsMap = new HashMap<>();


    public ValidationException(String msg){
        super(msg);
    }



    public Map<String, String> getErrorsMap() {
        return errorsMap;
    }

    public void addError (String key, String errorMessage){
        errorsMap.put(key, errorMessage);
    }
}
