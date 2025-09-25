package edu.ccrm.service;
import edu.ccrm.domain.*;
import java.util.*;
import java.util.stream.*;
public class CourseService {
    private final DataStore ds = DataStore.getInstance();
    public void addCourse(Course c){ ds.addCourse(c); }
    public Optional<Course> findByCode(String code){ return Optional.ofNullable(ds.getCourses().get(code)); }
    public List<Course> listAll(){ return new ArrayList<>(ds.getCourses().values()); }

    // stream filter example
    public List<Course> filterByInstructor(String instructor){
        return ds.getCourses().values().stream()
            .filter(c -> c.getInstructor().equalsIgnoreCase(instructor))
            .collect(Collectors.toList());
    }
}
