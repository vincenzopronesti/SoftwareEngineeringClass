package pattern.decorator;

public class TextView extends VisualComponent {
    private String text;

    public TextView(String text){
        this.setText(text);
    }

    public void setText(String text){
        this.text = text;
    }

    @Override
    public String draw() {
        return (this.text);
    }
}
