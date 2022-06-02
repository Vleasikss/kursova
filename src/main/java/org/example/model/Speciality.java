package org.example.model;

public class Speciality {

    private String name;
    private int maxCoursesCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxCoursesCount() {
        return maxCoursesCount;
    }

    public void setMaxCoursesCount(int maxCoursesCount) {
        this.maxCoursesCount = maxCoursesCount;
    }

    @Override
    public String toString() {
        return "Speciality{" +
                "name='" + name + '\'' +
                ", maxCoursesCount=" + maxCoursesCount +
                '}';
    }
}
