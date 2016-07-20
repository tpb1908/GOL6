import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by theo on 20/07/16.
 */
public class Themer {

    public static void themeButtons(JButton... buttons) {
        for(JButton b : buttons) {
            b.setForeground(Color.black);
            b.setBackground(Color.white);
            final Border line = new LineBorder(Color.black);
            final Border margin = new EmptyBorder(5, 15, 5, 15);
            final Border compound = new CompoundBorder(line, margin);
            b.setBorder(compound);
        }
    }

}
