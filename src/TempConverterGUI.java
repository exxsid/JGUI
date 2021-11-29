import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;

public class TempConverterGUI {

    // three panels for containing the first and second temperature
    // option and convert button
    private JPanel firstPanel = new JPanel();
    private JPanel secPanel = new JPanel();
    private JPanel convPanel = new JPanel();

    // display and get input from the user
    private JTextArea firstTxtAr = new JTextArea();
    private JTextArea secTxtAr = new JTextArea();

    // display the options for temperature conversion
    private final String[] choices = {"Celsius", "Fahrenheit", "Kelvin"};
    private JComboBox<String> firstChoice = new JComboBox<>(choices);
    private JComboBox<String> secChoice = new JComboBox<>(choices);

    // conversion button
    private JButton convertBtn = new JButton();

    private JPanel getFirstPanel(){
        return firstPanel;
    }

    private JPanel getSecPanel(){
        return secPanel;
    }

    private JPanel getConvPanel(){
        return convPanel;
    }

    TempConverterGUI(){

        // panel for first option
        firstTxtAr.setBounds(10, 10, 180, 30);
        firstTxtAr.setBackground(Color.white);
        firstChoice.setVisible(true);
        firstChoice.setBounds(200, 10, 180, 30);


        firstPanel.setVisible(true);
        firstPanel.setLayout(null);
        firstPanel.setBounds(0, 0, 400, 50);
        firstPanel.add(firstTxtAr);
        firstPanel.add(firstChoice);

        // panel for second option
        secTxtAr.setBounds(10, 10, 180, 30);
        secTxtAr.setBackground(Color.white);
        secTxtAr.setEditable(false);
        secChoice.setVisible(true);
        secChoice.setBounds(200, 10, 180, 30);


        secPanel.setVisible(true);
        secPanel.setLayout(null);
        secPanel.setBounds(0, 50, 400, 50);
        secPanel.add(secTxtAr);
        secPanel.add(secChoice);

        // panel for convert button
        convertBtn.setVisible(true);
//        convertBtn.setSize(100, 30);
        convertBtn.setText("Convert");

        convPanel.setBounds(0, 100, 400, 30);
        convPanel.add(convertBtn);

    }


    private void tempConvGUI (){
        JFrame frame = new JFrame();
        TempConverterGUI gui = new TempConverterGUI();
        frame.setTitle("Temperature Converter");
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(400, 200));
        frame.setLayout(null);
        frame.getContentPane().add(gui.getFirstPanel());
        frame.getContentPane().add(gui.getSecPanel());
        frame.getContentPane().add(gui.getConvPanel());

    }

    public static void main(String[] args) {
        TempConverterGUI temp = new TempConverterGUI();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                temp.tempConvGUI();
            }
        });
    }

}
