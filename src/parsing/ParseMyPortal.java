package parsing;

import structures.Department;
import structures.Class;
import structures.ClassTime;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ParseMyPortal {

    private static final char WHITE_SPACE_CHARACTER = 160;

    public static void main(String[] args) throws IOException {
        File input = new File("resources/inputfiles/mp");
        String[] departmentStrings = mpFileToDepartmentStrings(input);

        ArrayList<Department> departments = new ArrayList<Department>();

        for(String s : departmentStrings){
            Scanner depScanner = new Scanner(s);
            String departmentName = depScanner.nextLine();
            ArrayList<Class> classes = new ArrayList<>();

            int c = 0;
            ArrayList<String[]> classStringArrays = new ArrayList<>();
            StringBuilder classString = new StringBuilder("");
            while (depScanner.hasNext()){
                classString.append(depScanner.nextLine());
                c++;

                if(c == 20){
                    classStringArrays.add(classString.toString().split("<<<"));
                    c = 0;
                    classString = new StringBuilder("");
                }else{
                    classString.append("<<<");
                }
            }

            String[] classStringArray = classStringArrays.get(1);
            Class tempClass = new Class(
                    classStringArray[0],
                    classStringArray[1],
                    classStringArray[2],
                    classStringArray[3],
                    classStringArray[4],
                    classStringArray[5],
                    classStringArray[6],
                    classStringArray[7],
                    classStringArray[10],
                    classStringArray[11],
                    classStringArray[12],
                    classStringArray[13],
                    classStringArray[14],
                    classStringArray[15]);
            tempClass.addClassTime(new ClassTime(
                    classStringArray[8],
                    classStringArray[9],
                    classStringArray[16],
                    classStringArray[17],
                    classStringArray[18],
                    classStringArray[19]));
            for(int i = 2; i < classStringArrays.size(); i++){
                classStringArray = classStringArrays.get(i);

                if(classStringArray[0].charAt(0) == ParseMyPortal.WHITE_SPACE_CHARACTER){
                    tempClass.addClassTime(new ClassTime(
                            classStringArray[8],
                            classStringArray[9],
                            classStringArray[16],
                            classStringArray[17],
                            classStringArray[18],
                            classStringArray[19]));
                }else{
                    classes.add(tempClass);
                    tempClass = new Class(
                            classStringArray[0],
                            classStringArray[1],
                            classStringArray[2],
                            classStringArray[3],
                            classStringArray[4],
                            classStringArray[5],
                            classStringArray[6],
                            classStringArray[7],
                            classStringArray[10],
                            classStringArray[11],
                            classStringArray[12],
                            classStringArray[13],
                            classStringArray[14],
                            classStringArray[15]);
                    tempClass.addClassTime(new ClassTime(
                            classStringArray[8],
                            classStringArray[9],
                            classStringArray[16],
                            classStringArray[17],
                            classStringArray[18],
                            classStringArray[19]));
                }
            }
            classes.add(tempClass);
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
