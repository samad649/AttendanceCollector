public class Log {
    // all variables in a log
    Student s;
    String time;
    String date;
    //constructor
    public Log(Student s, String time, String date){
        this.s = s;
        this.time = time;
        this.date = date;
    }
    public String getTime(){
        return time;
    }
    public int getHour(){
        return Integer.parseInt(time.substring(0, 2));
    }
    public int getMin(){
        return Integer.parseInt(time.substring(3, 5));
    }
    public int getSec(){
        return Integer.parseInt(time.substring(6));
    }
    public String getDate(){
        return date;
    }
    public Student getStudent(){
        return s;
    }
    public void setTime(String time){
        this.time = time;
    }
    public void setDate(String date){
        this.date = date;
    }
    public void setStudent(Student s){
        this.s = s;
    }
    public String getLog(){
        return s.getName() + ", " + getTime() + ", " + getDate();
    }
    public String toString(){
        return getLog();
    }
}
