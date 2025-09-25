# Campus Course & Records Manager (CCRM) - Java SE Project
## Overview
A console-based Java application to manage students, courses, enrollments, grades,
and import/export using NIO.2. This skeleton demonstrates required Java concepts:
OOP (encapsulation, inheritance, polymorphism), enums, Builder pattern, Singleton,
lambdas and Streams, custom exceptions, and basic file operations.

## How to run
- JDK 11+ is recommended.
- Compile:
  ```
  javac -d out $(find src -name "*.java")
  ```
- Run:
  ```
  java -cp out edu.ccrm.cli.Main
  ```

## What is included
- `src/` : Java source organized by packages (edu.ccrm.*)
- `data/` : sample CSV files for import
- `README.md` : this file
- `USAGE.md` : sample commands and notes

## Notes & Mapping (short)
- Student management: `edu.ccrm.service.StudentService`
- Course management: `edu.ccrm.service.CourseService`
- Enrollment & grading: `edu.ccrm.service.EnrollmentService`
- Import/Export: `edu.ccrm.io.ImportExportService`
- Config Singleton: `edu.ccrm.config.AppConfig`
- CLI entrypoint: `edu.ccrm.cli.Main`

## Academic integrity
Use this skeleton as a starting point. Customize and expand to meet your course requirements.
