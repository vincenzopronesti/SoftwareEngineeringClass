package pattern.decorator;

import pattern.decorator.decorations.BorderDecorator;
import pattern.decorator.decorations.ScrollDecorator;

public class ContentContainer {
    private VisualComponent contents;

    public ContentContainer (){
        this.setContents(null);
    }

    public ContentContainer (VisualComponent contents){
        this.setContents(contents);
    }

    public void setContents(VisualComponent contents) {
        this.contents = contents;
    }

    public void display(){
        System.out.println(this.contents.draw());
    }

    public String getContents(){
        return this.contents.draw();
    }

    public static void main(String args[]){
        TextView tv = new TextView("This is foo!!!");

        ContentContainer me = new ContentContainer(tv);
        me.display();
        System.out.println();

        BorderDecorator btv = new BorderDecorator(tv);
        me.setContents(btv);
        me.display();
        btv.incWidth();
        tv.setText("This WAS foo ... ");
        me.display();
        System.out.println();

        ScrollDecorator sbtv = new ScrollDecorator(btv);
        me.setContents(sbtv);
        me.display();
        sbtv.scrollTo(-4);
        btv.incWidth();
        tv.setText("This WAS foo ... and it keeps changing!!!");
        me.display();
    }
}
