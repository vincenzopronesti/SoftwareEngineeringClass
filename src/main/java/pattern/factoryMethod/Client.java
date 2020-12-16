package pattern.factoryMethod;

import pattern.factoryMethod.products.ProductBase;

public class Client {
    private ProductBase product1;
    private ProductBase product2;

    public Client() {
        Factory factory = new Factory();

        try{
            this.product1 = factory.createProductBase(1);
            this.product2 = factory.createProductBase(2);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main (String args[]){
        Client c = new Client();

        System.out.println("--- Using this.product1 ---");
        c.product1.useTheProduct();

        System.out.println("--- Using this.product2 ---");
        c.product2.useTheProduct();

    }
}
