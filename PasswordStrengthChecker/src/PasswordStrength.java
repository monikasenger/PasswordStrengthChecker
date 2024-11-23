import javax.swing.*;
import java.awt.*;

/**
 * class to check the strength password
 */
public class PasswordStrength {

    static PasswordChecker check = new PasswordChecker();// password checker class instance

    // method to create and display the Password Strength Checker GUI
    public void passwordStrength() {
        // create the main application frame, where all UI components will be added
        JFrame frame = new JFrame("Password Strength Checker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //  ensures the program exits when the window is closed
        frame.setSize(400, 250); // set the dimensions of the window in pixel
        frame.setLayout(new FlowLayout()); // use a simple FlowLayout for components

        // create GUI components for the user interface
        JLabel passwordLabel = new JLabel("Enter Password: "); // label asking for the password
        JPasswordField passwordField = new JPasswordField(20); // field for the user input password
        JCheckBox showPasswordCheckBox = new JCheckBox("Show Password"); // checkbox to toggle the visibility of the password
        JButton checkButton = new JButton("Check Strength"); // button to trigger the password strength check
        JTextArea resultArea = new JTextArea(6, 35); // area to display the feedback or results of the password strength check
        resultArea.setEditable(false); // prevent the user from editing the result area

        // components add to the frame
        frame.add(passwordLabel); // add password label
        frame.add(passwordField); //add password input field
        frame.add(showPasswordCheckBox); //add the checkbox to show/hide the password
        frame.add(checkButton); // add the button to trigger the strength check
        frame.add(new JScrollPane(resultArea)); // add the result area inside a scroll pane

        // action listener for the "Show Password" checkbox to toggle visibility
        showPasswordCheckBox.addActionListener(e -> {
            if (showPasswordCheckBox.isSelected()) {
                passwordField.setEchoChar((char) 0); //show the password as plain text when the checkbox is selected
            } else {
                passwordField.setEchoChar('*'); // show the password when the checkbox is not selected
            }
        });

        //action listener for the "Check Strength" button
        checkButton.addActionListener(e -> {
            // retrieve the password entered by the user
            char[] password = passwordField.getPassword(); // get the password as a char array

            // check iff no password is entered
            if (password.length == 0) {
                resultArea.setText("Please enter a password.");//display a warning message in the result area
            } else {
                // call PasswordChecker class
                String result = check.passwordCheck(password);
                resultArea.setText(result); //display the result in result area

                // clear the password field
                passwordField.setText("");
            }
        });

        // set the frame visibility to true, which displays the GUI to the user
        frame.setVisible(true);
    }
}
