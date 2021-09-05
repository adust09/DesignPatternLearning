public class StringDisplayImpl extends DisplayImpl {
    private String string; // 表示するべき文字列
    private int width; // 文字列の幅

    public StringDisplayImpl(String string) { // コンストラクタで渡された文字列stringをフィールドに保持
        this.string = string;
        this.width = string.getBytes().length;
    }

    public void rawOpen() {
        printLine();
    }

    public void rawPrint() {
        System.out.println("|" + string + "|");
    }

    public void rawClose() {
        printLine();
    }

    public void printLine() {
        System.out.print("+");
        for (int i = 0; i < width; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}