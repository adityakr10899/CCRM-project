package edu.ccrm.cli;
import edu.ccrm.config.AppConfig;
import edu.ccrm.domain.*;
import edu.ccrm.service.*;
import edu.ccrm.io.*;
import edu.ccrm.exceptions.*;
import java.nio.file.*;
import java.util.*;
import java.io.IOException;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentService studentService = new StudentService();
    private static final CourseService courseService = new CourseService();
    private static final EnrollmentService enrollmentService = new EnrollmentService();
    private static final ImportExportService ioService = new ImportExportService();

    public static void main(String[] args) {
        System.out.println("CCRM starting... Data root: " + AppConfig.getInstance().getDataRoot());
        boolean running = true;
        while(running){
            printMenu();
            String choice = scanner.nextLine().trim();
            switch(choice){
                case "1": manageStudents(); break;
                case "2": manageCourses(); break;
                case "3": manageEnrollments(); break;
                case "4": importData(); break;
                case "5": exportData(); break;
                case "0": running=false; break;
                default: System.out.println("Unknown option");
            }
        }
        System.out.println("Goodbye");
    }

    private static void printMenu(){
        System.out.println("--- CCRM Menu ---");
        System.out.println("1. Manage Students");
        System.out.println("2. Manage Courses");
        System.out.println("3. Enrollments/Grades");
        System.out.println("4. Import sample CSVs");
        System.out.println("5. Export data");
        System.out.println("0. Exit");
        System.out.print("Choose: ");
    }

    private static void manageStudents(){
        System.out.println("Enter id,regNo,fullName,email (comma)");
        try{
            String line = scanner.nextLine();
            String[] p = line.split(",");
            Student s = new Student(p[0].trim(), p[1].trim(), p[2].trim(), p[3].trim());
            studentService.addStudent(s);
            System.out.println("Added: " + s);
        }catch(Exception e){ System.out.println("Bad input: " + e.getMessage()); }
    }

    private static void manageCourses(){
        System.out.println("Enter code,title,credits,instructor,semester,department");
        try{
            String line = scanner.nextLine();
            String[] p = line.split(",");
            Course c = new Course.Builder(p[0].trim())
                .title(p[1].trim())
                .credits(Integer.parseInt(p[2].trim()))
                .instructor(p[3].trim())
                .semester(Semester.valueOf(p[4].trim()))
                .department(p[5].trim())
                .build();
            courseService.addCourse(c);
            System.out.println("Added course: " + c);
        }catch(Exception e){ System.out.println("Bad input: " + e.getMessage()); }
    }

    private static void manageEnrollments(){
        System.out.println("Enter studentId,courseCode to enroll");
        String line = scanner.nextLine();
        String[] p = line.split(",");
        try{
            Student s = studentService.findById(p[0].trim()).orElseThrow(() -> new RuntimeException("Student not found"));
            Course c = courseService.findByCode(p[1].trim()).orElseThrow(() -> new RuntimeException("Course not found"));
            enrollmentService.enroll(s, c);
            System.out.println("Enrolled successfully");
        }catch(DuplicateEnrollmentException | MaxCreditLimitExceededException ex){
            System.out.println("Enrollment failed: " + ex.getMessage());
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void importData(){
        try{
            Path root = Paths.get("data/import");
            ioService.importStudents(root.resolve("students.csv"));
            ioService.importCourses(root.resolve("courses.csv"));
            System.out.println("Imported sample CSVs");
        }catch(IOException e){ System.out.println("IO Error: " + e.getMessage()); }
    }

    private static void exportData(){
        try{
            Path out = Paths.get("data/export");
            ioService.exportAll(out.resolve("students_out.csv"), out.resolve("courses_out.csv"));
            System.out.println("Exported data to data/export");
        }catch(IOException e){ System.out.println("Export failed: " + e.getMessage()); }
    }
}
