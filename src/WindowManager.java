
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

/**
 * Created by theo on 20/07/16.
 */
public class WindowManager extends JFrame {

    //Buttons
    private JButton pauseButton = new JButton("Pause");
    private JButton stepButton = new JButton("Step");
    private JButton gridButton = new JButton("Grid");
    private JButton startButton = new JButton("Start");
    private JButton saveButton = new JButton("Save");
    private JButton loadButton = new JButton("Load");
    private JButton screenshotButton = new JButton("Screenshot");
    private JButton cellTemplateButton = new JButton("Cells");
    private JButton environmentSetupButton = new JButton("Environment");

    //Readouts
    private TextArea currentStatsText;

    private MigLayout layout;
    private GridBagConstraints constraints;

    public WindowManager() {
        layout = new MigLayout("wrap 3");
        setLayout(layout);
        setMinimumSize(getPreferredSize());
        initComponents();
    }

    private void initComponents() {
        System.out.println("Core count " + Runtime.getRuntime().availableProcessors());
        Themer.themeButtons(pauseButton, stepButton, gridButton, startButton, saveButton, loadButton, screenshotButton,
                cellTemplateButton, environmentSetupButton);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);

    }
}
