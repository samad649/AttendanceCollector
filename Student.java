public class Student {
    // variables
    private String last;
    private String first;

// constructors for students 
// needs a last and first name
public Student(String last, String first){
    this.last = last;
    this.first = first;
}
public void setFirst(String newfirst){
this.first = newfirst;
}
public void setLast(String newlast){
this.last = newlast;
}
public String getFirst(){
    return first;
}
public String getLast(){
    return last;
}
// returns name formatted like it was in file
public String getName(){
    return this.last + ", " + this.first;
}
public String toString(){
    return getName();
}

}
