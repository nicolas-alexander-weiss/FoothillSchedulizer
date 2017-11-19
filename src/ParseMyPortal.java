import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ParseMyPortal {
    public static void main(String[] args) throws IOException {
        File input = new File("resources/inputfiles/mp");

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

        String[] subjects = fileParse.toString().split("<<<");

        for(String s : subjects){
            Scanner depScanner = new Scanner(s);
            String department = depScanner.nextLine();
            while (depScanner.hasNext()){

            }

        }


        System.out.println("stop");
    }
}
