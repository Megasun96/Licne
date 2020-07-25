package osobe;

import java.util.ArrayList;

public class ElementaryStudent extends Person {

    String schoolName;
    int grade;
    double averageRating;
    
    ElementaryStudent(String name, String dateOfBirth, String address, String schoolName, int grade, double averageRating){
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.schoolName = schoolName;
        this.grade = grade;
        this.averageRating = averageRating;
    }
    double average(ArrayList<ElementaryStudent> els) {
        double av = 0;
        for(int i = 0; i < els.size(); i++){
            av += els.get(i).averageRating;
        }
        return av / els.size();
    }
    
    @Override
    public void markica(){
        System.out.println("Blue");
    }
}
