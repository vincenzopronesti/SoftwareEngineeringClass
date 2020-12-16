package pattern.decorator.decorations;

import pattern.decorator.VisualComponent;

public abstract class Decorator extends VisualComponent {

    private VisualComponent component;

    public Decorator( VisualComponent component){
        this.component = component;
    }

    @Override
    public String draw() {
        String resultsFromRedirection = this.component.draw();
        return resultsFromRedirection;
    }

}
