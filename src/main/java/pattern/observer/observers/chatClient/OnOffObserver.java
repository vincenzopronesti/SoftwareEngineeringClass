package pattern.observer.observers.chatClient;

import pattern.observer.subjects.chatClient.ChatClient;

public class OnOffObserver extends AbstractChatClientObserver {
    private String name;

    public OnOffObserver(){
        this("OnOff");
    }

    public OnOffObserver(String name){
        this(name,null);
    }

    public OnOffObserver(String name, ChatClient subject){
        super(5000);
        this.cc = subject;
        this.name = name;
    }

    @Override
    public void update() {
        if (this.cc == null){
            this.notifySubjectStatus(this.name +" : No subject Attached");
        }else{
            String status = this.cc.getStatus();
            String message = this.name +" : The ChatClient is ";
            if (status.equalsIgnoreCase("Offline"))
                message = message + " Off";
            else
                message = message + " On";
            this.notifySubjectStatus(message);
        }
    }

}
