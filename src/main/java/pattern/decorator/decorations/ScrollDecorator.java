package pattern.decorator.decorations;

import pattern.decorator.VisualComponent;

public class ScrollDecorator extends Decorator {

    private int scrollPosition;

    public ScrollDecorator(VisualComponent component) {
        super(component);
        scrollPosition = 0;
    }

    public void scrollTo(int offset){
        this.scrollPosition = offset;
    }

    protected String applyScroll(String input){
        String output = "[scroll " + this.scrollPosition + "]" + input + "[/scroll]";
        return output;
    }

    @Override
    public String draw() {
        String preliminaryResults = super.draw();
        preliminaryResults = this.applyScroll(preliminaryResults);
        return preliminaryResults;
    }


}
