package pattern.adapter;

public class Adapter implements Jewel {
    private Stone s;

    public Adapter(Stone s) {
        this.s = s;
    }

    @Override
    public int weight() {
        return Math.round((this.s.weightInKilos()*1000) * 5);
    }

    @Override
    public boolean hasAValue() {
        StoneKinds kind = this.s.getStoneKind();
        return ((kind == StoneKinds.Diamond) || (kind == StoneKinds.Ruby));
    }
}
