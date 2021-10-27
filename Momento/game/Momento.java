package game;
import java.util.*;

public class Momento {
    int money;
    ArrayList fruits;

    public int getMoney() {
        return money;
    }

    Momento(int money) {
        this.money = money;
        this.fruits = new ArrayList();
    }

    void addFruit(String fruit) {
        fruits.add(fruit);
    }

    List getFruits() {
        return (List) fruits.clone();
    }
}
