import java.util.ArrayList;
import java.util.List;

public class Bar {

    List<BarObserver> observers = new ArrayList<>();
    private boolean isHappyHour;
    Bar()
    {
        isHappyHour=false;
    }

    public boolean isHappyHour()
    {
        return isHappyHour;
    }

    public void startHappyHour()
    {
        isHappyHour=true;
        notifyObservers();
    }

    public void endHappyHour()
    {
        isHappyHour=false;
        notifyObservers();
    }

    void addObserver(BarObserver observer) {
        observers.add(observer);
    }

    void removeObserver(BarObserver observer) {
        observers.remove(observer);
    }

    void notifyObservers() {
        for (BarObserver observer : observers)
            if (isHappyHour()) observer.happyHourStarted(this);
            else observer.happyHourEnded(this);
    }

    public void order( StringRecipe s)
    {
        s.mix();
    }
}
