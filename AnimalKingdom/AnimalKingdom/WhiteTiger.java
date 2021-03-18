

import java.awt.*;

public class WhiteTiger extends Tiger {
    private boolean hasInfected;

    public WhiteTiger() {

    }

    @Override
    public Color getColor() {
        return Color.WHITE;
    }

    @Override
    public String toString() {
        return (hasInfected) ? super.toString() : "tgr";
    }

    @Override
    public Action getMove(CritterInfo info) {
        if (!hasInfected && info.getFront() == Neighbor.OTHER) {
            hasInfected = true;
        }

        return super.getMove(info);

    }
}
