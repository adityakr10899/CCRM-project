# Java Project Repository

## Project Overview & How to Run

This project demonstrates various Java programming concepts aligned with the syllabus. The source code includes examples of exception handling, Stream API usage, file I/O, and assertions.

- **JDK Version:** 11+
- **How to Compile and Run (command line):**
  ```bash
  javac -d out $(find src -name "*.java")
  java -cp out edu.ccrm.Main

* **How to Run in Eclipse:**

  * Import the project as a Java project.
  * Run `edu.ccrm.Main` as a Java application.

---

## Evolution of Java (Short Bullets)

* **Java 1.0 (1996):** Initial release, platform-independent language
* **Java 5 (2004):** Introduced generics, annotations, enhanced for-loop
* **Java 8 (2014):** Lambda expressions, Stream API, new Date-Time API
* **Java 11 (2018):** Long-Term Support (LTS), HTTP client, local-variable syntax
* **Java 17 (2021):** Latest LTS, pattern matching, sealed classes, new APIs

---

## Java ME vs SE vs EE Comparison

| Edition     | Purpose            | Typical Usage                                     |
| ----------- | ------------------ | ------------------------------------------------- |
| **Java ME** | Micro Edition      | Embedded systems, mobile devices                  |
| **Java SE** | Standard Edition   | Desktop and server-side applications              |
| **Java EE** | Enterprise Edition | Large-scale web services, enterprise applications |

---

## JDK / JRE / JVM Explanation

* **JDK (Java Development Kit):** Includes compiler (`javac`), tools, and the runtime environment to develop and run Java applications.
* **JRE (Java Runtime Environment):** Includes the JVM and libraries required to run Java applications but no compiler.
* **JVM (Java Virtual Machine):** Executes Java bytecode and provides platform independence.

---

## Windows Installation Steps

1. Download JDK installer from [Oracle](https://www.oracle.com/java/technologies/downloads/) or [OpenJDK](https://jdk.java.net/).
2. Run the installer and follow the wizard.
3. Set `JAVA_HOME` environment variable:

   * Open System Properties > Advanced > Environment Variables.
   * Create a new variable `JAVA_HOME` pointing to JDK installation directory.
4. Add `%JAVA_HOME%\bin` to the `Path` variable.
5. Verify installation by running:

   ```bash
   java -version
   ```

---

## Eclipse Setup Steps

1. Download and install Eclipse IDE from [eclipse.org](https://www.eclipse.org/downloads/).
2. Open Eclipse and create a new Java Project.
3. Copy source files to the project’s `src` folder.
4. Right-click `Main.java` > Run As > Java Application.
5. Program output should display in the Console.

---

## Notes on Enabling Assertions

* Enable assertions by running Java with the `-ea` flag:

  ```bash
  java -ea -cp out edu.ccrm.AssertionsDemo
  ```
* Assertions are used to verify assumptions in code and can be enabled/disabled at runtime.
* Example assertion in code:

  ```java
  assert x > 0 : "x must be positive";
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


