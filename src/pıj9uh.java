import java.util.Scanner;

public class pıj9uh {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");

        int num1 = scanner.nextInt();

        if(isPrime(num1))
            System.out.println(num1 + " is a prime number.");
        else
            System.out.println(num1 + " is not a prime number.");

    }
    public static boolean isPrime(int x){
        boolean temp = true;
        for(int i = 2; x > i; i++){
            if(x % i == 0){
                temp = false;
                break;
            }

        }
        return temp;

    }
}
