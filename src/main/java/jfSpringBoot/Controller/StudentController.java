package jfSpringBoot.Controller;

import jfSpringBoot.Model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private List<Student> students = new ArrayList<>(Arrays.asList(
        new Student(1, "juan fragoso", "j@gmail.com", 30, "course java springBoot"),
        new Student(2, "luis perez", "l@gmail.com", 25, "course angular"),
        new Student(3, "sandra torr", "s@gmail.com", 18, "course php"),
        new Student(4, "juan fragoso", "jf@gmail.com", 36, "course laravel")
    ));

    @GetMapping()
    public List<Student> getStudents(){
        return students;
    }

    @GetMapping("/{name}")
    public Student getCustomer(@PathVariable String name){
        for (Student s: students){
            if (s.getFullName().equalsIgnoreCase(name)){
                return s;
            }
        }

        return null;
    }

    @PostMapping("/create-student")
    public Student createStudent(@RequestBody Student student)
    {
        students.add(student);
        return student;
    }

    @PutMapping("/update-student")
    public Student updateStudent(@RequestBody Student student)
    {
        for (Student s : students){
            if (s.getId() == student.getId()){
                s.setAge(student.getAge());
                s.setEmail(student.getEmail());
                s.setFullName(student.getFullName());
                s.setCurseName(student.getCurseName());

                return s;
            }
        }

        return null;
    }

    @PatchMapping("/patch-student")
    public Student patchStudent(@RequestBody Student student)
    {
        for (Student s : students){
            if (s.getId() == student.getId()){
                if (student.getFullName() != null){
                    s.setFullName(student.getFullName());
                }
                if (student.getEmail() != null){
                    s.setEmail(student.getEmail());
                }
                if (student.getAge() != 0){
                    s.setAge(student.getAge());
                }
                if (student.getCurseName() != null){
                    s.setCurseName(student.getCurseName());
                }

                return s;
            }
        }

        return null;
    }

    @DeleteMapping("delete-student/{id}")
    public Student deleteStudent(@PathVariable int id)
    {
        for (Student s : students){
            if (s.getId() == id){
                students.remove(s);
                return s;
            }
        }

        return null;
    }
}
