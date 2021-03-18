import java.awt.*;

public class Giant extends Critter {
    private int moves;

    public Giant() {
        moves = 1;
    }

    @Override
    public Color getColor() {
        return Color.GRAY;
    }

    @Override
    public Action getMove(CritterInfo info) {
        moves++;

        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;

        } else {
            return Action.RIGHT;
        }
    }

    @Override
    public String toString() {
        if (moves <= 6) {
            return "fee";
        } else if (moves <= 12) {
            return "fie";
        } else if (moves <= 18) {
            return "foe";
        } else if (moves <= 24) {
            return "fum";
        } else {
            moves = 1;
        }

        return "fee";
    }

}
