package structures;

import java.util.ArrayList;

public class Department {
    private String name;
    private ArrayList<Class> classes;

    public Department(String name, ArrayList<Class> classes){
        this.name = name;
        this.classes = classes;
    }

}
