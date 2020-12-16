package pattern.facade.compiler;

public class Assembler {
    public String assemble(String sourceFile) {
        String asmFile = sourceFile.toLowerCase().replaceAll(".asm", ".obj");
        System.out.println("Translated to binary object code " + asmFile);
        return asmFile;
    }
}
