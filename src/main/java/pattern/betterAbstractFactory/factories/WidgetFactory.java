package pattern.betterAbstractFactory.factories;

import pattern.abstractFactory.scrollBar.ScrollBar;
import pattern.abstractFactory.window.Window;

public abstract class WidgetFactory {
    private static WidgetFactory me = null;

    protected WidgetFactory(){
    }

    public static synchronized WidgetFactory getWidgetFactory(){
        if ( me == null ){
            String laf = System.getProperty("abstractFactoryExample.look_and_feel");

            switch (SupportedLookAndFeels.valueOf(laf)) {
                case Motif :
                    me = new MotifWidgetFactory();
                    break;
                case PM :
                    me = new PMWidgetFactory();
                    break;
            }
        }
        return me;
    }

    public abstract Window createWindow();
    public abstract ScrollBar createScrollBar();
}
