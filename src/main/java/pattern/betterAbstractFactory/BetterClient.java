package pattern.betterAbstractFactory;

import pattern.abstractFactory.scrollBar.ScrollBar;
import pattern.abstractFactory.window.Window;
import pattern.betterAbstractFactory.factories.WidgetFactory;

public class BetterClient {
    private Window w;
    private ScrollBar sb;

    public BetterClient() {
        this.w = WidgetFactory.getWidgetFactory().createWindow();
        this.sb = WidgetFactory.getWidgetFactory().createScrollBar();
    }

    public static void main (String args[]){

//	In a more general context, please ignore the following
//	statement, and read the property from a Java Property File
        System.setProperty("abstractFactoryExample.look_and_feel",args[0]);

        BetterClient me = new BetterClient();

//		The results depend on the configuration
//		given in the property : abstractFactoryExample.look_and_feel
        me.w.printWhoIAm();
        me.sb.printWhoIAm();
    }
}
