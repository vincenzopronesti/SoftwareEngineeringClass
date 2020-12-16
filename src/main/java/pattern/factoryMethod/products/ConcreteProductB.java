package pattern.factoryMethod.products;

public class ConcreteProductB implements ProductBase {

    @Override
    public void useTheProduct(){
        System.out.println("Here you are using: ConcreteProductB");
    }
}
