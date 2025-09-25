package edu.ccrm.domain;
import java.time.LocalDateTime;
public class Enrollment {
    private final Student student;
    private final Course course;
    private final LocalDateTime enrolledAt;
    private Double marks; // nullable
    public Enrollment(Student s, Course c){
        this.student = s;
        this.course = c;
        this.enrolledAt = LocalDateTime.now();
    }
    public Student getStudent(){ return student; }
    public Course getCourse(){ return course; }
    public LocalDateTime getEnrolledAt(){ return enrolledAt; }
    public void setMarks(double m){ this.marks = m; }
    public Double getMarks(){ return marks; }
    public Grade getGrade(){
        return marks==null? null : Grade.fromScore(marks);
    }
    @Override
    public String toString(){
        return String.format("Enrollment[student=%s, course=%s, marks=%s]",
            student.getRegNo(), course.getCode(), marks==null?"-":marks.toString());
    }
}
