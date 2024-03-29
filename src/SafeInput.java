import java.util.Scanner;

public class SafeInput
{
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";
        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.length() == 0);

        return retString;
    }

    public static int getInt(Scanner pipe, String prompt) {
        int value;
        do {
            System.out.print("\n" + prompt + ": ");
            while (!pipe.hasNextInt()) {
                String input = pipe.next();
                System.out.println("Invalid input. Please enter an integer.");
            }
            value = pipe.nextInt();
            pipe.nextLine();
        } while (value < Integer.MIN_VALUE || value > Integer.MAX_VALUE);

        return value;
    }

    public static double getDouble(Scanner pipe, String prompt) {
        double value;
        do {
            System.out.print("\n" + prompt + ": ");
            while (!pipe.hasNextDouble()) {
                String input = pipe.next();
                System.out.println("Invalid input. Please enter a double value.");
            }
            value = pipe.nextDouble();
            pipe.nextLine();
        } while (value < -Double.MAX_VALUE || value > Double.MAX_VALUE);

        return value;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int value;
        do {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            while (!pipe.hasNextInt()) {
                String input = pipe.next();
                System.out.println("Invalid input. Please enter an integer.");
            }
            value = pipe.nextInt();
            pipe.nextLine();
        } while (value < low || value > high);

        return value;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double value;
        do {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            while (!pipe.hasNextDouble()) {
                String input = pipe.next();
                System.out.println("Invalid input. Please enter a double value.");
            }
            value = pipe.nextDouble();
            pipe.nextLine();
        } while (value < low || value > high);

        return value;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String input;
        boolean isValidInput;
        do {
            System.out.print("\n" + prompt + " [Y/N]: ");
            input = pipe.next();
            isValidInput = input.matches("[YyNn]");
            if (!isValidInput) {
                System.out.println("Invalid input. Please enter 'Y' or 'N'.");
            }
        } while (!isValidInput);

        return input.equalsIgnoreCase("Y");
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String value;
        do {
            System.out.print("\n" + prompt + ": ");
            value = pipe.nextLine();
        } while (!value.matches(regEx));

        return value;
    }

    public static void prettyHeader(String msg) {
        int width = 60;
        int stars = (width - msg.length() - 6) / 2; // 3 stars on each side
        StringBuilder header = new StringBuilder(width);
        for (int i = 0; i < width; i++) {
            header.append("*");
        }
        System.out.println(header);
        System.out.println("***" + " ".repeat(stars) + msg + " ".repeat(stars) + "***");
        System.out.println(header);
    }
}