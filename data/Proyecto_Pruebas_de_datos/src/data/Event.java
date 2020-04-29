package data;

public class Event {
    private String name;
    private String startDate;
    private String endDate;
    private String id;
    private String description;
    private boolean isActive;
    private boolean isFinished;

    public Event() {
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

