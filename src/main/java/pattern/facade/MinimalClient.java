package pattern.facade;

import pattern.facade.compiler.ParseCheckFacade;

public class MinimalClient {
    public static void main(String[] args) {
        ParseCheckFacade parser = new ParseCheckFacade();
        parser.parse("random.foo");
    }
}
