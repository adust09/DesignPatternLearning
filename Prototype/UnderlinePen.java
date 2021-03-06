import framework.*;

public class UnderlinePen implements Product {
    private char ulchar;

    public UnderlinePen(char ulchar) {
        this.ulchar = ulchar;
    }

    void use(String s) {
        int length = s.getBytes().length;
        System.out.println("¥" + s + "¥");
        System.out.println(" ");
        for (int i = 0; i < length; i++) {
            System.out.println(" ");
        }
    }

    public Product createClone() {
        Product p = null;
        try {
            p = (Product) clone();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
