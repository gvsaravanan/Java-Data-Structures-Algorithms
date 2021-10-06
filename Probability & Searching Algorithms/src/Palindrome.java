public class Palindrome {
    public static void main(String[] args) {
        int counter = 0;

        for (int i = 1; i <= 10000; i++) {
            if (isPalindrome(i)) {
                counter++;
            }
        }

        System.out.println(counter);
    }

    public static boolean isPalindrome(int number) {
        int num = number;
        int reverse = 0;

        while(num != 0)
        {
            int remainder = num % 10;
            reverse = reverse * 10 + remainder;
            num /= 10;
        }

        if (number == reverse) {
            return true;
        }
        return false;
    }

    public static boolean isPalindromeString(int number) {
        String num = Integer.toString(number);
        if (num.equals(new StringBuilder(num).reverse().toString())) {
            return true;
        }
        return false;
    }
}
