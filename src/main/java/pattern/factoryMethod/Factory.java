package pattern.factoryMethod;

import pattern.factoryMethod.products.ConcreteProductA;
import pattern.factoryMethod.products.ConcreteProductB;
import pattern.factoryMethod.products.ConcreteProductC;
import pattern.factoryMethod.products.ProductBase;

public class Factory {
    public ProductBase createProductBase(int type) throws Exception{
        switch (type)
        {
            case 1: return new ConcreteProductA();
            case 2: return new ConcreteProductB();
            case 3: return new ConcreteProductC();
            default: throw new Exception("Invalid type : " + type);
        }
    }

    public ProductBase createConcreteProductA(){
        return new ConcreteProductA();
    }

    public ProductBase createConcreteProductB(){
        return new ConcreteProductB();
    }
}
