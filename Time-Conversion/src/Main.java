import java.util.*;

/*
    The main class used to print and take in the user input to create a simple console text with the answer to
    the time difference.
 */

public class Main {

    public static void main(String []args){
        Data data = new Data();
        data.createMap();
        Scanner scanner = new Scanner(System.in);
        scanAndPrint(scanner, data);
    }

    //a shortcut print statement
    public static void print(Object o){ System.out.print(o);}

    //takes the scanner and completes the steps for calculating the time difference

    public static void scanAndPrint(Scanner sc, Data data){
        System.out.print("Enter two places you wish to compare time between(Delimiter is ','): ");

        String input[] = sc.nextLine().split(",");

        String timezone1 = data.getTimeZone(input[0].toString());
        String timezone2 = data.getTimeZone(input[1].toString());

        System.out.print("The time difference between " + input[0].toString() +  " and " + input[1].toString() + " is " + data.compareTime(timezone1,timezone2) + " hours.");
    }
}
