import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 * Created by theo on 20/07/16.
 */
public class Visualiser extends JPanel implements IterationCompleteListener {
    private BufferedImage bi;
    private Cell cellTemplate;
    private Cell[][] cells;

    private DrawMethod drawMethod;
    private boolean penActive = false;

    private int drawSize;
    private int[] linepoints;

    public Visualiser() {
        addMouseListener(mouseAdapter);
    }

    private MouseAdapter mouseAdapter = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            if(SwingUtilities.isLeftMouseButton(e)) {
                penActive = !penActive;
            } else if(SwingUtilities.isRightMouseButton(e)) {
                drawMethod = drawMethod.next();
            }
            switch (drawMethod) {
                case Point:

            }
        }
    };

    void drawSquare(int x, int y) {
        int xBound = x+drawSize > cells.length ? cells.length : x+drawSize;
        int yBound = y+drawSize > cells.length ? cells.length : x+drawSize;
        for(int i = x; i < xBound; i++) {

        }
        for(int j = y; j < yBound; j++) {

        }
    }

    public enum DrawMethod {
        Point, Paint, Line, Eraser;
        private static DrawMethod[] values = values();

        public DrawMethod next() {
            return values[(this.ordinal()+1)%values.length];
        }
    }

    @Override
    public void iterationComplete(Cell[][] cells) {

    }
}
