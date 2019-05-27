package com.geektech.lastfmmvvm.ui;

public class ObservableUser {

    private UserObserver observer;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

        if (observer != null) {
            observer.onChanged(this);
        }
    }

    public void setObserver(UserObserver observer) {
        this.observer = observer;
    }

    public interface UserObserver {
        void onChanged(ObservableUser user);
    }
}
