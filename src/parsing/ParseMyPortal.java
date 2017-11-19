package parsing;

import structures.Department;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ParseMyPortal {
    public static void main(String[] args) throws IOException {
        File input = new File("resources/inputfiles/mp");

        String[] departmentStrings = mpFileToDepartmentStrings(input);

        ArrayList<Department> departments = new ArrayList<Department>();

        for(String s : departmentStrings){
            Scanner depScanner = new Scanner(s);
            String departmentName = depScanner.nextLine();
            ArrayList<String[]> classes = new ArrayList<>();


            int c = 0;
            StringBuilder classString = new StringBuilder("");
            while (depScanner.hasNext()){
                classString.append(depScanner.nextLine());
                c++;

                if(c == 20){
                    classes.add(classString.toString().split("<<<"));
                    c = 0;
                    classString = new StringBuilder("");
                }else{
                    classString.append("<<<");
                }
            }
/*
            if(c != 20){
                classes.add(classString.toString().split("<<<"));
            }
*/
            departments.add(new Department(departmentName, classes));
        }

        System.out.println("stop");
    }

    private static String[] mpFileToDepartmentStrings(File input) throws FileNotFoundException {
        Scanner scanner = new Scanner(input);

        StringBuilder fileParse = new StringBuilder("");

        int counter = 0;
        while(scanner.hasNext()){
            String nextLine = scanner.nextLine();
            if(nextLine.indexOf("-FD") != -1 || nextLine.indexOf("-FH") != -1){
                if(counter > 0){
                    fileParse.append("<<<");
                }
            }
            fileParse.append( nextLine + "\n");
            counter ++;
        }

        return fileParse.toString().split("<<<");
    }
}
