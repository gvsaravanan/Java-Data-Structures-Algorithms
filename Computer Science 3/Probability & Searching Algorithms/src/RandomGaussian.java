import java.lang.*;

public class RandomGaussian {
    public static void main(String[] args) {
        double r = Math.sin(2 * Math.PI * Math.random()) * Math.sqrt((-2 * Math.log(Math.random())));
        System.out.println("Random Gaussian number: " + r);
    }
}
