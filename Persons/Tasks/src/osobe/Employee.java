package osobe;

import java.util.ArrayList;

public class Employee extends Person {

    String company;
    String department;
    double salary;

    Employee(String name, String dateOfBirth, String address, String company, String department, double salary) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.company = company;
        this.department = department;
        this.salary = salary;
    }
    
    double average(ArrayList<Employee> e){
        double av = 0; 
        for(int i = 0; i < e.size(); i++){
            av += e.get(i).salary;
        }
        return av / e.size();
    }
    
    @Override
    public void markica(){
        System.out.println("Red");
    }
}
