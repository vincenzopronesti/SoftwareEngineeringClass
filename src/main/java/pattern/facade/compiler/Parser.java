package pattern.facade.compiler;

public class Parser {
    private Scanner scanner;

    public Parser(){
        this.scanner = new Scanner();
    }

    public boolean parse(String sourceFile) {
        this.scanner.scan(sourceFile);
        System.out.println("Started parsing " + sourceFile + "...");
        System.out.println("... done!!");

        double rnd = Math.random()*2;
        int status = ((int)rnd)%2;

        return status == 0;
    }
}
