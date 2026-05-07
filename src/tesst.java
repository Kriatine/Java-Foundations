public class  tesst {
    public static void main(String[] args) {
        Student student = new Student("Yağız", 18, 324253221);
        student.name = "Mert";
        System.out.println(student.name);
        System.out.println(student.age);
        System.out.println(student.ssn);


        System.out.println(student.name);
        student.printStudent();
    }
}

