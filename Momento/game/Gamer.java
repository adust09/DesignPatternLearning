package game;
import java.util.*;

public class Gamer {
    private int money;
    private List fruits = new ArrayList();
    private Random random = new Random();
    private static String[] fruitsname = { "りんご", "みかん", "ぶどう", "バナナ", };

    public Gamer(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void bet() {
        int dice = random.nextInt(6) + 1;
        if (dice == 1) {
            money += 100;
            System.out.println("所持金が増えました");
        } else if (dice == 2) {
            money /= 2;
            System.out.println("所持金が半分になりました");
        } else if (dice == 6) {
            String f = getFruits();
            System.out.println("フルーツ(" + f + ")を手に入れました");
            fruits.add(f);
        } else {
            System.out.println("何も起こりませんでした");
        }
    }

    public Momento createMomento() {
        Momento m = new Momento(money);
        Iterator it = fruits.iterator();
        while (it.hasNext()) {
            String f = (String) it.next();
            if (f.startsWith("おいしい")) {
                m.addFruit(f);
            }
        }
        return m;
    }

    public void restoreMomento(Momento momento) {
        this.money = momento.getMoney();
        this.fruits = momento.getFruits();
    }

    public String toString() {
        return "[money=" + money + ",fruits=" + fruits + "]";
    }

    private String getFruits() {
        String prefix = "";
        if (random.nextBoolean()) {
            prefix = "おいしい";
        }
        return prefix + fruitsname[random.nextInt(fruitsname.length)];
    }
}
