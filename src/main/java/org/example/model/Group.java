package org.example.model;

public class Group {

    private String name;
    private String facultyName;
    private int specialtyName;
    private int course;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public int getSpecialtyName() {
        return specialtyName;
    }

    public void setSpecialtyName(int specialtyName) {
        this.specialtyName = specialtyName;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", facultyName='" + facultyName + '\'' +
                ", specialtyName=" + specialtyName +
                ", course=" + course +
                '}';
    }
}
