package cinema.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class SeatAlreadyPurchasedException extends RuntimeException{
    public SeatAlreadyPurchasedException() {
        super("The ticket has been already purchased!");
    }
}
