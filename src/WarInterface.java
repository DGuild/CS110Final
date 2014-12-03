import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WarInterface {
    public final static boolean RIGHT_TO_LEFT = false;
    JLabel j1;
    JLabel j2;
    JLabel j3;
    JLabel j4;
    JButton j5;
    JLabel j6;
    JLabel j7;
    JLabel j8;
    JLabel j9;

    public void addComponentsToPane(Container contentPane) {
        if (RIGHT_TO_LEFT) {
            contentPane.setComponentOrientation(
                ComponentOrientation.RIGHT_TO_LEFT);
        }
//        Any number of rows and 2 columns
        contentPane.setLayout(new GridLayout(0,3));
        
        
        
        JLabel j1 = new JLabel();
        j1.setIcon(new ImageIcon("../img\\2c.jpg"));
        contentPane.add(j1);
        contentPane.add(new JLabel("Weclome to War"));
        JLabel j3 = new JLabel();
        contentPane.add(j3);
        JLabel j4 = new JLabel();
        j4.setIcon(new ImageIcon("../img\\back.jpg"));
        contentPane.add(j4);
        JButton j5 = new JButton("Click to continues");
        j5.addActionListener(new ButtonListener());
        contentPane.add(j5);
        JLabel j6 = new JLabel();
        j6.setIcon(new ImageIcon("../img\\back.jpg"));
        contentPane.add(j6);
        JLabel j7 = new JLabel("Player", SwingConstants.CENTER);
        contentPane.add(j7);
        JLabel j8 = new JLabel();
        contentPane.add(j8);
        JLabel j9 = new JLabel("Computer", SwingConstants.CENTER);
        contentPane.add(j9);
        
        
    }

    public void createAndShowGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);

        JFrame frame = new JFrame("WAR");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set up the content pane and components in GridLayout
        addComponentsToPane(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
        
    }
        
     private class ButtonListener implements ActionListener{
     
         public void actionPerformed(ActionEvent e){
            ;
         }
     }
}