package edu.ccrm.domain;
import java.time.LocalDateTime;
public abstract class Person {
    protected final String id;
    protected String fullName;
    protected String email;
    protected final LocalDateTime createdAt;

    public Person(String id, String fullName, String email){
        assert id != null;
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.createdAt = LocalDateTime.now();
    }

    public String getId(){ return id; }
    public String getFullName(){ return fullName; }
    public void setFullName(String fn){ this.fullName = fn; }
    public String getEmail(){ return email; }
    public void setEmail(String e){ this.email = e; }
    public LocalDateTime getCreatedAt(){ return createdAt; }

    public abstract String profile();
}
