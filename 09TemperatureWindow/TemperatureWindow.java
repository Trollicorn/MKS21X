import javax.swing.*;
import java.awt.*;
public class TemperatureWindow extends JFrame{

    private Container layout; 
    private JTextField temperature;
    private JRadioButton CtoF;
    private JRadioButton FtoC;
    private ButtonGroup conversion;

    
    public TemperatureWindow(){
	this.setTile("Temperature Conversion");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	layout.setLayout( new FlowLayout());

	temperature = new JTextField(7);
	buttonCtoF = new JButton("Celsius to Farhenheit");
	buttonFtoC = new JButton("Farhenheit to Celsius");

	layout.add(temperature);
	layout.add
    }



}
