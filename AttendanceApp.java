import java.util.List;
import java.util.ArrayList;

public class AttendanceApp {
    //variables
    private AttendanceLog logs;
    private StudentRoster roster;

    public AttendanceApp(){
        roster = new StudentRoster();
        logs = new AttendanceLog();

       // roster.load_roster(rosterFile);
        // logs.load_log(swipeFile);
    }
    //get roster
    public StudentRoster getRoster(){
        return roster;
    }
    //get logs
    public AttendanceLog getLogs(){
        return logs;
    }
    //function compares times and returns true if t1 is < t2
    public boolean compare_times(String t1, String t2){
        int hour1 = Integer.parseInt(t1.substring(0, 2));
        int min1 = Integer.parseInt(t1.substring(3, 5));
        int sec1 = Integer.parseInt(t1.substring(6));

        int hour2 = Integer.parseInt(t2.substring(0, 2));
        int min2 = Integer.parseInt(t2.substring(3, 5));
        int sec2 = Integer.parseInt(t2.substring(6));

        if(hour1 < hour2){
            return true;
        }
        else if(hour1 == hour2){
            if(min1 < min2){
                return true;
            }
            else if(min1 == min2){
                if(sec1 < sec2){
                    return true;
                }
            }
        }
        return false;
    }
    // returns a list of students not on the log
    public ArrayList<Student> list_students_not_in_class(){
        ArrayList<Student> badStudentList = new ArrayList<Student>();
        for(Student s: roster.getRoster()){
            if(logs.is_on_log(s.getName()) == false){
                badStudentList.add(s);
            }
        }
        return badStudentList;
    }
    // returns a list of all logs given a student
    public ArrayList<Log> list_all_times_checking_in_and_out(Student s){
        ArrayList<Log> ioLogs = new ArrayList<Log>();
        for(Log l: logs.getLogs()){
            if(l.getStudent().getName().equals(s.getName())){
                ioLogs.ensureCapacity(ioLogs.size()*2);
                ioLogs.add(l);
            }
        }
        return ioLogs;
    }
    // returns a list of everyones first swipe
    public ArrayList<Log> list_all_times_checked_in(){
        ArrayList<Log> list = new ArrayList<Log>();
        for(Log l : logs.getLogs()){
            boolean inlist = false;
            for(Log s: list){
                if(l.getStudent().getName().equals(s.getStudent().getName())){
                    inlist = true;
                }
            }
            if(inlist == false){
                list.ensureCapacity(list.size()*2);
                list.add(l);
            }
        }
        return list;
    }
    // returns a list of students logs of those late to class
    public ArrayList<Log> list_students_late_to_class(String time){
        ArrayList<Log> list = list_all_times_checked_in();
        ArrayList<Log> late = new ArrayList<Log>();
        int hour = Integer.parseInt(time.substring(0, 2));
        int min = Integer.parseInt(time.substring(3, 5));
        int sec = Integer.parseInt(time.substring(6));
        for(Log l: list){
            if(l.getHour()  > hour + 2){
                //do nothing
                // in different class
            }
            else if(l.getHour() > hour){
                late.ensureCapacity(late.size()*2);
                late.add(l);
            }
            else if(l.getHour() == hour){
                if(l.getMin() > min){
                    late.ensureCapacity(late.size()*2);
                    late.add(l);  
                }
                else if(l.getMin() == min){
                    if(l.getSec() > sec){
                        late.ensureCapacity(late.size()*2);
                        late.add(l);
                    }
                }
            }
        }
        return late;
    }
    //returns a list of logs of a given student
    public ArrayList<Log> list_of_logs_of_student(Student s){
        ArrayList<Log> list = new ArrayList<Log>();
        for(Log l : logs.getLogs()){
            if(l.getStudent().getName().equals(s.getName())){
                //list.ensureCapacity(list.size()*2);
                list.add(l);
            }
        }
        return list;
    }
    // prints all the attendance data given a student
    public void print_attendance_data_for_student(Student s){
        System.out.println("********* Looking up Student Attendance Data ***********");
        boolean hasLog = false;
        for(Log l: logs.getLogs()){
            if(l.getStudent().getName().equals(s.getName())){
                hasLog = true;
                System.out.println(l.getLog());
        }
    }
    if(hasLog = false){
        System.out.println("No student of this name in the attendance log");
    }
    }
    //returns true if a student shows on a certain day
    public boolean is_present(Student s, String date){
        for(Log l: logs.getLogs()){
            if(l.getStudent().getName().equals(s.getName()) && l.getDate().equals(date)){
                return true;
            }
        }
        return false;
    }
    //return a list of logs on a given day
    public ArrayList<Log> list_of_logs_on_day(String date){
        ArrayList<Log> list = new ArrayList<Log>();
        ArrayList<Log> list1 = list_all_times_checked_in();
        //System.out.println(list1.size());
        for(Log l: list1){
            if(l.getDate().equals(date)){
                //System.out.println(l.getLog());
                //list.ensureCapacity(list.size()*2);
                list.add(l);
            }
        }
        return list;
    }
    //return a list of students present given a date
    public ArrayList<Student> list_all_students_checked_in(String date){
        ArrayList<Student> studentList = new ArrayList<Student>();
        for(Log l: logs.getLogs()){
            if(l.getDate().equals(date)){
                //studentList.ensureCapacity(studentList.size()*2);
                studentList.add(l.getStudent());
            }
        }
        return studentList;
    }
    //return a list of students present on a given date and b4 a given time
    public ArrayList<Student> list_all_students_checked_in_before(String date, String time){
        ArrayList<Student> list = new ArrayList<Student>();
        //list of all logs on a day
        ArrayList<Log> dayList = list_of_logs_on_day(date);
        //list of everyones first swipe
        ArrayList<Log> firstSwList = list_all_times_checked_in();

        ArrayList<Log> firstDayList = new ArrayList<Log>();

        //create a list of all logs that are both on a day and first swipes
        for(Log l: dayList){
            for(Log s: firstSwList){
                if(l.getStudent().getName().equals(s.getStudent().getName()) && l.getDate().equals(s.getDate()) && l.getTime().equals(s.getTime())){
                    //firstDayList.ensureCapacity(firstDayList.size()*2);
                    firstDayList.add(l);
                }
            }
        }

        for(Log l: firstDayList){
            if(compare_times(l.getTime(),time)){
                //list.ensureCapacity(list.size()*2);
                list.add(l.getStudent());
            }
        }

        return list;
    }
    //return a list of students that have attended a (integer) particular amount of days
    public ArrayList<Student> list_students_attendance_count(int days){
        ArrayList<Student> list = new ArrayList<Student>();
        // loop through the roster and get every log of that student
        for(Student s: roster.getRoster()){
            int num = 0;
            ArrayList<Log> logList = list_of_logs_of_student(s);
            ArrayList<String> dayList = new ArrayList<String>();
            // loop through the logs and see how many different days are on there
            for(Log l: logList){
                boolean inList = false;
                for(String str: dayList){
                    if(str.equals(l.getDate())){
                        inList = true;
                    }
                }
                if(inList == false){
                    num++;
                    dayList.add(l.getDate());
                }
            }
            if(num == days){
                //list.ensureCapacity(list.size()*2);
                list.add(s);
            }
        }
        return list;
    }
    // returns the earliest student given a day
    public Student get_first_student_to_enter(String date){
        ArrayList<Log> list = list_of_logs_on_day(date);

        if(list.size() == 0){
            System.out.println("NO LOGS OF THIS DATE");
        }
        else{
            Log earlistLog = list.get(0);
            //System.out.print(earlistLog.getLog());
        
        for(Log l: list){
            if(compare_times(l.getTime(), earlistLog.getTime())){
                earlistLog = l;
            }
        }
        Student early = earlistLog.getStudent();
        return early;
    }
    return null;
    }
    //strips null elements from a list
    public void stripList(ArrayList<?> list){
        list.removeIf(e -> e == null);
    }
    //prints the number of items in a query
    public void print_count(ArrayList<?> list){
        System.out.println("There were " + list.size() + " records for this query");
    }
    //print the list of a query
    public void print_query_list(String query, ArrayList<?> list){
        stripList(list);
        System.out.println("**** " + query + " ****");
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
        print_count(list);
        
    }
}
