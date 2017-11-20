package structures;

public class ClassTime {
    private int timestamp;
    private String instructor;
    private String location;
    private String attribute;

    public ClassTime(int timestamp,  String instructor, String location, String attribute){
        this.timestamp = timestamp;
        this.instructor = instructor;
        this.location = location;
        this.attribute = attribute;
    }

    public String toJSON(){
        return "{\"timestamp\":"+timestamp+"," +
                "\"instructor\":\""+instructor+"\"," +
                "\"location\":\""+location+"\"," +
                "\"attribute\":\""+attribute+"\"}";
    }

}
