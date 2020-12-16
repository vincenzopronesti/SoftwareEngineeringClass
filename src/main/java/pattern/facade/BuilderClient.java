package pattern.facade;

import pattern.facade.compiler.FullCompilerFacade;

public class BuilderClient {
    public static void main(String[] args) {
        FullCompilerFacade compiler = new FullCompilerFacade();
        compiler.compile("random.foo");
    }
}
