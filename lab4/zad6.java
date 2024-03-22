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

public class zad6 {
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

    public static int porownajPracownikow(Pracownik prac1, Pracownik prac2) {
        int wynikPorownania = prac1.getNazwisko().compareTo(prac2.getNazwisko());
        if (wynikPorownania == 0) {
            wynikPorownania = prac1.getImie().compareTo(prac2.getImie());
        }
        return wynikPorownania;
    }

    public static void sortujPracownikow(Pracownik[] pracownicy) {
        sortujPracownikow(pracownicy, 0, pracownicy.length - 1);
    }
    
    private static void sortujPracownikow(Pracownik[] pracownicy, int lewy, int prawy) {
        if (lewy < prawy) {
            int srodek = (lewy + prawy) / 2;
    
            sortujPracownikow(pracownicy, lewy, srodek);
            sortujPracownikow(pracownicy, srodek + 1, prawy);
    
            scalanie(pracownicy, lewy, srodek, prawy);
        }
    }
    
    private static void scalanie(Pracownik[] pracownicy, int lewy, int srodek, int prawy) {
        int rozmiar1 = srodek - lewy + 1;
        int rozmiar2 = prawy - srodek;
    
        Pracownik[] lewaTablica = new Pracownik[rozmiar1];
        Pracownik[] prawaTablica = new Pracownik[rozmiar2];
    
        for (int i = 0; i < rozmiar1; ++i) {
            lewaTablica[i] = pracownicy[lewy + i];
        }
        for (int j = 0; j < rozmiar2; ++j) {
            prawaTablica[j] = pracownicy[srodek + 1 + j];
        }
    
        int i = 0, j = 0;
        int k = lewy;
        while (i < rozmiar1 && j < rozmiar2) {
            if (porownajPracownikow(lewaTablica[i], prawaTablica[j]) <= 0) {
                pracownicy[k] = lewaTablica[i];
                i++;
            } else {
                pracownicy[k] = prawaTablica[j];
                j++;
            }
            k++;
        }
    
        while (i < rozmiar1) {
            pracownicy[k] = lewaTablica[i];
            i++;
            k++;
        }
    
        while (j < rozmiar2) {
            pracownicy[k] = prawaTablica[j];
            j++;
            k++;
        }
    }
}    
