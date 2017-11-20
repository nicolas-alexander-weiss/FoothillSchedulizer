package structures;

import java.util.ArrayList;

public class Department {
    private String name;
    private ArrayList<Class> classes;

    public Department(String name, ArrayList<Class> classes){
        this.name = name;
        this.classes = classes;
    }

    public String toJSON(){
        String json = "{\"name\":\""+name+"\",\"classes\":[";
        for(Class c : classes){
            json += c.toJSON() + ",";
        }
        json = json.substring(0,json.length()-1);
        json += "]}";

        return json;
    }

}
