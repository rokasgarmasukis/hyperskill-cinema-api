package cinema;

import cinema.exceptions.SeatAlreadyPurchasedError;
import cinema.exceptions.SeatsDoesNotExistMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeatsController {


    Cinema cinema = new Cinema();
    @GetMapping("/seats")
    public Cinema getSeats() {
        return cinema;
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> purchaseSeat(@RequestBody SeatForPurchaseDto seatDto) {
        int row = seatDto.getRow();
        int column = seatDto.getColumn();

        if (row > cinema.getTotalRows() || row < 0 || column > cinema.getTotalColumns() || column < 0) {
            return new ResponseEntity<>(new SeatsDoesNotExistMessage(), HttpStatus.BAD_REQUEST);
        }

        String key = "row:" + row + ",column:" + column;

        Seat seat = cinema.getSeats().get(key);

        if (seat.getSeatStatus() != SeatStatus.AVAILABLE) {
            return new ResponseEntity<>(new SeatAlreadyPurchasedError(), HttpStatus.BAD_REQUEST);
        }

        seat.setSeatStatus(SeatStatus.PURCHASED);

        return new ResponseEntity<>(seat, HttpStatus.OK);
    }
}
