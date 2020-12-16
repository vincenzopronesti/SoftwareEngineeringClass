package pattern.abstractFactory;

import pattern.abstractFactory.factories.MotifWidgetFactory;
import pattern.abstractFactory.factories.PMWidgetFactory;
import pattern.abstractFactory.factories.WidgetFactory;
import pattern.abstractFactory.scrollBar.ScrollBar;
import pattern.abstractFactory.window.Window;

public class Client {
    private Window w;
    private ScrollBar sb;

    public Client(WidgetFactory f) {
        this.w = f.createWindow();
        this.sb = f.createScrollBar();
    }

    public void checkMyWindow(){
        this.w.printWhoIAm();
    }

    public void checkMyScrollBar(){
        this.sb.printWhoIAm();
    }

    public static void main (String args[]){
        Client me;
        WidgetFactory factoryInTheExample;

//		The Motif Case
        System.out.println("--- The Motif Case ---");
        factoryInTheExample = new MotifWidgetFactory();

        me = new Client(factoryInTheExample);
        me.w.printWhoIAm();
        me.sb.printWhoIAm();

//		The Presentation Manager Case
        System.out.println("--- The Presentation Manager Case ---");
        factoryInTheExample = new PMWidgetFactory();

        me = new Client(factoryInTheExample);
        me.w.printWhoIAm();
        me.sb.printWhoIAm();
    }
}
