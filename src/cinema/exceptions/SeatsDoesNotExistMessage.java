package cinema.exceptions;

public class SeatsDoesNotExistMessage {
    private String error = "The number of a row or a column is out of bounds!";

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
