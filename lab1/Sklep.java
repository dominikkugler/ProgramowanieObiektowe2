class Sprzedawcy {
    private static double przychod = 0;
    public void sprzedaz(double kwota) {
        przychod += kwota;
    }
    public static double uzysk( ) {
        return przychod;
    }

}
class Sklep {
    public static void main(String[ ] args) {
        Sprzedawcy jacek = new Sprzedawcy();
        Sprzedawcy iwona = new Sprzedawcy();
        Sprzedawcy roman= new Sprzedawcy();
        jacek.sprzedaz(5.50);
        roman.sprzedaz(10.80);
        roman.sprzedaz(7.00);
        iwona.sprzedaz(11.20);
        jacek.sprzedaz(2.30);
        System.out.println("\n Sumaryczny przychod: " + Sprzedawcy.uzysk( ) + "\n");
    }
}