package structures;

public class Class {
    private String select;
    private String crn;
    private String crse;
    private String sec;
    private String cmp;
    private String cred;
    private String title;
    private ClassTime[] classTimes;

    public Class(String select, String crn, String crse, String sec, String cmp, String cred, String title, ClassTime[] classTimes){
        this.select = select;
        this.crn = crn;
        this.crse = crse;
        this.sec = sec;
        this.cmp = cmp;
        this.cred = cred;
        this.title = title;
        this.classTimes = classTimes;
    }

    public Class(String[] strings, ClassTime[] classTimes){
        this(strings[0],strings[1],strings[2],strings[3],strings[4],strings[5],strings[6], classTimes);
    }

}
