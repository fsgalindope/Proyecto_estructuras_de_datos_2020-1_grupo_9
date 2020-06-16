package data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event {
    private String name;
    private DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private String startDate; // Cambio a string para facilitar el guardado de los datos
    private String endDate; // En el momento que la declare convierta de tiemformat a string =>super.getTimeFormat().format(LocalDateTime.now())
    private String id;             //Es decir, Captura la hora y luego la mete en un String
    private String description;
    private boolean isActive;
    private boolean isFinished;

    public void setTimeFormat(DateTimeFormatter timeFormat) {
        this.timeFormat = timeFormat;
    }

    public String getId() {
        return id;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public boolean isIsFinished() {
        return isFinished;
    }

    public Event() {
    }

    public Event(String name, String startDate, String endDate, String id, String description) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.id = id;
        this.description = description;
    }

    public Event(String name, String description) {
        this.name = name;
        this.description = description;
        isActive = false;
        isFinished = false;
    }

    public boolean isActive() {
        return isActive;
    }

    public boolean isFinished() {
        return isFinished;
    }


    public String getName() {
        return name;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getDescription() {
        return description;
    }

    public DateTimeFormatter getTimeFormat() {
        return timeFormat;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void setIsFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }
}
