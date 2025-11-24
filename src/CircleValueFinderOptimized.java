import java.util.Scanner;

public class CircleValueFinderOptimized {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        double radius;
        double circumference;
        double area;
        double volume;

        System.out.print("What is the radius of your object?:");
        radius = scanner.nextDouble();
        String ads = scanner.nextLine();

        System.out.print("Is your object a circle or a sphere?: ");
        String object = scanner.nextLine().toLowerCase();

        if(object.equals("circle")){

            circumference = 2*Math.PI*radius;
            area = Math.PI*Math.pow(radius, 2);
            System.out.printf("Your circles circumference is %.1fcm\n", circumference);
            System.out.printf("Your circles area is %.1fcm^2\n", area);
        }
        else if(object.equals("sphere")){

            area = 4*Math.PI*Math.pow(radius, 2);
            volume = 4/3*Math.PI*Math.pow(radius, 3);

            System.out.printf("Your spheres area is %.1fcm\n", area);
            System.out.printf(" Your spheres volume is %.1fcm\n", volume);
        }
        else{
            System.out.printf("Invalid object, please enter a valid object.");
        }
        scanner.close();



    }
}
