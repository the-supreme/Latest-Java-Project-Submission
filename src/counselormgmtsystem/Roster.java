package counselormgmtsystem;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Roster {
    protected String rosterID;
    protected String counselorID;
    protected String date;
    protected String startTime;
    protected String endTime;

    public Roster(String rosterID, String counselorID, String date, String startTime, String endTime) {
        this.rosterID = rosterID;
        this.counselorID = counselorID;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    
    //getters
    public String getRosterID() { 
        return rosterID; 
    }
    
    public String getCounselorID() { 
        return counselorID; 
    }
    
    public String getDate() { 
        return date; 
    }
    
    public String getStartTime() { 
        return startTime; 
    }
    
    public String getEndTime() { 
        return endTime; 
    }
    
    //setters
    public void setRosterID(String rosterID) { 
        this.rosterID = rosterID; 
    }
    
    public void setCounselorID(String counselorID) { 
        this.counselorID = counselorID; 
    }
    
    public void setDate(String date) { 
        this.date = date; 
    }
    
    public void setStartTime(String startTime) { 
        this.startTime = startTime;
    }
    
    public void setEndTime(String endTime) {
        this.endTime = endTime; 
    } 
}
