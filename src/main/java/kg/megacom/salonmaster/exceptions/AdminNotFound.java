package kg.megacom.salonmaster.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class AdminNotFound extends RuntimeException{
    public AdminNotFound(String message) {
        super(message);
    }
}
