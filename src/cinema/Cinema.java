package cinema;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cinema {
    private int totalRows = 9;
    private int totalColumns = 9;

    @JsonIgnore
    private Map<String, Seat> seats = new ConcurrentHashMap<>();

    @JsonProperty
    public List<Seat> availableSeats() {
        return new ArrayList<>(seats.values());
    }

    public Cinema() {
        String key = "";
        for (int i = 1; i <= totalRows; i++) {
            for (int j = 1; j <= totalColumns; j++) {
                key = "row:" + i + ",column:" + j;
                seats.put(key, new Seat(i, j));

            }
        }
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getTotalColumns() {
        return totalColumns;
    }

    public void setTotalColumns(int totalColumns) {
        this.totalColumns = totalColumns;
    }


    public Map<String, Seat> getSeats() {
        return seats;
    }

    public void setSeats(Map<String, Seat> seats) {
        this.seats = seats;
    }
}
