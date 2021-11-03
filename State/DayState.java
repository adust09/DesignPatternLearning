
public class DayState implements State {
    private static DayState singlton = new DayState();

    private DayState() {

    }

    public static State getInstance() {
        return singlton;
    }

    public void doClock(Context context, int hour) {
        if (hour < 9 || 17<= hour) {
            context.changeState(NightState.getInstance());
        }
    }

    public void doUse(Context context) {
        context.recordLog("金庫使用(昼間");
    }

    public void doAlarm(Context context) {
        context.callSecurityCenter("非常ベル(昼間");
    }

    public void doPhone(Context context) {
        context.callSecurityCenter("電話(昼間");
    }

    public String toString() {
        return "昼間";
    }

}