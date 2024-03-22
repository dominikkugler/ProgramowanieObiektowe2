import java.util.Scanner;

enum Wyksztalcenie {
    NIEISTOTNE,
    SREDNIE,
    WYZ_EKON,
    WYZ_TECHN
}

class PracownikWlasny {
    private String nazwisko, imie;
    private Wyksztalcenie wyksztalcenie;
    private double pensja;

    // konstruktor:
    public PracownikWlasny(String nz, String im, Wyksztalcenie wk, double ps) {
        nazwisko = nz;
        imie = im;
        wyksztalcenie = wk;
        pensja = ps;
    }

    // konstruktor alternatywny:
    public PracownikWlasny() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("NOWY PRACOWNIK");
        System.out.println("nazwisko:");
        nazwisko = scanner.nextLine();

        System.out.println("imie:");
        imie = scanner.nextLine();

        System.out.println("wyksztalcenie:");
        System.out.println("0 — nieistotne");
        System.out.println("1 — srednie");
        System.out.println("2 — wyzsze ekonomiczne");
        System.out.println("3 — wyzsze techniczne");
        System.out.println("wybor:");
        int wybor = scanner.nextInt();
        switch (wybor) {
            case 0:
                wyksztalcenie = Wyksztalcenie.NIEISTOTNE;
                break;
            case 1:
                wyksztalcenie = Wyksztalcenie.SREDNIE;
                break;
            case 2:
                wyksztalcenie = Wyksztalcenie.WYZ_EKON;
                break;
            case 3:
                wyksztalcenie = Wyksztalcenie.WYZ_TECHN;
                break;
            default:
                System.out.println("Niepoprawny wybór, przyjęto wykształcenie nieistotne.");
                wyksztalcenie = Wyksztalcenie.NIEISTOTNE;
                break;
        }

        System.out.println("pensja:");
        pensja = scanner.nextDouble();
        scanner.close();
    }

    // pozostałe metody bez zmian...
    public String nazwisko() { return nazwisko; }
    public String imie() { return imie; }
    public Wyksztalcenie wyksztalcenie() { return wyksztalcenie; }
    public double pensja() { return pensja; }
}

public class zad3 {
    public static void main(String[] args) {
        // Tworzenie nowego pracownika z konsoli
        PracownikWlasny pracownik = new PracownikWlasny();

        // Wyświetlanie informacji o nowym pracowniku
        System.out.println("\nNowy pracownik:");
        System.out.println("Nazwisko: " + pracownik.nazwisko());
        System.out.println("Imię: " + pracownik.imie());
        System.out.println("Wykształcenie: " + pracownik.wyksztalcenie());
        System.out.println("Pensja: " + pracownik.pensja());
    }
}
