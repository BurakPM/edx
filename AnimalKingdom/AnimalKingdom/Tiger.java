import java.awt.*;
import java.util.*;


public class Tiger extends Critter {
    private Color color;
    private int moves;


    public Tiger() {
    }

    @Override
    public Color getColor() {
        int x = 0;

        if (moves % 3 == 0) {
            while (x == 0) {
                int random = (int) (Math.random() * 3);

                if (random == 0 && color != Color.RED) {
                    color = Color.RED;
                    x++;
                } else if (random == 1 && color != Color.GREEN) {
                    color = Color.GREEN;
                    x++;
                } else if (color != Color.BLUE) {
                    color = Color.BLUE;
                    x++;
                }
            }
        }
        return color;
    }

    @Override
    public String toString() {
        return "TGR";
    }

    @Override
    public Action getMove(CritterInfo info) {
        moves++;

        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;

        } else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
            return Action.LEFT;
        } else if (info.getFront() == Neighbor.SAME) {
            return Action.RIGHT;
        } else {
            return Action.HOP;
        }
    }
}
