package pattern.adapter;

import java.util.Vector;

public class Jeweller {
    private Vector<Jewel> luxuryJevels;
    private int minCarats;


    public Jeweller( int thresholdInCarats ) {
        this.luxuryJevels = new Vector<Jewel>();
        this.minCarats = thresholdInCarats ;
    }

    private boolean evaluate (Jewel j){
        return ((j.hasAValue()) && (j.weight() >= this.minCarats));
    }

    public boolean buyLuxuryJewels (Jewel j){
        if (this.evaluate(j))
            return this.luxuryJevels.add(j);
        return false;
    }

    public static void main(String args[]) {
        Jeweller me = new Jeweller(24);

//		Create a Stone
        Stone s1 = new Stone();
//		Adapt the Stone as Jewel
        Jewel a = new Adapter(s1);

//		The Jeweller try to by the "luxury stone" :-D
        if (!me.buyLuxuryJewels(a))
            System.out.println("That Jawel was not good for me!!!");
        else
            System.out.println("Yes!!!! I got it!");

    }
}
