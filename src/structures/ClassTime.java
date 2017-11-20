package structures;

public class ClassTime {
    private String time;
    private String instructor;
    private String date;
    private String location;
    private String attribute;

    public ClassTime(String timeString,  String instructor, String date, String location, String attribute){
        this.time = timeString;
        this.instructor = instructor;
        this.date = date;
        this.location = location;
        this.attribute = attribute;
    }

    public String toJSON(){
        return "{\"time\":"+time+"," +
                "\"instructor\":\""+instructor+"\"," +
                "\"date\":\""+date+"\"," +
                "\"location\":\""+location+"\"," +
                "\"attribute\":\""+attribute+"\"}";
    }

}
