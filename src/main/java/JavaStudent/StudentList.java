package JavaStudent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class StudentList extends ArrayList<Student> {
    public Student addStudent(Student s){
        // let the student list create the ids
        // so we dont have student around with ids that the list doesnt know about
        UUID id = UUID.randomUUID();
        s.setId(id);
        this.add(s);
        return s;
    }
    public void removeStudent(Student s){
        this.remove(s);
    }
    public void deleteStudent(UUID id){
        // anonying this because we are extending arraylist
        // step one filter the list
        List<Student> s = this.stream().filter((student)->{
            return student.getId() != id;
        }).collect(Collectors.toList());
        // step two remove everything
        this.removeAll(this);
        // step three add the filter list into our object
        this.addAll(s);
    }
    public Integer genderCount(Character gen){
        /// this is roughly the same as javascripts filter
        /// but get access to them we need to call stream() and collect to turn it back into an array
        return this
                .stream()
                .filter((student)->{
                    Optional<Character> gender = student.getGender();

                    if(gender.isPresent()){
                        Character g = gender.get();
                       return g == gen;
                    }
                    return false;
                })
                .collect(Collectors.toList())
                .size();
    }
    public Float avgGrade(){
        Float total  = 0.0F;
        Integer skipped = 0; // keep a total of those we skipped so they dont effect the avg
        for(Student student: this){
            Optional<Integer> grade = student.getGrade(); // because this value may or may not be set we need you use an optional
            if(grade.isPresent()){ // check if there is a value
                Integer g = grade.get(); // open it up to get it value out
                total += g;
            } else {
                skipped++;
            }
        }
        System.out.println(skipped);
        return total / (this.size() - skipped);
    }
}
