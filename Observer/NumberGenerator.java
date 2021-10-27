import java.util.ArrayList;
import java.util.Iterator;

public abstract class NumberGenerator {
    private AllayList observers = new AllayList();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void deleteObserver(Observer observer) {
        observers.delete(observer);
    }

    public void notifyObservers() {
        Iterator it = observers.iterator();
        while (it.hasNext()) {
            Observer o = (Observer) it.next();
            o.update(this);
        }
    }

    public abstract int getNumber();

    public abstract void execute();

}
