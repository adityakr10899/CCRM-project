package edu.ccrm.io;
import edu.ccrm.domain.*;
import edu.ccrm.service.*;
import java.nio.file.*;
import java.io.IOException;
import java.util.*;
import java.util.stream.*;
import java.nio.charset.StandardCharsets;

public class ImportExportService {
    private final Path dataRoot = AppPaths.getDataRoot();
    private final StudentService studentService = new StudentService();
    private final CourseService courseService = new CourseService();
    public void importStudents(Path csv) throws IOException {
        try(Stream<String> lines = Files.lines(csv, StandardCharsets.UTF_8)){
            lines.skip(1).forEach(l -> {
                String[] parts = l.split(",");
                String id = parts[0].trim();
                String reg = parts[1].trim();
                String name = parts[2].trim();
                String email = parts[3].trim();
                Student s = new Student(id, reg, name, email);
                studentService.addStudent(s);
            });
        }
    }
    public void importCourses(Path csv) throws IOException {
        try(Stream<String> lines = Files.lines(csv, StandardCharsets.UTF_8)){
            lines.skip(1).forEach(l -> {
                String[] p = l.split(",");
                Course c = new Course.Builder(p[0].trim())
                    .title(p[1].trim())
                    .credits(Integer.parseInt(p[2].trim()))
                    .instructor(p[3].trim())
                    .semester(Semester.valueOf(p[4].trim()))
                    .department(p[5].trim())
                    .build();
                courseService.addCourse(c);
            });
        }
    }
    public void exportAll(Path outStudents, Path outCourses) throws IOException {
        Files.createDirectories(outStudents.getParent());
        // export students
        List<String> sLines = studentService.listAll().stream()
            .map(s -> String.join(",", s.getId(), s.getRegNo(), s.getFullName(), s.getEmail()))
            .collect(Collectors.toList());
        sLines.add(0, "id,regNo,fullName,email");
        Files.write(outStudents, sLines, StandardCharsets.UTF_8);
        // export courses
        List<String> cLines = courseService.listAll().stream()
            .map(c -> String.join(",", c.getCode(), c.getTitle(), String.valueOf(c.getCredits()), c.getInstructor(), c.getSemester().name(), c.getDepartment()))
            .collect(Collectors.toList());
        cLines.add(0, "code,title,credits,instructor,semester,department");
        Files.write(outCourses, cLines, StandardCharsets.UTF_8);
    }
}
