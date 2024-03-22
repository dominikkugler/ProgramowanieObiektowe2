package lab3;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;

abstract class BubbleSort {
    abstract boolean compareStrings(String str1, String str2);
    void sortStrings(String[] strings) {
        int licznik = 0;
        int n = strings.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (compareStrings(strings[j], strings[j + 1])) {
                    String temp = strings[j];
                    strings[j] = strings[j + 1];
                    strings[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
            licznik++;
        }
        System.out.println("Liczba porównań: " + licznik);
    }  
}

class AlphabeticalBubbleSort extends BubbleSort {
    boolean compareStrings(String str1, String str2) {
        return str1.compareTo(str2) > 0;
    }
}

class ReverseAlphabeticalBubbleSort extends BubbleSort {
    boolean compareStrings(String str1, String str2) {
        return str1.compareTo(str2) < 0;
    }
}

class ReverseBubbleSort extends BubbleSort {
    boolean compareStrings(String str1, String str2) {
        int minLength = Math.min(str1.length(), str2.length());
        for (int i = minLength - 1; i >= 0; i--) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return str1.charAt(i) < str2.charAt(i);
            }
        }
        return str1.length() < str2.length();
    }
}


public class zad6 {
    public static void main(String[] args) {
        String filePath = "/workspaces/ProgramowanieObiektowe2/lab3/dane-slowa-100tys.txt";
        
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            String[] strings = lines.toArray(new String[0]);
            
            BubbleSort alphabeticalSort = new AlphabeticalBubbleSort();
            alphabeticalSort.sortStrings(strings);
            
            BubbleSort reverseAlphabeticalSort = new ReverseAlphabeticalBubbleSort();
            reverseAlphabeticalSort.sortStrings(strings);
            
            BubbleSort reverseSort = new ReverseBubbleSort();
            reverseSort.sortStrings(strings);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

