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

    // variable for result
    private double resDbl = 0.0;

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
        convertBtn.addActionListener(btn -> {
            try {
                if (firstChoice.getSelectedItem().equals(choices[0])){
                    // convert temperature celsius to celsius
                    if (secChoice.getSelectedItem().equals(choices[0])){
                        secTxtAr.setText(String.valueOf(Double.parseDouble(firstTxtAr.getText())));
                    }
                    // convert temperature celsius to fahrenheit
                    else if (secChoice.getSelectedItem().equals(choices[1])){
                        convertCelToFahr(Double.parseDouble(firstTxtAr.getText()));
                        secTxtAr.setText(String.valueOf(resDbl));
                    }
                    // convert celsius to kelvin
                    else{
                        convertCelToKelvin(Double.parseDouble(firstTxtAr.getText()));
                        secTxtAr.setText(String.valueOf(resDbl));
                    }
                }
                else if (firstChoice.getSelectedItem().equals(choices[1])){
                    // convert fahrenheit to celsius
                    if (secChoice.getSelectedItem().equals(choices[0])){
                        convertFahrToCel(Double.parseDouble(firstTxtAr.getText()));
                        secTxtAr.setText(String.valueOf(resDbl));
                    }
                    // convert fahrenheit to fahrenheit
                    else if (secChoice.getSelectedItem().equals(choices[1])){
                        secTxtAr.setText(String.valueOf(Double.parseDouble(firstTxtAr.getText())));
                    }
                    // convert fahrenheit to kelvin
                    else {
                        convertFahrToKel(Double.parseDouble(firstTxtAr.getText()));
                        secTxtAr.setText(String.valueOf(resDbl));
                    }
                }
                else {
                    // convert kelvin to celsius
                    if (secChoice.getSelectedItem().equals(choices[0])){
                        convertKelToCel(Double.parseDouble(firstTxtAr.getText()));
                        secTxtAr.setText(String.valueOf(resDbl));
                    }
                    // convert kelvin to fahrenheit
                    else if (secChoice.getSelectedItem().equals(choices[1])){
                        convertKelToFahr(Double.parseDouble(firstTxtAr.getText()));
                        secTxtAr.setText(String.valueOf(resDbl));
                    }
                    // convert kelvin to kelvin
                    else{
                        secTxtAr.setText(String.valueOf(Double.parseDouble(firstTxtAr.getText())));
                    }
                }
            } catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null,
                        "Enter an Integer",
                        "Number Format Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        });

        convPanel.setBounds(0, 100, 400, 30);
        convPanel.add(convertBtn);

    }

    private void convertCelToFahr(double c){
        resDbl = (c * (9.0 / 5.0)) + 32;
    }

    private void convertCelToKelvin(double c){
        resDbl = c + 273.15;
    }

    private void convertFahrToCel(double f){
        resDbl = (f - 32.0) / 1.8000;
    }

    private void convertFahrToKel(double f){
        resDbl = (f + 459.67) * (5.0/9.0);
    }

    private void convertKelToCel(double k){
        resDbl = k - 273.15;
    }

    private void convertKelToFahr(double k){
        resDbl = (k * (9.0 / 5.0)) - 459.57;
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
