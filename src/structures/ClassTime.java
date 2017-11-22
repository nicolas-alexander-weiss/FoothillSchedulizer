package structures;

public class ClassTime {
    private int timestamp;
    private String[] instructors;
    private String location;
    private String attribute;

    public ClassTime(int timestamp,  String instructor, String location, String attribute){
        this.timestamp = timestamp;

        setInstructors(instructor);
        this.location = location;
        this.attribute = attribute;
    }

    public String toJSON(){

        String JSON = "{\"timestamp\":"+timestamp + ",\"instructors\":[";

        for(String instructor : instructors){
            JSON += "\""+instructor+"\",";
        }

        JSON = JSON.substring(0,JSON.length() - 1) + "],"
                +"\"location\":\""+location+"\"," +
                "\"attribute\":\""+attribute+"\"}";

        return JSON;
    }

    private void setInstructors(String instructorString) {
        String[] instructors = instructorString.split(",");
        for(int i = 0; i < instructors.length; i++){
            instructors[i] = instructors[i].trim();
        }
        this.instructors = instructors;
    }
}
