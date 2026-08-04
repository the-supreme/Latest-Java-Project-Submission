

package counselormgmtsystem;

//abstract because dont want to randomly create a user object
public abstract class User {
    protected String ID;
    protected String username;
    protected String password;
    protected String fullName;
    protected String status;


    //constructor
    public User(String ID, String username, String password, String fullName, String status) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.status = status;
    }

    // getter & setter
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }    
    
    public String getPassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }    
    
    public String getfullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }   
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
        
}
