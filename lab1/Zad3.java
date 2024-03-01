class Regal{
    public int ilePolek;
    void dodajPolke(int ile){
        ilePolek = ilePolek+ ile;
    }
    int ilePolek(){
        return ilePolek;
    }
}
class Polka{
    public int ilePolek;
    public int ileKsiazek;
    Polka(int ilePolek){
        this.ilePolek=ilePolek;
    }
    void dodajKsiazke(int ile){
        ileKsiazek = ileKsiazek + ile;

    }
    int ileKsiazek(){
        return ileKsiazek;
    }
}



public class Zad3 {
    public static void main (String[] args){
        Regal r = new Regal();
        Polka p = new Polka(20);
        r.dodajPolke(20);
        p.dodajKsiazke(5);
        System.out.println(r.ilePolek());
        System.out.println(p.ileKsiazek());
    }
}
