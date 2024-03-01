public class Macierze {
    private int[][] macierz;
    private int wiersze;
    private int kolumny;

    public Macierze(int wiersze, int kolumny) {
        this.wiersze = wiersze;
        this.kolumny = kolumny;
        this.macierz = new int[wiersze][kolumny];
    }

    public void wypelnijMacierz(int[][] dane) {
        if (dane.length != wiersze || dane[0].length != kolumny) {
            throw new IllegalArgumentException("Nieprawidłowe wymiary macierzy");
        }
        this.macierz = dane;
    }

    public void drukujMacierz() {
        for (int i = 0; i < wiersze; i++) {
            for (int j = 0; j < kolumny; j++) {
                System.out.print(macierz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public Macierze transponuj() {
        Macierze transponowana = new Macierze(kolumny, wiersze);
        for (int i = 0; i < wiersze; i++) {
            for (int j = 0; j < kolumny; j++) {
                transponowana.macierz[j][i] = macierz[i][j];
            }
        }
        return transponowana;
    }

    public Macierze dodaj(Macierze drugaMacierz) {
        if (wiersze != drugaMacierz.wiersze || kolumny != drugaMacierz.kolumny) {
            throw new IllegalArgumentException("Nieprawidłowe wymiary macierzy");
        }
        Macierze suma = new Macierze(wiersze, kolumny);
        for (int i = 0; i < wiersze; i++) {
            for (int j = 0; j < kolumny; j++) {
                suma.macierz[i][j] = macierz[i][j] + drugaMacierz.macierz[i][j];
            }
        }
        return suma;
    }

    public Macierze pomnoz(Macierze drugaMacierz) {
        if (kolumny != drugaMacierz.wiersze) {
            throw new IllegalArgumentException("Nieprawidłowe wymiary macierzy");
        }
        Macierze iloczyn = new Macierze(wiersze, drugaMacierz.kolumny);
        for (int i = 0; i < wiersze; i++) {
            for (int j = 0; j < drugaMacierz.kolumny; j++) {
                for (int k = 0; k < kolumny; k++) {
                    iloczyn.macierz[i][j] += macierz[i][k] * drugaMacierz.macierz[k][j];
                }
            }
        }
        return iloczyn;
    }

    public int wyznacznik() {
        if (wiersze != kolumny) {
            throw new IllegalArgumentException("Macierz nie jest kwadratowa");
        }
        if (wiersze == 1) {
            return macierz[0][0];
        }
        int wyznacznik = 0;
        for (int i = 0; i < wiersze; i++) {
            int[][] podmacierz = new int[wiersze - 1][wiersze - 1];
            for (int j = 1; j < wiersze; j++) {
                for (int k = 0, l = 0; k < wiersze; k++) {
                    if (k != i) {
                        podmacierz[j - 1][l++] = macierz[j][k];
                    }
                }
            }
            wyznacznik += Math.pow(-1, i) * macierz[0][i] * new Macierze(wiersze - 1, wiersze - 1).wyznacznik();
        }
        return wyznacznik;
    }

    public static void main(String[] args) {
        Macierze a = new Macierze(2, 2);
        a.wypelnijMacierz(new int[][]{{1, 2}, {3, 4}});
        a.drukujMacierz();
        System.out.println();
        a.transponuj().drukujMacierz();
        System.out.println();
        int wyznacznikA = a.wyznacznik();
        System.out.println("Wyznacznik macierzy A: " + wyznacznikA);
}
}
