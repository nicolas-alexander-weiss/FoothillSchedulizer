package old;

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
            System.out.print("old.Class #" + (i+1) + ": ");
            inputClasses[i] = in.nextLine();
        }

        // put all the valid classes into an ArrayList
        ArrayList<ClassName> validClassList = new ArrayList<>();
        for (int i = 0; i < numClass; i++) {
            int digitCounter = 0;

            ClassName tempClass = new ClassName(inputClasses[i]);
            for (int j = 0; j < tempClass.getName().length(); j++) {
                if (Character.isDigit(tempClass.getName().charAt(j)))
                    ++digitCounter;
            }

            if (digitCounter == 1)
                tempClass.setName("00" + tempClass.getName());
            else if (digitCounter == 2)
                tempClass.setName("0" + tempClass.getName());

            if (ClassLoader.classExists(tempClass))
                validClassList.add(tempClass);
        }
        // move all the ArrayList elements into an array
        ClassName[] validClasses = new ClassName[validClassList.size()];
        validClasses = validClassList.toArray(validClasses);

        // load all the valid input classes into 2D old.Class object
        Class[][] classes = ClassLoader.loadClassesWithoutCheck(validClasses);

        // get schedule possibility
        ScheduleChecker scheduleChecker = new ScheduleChecker(classes);
        Schedule[] schedules = scheduleChecker.getPossibleSchedules();

        System.out.print("\nold.Schedule for: ");
        for (int i = 0; i < validClasses.length; i++) {
            if (i == validClasses.length - 1)
                System.out.print(validClasses[i] + ".\n\n");
            else
                System.out.print(validClasses[i] + ", ");
        }

        // print the schedule
        for (int i = 0; i < schedules.length; i++)
            System.out.println("SCHEDULE #" + (i+1) + ":\n" + schedules[i]);
    }
}