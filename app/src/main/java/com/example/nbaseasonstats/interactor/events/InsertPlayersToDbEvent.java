package com.example.nbaseasonstats.interactor.events;

public class InsertPlayersToDbEvent {

    private boolean done;
    private Throwable throwable;

    public InsertPlayersToDbEvent() {
    }

    public InsertPlayersToDbEvent(boolean done, Throwable throwable) {
        this.done = done;
        this.throwable = throwable;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
