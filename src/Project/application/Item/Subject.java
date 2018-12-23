package Project.application.Item;

import user.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    private List<Observer> observers;

    public Subject() {
        observers = new ArrayList<>();
    }


    public void addObserver(Observer o) {
        if (!observers.contains(o))
            observers.add(o);
    }

    public void removeObserver(Observer o) {
        if (observers.contains(o))
            observers.remove(o);
    }

    public void notifyObservers(Item item) {
        for (Observer o : observers)
            o.update(item);
    }
}

