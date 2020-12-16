package pattern.observer.observers.chatClient;

import pattern.observer.subjects.chatClient.ChatClient;

public class ComeBackObserver extends AbstractChatClientObserver {

    private long ID;
    private boolean isThere;

    public ComeBackObserver(ChatClient sbj) {
        this(Math.round(100 * Math.random()), sbj);
    }

    public ComeBackObserver(long l, ChatClient sbj) {
        super(5000);
        this.ID = l;
        this.cc = sbj;
        this.isThere = this.cc.getStatus().equalsIgnoreCase("Available");
    }

    private String getPrettyName() {
        return "CB**" + this.ID;
    }

    @Override
    public void update() {
        if (this.cc == null) {
            this.notifySubjectStatus(this.getPrettyName()
                    + " : No subject Attached");
        } else {
            String status = this.cc.getStatus();

            if (status.equalsIgnoreCase("Available")) {
                if (!this.isThere) {
                    String message = this.getPrettyName()
                            + " : The observed client is now available";
                    this.notifySubjectStatus(message);
                    this.isThere = true;
                };
            } else {
                this.isThere = false;
            }
        }
    }

    public void setUpdatePeriod(long timeOut) {
        this.timeOut =  timeOut;
    }

}
