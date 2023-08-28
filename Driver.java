

package application; // could be different

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.util.Scanner;
import java.util.ArrayList;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.OutputStream;
public class Driver extends Application{


static Button A; static Button B;
static Button C; static Button D;
static Button E; static Button F;
static Button G; static Button H;
static Button I; static Button J;
static Button K; static Button L;
static Button M; static Button N;
static Button O; static Button P;
static Button Q; static Button R;
static Button S; static Button EXIT;

private TextArea tf;

private TextArea instructions;

private static TextField input;

private VBox root;

private HBox row1;
private HBox row2;
private HBox row3;
private HBox row4;
private HBox row5;
private File file1;
private File file2;

static Boolean buttonPressed = false;
Button[] num;

static Button submit;

ArrayList<?> queryList;
String currentQ = "";
AttendanceApp app = new AttendanceApp();


public static Student grabStudent(){
		
	input.setVisible(true);
	submit.setVisible(true);
    //Scanner input = new Scanner(System.in);
    System.out.println("Enter student's last name: ");
    while(buttonPressed == false) {
    	// wait for button press
    }
    String lastName = input.getText();
    input.clear();
    buttonPressed = false;
    System.out.println("Enter student's first name: ");
    while(buttonPressed == false) {
    	// wait for button press
    }
    String firstName = input.getText();
    input.clear();
    buttonPressed = false;
	input.setVisible(false);
	submit.setVisible(false);
    Student s = new Student(lastName,firstName);
    return s;
}
public static String grabDate(){
	input.setVisible(true);
	submit.setVisible(true);
    //Scanner input = new Scanner(System.in);
    System.out.println("Enter a date: ");
   // while(buttonPressed == false) {
    	// wait for button press
  //  }
    String date = input.getText();
    input.clear();
    buttonPressed = false;
	input.setVisible(false);
	submit.setVisible(false);
	
    return date;
	
}
public static String grabTime(){
	input.setVisible(true);
	submit.setVisible(true);
    //Scanner input = new Scanner(System.in);
    System.out.println("Enter a timeStamp: ");
    String timeStamp = input.getText();
    input.clear();
    buttonPressed = false;
	input.setVisible(false);
	submit.setVisible(false);
    return timeStamp;
}
public static int grabDays(){
	input.setVisible(true);
	submit.setVisible(true);
    //Scanner input = new Scanner(System.in);
    System.out.println("Enter number of days: ");
    String sdays = input.getText();
    int days = Integer.parseInt(sdays);
    input.clear();
    buttonPressed = false;
	input.setVisible(false);
	submit.setVisible(false);
    return days;

	
}
public static void addTextBox(VBox vbox) {
	TextField textField = new TextField();
	vbox.getChildren().add(textField);

	// Set the VBox alignment to bottom
	vbox.setAlignment(Pos.BOTTOM_CENTER);
}
public static void main(String[] args){

launch(args);

}
EventHandler<ActionEvent> inp = new EventHandler<ActionEvent>() {
	 ;
	public void handle(ActionEvent event)
	  {
		
		buttonPressed = true;

	  } 
	  };
	  


  public void start(Stage stage){
	    FileChooser fileChooser = new FileChooser();
	    fileChooser.setTitle("Open Roster");
	    File selectedFile = fileChooser.showOpenDialog(stage);
	    if (selectedFile != null) {
	    	file1 = selectedFile;
	        System.out.println(selectedFile.getAbsolutePath());
	    }
	    FileChooser fileChooser2 = new FileChooser();
	    fileChooser.setTitle("Open Logs");
	    File selectedFile2 = fileChooser2.showOpenDialog(stage);
	    if (selectedFile != null) {
	    	file2 = selectedFile2;
	        System.out.println(selectedFile2.getAbsolutePath());
	    }
	    
	    
	  root = new VBox();
	  row1 = new HBox();
	  row2 = new HBox();
	  row3 = new HBox();
	  row4 = new HBox();
	  row5 = new HBox();
	  row1.setSpacing(20);
	  row2.setSpacing(15);
	  row3.setSpacing(30);
	  row4.setSpacing(40);
	  row5.setSpacing(50);
	  submit = new Button("Enter");
	  submit.setOnAction(inp);
	  input = new TextField();
	  input.setVisible(false);
	  submit.setVisible(false);
	  row5.getChildren().add(input);
	  row5.getChildren().add(submit);
	  tf = new TextArea();
	  instructions = new TextArea();
	  PrintStream ps = new PrintStream(new OutputStream() {
	        public void write(int b) throws IOException {
	            tf.appendText(String.valueOf((char) b));
	        }
	    });
	  
	  System.setOut(ps);
	  
	  tf.setWrapText(true);
	  tf.setEditable(false);
	  instructions.setEditable(false);
	  instructions.setText("*** Here are your options *** \n"
	  		+ "0 - Exit Program \n"
	  		+ "(AttendanceLog)  \n"
	  		+ "A - load_log() \n"
	  		+ "B - print_collection() \n"
	  		+ "C - print_count() \n"
	  		+ "(StudentRoster) \n"
	  		+ "D - load_log() \n"
	  		+ "E - print_collection() \n"
	  		+ "F - print_count() \n"
	  		+ "(AttendanceApp) \n"
	  		+ "G - list_students_not_in_class() \n"
	  		+ "H - list_all_times_checking_in_and_out() \n"
	  		+ "I - list_all_times_checked_in() \n"
	  		+ "J - list_students_late_to_class() \n"
	  		+ "K - get_first_student_to_enter() \n"
	  		+ "L - print_attendance_data_for_student() \n"
	  		+ "M - is_present() \n"
	  		+ "N - list_all_students_checked_in() \n"
	  		+ "O - list_all_students_checked_in_before() \n"
	  		+ "P - list_students_attendance_count() \n"
	  		+ "Q - get_first_student_to_enter() \n"
	  		+ "R - print_query_list() \n"
	  		+ "S - print_count() \n");
	  //tf.setStyle("-fx-border-color:transparent transparent transparent #293036;-fx-background-color:#000000;-fx-focus-color:transparent;-fx-faint-focus-color:transparent;-fx-font-Size:80;-fx-border-width:3px;");
	  root.getChildren().add(instructions);
	  root.getChildren().add(tf);
	  num = new Button[20];
	  num[0]=A = new Button("A");
	    num[1]=B = new Button("B");
	    num[2]=C = new Button("C");
	    num[3]=D = new Button("D");
	    num[4]=E = new Button("E");
	    num[5]=F = new Button("F");
	    num[6]=G = new Button("G");
	    num[7]=H = new Button("H");
	    num[8]=I = new Button("I");
	    num[9]=J = new Button("J");
	    num[10]=K = new Button("K");
	    num[11]=L = new Button("L");
	    num[12]=M = new Button("M");
	    num[13]=N = new Button("N");
	    num[14]=O = new Button("O");
	    num[15]=P = new Button("P");
	    num[16]=Q = new Button("Q");
	    num[17]=R = new Button("R");
	    num[18]=S = new Button("S");
	    num[19]=EXIT = new Button("0");
	    
	    root.setSpacing(10);
	   for(int i = 0; i < 20; i++) {
		   num[i].setMinWidth(40);
	          num[i].setMinHeight(25);
	          num[i].setStyle("-fx-Font-Size:20;-fx-background-color:#234D71;-fx-focul-color:#228B22;-fx-text-fill: #D9EEED;");
	          num[i].setOnAction(b1);
	          num[i].setId(""+i);
	   }
	   for(int i = 0; i < 5; i++) {
		   row1.getChildren().add(num[i]);
	   }
	   for(int i = 5; i < 10; i++) {
		   row2.getChildren().add(num[i]);
	   }
	   for(int i = 10; i < 15; i++) {
		   row3.getChildren().add(num[i]);
	   }
	   for(int i = 15; i < 20; i++) {
		   row4.getChildren().add(num[i]);
	   }
	   root.getChildren().addAll(row1, row2, row3, row4, row5);
	   Scene scene = new Scene(root,900,1400);
    
	   // tf.setText(menu);
    		        
    

    
    
    
    
    
    
    stage.setScene(scene);
    stage.show();
    
    
    
    
    
    
    
  }
  
  EventHandler<ActionEvent> b1 = new EventHandler<ActionEvent>() {
	  System.out.println("hello");
	  public void handle(ActionEvent event)
	  {
		  Button button = (Button) event.getSource();
		  String c = button.getText();
		  
	         switch(c){
	            case "A":
	            app.getLogs().load_log(file2);
	            tf.setText("****** successfully loaded AttendanceLog ******");
	            break;
	            case "B":
	            	tf.setText(" ");
	            app.getLogs().print_collection();
	            break;
	            case "C":
	            tf.setText(" ");
	            app.getLogs().print_count();
	            break;
	            case "D":
	            app.getRoster().load_roster(file1);
	            tf.setText("***** successfully loaded Roster ******");
	            break;
	            case "E":
	            	tf.setText(" ");
	            app.getRoster().print_collection();
	            break;
	            case "F":
	            	tf.setText(" ");
	            app.getRoster().print_count();
	            break;
	            case "G":
	            currentQ = "Students missing in class";
	           queryList = app.list_students_not_in_class();
	            break;
	            case "H":
	            	input.setVisible(true);
	            	submit.setVisible(true);
	            Student s = grabStudent();
	            currentQ = "List all swipes in and out for a student";
	            queryList = app.list_all_times_checking_in_and_out(s);
	            break;
	            case "I":
	            currentQ = "Check in times for all students who attended";
	            queryList = app.list_all_times_checked_in();
	            break;
	            case "J":
	            String time = grabTime();
	            currentQ = "Students that arrived late";
	            queryList = app.list_students_late_to_class(time);
	            break;
	            case "K":
	            String date = grabDate();
	            currentQ = "First student to enter on " + date;
	            Student s2 = app.get_first_student_to_enter(date);
	            ArrayList<Student> studentQ = new ArrayList<Student>();
	            studentQ.add(s2);
	            queryList = studentQ;
	            break;
	            case "L":
	            Student s3 = grabStudent();
	            currentQ = "Looking up Student Attendance Data";
	            tf.clear();
	             app.print_attendance_data_for_student(s3);
	            break;
	            case "M":
	            Student s4 = grabStudent();
	            String date2 = grabDate();
	            currentQ = "Looking to see if Student was present on " + date2;
	            boolean isP = app.is_present(s4,date2);
	            ArrayList<Boolean> boolQ = new ArrayList<Boolean>();
	            boolQ.add(isP);
	            queryList = boolQ;
	            break;
	            case "N":
	            String date3 = grabDate();
	            currentQ = " Students present on this date";
	            queryList = app.list_all_students_checked_in(date3);
	            break;
	            case "O":
	            String date4 = grabDate();
	            String timeString = grabTime();
	            currentQ = "Those present on date & before a time assigned";
	            queryList = app.list_all_students_checked_in_before(date4,timeString);
	            break;
	            case "P":
	            int days = grabDays();
	            currentQ = "Those who attended " + days + " class(s)";
	            queryList = app.list_students_attendance_count(days);
	            break;
	            case "Q":
	            String date5 = grabDate();
	            currentQ = "First student to enter on " + date5;
	            Student s5 = app.get_first_student_to_enter(date5);
	            ArrayList<Student> studentQ2 = new ArrayList<Student>();
	            studentQ2.add(s5);
	            queryList = studentQ2;
	            break;
	            case "R":
	            	tf.setText(" ");
	            app.print_query_list(currentQ,queryList);
	            break;
	            case "S":
	            	tf.setText(" ");
	            app.print_count(queryList);
	            break;
	            case "0":
	            System.exit(0);
	            break;
	            default:
	            	tf.setText(" ");;
	            System.out.println("Invalid option");
	            break;

	         }
	  }
	  };
  
}