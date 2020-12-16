package pattern.singleton;

public class SingletonClass {
    private static SingletonClass instance = null;

    private int singletonData1;
    private String singletonDataN;

    protected SingletonClass(int init) {
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

    public static final SingletonClass getSingletonInstance() {
        if (SingletonClass.instance == null)
            SingletonClass.instance = new SingletonClass(10);
        return instance;
    }
}
