public class Samochod {
    public int kola;
    public int siedzenia;
    public int kierownica;
    public Boolean start() {
        return true;
    }
    public void hamuj(int jak) {
        System.out.println("Hamuje z siłą " + jak);
    }

    public void przyspiesz() {
        System.out.println("Przyspieszam");
    }

    Samochod() { }

    public static void main(String[] args) {
        Samochod a = new Samochod();
        a.kola = 4;
        // a.siedzenia(5); -> Blad 1
        // start(); -> Blad 2
        a.start();
        System.out.println(a.start());
        // System.out.println(a.hamuj(2)); -> Blad 3
        // a = a.start(); -> Blad 4
        // int wynik = a.start(); -> Blad 5
        // Boolean wynik = a.przyspiesz(); -> Blad 6
    }
}

// Blad 1 : siedzenia to pole klasy, nie metoda
// Blad 2 : start to metoda klasy, nie zmienna
// Blad 3 : metoda hamuj nie zwraca wartosci, ktora mozna by wydrukowac na ekran
// Blad 4 : start zwraca wartosc typu Boolean, a nie obiekt klasy Samochod
// Blad 5 : start zwraca wartosc typu Boolean, a nie int
// Blad 6 : przyspiesz nie zwraca wartosci, ktora mozna by przypisac do zmiennej typu Boolean
