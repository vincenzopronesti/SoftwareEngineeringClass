package pattern.factoryMethod.products;

public class ConcreteProductA implements ProductBase{

    @Override
    public void useTheProduct(){
        System.out.println("Here you are using: ConcreteProductA");
    }
}
