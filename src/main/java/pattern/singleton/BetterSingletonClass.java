package pattern.singleton;

public class BetterSingletonClass {
    private static BetterSingletonClass instance = null;

    private int singletonData1;
    private String singletonDataN;

    protected BetterSingletonClass(int init) {
        this.singletonData1 = init;
        this.singletonDataN = "The string : " + init;
    }

    public void singletonOperation1() {
        instance.singletonData1 += 10;
        instance.singletonDataN = "Updeted now to : " + instance.singletonData1;
    }

    public String singletonOperationM() {
        return "This is " + instance.singletonDataN;
    }

    public synchronized static final BetterSingletonClass getSingletonInstance() {
        if (BetterSingletonClass.instance == null)
            BetterSingletonClass.instance = new BetterSingletonClass(10);
        return instance;
    }
}
