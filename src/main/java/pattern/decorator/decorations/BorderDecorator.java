package pattern.decorator.decorations;

import pattern.decorator.VisualComponent;

public class BorderDecorator extends Decorator {

    private int borederWidth;
    private int tick;

    public BorderDecorator(VisualComponent component) {
        super(component);
        this.setWidth(5);
        this.tick = 1;
    }

    public void setWidth(int width){
        if (width > 0 )
            this.borederWidth = width;
    }

    public void incWidth(){
        this.borederWidth += this.tick;
    }

    public void decWidth(){
        if ((this.borederWidth - this.tick) > 0)
            this.borederWidth -= this.tick;
        else
            this.borederWidth = 0;
    }

    protected String applyBorder(String input){
        String output = "[border " + this.borederWidth + "]" + input + "[/border]";
        return output;
    }

    @Override
    public String draw() {
        String preliminaryResults = super.draw();
        preliminaryResults = this.applyBorder(preliminaryResults);
        return preliminaryResults;
    }


}
