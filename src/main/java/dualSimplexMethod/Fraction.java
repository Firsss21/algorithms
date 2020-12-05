package dualSimplexMethod;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if(denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }
        this.numerator = numerator;
        this.denominator = denominator;
        shorten();
    }

    public Fraction(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    public Fraction() {

    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public double doubleValue() {
        if ((double) numerator == 0) return 0;
        return ((double) numerator)/((double) denominator);
    }


    public float floatValue() {
        return (float) this.doubleValue();
    }

    private void shorten() {
        if(this.numerator == this.denominator && this.numerator != 0) {
            this.numerator = 1; this.denominator = 1;
        }

        for (int i = 10; i > 1; i--) {
            while ((this.denominator %i == 0) && (this.numerator %i == 0) && this.denominator != 0 && this.numerator != 0)
            {
                this.denominator/=i;
                this.numerator/=i;
            }
        }
    }

    @Override
    public String toString() {
        String string = this.numerator + "/" + this.denominator;

        if (this.numerator == 0 || this.denominator == 0)
            string = "" + this.numerator;
        if (this.denominator == 1)
            string = "" + this.numerator;
        return string;
    }

    public Fraction addition(Fraction first, Fraction second) {
        return new Fraction(((first.numerator*second.denominator) + (second.numerator*first.denominator)),(first.denominator * second.denominator));
    }

    public Fraction subtraction(Fraction first, Fraction second) {
        int numerator_temp = ((first.numerator*second.denominator) - (second.numerator*first.denominator));
        int denominator_temp =  (first.denominator * second.denominator);
        if (numerator_temp == 0) denominator_temp = 1;

        return new Fraction(numerator_temp,denominator_temp);
    }

    public Fraction division(Fraction first, Fraction second) {
        return new Fraction((first.numerator*second.denominator),(first.denominator * second.numerator));
    }

    public Fraction multiplication(Fraction first, Fraction second) {
        return new Fraction((first.numerator*second.numerator),(first.denominator * second.denominator));
    }
}
