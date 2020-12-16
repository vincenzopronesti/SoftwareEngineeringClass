package pattern.facade.compiler;

public class FullCompilerFacade {
    private Scanner scanner;
    private Parser parser;
    private Assembler assembler;
    private Linker linker;

    public FullCompilerFacade(){
        this.scanner = new Scanner();
        this.parser = new Parser();
        this.assembler = new Assembler();
        this.linker = new Linker();
    }

    public String compile(String sourceFile) {

        String loadedFile = this.scanner.scan(sourceFile);

        String processedFile = "<none>";

        if (loadedFile != null){
            if (this.parser.parse(loadedFile)){

                processedFile = compileInternal(loadedFile);
                processedFile = this.assembler.assemble(processedFile);
                processedFile = this.linker.link(processedFile);

                System.out.println();
                System.out.println("Successfully compiled and linked : " + sourceFile + ", to : " + processedFile);
            }else{
                System.out.println("Parsing Failed on : " + sourceFile);
            }
        }

        return processedFile;
    }

    private String compileInternal(String sourceFile) {
        String processedFile = sourceFile.toLowerCase().replaceAll(".foo", ".asm");
        System.out.println("Compiled to assembly " + processedFile);
        return processedFile;
    }
}
