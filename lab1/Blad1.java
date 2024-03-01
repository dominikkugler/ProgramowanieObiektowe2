import java.lang.Math;
public class Blad1 {
    public static void main(String[ ] argumenty) {
        System.out.println("\n sin(30) == " + Math.sin(30) + "\n");
        System.out.println("\n sin(30) == " + Math.sin(30 * Math.PI / 180) + "\n");
    }
}
 // Wyjaśnienie
 // W pierwszym przypadku Math.sin(30) zwraca wartość 0.9880316240928618, ponieważ Math.sin przyjmuje argumenty w radianach, a nie w stopniach.
 // W drugim przypadku Math.sin(30 * Math.PI / 180) zwraca wartość 0.49999999999999994, ponieważ 30 * Math.PI / 180 to przeliczenie 30 stopni na radiany.