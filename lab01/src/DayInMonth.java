package src;
import java.util.Scanner;

public class DayInMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Nhap thang: ");
            String monthInput = scanner.nextLine().trim().toLowerCase();

            System.out.print("Nhap nam: ");
            int year;
            try {
                year = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Nam không ton tai. Nhap lai!");
                continue;
            }

            int month;
            if (monthInput.equals("january") || monthInput.equals("jan.") || monthInput.equals("jan") || monthInput.equals("1")) {
                month = 1;
            } else if (monthInput.equals("february") || monthInput.equals("feb.") || monthInput.equals("feb") || monthInput.equals("2")) {
                month = 2;
            } else if (monthInput.equals("march") || monthInput.equals("mar.") || monthInput.equals("mar") || monthInput.equals("3")) {
                month = 3;
            } else if (monthInput.equals("april") || monthInput.equals("apr.") || monthInput.equals("apr") || monthInput.equals("4")) {
                month = 4;
            } else if (monthInput.equals("may") || monthInput.equals("5")) {
                month = 5;
            } else if (monthInput.equals("june") || monthInput.equals("jun.") || monthInput.equals("jun") || monthInput.equals("6")) {
                month = 6;
            } else if (monthInput.equals("july") || monthInput.equals("jul.") || monthInput.equals("jul") || monthInput.equals("7")) {
                month = 7;
            } else if (monthInput.equals("august") || monthInput.equals("aug.") || monthInput.equals("aug") || monthInput.equals("8")) {
                month = 8;
            } else if (monthInput.equals("september") || monthInput.equals("sep.") || monthInput.equals("sep") || monthInput.equals("9")) {
                month = 9;
            } else if (monthInput.equals("october") || monthInput.equals("oct.") || monthInput.equals("oct") || monthInput.equals("10")) {
                month = 10;
            } else if (monthInput.equals("november") || monthInput.equals("nov.") || monthInput.equals("nov") || monthInput.equals("11")) {
                month = 11;
            } else if (monthInput.equals("december") || monthInput.equals("dec.") || monthInput.equals("dec") || monthInput.equals("12")) {
                month = 12;
            } else {
                System.out.println("Invalid month input. Please enter a valid month.");
                continue;
            }

            if (year < 0) {
                System.out.println("Year must be a non-negative number.");
                continue;
            }

            int daysInMonth = getDaysInMonth(year, month);
            if (daysInMonth == -1) {
                System.out.println("Invalid month/year combination. Please enter a valid month and year.");
            } else {
                System.out.println("There are " + daysInMonth + " days in " + monthInput + " " + year + ".");
                break;
            }
        }

        scanner.close();
    }

    public static int getDaysInMonth(int year, int month) {
        if (month < 1 || month > 12) {
            return -1;
        }

        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (isLeapYear(year) && month == 2) {
            return 29;
        } else {
            return daysInMonth[month];
        }
    }

    public static boolean isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            return true;
        }
        return false;
    }
}
