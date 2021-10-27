import game.Momento;
import game.Gamer;

public class Main {
    public static void main(String[] args) {
        Gamer gamer = new Gamer(100);
        Momento momento = gamer.createMomento();
        for (int i = 0; i < 100; i++) {
            System.out.println("====" + i);
            System.out.println("現状:" + gamer);

            gamer.bet();

            System.out.println("所持金は" + gamer.getMoney() + "円になりました");

            if (gamer.getMoney() > momento.getMoney()) {
                System.out.println("増えたンゴ！保存や！");
                momento = gamer.createMomento();
            } else if (gamer.getMoney() < momento.getMoney()) {
                System.out.println("減ったンゴ！復元や！");
                gamer.restoreMomento(momento);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println("");
        }
    }
}
