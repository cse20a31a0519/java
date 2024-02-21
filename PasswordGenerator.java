import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the length of the password:");
        int length = scanner.nextInt();
        System.out.println("Enter the number of digits:");
        int digits = scanner.nextInt();
        System.out.println("Enter the number of lowercase letters:");
        int lowercase = scanner.nextInt();
        System.out.println("Enter the number of uppercase letters:");
        int uppercase = scanner.nextInt();
        System.out.println("Enter the number of special characters:");
        int special = scanner.nextInt();

        if (length < digits + lowercase + uppercase + special) {
            System.out.println("The sum of digits, lowercase letters, uppercase letters, and special characters cannot be greater than the password length.");
            return;
        }

        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < digits; i++) {
            password.append((char) (random.nextInt(10) + '0'));
        }

        for (int i = 0; i < lowercase; i++) {
            password.append((char) (random.nextInt(26) + 'a'));
        }

        for (int i = 0; i < uppercase; i++) {
            password.append((char) (random.nextInt(26) + 'A'));
        }

        for (int i = 0; i < special; i++) {
            password.append("!@#$%^&*()-_=+[]{};:'\",.<>/?`~\\".charAt(random.nextInt("!@#$%^&*()-_=+[]{};:'\",.<>/?`~\\".length())));
        }

        if (password.length() < length) {
            for (int i = 0; i < length - password.length(); i++) {
                password.append(random.nextInt(93) + 33);
            }
        }

        password = new StringBuilder(shuffle(password.toString()));

        System.out.println("Generated password: " + password.substring(0, length));
    }

    private static String shuffle(String s) {
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(s);
        for (int i = sb.length() - 1; i > 0; i--) {
            int r = rnd.nextInt(i + 1);
            sb.setCharAt(i, sb.charAt(r));
            sb.setCharAt(r, sb.charAt(i));
        }
        return sb.toString();
    }
}