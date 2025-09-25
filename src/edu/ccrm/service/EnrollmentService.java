package edu.ccrm.service;
import edu.ccrm.domain.*;
import edu.ccrm.exceptions.*;
import java.util.*;
public class EnrollmentService {
    private final DataStore ds = DataStore.getInstance();
    private final int MAX_CREDITS = 18;

    public void enroll(Student s, Course c) throws DuplicateEnrollmentException, MaxCreditLimitExceededException {
        if(s.getEnrollments().stream().anyMatch(e -> e.getCourse().getCode().equals(c.getCode()))){
            throw new DuplicateEnrollmentException("Already enrolled in " + c.getCode());
        }
        int current = s.getEnrollments().stream().mapToInt(e -> e.getCourse().getCredits()).sum();
        if(current + c.getCredits() > MAX_CREDITS){
            throw new MaxCreditLimitExceededException("Enrolling would exceed max credits ("+MAX_CREDITS+")");
        }
        Enrollment e = new Enrollment(s, c);
        s.enroll(e);
    }

    public void recordMarks(Student s, String courseCode, double marks){
        s.getEnrollments().stream()
            .filter(e -> e.getCourse().getCode().equals(courseCode))
            .findFirst()
            .ifPresent(e -> e.setMarks(marks));
    }

    public double computeGPA(Student s){
        double totalPoints = s.getEnrollments().stream()
            .filter(e -> e.getGrade()!=null)
            .mapToDouble(e -> e.getCourse().getCredits() * e.getGrade().getPoints())
            .sum();
        int totalCredits = s.getEnrollments().stream()
            .filter(e -> e.getGrade()!=null)
            .mapToInt(e -> e.getCourse().getCredits())
            .sum();
        return totalCredits==0?0.0: totalPoints / totalCredits;
    }
}
