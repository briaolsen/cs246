package olsen;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        // Declare variables to be used
        Scanner scanner = new Scanner(System.in);
        String password = "";
        User user;
        boolean validPW = true;

        // Ask user for a new password and create a hashpassword

        do {
            // Prompt user for password
            System.out.println("Enter password: ");
            password = scanner.nextLine();
            user = new User(password);
            validPW = true;
            System.out.println(user);

            // Attempt to hash the password and check for validity
            // must be 8 characters and contain a digit
            try {
                NSALoginController.hashUserPassword(user);
            } catch (WeakPasswordException e) {
                System.out.println(e);
                validPW = false;
            } catch (Exception e) {
                System.out.println(e);
                validPW = false;
            }

        } while (!validPW);

        // print out user information to check
        System.out.println(user);

        // Have user verify their password
        boolean correctPassword = false;
        do {

            // Prompt for password
            System.out.println("Verify password: ");
            String checkPassword = scanner.nextLine();
            user.setPassword(checkPassword);

            // Verify the new input password
            try {
                correctPassword = NSALoginController.verifyPassword(user);
            } catch (Exception e) {
                System.out.println(e);
            }

            // Tell the user whether the passwords match or not
            if (correctPassword) {
                System.out.println("Password is a match");
            } else {
                System.out.println("Password is not a match");
            }

        } while (!correctPassword); // Prompt the user until there is a match

    }
}
