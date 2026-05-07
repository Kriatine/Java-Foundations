import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
public class awrdfas {
    public static void main(String[] args) throws Exception {
        //()    try {
        //File file = new File("numbers.txt");
        Scanner inp = new Scanner("3\n34\n123456235\n456\n");
        //       Scanner inp = new Scanner("3\n34\n1234565\n456\n");
        //      Scanner inp = new Scanner(System.in);
//          System.out.print("How many numbers? ");
        //int howMany = inp.nextInt();
        int max = Integer.MIN_VALUE;
        //for(int i = 0; i < howMany; i++) {
        while(inp.hasNext()) {
            //System.out.print("Enter a number: ");
            int num = inp.nextInt();
            if(num > max)
                max = num;
        }
        PrintWriter out = new PrintWriter("numbersMax.txt");
        out.println("Max is " + max);
        out.close();
//       } catch(Exception ex) {
      }
    }


