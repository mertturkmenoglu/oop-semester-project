package ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SimpleWindow extends JFrame {
	public SimpleWindow() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		
		setSize(screenWidth / 2, screenHeight / 2);
		setLocation(screenWidth / 4, screenHeight / 4);
		setTitle("Test Window 2");
		
		FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
		setLayout(layout);
		
		JLabel testLabel = new JLabel("Plate: ");
		add(testLabel);
		
		JTextField testText = new JTextField(20);
		add(testText);
		
		JButton testButton = new JButton("Add Vehicle");
		add(testButton);
		
		testButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = testText.getText();
				JOptionPane.showMessageDialog(null, str);
			}
		});
	}
	
	public static void main(String[] args) {
		SimpleWindow window = new SimpleWindow();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setResizable(true);
		
		JOptionPane.showMessageDialog(null, "Message");
	}
}
