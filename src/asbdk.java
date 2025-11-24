import java.util.Scanner;
import java.lang.Math;

public class asbdk {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int numOfDigit = 0;
        int sum = 0;
        double sumTemp = 0;
        int numOrig = number;

        for(int i = 1; (number / i*10) != 0; i = i * 10) {
            numOfDigit++;
        }
        System.out.println(number + " is " + numOfDigit + " digits");

        System.out.print("Total = ");
        for(int i = 1; i <= numOfDigit; i++){
            sum += Math.pow(number % 10, numOfDigit);
            int digit = number % 10;
            number = number / 10;
            if(numOfDigit > i)
                System.out.print(digit + " ^ " + numOfDigit + " + ");
            else
                System.out.print(digit + " ^ " + numOfDigit + " = ");

        }
        System.out.println(sum);

        if(sum == numOrig)
            System.out.println(numOrig + " is an Armstrong number");
        else
            System.out.println((numOrig + " is not an Armstrong number"));
        scanner.close();
    }
}