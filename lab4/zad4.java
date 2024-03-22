import java.util.Scanner;

class Pracownik {
    private String nazwisko, imie;
    private double pensja;

    public Pracownik(String nazwisko, String imie, double pensja) {
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.pensja = pensja;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public double getPensja() {
        return pensja;
    }
}

public class zad4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj liczbę pracowników: ");
        int liczbaPracownikow = scanner.nextInt();

        Pracownik[] pracownicy = new Pracownik[liczbaPracownikow];

        for (int i = 0; i < liczbaPracownikow; i++) {
            scanner.nextLine(); // konsumowanie znaku nowej linii
            System.out.println("Pracownik " + (i + 1) + ":");
            System.out.println("Nazwisko: ");
            String nazwisko = scanner.nextLine();
            System.out.println("Imię: ");
            String imie = scanner.nextLine();
            System.out.println("Pensja: ");
            double pensja = scanner.nextDouble();

            pracownicy[i] = new Pracownik(nazwisko, imie, pensja);
        }

        // Sortowanie pracowników wg nazwisk i imion
        sortujPracownikow(pracownicy);

        // Wyświetlanie posortowanej listy pracowników
        System.out.println("\nPosortowani pracownicy:");
        System.out.println("Nazwisko\tImię\tPensja");
        for (Pracownik pracownik : pracownicy) {
            System.out.println(pracownik.getNazwisko() + "\t\t" + pracownik.getImie() + "\t" + pracownik.getPensja());
        }
    }

    // Metoda sortująca pracowników wg nazwisk i imion (sortowanie bąbelkowe)
    public static void sortujPracownikow(Pracownik[] pracownicy) {
        int n = pracownicy.length;
        boolean zamieniono;

        do {
            zamieniono = false;
            for (int i = 0; i < n - 1; i++) {
                if (porownajPracownikow(pracownicy[i], pracownicy[i + 1]) > 0) {
                    Pracownik temp = pracownicy[i];
                    pracownicy[i] = pracownicy[i + 1];
                    pracownicy[i + 1] = temp;
                    zamieniono = true;
                }
            }
            n--;
        } while (zamieniono);
    }

    // Metoda porównująca pracowników wg nazwisk i imion
    public static int porownajPracownikow(Pracownik prac1, Pracownik prac2) {
        int wynikPorownania = prac1.getNazwisko().compareTo(prac2.getNazwisko());
        if (wynikPorownania == 0) {
            wynikPorownania = prac1.getImie().compareTo(prac2.getImie());
        }
        return wynikPorownania;
    }
}
