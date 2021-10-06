import java.lang.*;

public class Taxicab {
    public static void main(String[] args) {

        int count = 0;
        for (int i = 1; i < 100000; i++)
        {
            int numCount = 0;
            int a = 0;
            int b = 0;
            int c = 0;
            int d = 0;

            for (int j = 1; j <= Math.cbrt(i); j++) {
                for (int k = j + 1; k <= Math.cbrt(i); k++) {
                    if (j * j * j + k * k * k == i) {
                        if (a != 0 && b != 0) {
                            c = j;
                            d = k;
                        } else {
                            a = j;
                            b = k;
                        }
                        numCount++;
                    }
                }
            }

            if (numCount == 2)
            {
                count++;
                System.out.println(a + "^2 + " + b + "^2 = " + c + "^2 + " + d + "^2 = " + i);
            }
        }
        System.out.println(count);
    }
}
