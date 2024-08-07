import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private int age;
    private String email;
    private String phone;
    private String code;
    private int gender; // 0 - Female, 1 - Male
    private float grade;

    public Student(String name, int age, String email, String phone, String code, int gender, float grade) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.code = code;
        this.gender = gender;
        this.grade = grade;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public float getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", code='" + code + '\'' +
                ", gender=" + (gender == 0 ? "Female" : "Male") +
                ", grade=" + grade +
                '}';
    }
}

public class Main {
    private static List<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add student");
            System.out.println("2. Display all students");
            System.out.println("3. Delete student by code");
            System.out.println("4. Sort students by grade descending");
            System.out.println("5. Search student by name or code");
            System.out.println("6. Search students with grade ");
            System.out.println("7. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayAllStudents();
                    break;
                case 3:
                    deleteStudentByCode();
                    break;
                case 4:
                    sortStudentsByGrade();
                    break;
                case 5:
                    searchStudentByNameOrCode();
                    break;
                case 6:
                    searchStudentsByGrade();
                    break;
                case 7:
                    System.exit(0);
            }
        }
    }

    private static void addStudent() {
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Enter age:");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.println("Enter email:");
        String email = scanner.nextLine();
        System.out.println("Enter phone:");
        String phone = scanner.nextLine();
        System.out.println("Enter code:");
        String code = scanner.nextLine();
        System.out.println("Enter gender (0 for Female, 1 for Male):");
        int gender = scanner.nextInt();
        System.out.println("Enter grade:");
        float grade = scanner.nextFloat();
        scanner.nextLine();  // Consume newline

        Student student = new Student(name, age, email, phone, code, gender, grade);
        studentList.add(student);
    }

    private static void displayAllStudents() {
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    private static void deleteStudentByCode() {
        System.out.println("Enter code:");
        String code = scanner.nextLine();
        studentList.removeIf(student -> student.getCode().equals(code));
    }

    private static void sortStudentsByGrade() {
        studentList.sort((s1, s2) -> Float.compare(s2.getGrade(), s1.getGrade()));
    }

    private static void searchStudentByNameOrCode() {
        System.out.println("Enter name or code:");
        String input = scanner.nextLine();
        for (Student student : studentList) {
            if (student.getName().equalsIgnoreCase(input) || student.getCode().equalsIgnoreCase(input)) {
                System.out.println(student);
            }
        }
    }

    private static void searchStudentsByGrade() {
        System.out.println("Enter grade:");
        float grade = scanner.nextFloat();
        scanner.nextLine();  // Consume newline
        for (Student student : studentList) {
            if (student.getGrade() >= grade) {
                System.out.println(student);
            }
        }
    }
}
