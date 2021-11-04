public class Complex {
    public final double REAL;
    public final double IMAGINARY;

    public Complex() {
        REAL = 0.0;
        IMAGINARY = 0.0;
    }
    public Complex(double r, double i) {
        REAL = r;
        IMAGINARY = i;
    }

    public double abs() {
        return Math.hypot(REAL, IMAGINARY);
    }

    public Complex add(Complex that) {
        return new Complex(this.REAL + that.REAL, this.IMAGINARY + that.IMAGINARY);
    }

    public Complex subtract(Complex that) {
        return new Complex(this.REAL - that.REAL, this.IMAGINARY - that.IMAGINARY);
    }

    public Complex multiply(Complex that) {
        return new Complex(this.REAL * that.REAL - this.IMAGINARY * that.IMAGINARY, this.REAL * that.IMAGINARY + this.IMAGINARY * that.REAL);
    }

    public double REAL() {
        return REAL;
    }

    public double IMAGINARY() {
        return IMAGINARY;
    }
}