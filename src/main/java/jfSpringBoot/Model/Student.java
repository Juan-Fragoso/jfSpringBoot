package jfSpringBoot.Model;

public class Student {
    private int id;
    private String fullName;
    private String email;
    private int age;
    private String curseName;

    public Student(int id, String fullName, String email, int age, String curseName) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.age = age;
        this.curseName = curseName;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getCurseName() {
        return curseName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCurseName(String curseName) {
        this.curseName = curseName;
    }
}
