package pattern.abstractFactory.factories;

import pattern.abstractFactory.scrollBar.ScrollBar;
import pattern.abstractFactory.window.Window;

public abstract class WidgetFactory {
    public abstract Window createWindow();
    public abstract ScrollBar createScrollBar();
}
