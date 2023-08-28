import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class StudentRoster {
    // variables
    private ArrayList<Student> roster;
    //roster constructor
    public StudentRoster(){
        roster = new ArrayList<Student>();
    }
    //set roster
    public void setRoster(ArrayList<Student> newRoster){
        roster = newRoster;
    }
    //get roster
    public ArrayList<Student> getRoster(){
        return roster;
    }
    //load roster of students into arrayList roster
    public void load_roster(String file){
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
            String last = "";
            String first = "";
            for(int i = 0; i < line.length(); i++){
                if(line.charAt(i) == ','){
                    last = line.substring(0, i);
                    first = line.substring(i+2);
                    break;
                }
            
            }

            Student s = new Student(last,first);
           
            roster.add(s);
            
            
        }
        infile.close();
    }
    //display the roster
    public void print_collection(){
        System.out.println("**** Those Students on roster ****");
        for(Student s: roster){
            System.out.println(s.getName());
        }
    }
    //display size of roster
    public void print_count(){
        System.out.println("roster size: " + roster.size());
    }
    //returns student given an index
    public Student getStudent(int index){
        return roster.get(index);
    }
    //returns true/false if a name is on the roster
    public boolean is_on_roster(String name){
        for(Student s: roster){
            if(s.getName() == name){
                return true;
            }
        }
        return false;
    }
}