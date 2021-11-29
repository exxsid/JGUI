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



}
