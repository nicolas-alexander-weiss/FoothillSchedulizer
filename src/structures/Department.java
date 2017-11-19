package structures;

import java.util.ArrayList;

public class Department {
    private String name;
    private ArrayList<String[]> classes;

    public Department(String name, ArrayList<String[]> classes){
        this.name = name;
        this.classes = classes;
    }

}
