public class SieveOfEratosthenes {
    public static void main(String[] args) {
        int num = 500;
        boolean prime[] = new boolean[num + 1];

        for (int i = 0; i <= num; i++)
            prime[i] = true;

        for (int i = 2; Math.pow(i, 2) <= num; i++) {
            if (prime[i] == true) {
                for (int j = (int) Math.pow(i, 2); j <= num; j += i)
                    prime[j] = false;
            }
        }

        for (int i = 2; i <= num; i++)
        {
            if (prime[i] == true)
                System.out.print(i + " ");
        }
    }
}
