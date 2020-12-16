package pattern.singleton;

public class LazySingletonClass {
    private int singletonData1;
    private String singletonDataN;

    /**
     *
     * The inner-class LazyCointainer is loaded only at the first invocation of getInstance.
     * This activity results "thread-safe".
     * @author gulyx
     *
     */
    private static class LazyCointainer{
        public final static LazySingletonClass sigletonInstance = new LazySingletonClass(10);
    }

    protected LazySingletonClass(int init) {
        this.singletonData1 = init;
        this.singletonDataN = "The string : " + init;
    }

    public void singletonOperation1() {
        LazyCointainer.sigletonInstance.singletonData1 += 10;
        LazyCointainer.sigletonInstance.singletonDataN = "Updeted now to : " + LazyCointainer.sigletonInstance.singletonData1;
    }

    public String singletonOperationM() {
        return "This is " + LazyCointainer.sigletonInstance.singletonDataN;
    }

    public static final LazySingletonClass getSingletonInstance() {
        return LazyCointainer.sigletonInstance;
    }
}
