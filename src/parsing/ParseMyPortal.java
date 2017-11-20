package parsing;

import jdk.nashorn.internal.parser.JSONParser;
import structures.Department;
import structures.Class;
import structures.ClassTime;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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

            tempClass.addClassTimes(getClassTimes(
                    classStringArray[8],
                    classStringArray[9],
                    classStringArray[16],
                    classStringArray[17],
                    classStringArray[18],
                    classStringArray[19]));
            for(int i = 2; i < classStringArrays.size(); i++){
                classStringArray = classStringArrays.get(i);

                if(classStringArray[0].charAt(0) == ParseMyPortal.WHITE_SPACE_CHARACTER){
                    tempClass.addClassTimes(getClassTimes(
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
                    tempClass.addClassTimes(getClassTimes(
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



        //System.out.println(departmentsToJSON(departments));

        String JSON = departmentsToJSON(departments);

        FileWriter fileWriter = new FileWriter("resources/fh2018winter/fh2018winter.json", false);

        fileWriter.append(JSON).flush();

        System.out.println("end");
    }

    private static String departmentsToJSON(ArrayList<Department> departments) {
        StringBuilder stringBuilder = new StringBuilder("{\"departments\":[");
        for(Department department:departments){
            stringBuilder.append(department.toJSON() + ",");
        }
        stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), "");
        stringBuilder.append("]}");
        return stringBuilder.toString();
    }

    private static ClassTime[] getClassTimes(String days, String time,String instructor, String date, String location, String attribute) {

        String[] daysArray = seperateCamelCase(days);

        int[] timestamps = getTimeStamps(time, daysArray);

        ClassTime[] classTimes = new ClassTime[timestamps.length];
        for(int i = 0; i < classTimes.length; i++){
            classTimes[i] = new ClassTime(timestamps[i], instructor, location, attribute);
        }

        return classTimes;
    }

    private static int[] getTimeStamps(String time, String[] days) {
        int[] timestamps = new int[days.length];
        for(int i = 0; i < timestamps.length; i++){
            timestamps[i] = getTimeStamp(time,days[i]);
        }
        return timestamps;
    }

    private static int getTimeStamp(String timeInterval, String day) {
        return ((int)Math.pow(10,8))*dayToInt(day) + timeIntervalToInt(timeInterval);
    }

    private static int timeIntervalToInt(String timeInterval) {
        String[] times = timeInterval.split("-");
        //06:00 pm-08:50 pm"

        if(times.length != 2){
            return -1;
        }else{
            String[] t0 = times[0].split(":");
            String[] t1 = times[1].split(":");

            int timeBegin =
                    Integer.parseInt(t0[0]) * (int)Math.pow(10,2)
                    + Integer.parseInt(t0[1].substring(0,2));
            int timeEnd =
                    Integer.parseInt(t1[0]) * (int)Math.pow(10,2)
                            + Integer.parseInt(t1[1].substring(0,2));
            return timeBegin * (int)Math.pow(10,4) + timeEnd;
        }

    }

    /**
     *
     * @param day M,T,W,Th/R,F,S,U
     * @return day as integer
     */
    private static int dayToInt(String day) {
        switch (day){
            case "M":
                return 0;
            case "T":
                return 1;
            case "W":
                return 2;
            case "Th":
                return 3;
            case "R":
                return 3;
            case "F":
                return 4;
            case "S":
                return 5;
            case "U":
                return 6;
            default:
                return 0;
        }
    }

    private static String[] seperateCamelCase(String s) {
        ArrayList<String> strings = new ArrayList<>();

        int counter = 0;
        int lastIndex = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c >= 65 && c <= 90){
                if(counter > 0){
                    strings.add(s.substring(lastIndex, i));
                    lastIndex = i;
                }
                counter++;
            }
        }

        strings.add(s.substring(lastIndex, s.length()));

        String[] stringsArray = new String[strings.size()];

        for(int i = 0; i < strings.size(); i++){
            stringsArray[i] = strings.get(i);
        }

        return stringsArray;
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
