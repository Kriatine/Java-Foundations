public class Student {
    public String name;
    public int age;
    public int ssn = 1235324324;
    public Student(String name, int age, int number){
        this.name = name;
        this.age = age;
        ssn = number;
    }

    public void printStudent(){
        System.out.println(name + " " + age);
    }
}
