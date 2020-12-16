package pattern.observer.observers.chatClient;

import pattern.observer.observers.Observer;
import pattern.observer.subjects.chatClient.ChatClient;

public abstract class AbstractChatClientObserver extends Observer {

    protected AbstractChatClientObserver(int timeOut) {
        super(timeOut);
    }

    protected ChatClient cc;

    public void setSubject(ChatClient subject) {
        this.cc = subject;
    }

}
