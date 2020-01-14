package jenkins.coby;

import java.util.Scanner;

public class Test {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isValid = true;

        System.out.println("Please enter a password with at least 8 characters and 1 digit:");
        String userInput = scanner.nextLine();

        User user = new User(userInput);

        System.out.println("Before hashing");
        System.out.println(user.getPassword());
        System.out.println(user.getSalt());
        System.out.println(user.getHashedPassword());
        System.out.println("_____________________________________________");

        do {
            try {
                NSALoginController.hashUserPassword(user);
            } catch (WeakPasswordException e){
                System.out.println(e.toString());
                isValid = false;
                System.out.println("Please enter a password with at least 8 characters and 1 digit:");
                userInput = scanner.nextLine();
                user.setPassword(userInput);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }while (isValid);


        System.out.println("After hashing");
        System.out.println(user.getPassword());
        System.out.println(user.getSalt());
        System.out.println(user.getHashedPassword());
        System.out.println("_____________________________________________");

        System.out.println("Please re-enter the same password you entered before:");
        userInput = scanner.nextLine();
        user.setPassword(userInput);

        try {
            NSALoginController.verifyPassword(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
