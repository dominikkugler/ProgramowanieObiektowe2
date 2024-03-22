import java.util.Random;

public class zad2 {
    public static void main(String[] args) {
        // Tworzenie 15 pracowników
        Pracownik[] pracownicy = new Pracownik[15];
        for (int i = 0; i < 15; i++) {
            pracownicy[i] = losujPracownika();
        }

        // Wybieranie dwóch szefów
        Szef szef1 = losujSzefa();
        Szef szef2 = losujSzefa();

        // Przydzielanie podwładnych do szefów
        for (int i = 0; i < 5; i++) {
            szef1.dodajPodwladnego(pracownicy[i]);
        }
        for (int i = 5; i < 13; i++) {
            szef2.dodajPodwladnego(pracownicy[i]);
        }

        // Wyświetlanie spisu pracowników z zaznaczeniem szefów
        System.out.println("Spis pracowników:");
        System.out.println("+--------------+------------+-------------------+------------+------+");
        System.out.println("|   Nazwisko   |    Imię    |   Wykształcenie   |   Pensja   | Szef |");
        System.out.println("+--------------+------------+-------------------+------------+------+");
        for (Pracownik pracownik : pracownicy) {
            String szef = " Nie ";
            if (szef1.czyPodwladny(pracownik)) {
                szef = "Szef1";
            } else if (szef2.czyPodwladny(pracownik)) {
                szef = "Szef2";
            }
            System.out.printf("| %-12s| %-11s| %-18s| %10.2f | %-4s |\n",
                              pracownik.nazwisko(), pracownik.imie(),
                              pracownik.wyksztalcenie(), pracownik.pensja(), szef);
        }
        System.out.println("+--------------+------------+-------------------+------------+------+");
    }

    // Metoda losująca pracownika
    private static Pracownik losujPracownika() {
        String[] nazwiska = {"Kowalski", "Nowak", "Wiśniewski", "Wójcik", "Kowalczyk", "Lewandowski"};
        String[] imiona = {"Jan", "Anna", "Piotr", "Maria", "Andrzej", "Katarzyna"};
        Wyksztalcenie[] wyksztalcenie = {Wyksztalcenie.SREDNIE, Wyksztalcenie.WYZ_EKON, Wyksztalcenie.WYZ_TECHN};
        Random random = new Random();
        return new Pracownik(nazwiska[random.nextInt(nazwiska.length)], imiona[random.nextInt(imiona.length)],
                             wyksztalcenie[random.nextInt(wyksztalcenie.length)], random.nextDouble() * 10000 + 3000);
    }

    // Metoda losująca szefa
    private static Szef losujSzefa() {
        Pracownik pracownik = losujPracownika();
        return new Szef(pracownik, pracownik.pensja());
    }
}

