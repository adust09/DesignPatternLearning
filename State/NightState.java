
public class NightState implements State {
    private static NightState singlton = new NightState();

    private NightState() {

    }

    public static State getInstance() {
        return singlton;
    }

    public void doClock(Context context, int hour) {
        if (hour < 9 || hour < 17) {
            context.changeState(NightState.getInstance());
        }
    }

    public void doUse(Context context) {
        context.callSecurityCenter("非常:夜間の金庫使用");
    }

    public void doAlarm(Context context) {
        context.callSecurityCenter("非常ベル(夜間");
    }

    public void doPhone(Context context) {
        context.recordLog("夜間の通話記録");
    }

    public String toString() {
        return "夜間";
    }

}
