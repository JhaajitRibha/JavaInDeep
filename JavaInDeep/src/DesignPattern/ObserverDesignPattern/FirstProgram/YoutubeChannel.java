package DesignPattern.ObserverDesignPattern.FirstProgram;

import java.util.ArrayList;
import java.util.List;

public class YoutubeChannel implements Subject {

    List<Observer> subscribersList = new ArrayList<>();
    private String name;

    public YoutubeChannel(String name) {
        this.name = name;
    }

    @Override
    public void subscribe(Observer ob) {
        this.subscribersList.add(ob);
    }

    @Override
    public void unsubscribe(Observer ob) {
        this.subscribersList.remove(ob);
    }

    @Override
    public void newVideoUploaded(String title) {

        subscribersList.stream().forEach(e -> {
            e.notified(title,name);

        });

    }
}
