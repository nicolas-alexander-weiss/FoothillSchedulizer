package structures;

import java.util.ArrayList;

public class Class {
    private String select,crn,subj,crse,sec,cmp,cred,title,cap,act,rem,wlCap,wlAct,wlRem;

    private ArrayList<ClassTime> classTimes;

    public Class(String select, String crn, String subj, String crse, String sec, String cmp, String cred, String title, String cap, String act, String rem, String wlCap, String wlAct, String wlRem, ArrayList<ClassTime> classTimes){
        this.select = select;
        this.crn = crn;
        this.subj = subj;
        this.crse = crse;
        this.sec = sec;
        this.cmp = cmp;
        this.cred = cred;
        this.title = title;
        this.cap = cap;
        this.act = act;
        this.rem = rem;
        this.wlCap = wlCap;
        this.wlAct = wlAct;
        this.wlRem = wlRem;
        this.classTimes = classTimes;
    }

    public Class(String select, String crn, String subj, String crse, String sec, String cmp, String cred, String title, String cap, String act, String rem, String wlCap, String wlAct, String wlRem){
        this(select,crn,subj,crse,sec,cmp,cred,title,cap,act,rem,wlCap,wlAct,wlRem, new ArrayList<ClassTime>());
    }

    public boolean addClassTime(ClassTime classTime){
        this.classTimes.add(classTime);
        return true;
    }
}
