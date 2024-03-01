class Trojkat {
    int a;
    int b;
    int c;

    Trojkat(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    static double pole(Trojkat t) {
        double p = (t.a + t.b + t.c) / 2.0;
        return Math.sqrt(p * (p - t.a) * (p - t.b) * (p - t.c));
    }

    static double obwod(Trojkat t) {
        return t.a + t.b + t.c;
    }
}

public class Trojkat2 {
    public static void main(String[] args) {
        Trojkat t = new Trojkat(3, 4, 5);
        System.out.println("Pole: " + Trojkat.pole(t));
        System.out.println("Obwod: " + Trojkat.obwod(t));
    }
}
