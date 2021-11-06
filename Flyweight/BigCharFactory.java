import java.util.HashMap;

public class BigCharFactory {
    // すでに作ったBigCharのインスタンスを管理
    private HashMap pool = new HashMap();
    // Singlton パターン
    private static BigCharFactory singlton = new BigCharFactory();

    // コンストラクタ
    private BigCharFactory() {
    }

    // 唯一のインスタンスをつくる
    public static BigCharFactory getInstance() {
        return singlton;
    }

    // BigCharのインスタンス作成
    public synchronized BigChar getBigChar(char charname) {
        BigChar bc = (BigChar) pool.get("" + charname);
        if (bc == null) {
            bc = new BigChar(charname);
            pool.put("" + charname, bc);
        }
        return bc;
    }
}
