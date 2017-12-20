import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class TemperatureWindow extends JFrame implements ActionListener{

	private Container layout; 
	private JTextField temperature;
	private JRadioButton bCtoF;
	private JRadioButton bFtoC;
	private ButtonGroup conversion;
	private JButton convert;
	private JTextField output;
	
	public TemperatureWindow(){
		this.setTitle("Temperature Conversion");
		this.setSize(600,400);
		this.setLocation(100,100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		layout = this.getContentPane();
		layout.setLayout( new FlowLayout());

		temperature = new JTextField(7);
		convert = new JButton("Convert");
		convert.addActionListener(this);
		bCtoF = new JRadioButton("Celsius to Farhenheit");
		bFtoC = new JRadioButton("Farhenheit to Celsius");
		bFtoC.setSelected(true);
		conversion = new ButtonGroup();

		conversion.add(bCtoF);
		conversion.add(bFtoC);

		layout.add(temperature);
		layout.add(bCtoF);
		layout.add(bFtoC);
		layout.add(convert);
		

		output = new JTextField(15);
		output.setEditable(false);
		layout.add(output);
		
	}

	public void actionPerformed(ActionEvent e){
		double temp = 0.0;
		boolean calculate = true; 
		try{
			temp = Double.parseDouble(temperature.getText());
		}catch(NumberFormatException n){
			output.setText("enter a number");
			calculate = false;
		}
		if (calculate){
			if (bFtoC.isSelected()){
				output.setText(""+TemperatureConversion.FtoC(temp));
			}else{
				output.setText(""+TemperatureConversion.CtoF(temp));
			}
		}
	}

	public static void main(String[] args){
		TemperatureWindow g = new TemperatureWindow();
		g.setVisible(true);
	}
}
