package edu.ccrm.service;
import edu.ccrm.domain.*;
import java.util.*;
public class StudentService {
    private final DataStore ds = DataStore.getInstance();

    public void addStudent(Student s){ ds.addStudent(s); }
    public Optional<Student> findById(String id){ return Optional.ofNullable(ds.getStudents().get(id)); }
    public List<Student> listAll(){ return new ArrayList<>(ds.getStudents().values()); }
}
