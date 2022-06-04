package org.example.service.gui.tab;

import org.example.model.Faculty;
import org.example.model.Group;
import org.example.model.RatingScore;
import org.example.model.Student;
import org.example.model.StudyForm;
import org.example.service.db.dao.FacultyDatabaseHelper;
import org.example.service.db.dao.GroupDatabaseHelper;
import org.example.service.db.dao.StudentDatabaseHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Frame Tab which shows a 'Student's Registration Form'
 */
public class AddStudentTab extends JFrame implements ActionListener, FrameTab {

    private static final Rectangle ADD_STUDENT_BOUNDS = new Rectangle(300, 90, 1200, 700);

    private static final Font TITLE_FONT = new Font("Arial", Font.PLAIN, 30);
    private static final Font ANY_LABEL_FONT = new Font("Arial", Font.PLAIN, 20);
    private static final Font ANY_TEXT_FIELD_FONT = new Font("Arial", Font.PLAIN, 15);

    private static final Dimension ANY_LABEL_DIMENSION = new Dimension(150, 20);
    private static final Dimension ANY_TEXT_FIELD_DIMENSION = new Dimension(190, 20);

    private static final AllStudentsTab allStudentsTab = AllStudentsTab.getInstance();

    private final GroupDatabaseHelper groupDatabaseHelper;
    private final StudentDatabaseHelper studentDatabaseHelper;

    private final JTextField lastNameTf;
    private final JTextField firstNameTf;
    private final JComboBox<String> facultiesComboBox;
    private final JTextField patronymicTf;
    private final JTextField ratingScoreTf;
    private final JComboBox<StudyForm> studyFormsComboBox;
    private final JCheckBox termsCheckBox;
    private final JButton submitButton;
    private final JButton resetButton;
    private final JLabel resultLabel;
    private JComboBox<String> groupsComboBox;


    public AddStudentTab() {
        this.groupDatabaseHelper = new GroupDatabaseHelper();
        this.studentDatabaseHelper = new StudentDatabaseHelper();
        FacultyDatabaseHelper facultyDatabaseHelper = new FacultyDatabaseHelper();

        setBounds(ADD_STUDENT_BOUNDS);

        Container c = getContentPane();
        c.setLayout(null);

        JLabel title = new JLabel("Student's Registration Form");
        title.setFont(TITLE_FONT);
        title.setSize(450, 30);
        title.setLocation(425, 30);
        c.add(title);

        JLabel firstNameLabel = new JLabel("First name");
        firstNameLabel.setFont(ANY_LABEL_FONT);
        firstNameLabel.setSize(ANY_LABEL_DIMENSION);
        firstNameLabel.setLocation(400, 100);
        c.add(firstNameLabel);

        firstNameTf = new JTextField();
        firstNameTf.setFont(ANY_TEXT_FIELD_FONT);
        firstNameTf.setSize(ANY_TEXT_FIELD_DIMENSION);
        firstNameTf.setLocation(650, 100);
        c.add(firstNameTf);

        JLabel lastNameLabel = new JLabel("Last name");
        lastNameLabel.setFont(ANY_LABEL_FONT);
        lastNameLabel.setSize(ANY_LABEL_DIMENSION);
        lastNameLabel.setLocation(400, 150);
        c.add(lastNameLabel);

        lastNameTf = new JTextField();
        lastNameTf.setFont(ANY_TEXT_FIELD_FONT);
        lastNameTf.setSize(ANY_TEXT_FIELD_DIMENSION);
        lastNameTf.setLocation(650, 150);
        c.add(lastNameTf);

        JLabel patronymicLabel = new JLabel("Patronymic");
        patronymicLabel.setFont(ANY_LABEL_FONT);
        patronymicLabel.setSize(ANY_LABEL_DIMENSION);
        patronymicLabel.setLocation(400, 200);
        c.add(patronymicLabel);

        patronymicTf = new JTextField();
        patronymicTf.setFont(ANY_TEXT_FIELD_FONT);
        patronymicTf.setSize(ANY_TEXT_FIELD_DIMENSION);
        patronymicTf.setLocation(650, 200);
        c.add(patronymicTf);

        JLabel form = new JLabel("Form");
        form.setFont(ANY_LABEL_FONT);
        form.setSize(ANY_LABEL_DIMENSION);
        form.setLocation(400, 250);
        c.add(form);

        studyFormsComboBox = new JComboBox<>(StudyForm.values());
        studyFormsComboBox.setFont(new Font("Arial", Font.PLAIN, 15));
        studyFormsComboBox.setSize(125, 20);
        studyFormsComboBox.setLocation(650, 250);
        c.add(studyFormsComboBox);

        JLabel facultyLabel = new JLabel("Faculty");
        facultyLabel.setFont(ANY_LABEL_FONT);
        facultyLabel.setSize(ANY_LABEL_DIMENSION);
        facultyLabel.setLocation(400, 300);
        c.add(facultyLabel);

        facultiesComboBox = new JComboBox<>(getAllFacultyNames(facultyDatabaseHelper));
        facultiesComboBox.setFont(new Font("Arial", Font.PLAIN, 15));
        facultiesComboBox.setSize(100, 20);
        facultiesComboBox.setLocation(650, 300);
        c.add(facultiesComboBox);

        JLabel groupsLabel = new JLabel("Groups");
        groupsLabel.setFont(ANY_LABEL_FONT);
        groupsLabel.setSize(ANY_LABEL_DIMENSION);
        groupsLabel.setLocation(400, 350);
        c.add(groupsLabel);

        String[] allGroupsByFacultyName = getAllGroups(
                groupDatabaseHelper,
                Objects.requireNonNull(facultiesComboBox.getSelectedItem()).toString()
        );
        groupsComboBox = new JComboBox<>(allGroupsByFacultyName);
        groupsComboBox.setFont(new Font("Arial", Font.PLAIN, 15));
        groupsComboBox.setSize(100, 20);
        groupsComboBox.setLocation(650, 350);
        c.add(groupsComboBox);

        facultiesComboBox.addActionListener(e -> {
            String selectedItem = Objects.requireNonNull(facultiesComboBox.getSelectedItem()).toString();
            c.remove(groupsComboBox);
            String[] allGroups = getAllGroups(groupDatabaseHelper, selectedItem);
            groupsComboBox = new JComboBox<>(allGroups);
            groupsComboBox.setFont(new Font("Arial", Font.PLAIN, 15));
            groupsComboBox.setSize(100, 20);
            groupsComboBox.setLocation(650, 350);
            c.add(groupsComboBox);
        });

        JLabel ratingScoreLabel = new JLabel("Rating Score");
        ratingScoreLabel.setFont(ANY_LABEL_FONT);
        ratingScoreLabel.setSize(ANY_LABEL_DIMENSION);
        ratingScoreLabel.setLocation(400, 400);
        c.add(ratingScoreLabel);

        ratingScoreTf = new JTextField();
        ratingScoreTf.setFont(ANY_TEXT_FIELD_FONT);
        ratingScoreTf.setSize(ANY_TEXT_FIELD_DIMENSION);
        ratingScoreTf.setLocation(650, 400);
        c.add(ratingScoreTf);

        termsCheckBox = new JCheckBox("Accept Terms And Conditions.");
        termsCheckBox.setFont(new Font("Arial", Font.PLAIN, 15));
        termsCheckBox.setSize(250, 20);
        termsCheckBox.setLocation(550, 450);
        c.add(termsCheckBox);

        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.PLAIN, 15));
        submitButton.setSize(100, 20);
        submitButton.setLocation(550, 500);
        submitButton.addActionListener(this);
        c.add(submitButton);

        resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Arial", Font.PLAIN, 15));
        resetButton.setSize(100, 20);
        resetButton.setLocation(700, 500);
        resetButton.addActionListener(this);
        c.add(resetButton);

        resultLabel = new JLabel("");
        resultLabel.setFont(ANY_LABEL_FONT);
        resultLabel.setSize(1200, 25);
        resultLabel.setLocation(400, 550);
        c.add(resultLabel);

    }

    /**
     *
     * @param rawRatingScore some string
     * @return true if rawRatingScore {@link AddStudentTab#isDouble(String)} and in range between {@link RatingScore#MIN} and {@link RatingScore#MAX}
     */
    private static boolean isValidRatingScore(String rawRatingScore) {
        if (!isDouble(rawRatingScore)) {
            return false;
        }
        double ratingScore = Double.parseDouble(rawRatingScore);
        return ratingScore >= RatingScore.MIN && ratingScore <= RatingScore.MAX;
    }

    /**
     * @param someStr some string or null
     * @return true if string is null or empty
     */
    private static boolean isNullOrEmpty(String someStr) {
        return someStr == null || someStr.isEmpty();
    }

    /**
     * @param someValue some string
     * @return true if some string is can be converter into double
     */
    private static boolean isDouble(String someValue) {
        try {
            Double.parseDouble(someValue);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * @param facultyDatabaseHelper Faculty Database Helper
     * @return all faculties mapped into array of {@link Faculty#getName()}
     */
    private static String[] getAllFacultyNames(FacultyDatabaseHelper facultyDatabaseHelper) {
        return facultyDatabaseHelper.findAll().stream().map(Faculty::getName).toArray(String[]::new);
    }

    /**
     * @param groupDatabaseHelper Group Database Helper
     * @param facultyName faculty name
     * @return all groups in facultyName mapped into array of {@link Group#getName()}
     */
    private static String[] getAllGroups(GroupDatabaseHelper groupDatabaseHelper, String facultyName) {
        return groupDatabaseHelper.findByFacultyName(facultyName).stream().map(Group::getName).toArray(String[]::new);
    }

    @Override
    public List<Component> components() {
        return List.of(getComponents());
    }

    @Override
    public String title() {
        return "add a student";
    }

    /**
     * Listens to {@link AddStudentTab#submitButton} actions to submit student's registration into database
     * Listens to {@link AddStudentTab#resetButton} actions to reset student's registration form
     * @param e some event
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            Optional<String> maybeError = validateForm();
            if (maybeError.isEmpty()) {

                StudyForm form = matchStudyForm();
                Student student = Student.newBuilder()
                        .setFirstName(firstNameTf.getText())
                        .setLastName(lastNameTf.getText())
                        .setPatronymic(patronymicTf.getText())
                        .setForm(form)
                        .setFacultyId(Objects.requireNonNull(facultiesComboBox.getSelectedItem()).toString())
                        .setGroupId(Objects.requireNonNull(groupsComboBox.getSelectedItem()).toString())
                        .setRatingScore(new RatingScore(Double.parseDouble(ratingScoreTf.getText())))
                        .build();
                studentDatabaseHelper.insert(student);

                resultLabel.setForeground(Color.GREEN);
                resultLabel.setText("Registration Successfully..");

                allStudentsTab.reload();
                reset(false);
            } else {
                resultLabel.setForeground(Color.RED);
                resultLabel.setText(maybeError.get());
            }
        } else if (e.getSource() == resetButton) {
            reset(true);
        }
    }

    /**
     * @return maybe string error if registration form contains some invalid inputs
     */
    private Optional<String> validateForm() {
        if (isNullOrEmpty(firstNameTf.getText())) {
            return Optional.of("Firstname can't be empty");
        }
        if (isNullOrEmpty(lastNameTf.getText())) {
            return Optional.of("Lastname can't be empty");
        }
        if (isNullOrEmpty(patronymicTf.getText())) {
            return Optional.of("Patronymic can't be empty");
        }
        if (matchStudyForm() == null) {
            return Optional.of("Study form can't be empty");
        }
        if (isNullOrEmpty(ratingScoreTf.getText()) || !isValidRatingScore(ratingScoreTf.getText())) {
            return Optional.of("Invalid rating score. Rating score must be not less than 0.0 and no more than 100 points");
        }
        if (!termsCheckBox.isSelected()) {
            return Optional.of("Please accept the terms & conditions..");
        }
        return Optional.empty();
    }

    /**
     * @return {@link AddStudentTab#studyFormsComboBox} selected item converted into {@link StudyForm}
     */
    private StudyForm matchStudyForm() {
        return StudyForm.valueOf(Objects.requireNonNull(studyFormsComboBox.getSelectedItem()).toString());
    }

    /**
     * Resets the form
     * @param fullReset if true - resets fields with result labels
     */
    private void reset(boolean fullReset) {
        String def = "";
        lastNameTf.setText(def);
        firstNameTf.setText(def);
        patronymicTf.setText(def);
        studyFormsComboBox.setSelectedIndex(0);
        facultiesComboBox.setSelectedIndex(0);
        groupsComboBox.setSelectedIndex(0);
        ratingScoreTf.setText(def);
        if (fullReset) {
            resultLabel.setText(def);
        }
    }
}