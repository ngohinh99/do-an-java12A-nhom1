package Model;

import java.time.LocalDate;

public class Information {
    private String information;
    private LocalDate daySubmitted;
    
    public String getInformation() {
        return information;
    }
    public void setInformation(String information) {
        this.information = information;
    }
    public LocalDate getDaySubmitted() {
        return daySubmitted;
    }
    public void setDaySubmitted(LocalDate daySubmitted) {
        this.daySubmitted = daySubmitted;
    }
    @Override
    public String toString() {
        return information + " " + daySubmitted + "\n";
    }
    
}
