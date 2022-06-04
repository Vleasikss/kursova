package org.example.model;


public class Student implements BasicModel {

    private Long id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private StudyForm form;
    private String groupId;
    private String facultyId;
    private RatingScore ratingScore;

    public Student() {
    }

    public static Builder newBuilder() {
        return new Student().new Builder();
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

    public StudyForm getForm() {
        return form;
    }

    public void setForm(StudyForm form) {
        this.form = form;
    }

    public RatingScore getRatingScore() {
        return ratingScore;
    }

    public void setRatingScore(RatingScore ratingScore) {
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

    /**
     * Builder pattern realization
     *
     * @see <a href="https://blogs.oracle.com/javamagazine/post/exploring-joshua-blochs-builder-design-pattern-in-java">Joshua Bloch’s Builder design pattern in Java</a>
     */
    public class Builder {

        private Builder() {
        }

        public Builder setLastName(String lastName) {
            Student.this.lastName = lastName;

            return this;
        }

        public Builder setFirstName(String firstName) {
            Student.this.firstName = firstName;

            return this;
        }

        public Builder setPatronymic(String patronymic) {
            Student.this.patronymic = patronymic;

            return this;
        }

        public Builder setForm(StudyForm form) {
            Student.this.form = form;

            return this;
        }

        public Builder setGroupId(String groupId) {
            Student.this.groupId = groupId;

            return this;
        }

        public Builder setFacultyId(String facultyId) {
            Student.this.facultyId = facultyId;

            return this;
        }

        public Builder setRatingScore(RatingScore ratingScore) {
            Student.this.ratingScore = ratingScore;

            return this;
        }

        public Student build() {
            return Student.this;
        }

    }
}
