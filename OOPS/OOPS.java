public class OOPS{
    public static void main(String[] args) {
        Pen p1=new Pen();//Creating an object
        System.out.println(p1.color);
        Student s1= new Student();
        s1.marks[0]=4;
        System.out.println(s1.marks[0]);
        Animals a= new Fish();//Object can be created from parent reference vice versa is false
    }
}

class Pen{
    String color="red";
    int tip=5;

    //Private properties can only be accessed using getters and setters 
    String getColor(){
        return this.color;//this is a special keyword refers to the current object
    }
    
    void setColor(String newColor){
        color=newColor;
    }
    void setTip(int newTip){
        tip=newTip;
    }
}

class Student{
    String name;
    int roll;
    int marks[]=new int[3];
    // Parametrized Constructor
    // Student(String name, int roll){
    //     this.name=name;
    //     this.roll=roll;
    // }

    //Nonparameterized
    //Student(){
    //     System.out.println();
    // }

    // Copy Constructor Shallow
    // Student(Student s1){
    //     this.name=s1.name;
    //     this.roll=s1.roll;
    //     this.marks=s1.marks;
    // }

    //Deep copy
    // Student(Student s1){
        // marks = new int[3];
    //     this.name=s1.name;
    //     this.roll=s1.roll;
            // for(int i=0;i<3;i++){
                // this.marks[i]=s1.marks[i];
            // }
    // }
}

abstract class Animals{ // Cannot   instantiate abstract class (Careful)
    void eat(){
        System.out.println("Animals eat");
    }

    void breathe(){
        System.out.println("Animals breathe");
    }
    abstract void swim();// Abstract methods need definition in derived class
    // Can make constructors also 
}

//Derived class or Sub class
class Fish extends Animals{
    int fins;
    void swim(){
        System.out.println("Fishes swim");
    }
}

interface Chessplayer{
    void moves();
}

class Queen implements Chessplayer{
    public void moves(){
        System.out.println("anywhere");
    }
}




