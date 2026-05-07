
import java.io.PrintWriter;

public class asdasd {
    public static void main(String[] args) throws Exception {
        args = new String[]{"20250808007"};

            int a = 0;
            int b = 0;
            long sId = Long.parseLong(args[0]);
            long num = sId;
            int[] arr = new int[args[0].length()];

            for(int i = 0; i < arr.length; ++i) {
                arr[i] = (int)(num % 10L) % 4 + 1;
                num /= 10L;
            }
            for(int i = 0; i < arr.length; i++)
                System.out.print(arr[i]);

            if (a + b != 0) {
                PrintWriter out = new PrintWriter(args[0] + "_0.txt");
                out.println(0);
                out.close();

                for(int i = 1; i < arr.length; ++i) {
                    out = new PrintWriter("20250808007" + "_" + i + ".txt");
                    out.println(arr[arr.length - 1 - i]);
                    out.close();
                    if (arr[i] > 0) {
                        ++a;
                        System.out.println("ERROR " + a + ": incompatible number found.");
                    }
                }
            } else {
                for(int i = 0; i < arr.length; ++i) {
                    PrintWriter out = new PrintWriter("20250808007" + "_" + i + ".txt");
                    out.println(arr[i]);
                    out.close();
                    if (arr[i] == 1) {
                        ++b;
                        System.out.println("ERROR " + b + ": incompatible number found.");
                    }
                }
            }

            System.out.println(a + b + " ERRORS found.");
        }

    }
