package pattern.facade.compiler;

public class Scanner {
    public String scan(String sourceFile) {
        System.out.println("Started scanning " + sourceFile);
        return sourceFile;
    }
}
