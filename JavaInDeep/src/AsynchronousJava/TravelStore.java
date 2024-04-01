package AsynchronousJava;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TravelStore {

    private String name;
    private String distance;
    private LocalDate startTime;

    private LocalDate EndTime;

    public TravelStore(String name, String distance, LocalDate startTime, LocalDate endTime) {
        this.name = name;
        this.distance = distance;
        this.startTime = startTime;
        EndTime = endTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public LocalDate getEndTime() {
        return EndTime;
    }

    public void setEndTime(LocalDate endTime) {
        EndTime = endTime;
    }

    @Override
    public String toString() {
        return "TravelStore{" +
                "name='" + name + '\'' +
                ", distance='" + distance + '\'' +
                ", startTime=" + startTime +
                ", EndTime=" + EndTime +
                '}';
    }
}


