package edu.sjsu.assignment4;

import java.util.*;

public class Gradebook extends HashMap<Student, Character> {

    public boolean addStudent(Student student, char grade) {
        if (this.containsKey(student)) {
            return false;
        }
        switch (grade) {
            case 'A', 'B', 'C', 'D', 'F', 'N':
                this.put(student, grade);
                return true;
            default:
                this.put(student, 'N');
                return true;
        }
    }

    public boolean addStudent(Student student) {
        return addStudent(student, 'N');
    }

    public boolean deleteStudent(int id) {
        Student student = new Student(id);
        if (this.remove(student) != null) {
            return true;
        }
        return false;
    }

    public boolean updateStudent(int id, String newName) {
        Student student = new Student(id, newName);
        if (this.containsKey(student)) {
            char grade = this.remove(student);
            this.put(student, grade);
            return true;
        }
        return false;
    }

    public boolean updateGrade(int id, char newGrade) {
        Student student = new Student(id);
        switch (newGrade) {
                case 'A', 'B', 'C', 'D', 'F', 'N':
                    if (this.replace(student, newGrade) != null) {
                        return true;
                    }
                    return false;
                default:
                    return false;
        }
    }

    public void printGrades(Comparator<Student> comparator) {
        List<Student> list = new ArrayList(this.keySet());
        Collections.sort(list, comparator);
        for (Student s : list) {
            System.out.println(s.toString() + this.get(s));
        }
    }
}
