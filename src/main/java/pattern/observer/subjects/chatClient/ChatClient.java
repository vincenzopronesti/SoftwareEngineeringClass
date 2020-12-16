package pattern.observer.subjects.chatClient;

import pattern.observer.observers.chatClient.ComeBackObserver;
import pattern.observer.observers.chatClient.OnOffObserver;
import pattern.observer.subjects.Subject;

import java.io.IOException;

public class ChatClient extends Subject {

    private ChatStatus status;
    private int timeOut;
    private long lastNotificationTimestamp;

    public ChatClient() {
        this(1);
    }

    public ChatClient(int statusCode) {
        if (ChatStatus.values().length > 0) {
            int modIndex = statusCode % ChatStatus.values().length;
            this.status = ChatStatus.values()[modIndex];
        }
        this.timeOut = 1000;
        this.lastNotificationTimestamp = System.currentTimeMillis();
    }

    // This implementation is supposed to notify the observers periodically.
    // This means that the method must periodically return TRUE.
    // The width of the time-window (i.e. the period) is defined by the local attribute "timeOut"
    @Override
    protected boolean isThereAnythingToNotify() {
        long currentTime = System.currentTimeMillis();
        return (currentTime - this.lastNotificationTimestamp) > this.timeOut;
    }

    // Note the difference between how the internal status
    // is represented and how its modification is supported
    private void setStatus(ChatStatus s) {
        if (this.status != s){
            this.status = s;
            this.lastNotificationTimestamp = System.currentTimeMillis();
        }
    }

    public void setStatusAvailable() {
        this.setStatus(ChatStatus.Available);
    }

    public void setStatusAway() {
        this.setStatus(ChatStatus.Away);
    }

    public void setStatusBusy() {
        this.setStatus(ChatStatus.Busy);
    }

    public void setStatusInvisible() {
        this.setStatus(ChatStatus.Invisible);
    }

    public void setStatusOffline() {
        this.setStatus(ChatStatus.Offline);
    }

    // Note how a different view of the actual internal status
    // is given to the other classes: both in terms of types
    // and values
    public String getStatus() {
        String val;
        switch (this.status) {
            case Invisible:
                val = ChatStatus.Away.name();
                break;
            default:
                val = this.status.name();
                break;
        }
        return val;
    }

    protected void doSomething() {
        int n = ChatStatus.values().length;
        int newStatusIndex = (int) (Math.random() * n);
        this.setStatus(ChatStatus.values()[newStatusIndex]);

        System.err.println("Subject status is now : " + this.status.name());

        long sleep = Math.round(Math.random() * 2000);
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stopIt() {
        this.isAlive = false;
    }

    public static void main(String args[]) {
        ChatClient subject = new ChatClient();

        OnOffObserver obs1 = new OnOffObserver("OnOff_1");
        obs1.setSubject(subject);

        ComeBackObserver obs2 = new ComeBackObserver(subject);
        obs2.setUpdatePeriod(2000);
        ComeBackObserver obs3 = new ComeBackObserver(3, subject);

        ChatClient.prettyPrint("Subject and Observers were instantiated ...");
        ChatClient.simplePause();

        Thread tSbj = new Thread(subject);
        tSbj.start();

        ChatClient.prettyPrint("Subject is running ...");

        Thread tObs1 = new Thread(obs1);
        Thread tObs2 = new Thread(obs2);
        Thread tObs3 = new Thread(obs3);

        tObs1.start();
        tObs2.start();
        tObs3.start();

        ChatClient.prettyPrint("Observers are running ...");

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ChatClient.prettyPrint("These notifications were only triggered by Observers, because Subject is still ignoring any Observer (i.e. Subject.observers == null)");

        ChatClient.prettyPrint("Shutting down Observers ...");
        obs1.stopObservation();
        obs2.stopObservation();
        obs3.stopObservation();
        ChatClient.prettyPrint("... notifications sent");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ChatClient.simplePause();

        ChatClient.prettyPrint("Attaching Subject to the Observers...");
        subject.attach(obs1);
        subject.attach(obs2);
        subject.attach(obs3);
        ChatClient.prettyPrint("... done!!");

        ChatClient.prettyPrint("Now the notifications are only triggered by Subject");

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        subject.stopIt();

    }

    private static void simplePause() {
        try {
            ChatClient.prettyPrint(" [PRESS ANY KEY] ");
            char tmp = (char) System.in.read();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    private static void prettyPrint (String message){
        System.out.println("-*-*-* " + message);
    }
}
