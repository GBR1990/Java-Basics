import java.awt.EventQueue;



import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Container;
import java.io.BufferedReader;


/**
 * This class helps in converting units.
 * @author     Gireeshma Bokka Reddy
 * @author     Ketki Gorakhnath Trimukhe
 *
 */



public class Converter {

	JFrame Frame;
	JPanel Panel;
	JTextField textEntered;
	int convertOperation = 0;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {

				new Converter();
			}
		});

	}

	public Converter() {
		Frame = new JFrame();
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frame.setSize(600, 300);
		Frame.setLocationRelativeTo(null);
		textEntered = new JTextField();
		textEntered.setHorizontalAlignment(JTextField.RIGHT);
		textEntered.setEditable(false);
		Frame.add(textEntered, BorderLayout.NORTH);
		Panel = new JPanel();
		Panel.setLayout(new GridLayout(5, 4));
		Frame.add(Panel, BorderLayout.CENTER);

		addActionButton(Panel, 1, "C to F");
		addActionButton(Panel, 2, "F to C");
		addActionButton(Panel, 3, "Km to Ly");
		addActionButton(Panel, 4, "Ly to Km");
		addActionButton(Panel, 5, "kmph to mph");
		addActionButton(Panel, 6, "mph to kmph");
		addActionButton(Panel, 7, "inches to mtr");
		addActionButton(Panel, 8, "mtr to inches");

		for (int i = 0; i < 10; i++) {
			addNumberButton(Panel, String.valueOf(i));
		}

		JButton equalsButton = new JButton("=");
		equalsButton.setActionCommand("=");
		equalsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (!textEntered.getText().isEmpty()) {
					int number = Integer.parseInt(textEntered.getText());
					if (convertOperation == 1)// C to F
					{

						System.out.println("num:" + number);

						double calculate = ((number * 9) / 5) + 32;
						System.out.println("cal:" + calculate);
						textEntered.setText(Double.toString(calculate));
					} else if (convertOperation == 2)// F to C
					{

						double calculate = ((number - 32) * 5) / 9;
						textEntered.setText(Double.toString(calculate));
					} else if (convertOperation == 3)// km to Ly
					{

						double calculate = (number * (0.0001)) / (946073047);
						textEntered.setText(Double.toString(calculate));
					} else if (convertOperation == 4)// Ly to km
					{

						double calculate = (number * (946073047)) / (0.0001);
						textEntered.setText(Double.toString(calculate));
					} else if (convertOperation == 5)// kmph to mph
					{

						double calculate = (number / (1.6));
						textEntered.setText(Double.toString(calculate));
					} else if (convertOperation == 6)// mph to kmph
					{

						double calculate = (number * (1.6));
						textEntered.setText(Double.toString(calculate));
					} else if (convertOperation == 7)// inch to mtr
					{

						double calculate = (number * (2.54)) / 100;
						textEntered.setText(Double.toString(calculate));
					} else if (convertOperation == 8)// mtr to inch
					{

						double calculate = (number * (100)) / 2.54;
						textEntered.setText(Double.toString(calculate));
					} else if (convertOperation == 8)// mtr to inch
					{

						double calculate = (number * (100)) / 2.54;
						textEntered.setText(Double.toString(calculate));
					}
				}
			}
		});

		Panel.add(equalsButton);
		Frame.setVisible(true);
	}

	private void addNumberButton(Container cont, String name) {
		JButton but = new JButton(name);

		but.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String action = event.getActionCommand();

				textEntered.setText(textEntered.getText() + action);

			}
		});
		cont.add(but);
	}

	private void addActionButton(Container cont, int action, String text) {
		final int operator = action;
		JButton but = new JButton(text);
		but.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				{

					convertOperation = operator;
				}

			}
		});
		cont.add(but);
	}

}