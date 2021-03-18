import java.awt.*;

public class NinjaCat extends Tiger {
    private boolean hasGrown;

    public NinjaCat() {

    }

    @Override
    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.SAME) {
            hasGrown = true;
        }
        return super.getMove(info);
    }

    @Override
    public Color getColor() {
        return Color.lightGray;
    }

    @Override
    public String toString() {
        return (hasGrown) ? super.toString() : "N";
    }
}
