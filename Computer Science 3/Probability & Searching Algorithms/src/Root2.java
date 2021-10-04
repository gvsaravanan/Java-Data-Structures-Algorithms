public class Root2 {
    public static void main(String[] args) {
        int counter = 0;

        for (int i = 1; i <= 10000; i++) {
            if (isSquareRoot(i) && isCubeRoot(i)) {
                System.out.println(i);
                counter++;
            }
        }

        System.out.println("\nCount: " + counter);
    }

    public static boolean isSquareRoot(int number) {
        return (Math.sqrt(number) % 1 == 0);
    }

    public static boolean isCubeRoot(int number) {
        return (Math.cbrt(number) % 1 == 0);
    }
}
