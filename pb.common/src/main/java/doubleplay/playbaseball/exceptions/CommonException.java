package doubleplay.playbaseball.exceptions;

import doubleplay.playbaseball.code.SystemCode;

public class CommonException extends RuntimeException {
    public CommonException() { }

    public CommonException(String message) {
        super(message);
    }

    public CommonException(SystemCode.COMMON_MESSAGE error) {
        super(error.getLabel() + " (" + error.getCode() + ")");
    }

    public CommonException(SystemCode.COMMON_MESSAGE error, String text) {
        super(error.getLabel() + " (" + error.getCode() + ") : " + text);
    }
}
