import java.util.ArrayList;
import java.util.Scanner;

public class FoothillSchedulizer {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        String num;
        int numClass;

        // get user input of number of classes needed
        System.out.print("How many classes do you need to take: ");
        num = in.nextLine();
        numClass = Integer.parseInt(num);

        // get user input of classes needed
        String[] inputClasses = new String[numClass];
        for (int i = 0; i < numClass; i++) {
            System.out.print("Class #" + (i+1) + ": ");
            inputClasses[i] = in.nextLine();
        }

        
    }
}