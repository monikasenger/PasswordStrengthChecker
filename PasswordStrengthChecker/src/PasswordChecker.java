/**
 * class to check the password based on criteria
 */

public class PasswordChecker {

    //  method to check the strength of a given password
    public static String passwordCheck(char[] password) {
        StringBuilder feedback = new StringBuilder(); // StringBuilder instance
        // boolean value for each strength criteria
        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;

        // condition to check if the password length is less than 8 characters
        if (password.length < 8) {
            feedback.append("Password is too short. Must be at least 8 characters.\n");
        } else {
            feedback.append("Password length is sufficient.\n"); // If length is sufficient, inform the user
        }

        // loop through each character in the password to check for specific criteria
        for (char ch : password) {
            // condition to check if the character is an uppercase letter
            if (Character.isUpperCase(ch)) hasUpper = true;
                // condition to check if the character is a lowercase letter
            else if (Character.isLowerCase(ch)) hasLower = true;
                // condition to check if the character is a digit
            else if (Character.isDigit(ch)) hasDigit = true;
                // condition to check if the character is a special character from the given set
            else if ("!@#$%^&*()_+{}[]|:;,.<>?/".indexOf(ch) >= 0) hasSpecial = true;
        }

        // condition to provide feedback for missing criteria based on given password
        if (!hasUpper) feedback.append("Password must contain at least one uppercase letter.\n");
        if (!hasLower) feedback.append("Password must contain at least one lowercase letter.\n");
        if (!hasDigit) feedback.append("Password must contain at least one digit.\n");
        if (!hasSpecial) feedback.append("Password must contain at least one special character.\n");

        //condition to check the overall strength of the password based on its characteristics
        // conditions made for strong password
        if (password.length >= 12 && hasUpper && hasLower && hasDigit && hasSpecial) {
            feedback.append("********** Password is Strong **********");
        } else if (password.length >= 8 && hasUpper && hasLower && hasDigit) {
            feedback.append("********** Password is Medium **********"); // conditions made for medium password
        } else {
            feedback.append("********** Password is Weak **********"); // conditions made for weak password
        }

        // return the full feedback message with the password  result
        return feedback.toString();
    }
}