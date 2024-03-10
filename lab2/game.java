package lab2;
import java.util.Random;
class Map {
    char[][] map = new char[12][12];
    Map() {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++)
                if (i == 0 && j==0 || i == 0 && j == 11 || i == 11 && j == 0 || i == 11 && j == 11)
                    map[i][j] = '+';
                else if (i == 0 || i == 11) map[i][j] = '-';
                else if (j == 0 || j == 11) map[i][j] = '|';
                else map[i][j] = ' ';
        }
    }
    void printMap() {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++)
                System.out.print(map[i][j] + "");
            System.out.println();
        }
    }
    void placeSheppard(Sheppard s) {
        map[s.x][s.y] = '#';
    }
    void placeSheep(Sheep s) {
        map[s.x][s.y] = 's';
    }
    void placeBear(Bear b) {
        map[b.x][b.y] = 'B';
    }
    void placeWolf(Wolf w) {
        map[w.x][w.y] = 'W';
    }
    void removeSheppard(Sheppard s) {
        map[s.x][s.y] = ' ';
    }
    void removeSheep(Sheep s) {
        map[s.x][s.y] = ' ';
    }
    void removeBear(Bear b) {
        map[b.x][b.y] = ' ';
    }
    void moveBear(Bear b, int rolledDice) {
        removeBear(b);
        b.x -= rolledDice;
        placeBear(b);
    }
}
class Sheppard {
    int x;
    int y;
    Sheppard() {}
    void randomSheppard() {
        Random r = new Random();
        while (this.x == 0 || this.x == 11) this.x = r.nextInt(12);
        while (this.y == 0 || this.y == 11) this.y = r.nextInt(12);
    }
    void moveSheppardByVector(int x, int y) {
        this.x += x;
        this.y += y;
    }
}
class Sheep {
    int x;
    int y;
    Sheep() {}
    void randomSheep() {
        Random r = new Random();
        while (this.x == 0 || this.x == 11) this.x = r.nextInt(12);
        while (this.y == 0 || this.y == 11) this.y = r.nextInt(12);
    }
    void moveSheepByVector(int x, int y) {
        this.x += x;
        this.y += y;
    }
}
class Bear {
    int x;
    int y;
    Bear() {}
    void randomBear() {
        Random r = new Random();
        this.x = 11;
        while (this.y == 0 || this.y == 11) this.y = r.nextInt(12);
    }
}
class Wolf {
    int x;
    int y;
    Wolf() {}
    void randomWolf() {
        Random r = new Random();
        this.x = 11;
        while (this.y == 0 || this.y == 11) this.y = r.nextInt(12);
    }
    void moveWolfByVector(int x, int y) {
        this.x += x;
        this.y += y;
    }
}
class Dice {
    static int roll() {
        Random r = new Random();
        int rolledDice = r.nextInt(6) + 1;
        System.out.println("Dice rolled: " + rolledDice);
        return rolledDice;
    }
}
public class game {
    public static void legend() {
        System.out.println("Legend:");
        System.out.println("# - Sheppard");
        System.out.println("s - Sheep");
        System.out.println("B - Bear");
        System.out.println("W - Wolf");
    }
    public static void main(String[] args) {
        legend();
        Map m = new Map();
        Sheppard s = new Sheppard();
        Sheep sh [] = new Sheep[5];
        Bear b = new Bear();
        Wolf w = new Wolf();
        s.randomSheppard();
        for (int i = 0; i < 5; i++) {
            sh[i] = new Sheep();
            sh[i].randomSheep();
        }
        b.randomBear();
        w.randomWolf();
        m.placeSheppard(s);
        for (int i = 0; i < 5; i++) m.placeSheep(sh[i]);
        m.placeBear(b);
        m.placeWolf(w);
        m.printMap();
        m.moveBear(b, Dice.roll());
        m.printMap();
    }
} 

