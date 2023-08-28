import java.util.ArrayList;
import java.io.*;
import java.util.*;


public class AttendanceLog {
    //variables
    private ArrayList<Log> logs;
    //constructor
    public AttendanceLog(){
        logs = new ArrayList<Log>();
    }
    //setter
    public void setLogs(ArrayList<Log> newLogs){
    logs = newLogs;
    }
    //getter
    public ArrayList<Log> getLogs(){
        return logs;
    }
    //load data from file
    public void load_log(String file){
        Scanner infile = null;
        try
		{
		     infile = new Scanner(new FileReader(file));
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File not found");
			e.printStackTrace(); // prints error(s)
			System.exit(0); // Exits entire program
		}
        while(infile.hasNextLine()){
            String line = infile.nextLine();
            String[] arr = line.split(", ");
            String last = arr[0];
            String first = arr[1];
            String time = arr[2];
            String date = arr[3];
            date=date.trim();
            time=time.trim();
            Student s = new Student(last,first);
            //System.out.println(s.getName());

            //logs.ensureCapacity(logs.size() * 2);
            logs.add(new Log(s,time,date));
        }
        infile.close();
    }
    //print all values of logs
    public void print_collection(){
        for(Log l: logs){
            System.out.println(l.getLog());
        }
    }
    //print size of logs
    public void print_count(){
        System.out.println("Logs count: " + logs.size());
    }
    //checks if a student is on the log
    public boolean is_on_log(String name){
        //System.out.println("** This is the entire Collection Data currently stored **");
        //System.out.println(name.length());
        //System.out.println(name);
        for(Log l: logs){ 
            if(l.getStudent().getName().equals(name)){
                return true;
            }
        }
        return false;
    }
}
