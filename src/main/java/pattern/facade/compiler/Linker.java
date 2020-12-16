package pattern.facade.compiler;

public class Linker {
    public String link(String sourceFile) {
        String linkedFile = sourceFile.toLowerCase().replaceAll(".obj", ".exe");
        System.out.println("Linked to executable " + linkedFile);
        return linkedFile;
    }
}
