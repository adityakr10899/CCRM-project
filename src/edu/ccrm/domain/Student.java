package edu.ccrm.domain;
import java.time.LocalDate;
import java.util.*;
public class Student extends Person {
    public enum Status { ACTIVE, INACTIVE }
    private String regNo;
    private Status status;
    private final Map<String, Enrollment> enrolledCourses = new HashMap<>();
    private LocalDate dob;

    public Student(String id, String regNo, String fullName, String email){
        super(id, fullName, email);
        this.regNo = regNo;
        this.status = Status.ACTIVE;
    }

    public String getRegNo(){ return regNo; }
    public void setRegNo(String r){ this.regNo = r; }
    public Status getStatus(){ return status; }
    public void deactivate(){ this.status = Status.INACTIVE; }

    public void enroll(Enrollment e){
        enrolledCourses.put(e.getCourse().getCode(), e);
    }
    public void unenroll(String courseCode){
        enrolledCourses.remove(courseCode);
    }
    public Collection<Enrollment> getEnrollments(){ return enrolledCourses.values(); }

    @Override
    public String profile(){
        return String.format("Student[id=%s, reg=%s, name=%s, email=%s, status=%s]", id, regNo, fullName, email, status);
    }

    @Override
    public String toString(){
        return profile();
    }
}
