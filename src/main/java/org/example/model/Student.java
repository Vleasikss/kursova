package org.example.model;

public class Student {

    private Long id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String form;
    private String groupId;
    private String facultyId;
    private Double ratingScore;

    public Student() {
    }

    public Student(Long id, String firstName, String lastName, String patronymic, String form, String groupId, String facultyId, Double ratingScore) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.form = form;
        this.groupId = groupId;
        this.facultyId = facultyId;
        this.ratingScore = ratingScore;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public Double getRatingScore() {
        return ratingScore;
    }

    public void setRatingScore(Double ratingScore) {
        this.ratingScore = ratingScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", form='" + form + '\'' +
                ", groupId='" + groupId + '\'' +
                ", facultyId='" + facultyId + '\'' +
                ", ratingScore=" + ratingScore +
                '}';
    }
}
