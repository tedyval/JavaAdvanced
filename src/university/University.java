package university;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity){
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }


    public int getCapacity(){
        return this.capacity;
    }

    public  List<Student> getStudents(){
        return this.students;
    }

    public int getStudentCount(){
        return students.size();
    }

    public String registerStudent(Student student){
        int countOfMatches = (int)students.stream().filter(s -> s.getFirstName()
                .equals(student.getFirstName()) && s.getLastName().equals(student.getLastName())).count();
        String output = "";
        if(capacity > students.size() && countOfMatches == 0){
            students.add(student);
            output = String.format("Added student %s %s",student.getFirstName(),student.getLastName());
        }else if(capacity > students.size() && countOfMatches != 0){
            output = String.format("Student is already in the university");
        }else if(capacity < students.size()){
            output = String.format("No seats in the university" );
        }
        return output;

    }

    public String dismissStudent(Student student){
        int countOfMatches = (int)students.stream().filter(s -> s.getFirstName()
                .equals(student.getFirstName()) && s.getLastName().equals(student.getLastName())).count();
        String output = "";
        if(countOfMatches != 0){
            students.removeIf(s -> s.getFirstName().equals(student.getFirstName()) && s.getLastName().equals(student.getLastName()));
            return output= String.format("Removed student %s %s",student.getFirstName(),student.getLastName());
        }else{
           return output = "Student not found";
        }

    }

    public Student getStudent(String firstName, String lastName){
        Student studentSearched = students.stream().filter(s -> s.getFirstName()
                .equals(firstName) && s.getLastName().equals(lastName)).findAny().orElseGet(null);
        if(studentSearched != null){
            return studentSearched;
        }
        return null;
    }

    //==Student: First Name = Rihanna, Last Name = Fenty, Best Subject = Music


    public String getStatistics() {
        StringBuilder str = new StringBuilder();
        for (Student student : students) {
            str.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s",student.getFirstName(),student.getLastName(),student.getBestSubject())).append("\n");

        }
        return str.toString().trim();

    }
}
