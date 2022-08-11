package JavaStudent;

import java.util.Optional;
import java.util.UUID;

public class Student {
    private UUID id;
    public String firstName;
    public String lastName;
    // we used Optional types as a better way of dealing with null values
    private Optional<Character> gender; // this was made private because we have rule for how this need to be set
    private Optional<Integer> grade; // this was made private because we have rule for how this need to be set

    public Student(String firstName, String lastName, Character gender){
        this.firstName =firstName;
        this.lastName = lastName;
        this.setGender(gender); // since we put the validation in a function we should use it in the constuctor so we dont repat our selfs
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
    public void setGender(Character gender){
        String clean_gender = gender.toString().toUpperCase();
        if(clean_gender.equals("M") || clean_gender.equals("F")){
            this.gender = Optional.of(gender);
        } else {
            this.gender = Optional.empty();
        }
    }
    public Optional<Character> getGender(){
        return this.gender;
    }
    public Optional<Integer> getGrade(){
        return this.grade;
    }
    //public void setGender(char gender){
    //    if(gender == 'M' || gender == 'F')
    //        this.gender = gender;
    //    else if (gender == 'm' || gender == 'f')
    //        this.gender = gender;
    //}

    public void setGrade(Integer grade) {
        if(grade <= 5 && grade >= 0)
            this.grade = Optional.of(grade);
        else
            this.grade = Optional.empty();
    }
    public UUID getId(){
        return this.id;
    }
    public void setId(UUID id){
        this.id = id;
    }
}
