package pattern.betterAbstractFactory.factories;

import pattern.abstractFactory.scrollBar.MotifScrollBar;
import pattern.abstractFactory.scrollBar.ScrollBar;
import pattern.abstractFactory.window.MotifWindow;
import pattern.abstractFactory.window.Window;

public class MotifWidgetFactory extends WidgetFactory {
    @Override
    public Window createWindow() {
        return new MotifWindow() ;
    }

    @Override
    public ScrollBar createScrollBar() {
        return new MotifScrollBar();
    }
}
