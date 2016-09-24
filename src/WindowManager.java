
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
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
    private JTextArea currentStatsText = new JTextArea();

    private MigLayout layout;
    private GridBagConstraints constraints;

    public WindowManager() {
        layout = new MigLayout("wrap 3");
        setLayout(layout);
        setMinimumSize(getPreferredSize());
        initComponents();
        addMenuBar();

        final JScrollPane sp = new JScrollPane(currentStatsText);
        currentStatsText.setBackground(Color.BLACK);
        currentStatsText.setForeground(Color.WHITE);
        currentStatsText.setMinimumSize(new Dimension(300, 900));
        add(sp);
        pack();
    }

    private void addMenuBar() {
        final JMenuBar menuBar = new JMenuBar();
        menuBar.add(startButton);
        menuBar.add(pauseButton);
        menuBar.add(stepButton);
        menuBar.add(saveButton);
        menuBar.add(loadButton);
        menuBar.add(cellTemplateButton);
        menuBar.add(environmentSetupButton);
        menuBar.add(screenshotButton);
        menuBar.add(gridButton);

        menuBar.setForeground(Color.BLACK);
        menuBar.setBackground(Color.WHITE);
        menuBar.setBorder( new CompoundBorder(new LineBorder(Color.BLACK), new EmptyBorder(1,1,1,1)));

        setJMenuBar(menuBar);
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
