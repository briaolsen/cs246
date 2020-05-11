package olsen;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        System.out.println("Enter password: ");
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        User user = new User();
        NSALoginController.hashUserPassword(user);


    }

}