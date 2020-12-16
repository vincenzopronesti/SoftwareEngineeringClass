package pattern.facade.compiler;

public class ParseCheckFacade {
    private Scanner scanner;
    private Parser parser;

    public ParseCheckFacade(){
        this.scanner = new Scanner();
        this.parser = new Parser();
    }

    public boolean parse(String sourceFile) {

        String loadedFile = this.scanner.scan(sourceFile);
        boolean succesfullyCompleted = false;

        if (loadedFile != null){
            succesfullyCompleted = this.parser.parse(loadedFile);
            if (succesfullyCompleted){
                System.out.println("Parsing Succesfully Completed on : " + sourceFile);
            }else{
                System.out.println("Parsing Failed on : " + sourceFile);
            }
        }

        return succesfullyCompleted ;
    }
}
