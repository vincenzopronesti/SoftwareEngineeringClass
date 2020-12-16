package pattern.adapter;

import java.util.Random;

public class Stone {
    private float weight;
    private StoneKinds kind;

    public Stone() {
        Random r = new Random();
        this.weight = r.nextInt(50);
        int nKinds = StoneKinds.values().length;
        if (nKinds!=0)
            this.kind = StoneKinds.values()[r.nextInt(nKinds)];
        else
            this.kind = null;
    }

    public Stone(StoneKinds kind, float weightInKilos) {
        this.weight = weightInKilos;
        this.kind = kind;
    }

    public float weightInKilos() {
        return this.weight;
    }

    public StoneKinds getStoneKind() {
        return this.kind;
    }
}
