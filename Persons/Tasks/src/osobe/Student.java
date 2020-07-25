package osobe;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Student extends Person {

    Student s;
    String facultyName;
    String direction;
    int enrollmentYear;
    int grade;

    Student(String name, String dateOfBirth, String address, String facultyName, String direction, int enrollmentYear, int grade) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.facultyName = facultyName;
        this.direction = direction;
        this.enrollmentYear = enrollmentYear;
        this.grade = grade;
    }

    double average(ArrayList<Student> s) {
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        double av = 0;
            for(int i = 0; i < s.size(); i++){
                av += (double)(year - s.get(i).enrollmentYear) / s.get(i).grade;
            }
        return av / s.size();
    }
    
    @Override
    public void markica(){
        System.out.println("Green");
    }
}
