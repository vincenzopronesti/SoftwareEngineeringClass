package pattern.betterAbstractFactory.factories;

import pattern.abstractFactory.scrollBar.PMScrollBar;
import pattern.abstractFactory.scrollBar.ScrollBar;
import pattern.abstractFactory.window.PMWindow;
import pattern.abstractFactory.window.Window;

public class PMWidgetFactory extends WidgetFactory {
    @Override
    public Window createWindow() {
        return new PMWindow();
    }

    @Override
    public ScrollBar createScrollBar() {
        return new PMScrollBar();
    }
}
