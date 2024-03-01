import java.lang.Math;
class Trojkat {
    int a;
    int b;
    int c;
    Trojkat(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    double pole() {
        double p = (a + b + c) / 2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
    double obwod () {
        return a + b + c;
    }
}
public class Trojkat1 {
    public static void main(String[] args) {
        Trojkat t = new Trojkat(3, 4, 5);
        System.out.println("Pole: " + t.pole());
        System.out.println("Obwod: " + t.obwod());
    }
}

