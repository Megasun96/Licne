package osobe;

import java.util.Scanner;
import java.util.regex.*;
import java.util.ArrayList;

public class Test2 {

    static ArrayList<Employee> employeeList = new ArrayList<>();
    static ArrayList<ElementaryStudent> elemStudList = new ArrayList<>();
    static ArrayList<Student> studentList = new ArrayList<>();

    //dodavanje objekta student u studentList
    public static void nextStudent(int i) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("date of birthey: ");
        String dateOfBirth = sc.nextLine();
        System.out.print("address: ");
        String address = sc.nextLine();
        System.out.print("Faculty: ");
        String faculty = sc.nextLine();
        System.out.print("Direction: ");
        String direction = sc.nextLine();
        System.out.print("Enrollment Year: ");
        int enYear = 1999;
        if (sc.hasNextInt()) {
            enYear = sc.nextInt();
        }
        System.out.print("Grade: ");
        int grade = 1;
        if (sc.hasNextInt()) {
            grade = sc.nextInt();
        }

        
        Pattern p = Pattern.compile("^[a-zA-Z]+\\s[0-9]{1,2}\\.[0-9]{1,2}\\.[0-9]{4}\\s[\\w]+\\s?[\\w]*\\s[a-zA-Z]+\\s?[a-zA-z]*\\s[a-zA-Z]+\\s?[a-zA-Z]*\\s?[a-zA-Z]*\\s[0-9]{4}\\s[1-4]{1}$");
        Matcher m = p.matcher(name + " " + dateOfBirth + " " + address + " " + faculty + " " + direction + " " + enYear + " " + grade);

        if (m.find()) {
            Student student = new Student(name, dateOfBirth, address, faculty, direction, enYear, grade);
            studentList.add(student);
            System.out.println("Average per finished year: " + student.average(studentList) + "year");
            student.markica();
        } else {
            System.out.println("Your parameters aren't good");
            i = i-1;
        }
    }

    //dodavanje objekta ElementaryStudent u elemStudList
    public static void nextElemStudent(int i) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Date of birthey: ");
        String dateOfBirth = sc.nextLine();
        System.out.print("Address: ");
        String address = sc.nextLine();
        System.out.print("School name: ");
        String schoolName = sc.nextLine();
        System.out.print("Grade: ");
        int grade = 0;
        if (sc.hasNextInt()) {
            grade = sc.nextInt();
        }
        System.out.print("Average rating: ");
        double avRating = 0;
        if (sc.hasNextDouble()) {
            avRating = sc.nextDouble();
        }

        Pattern p = Pattern.compile("^[a-zA-Z]+\\s[0-9]{1,2}\\.[0-9]{1,2}\\.[0-9]{4}\\s[\\w]+\\s?[\\w]*\\s[a-zA-Z]+\\s?[a-zA-Z]*\\s[1-8]{1}\\s[1-5]{1}\\.?[0-9]{0,2}");
        Matcher m = p.matcher(name + " " + dateOfBirth + " " + address + " " + schoolName + " " + grade + " " + avRating);
        if (m.find()) {
            ElementaryStudent es = new ElementaryStudent(name, dateOfBirth, address, schoolName, grade, avRating);
            elemStudList.add(es);
            System.out.println("Average rating: " + es.average(elemStudList));
            es.markica();
        } else {
            System.out.println("Your parameters aren't good.");
            i = i - 1;
        }
    }

    //dodavanje objekta Employee u employeeList
    public static void nextEmployee(int i){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("date of birthey: ");
        String dateOfBirth = sc.nextLine();
        System.out.print("address: ");
        String address = sc.nextLine();
        System.out.print("Company name: ");
        String company = sc.nextLine();
        System.out.print("Department: ");
        String department = sc.nextLine();
        System.out.print("Salary: ");
        double salary = -1;
        if(sc.hasNextDouble()) salary = sc.nextDouble();
        
        Pattern p = Pattern.compile("^[a-zA-Z]+\\s[0-9]{1,2}\\.[0-9]{1,2}\\.[0-9]{4}\\s[\\w]+\\s?[\\w]*\\s?[\\w]\\s[\\w]+\\s?[\\w]*\\s?[\\w]*\\s[a-zA-Z]+\\s[0-9]+\\.?[0-9]*");
        Matcher m = p.matcher(name + " " + dateOfBirth + " " + address + " " + company + " " + department + " " + salary);
        
        if(m.find()){
            Employee employee = new Employee(name, dateOfBirth, address, company, department, salary);
            employeeList.add(employee);
            System.out.println("Average salary: " + employee.average(employeeList));
            employee.markica();
        }else {
            System.out.println("Your parameters aren't good");
            i = i-1;
        }
    }
    
    public static void main(String[] args) {
        
        System.out.println("Enter number of object.");
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int scint = sc.nextInt();
            for (int i = 0; i < scint; i++) {
                System.out.println("Enter one of: student, elementarystudent, employee or finish for end");
                String personType = sc.next().toLowerCase();

                if (personType.equals("student")) {
                    nextStudent(i);
                } else if (personType.equals("elementarystudent")) {
                    nextElemStudent(i);
                } else if (personType.equals("employee")) {
                    nextEmployee(i);
                } else if (personType.equals("finish")) {
                    i = scint;
                } else {
                    System.out.println("Your person don't exist");
                    i = i - 1;
                }
            }
        } else {
            System.out.println("Your input isn't int");
        }
    }
}
