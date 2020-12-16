package pattern.singleton;

public class TestTheSingletonClass {
    public void testSingletonClass() {
        System.out.println("Testing the SigletonClass");

        SingletonClass s = SingletonClass.getSingletonInstance();
        s.singletonOperation1();
        System.out.println("First reference: " + s.singletonOperationM());

        SingletonClass s1 = SingletonClass.getSingletonInstance();
        s1.singletonOperation1();
        System.out.println("Second reference: " + s1.singletonOperationM());
    }

    public void testLazySingletonClass() {
        System.out.println("Testing the LazySigletonClass");

        LazySingletonClass s = LazySingletonClass.getSingletonInstance();
        s.singletonOperation1();
        System.out.println("First reference: " + s.singletonOperationM());

        SingletonClass s1 = SingletonClass.getSingletonInstance();
        s1.singletonOperation1();
        System.out.println("Second reference: " + s1.singletonOperationM());
    }

    public static void main(String[] args) {
        TestTheSingletonClass test = new TestTheSingletonClass();

        test.testSingletonClass();
//		test.testLazySingletonClass();

    }
}
