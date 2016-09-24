import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 * Created by theo on 20/07/16.
 */
public class Visualiser extends JPanel{
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

    /**
        *  Visualiser-
     *  Draws cell templates
     *  Need to add a toggle between predefined templates and user templates
        */



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

    void drawLine(int x, int y, int x1, int y1) {
        int w = x1 - x ; //The lengths of the legs of the right triangle formed between the two points
        int h = y1 - y ;
        int dx1 = 0, dy1 = 0, dx2 = 0, dy2 = 0 ; //Initialising variables
        if (w<0) dx1 = -1 ; else if (w>0) dx1 = 1 ; //Whether the gradient is positive or negative
        if (h<0) dy1 = -1 ; else if (h>0) dy1 = 1 ;
        if (w<0) dx2 = -1 ; else if (w>0) dx2 = 1 ;
        int longest = Math.abs(w) ; //Abs to ensure that the lengths aren't negative
        int shortest = Math.abs(h) ;
        if (!(longest>shortest)) { //Switching the values around if they are in the wrong order
            longest = Math.abs(h) ; //Absolute values remove negatives
            shortest = Math.abs(w) ;
            if (h<0) dy2 = -1 ; else if (h>0) dy2 = 1 ;
            dx2 = 0 ;
        }
        int numerator = longest >> 1 ; //Bit shifting by 1
        for (int i=0; i <=longest; i++) {
            try {
                cells[y][x].state = 2;
                cells[y + 1][x].state = 2;
                cells[y + 1][x + 1].state = 2;
                cells[y][x + 1].state = 2;
            } catch (IndexOutOfBoundsException e) {}

            numerator += shortest ;
            if (!(numerator<longest)) {
                numerator -= longest ;
                x += dx1 ;
                y += dy1 ;
            } else {
                x += dx2 ;
                y += dy2 ;
            }
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
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bi, 0, 0, cells.length, cells.length, null);

    }

    public void iterationComplete() {
        for(int i = 0; i < cells.length; i++) {
            for(int j = 0; j < cells.length; j++) {
                switch (cells[i][j].state) {
                    case 0:
                        bi.setRGB(i, j, Color.white.getRGB());
                        break;
                    case 1:
                        bi.setRGB(i, j, Color.RED.getRGB());
                        break;
                    case 2:
                        bi.setRGB(i, j, Color.BLUE.getRGB());
                        break;
                    default:
                        bi.setRGB(i, j, Color.GRAY.getRGB());

                }

            }
        }
        repaint();
    }
}
