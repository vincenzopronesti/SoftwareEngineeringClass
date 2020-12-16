package pattern.factoryMethod.products;

public class ConcreteProductC implements ProductBase {

    @Override
    public void useTheProduct(){
        System.out.println("Here you are using: ConcreteProductC");
    }
}
