package cinema;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Seat {
    private int column;
    private int row;

    private int price;

    @JsonIgnore
    private SeatStatus seatStatus = SeatStatus.AVAILABLE;

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        price = row <= 4 ? 10 : 8;

    }

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(SeatStatus seatStatus) {
        this.seatStatus = seatStatus;
    }


    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
