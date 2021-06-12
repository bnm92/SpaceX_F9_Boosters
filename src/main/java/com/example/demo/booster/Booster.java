package com.example.demo.booster;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Booster {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String serialNumber;
    private boolean isOperative;
    private LocalDate firstFlight;
    private LocalDate lastFlight;
    private int timesFlown;

    public Booster() {
    }

    public Booster(
            String serialNumber,
            boolean isOperative,
            LocalDate firstFlight,
            LocalDate lastFlight,
            int timesFlown)
    {
        this.serialNumber = serialNumber;
        this.isOperative = isOperative;
        this.firstFlight = firstFlight;
        this.lastFlight = lastFlight;
        this.timesFlown = timesFlown;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public boolean isOperative() {
        return isOperative;
    }

    public void setOperative(boolean operative) {
        isOperative = operative;
    }

    public LocalDate getFirstFlight() {
        return firstFlight;
    }

    public void setFirstFlight(LocalDate firstFlight) {
        this.firstFlight = firstFlight;
    }

    public LocalDate getLastFlight() {
        return lastFlight;
    }

    public void setLastFlight(LocalDate lastFlight) {
        this.lastFlight = lastFlight;
    }

    public int getTimesFlown() {
        return timesFlown;
    }

    public void setTimesFlown(int timesFlown) {
        this.timesFlown = timesFlown;
    }

    @Override
    public String toString() {
        return "Booster{" +
                "id=" + id +
                ", serialNumber='" + serialNumber + '\'' +
                ", isOperative=" + isOperative +
                ", firstFlight=" + firstFlight +
                ", lastFlight=" + lastFlight +
                ", timesFlown=" + timesFlown +
                '}';
    }
}
