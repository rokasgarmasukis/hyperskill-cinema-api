package cinema.exceptions;

public class SeatAlreadyPurchasedError {
    private String error = "The ticket has been already purchased!";

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
