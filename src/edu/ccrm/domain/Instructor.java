package edu.ccrm.domain;
public class Instructor extends Person {
    private String department;
    public Instructor(String id, String name, String email, String dept){
        super(id, name, email);
        this.department = dept;
    }
    @Override
    public String profile(){
        return String.format("Instructor[id=%s, name=%s, dept=%s]", id, fullName, department);
    }
}
