package old;

import java.util.ArrayList;

public class ScheduleRank {



    private final int TIME_RATING_IN_FUNCTION_MAX = 999;


    public ScheduleRank(ArrayList<Schedule> possibleSchedules){
        this.possibleSchedules = possibleSchedules;
    }


    private ArrayList<Schedule> possibleSchedules;
    // private int[]


    private void rankingSchedules() {
        // get Time Ranking for each possible old.Schedule
            // through timeRank()

        // get old.Professor Ranking for each possible old.Schedule
            // through professorRank()

        // Prompt user for preference between Teacher or schedule

        // Declare int rankPoints to each possible old.Schedule

        // for each individual possible old.Schedule
            // if (Teacher > old.Schedule) {
                // int rankPoints = professorRank - timeRank
            // else if (old.Schedule > Teacher) {
                // int rankPoints = sum(professor.numberofratings) * timeRank - professorRank
            // else
                // int rankPoints = professorRank + sqrt(timeRank * sum(professor.numberofratings)

        // sort schedules by highest rankPoints
    }
    private int timeRank() {
        // pass time of Possible Schedules here

        // convert boolean schedule to int

        // b = convert time prefence into an array of schedule
            // ie [6][24*12] kind of matrix
            // place +1 if fall under time preference
            // ie for int start = starttime's array index, start < end
                // where end = endtime's array index
            // place -1 if a[count] != 1 (via for loop)

        // create new array [6][24*12]

        // c = multiply time preference with Possible old.Schedule's array
            // through each corresponding index
            // ie a[k][j] * b[k][j}

        // return sum(c)

        // **if no time preference, let b[any position] = 1

        return 0;
    }






    private int professorRank() {
        // open professor object
        // int easygrades = professor.ratings - professor.difficulty
        // int qualityTeacher = professor.ratings + professor.difficulty
        // if easy grades {
            // return professor.numberOfRatings * easygrades
        // else return sum(professor.numberOfRatings) * qualityTeacher

        return 0;
    }
}
