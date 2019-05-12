package ui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainActivity extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainActivity frame = new MainActivity();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainActivity() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		
		setSize(screenWidth / 2, screenHeight / 2);
		setLocation(screenWidth / 4, screenHeight / 4);
		setTitle("Test Window 2");
		
		JButton yellowButton = new JButton("Yellow");
		JButton blueButton = new JButton("Blue");
		JButton redButton = new JButton("Red");
		
		
		
		//contentPane = new JPanel();
		
		contentPane.add(yellowButton);
		contentPane.add(blueButton);
		contentPane.add(redButton);
		
	
//		getContentPane().setLayout(new GridLayout(3, 1));
//		
//		JLabel testLabel = new JLabel("Plate: ");
//		getContentPane().add(testLabel);
//		testLabel.setSize(350, 100);
//		
//		JTextField testText = new JTextField(20);
//		getContentPane().add(testText);
//		
//		JButton testButton = new JButton("Add Vehicle");
//		getContentPane().add(testButton);
//		
//		controlPanel = new JPanel();
//		controlPanel.setLayout(new FlowLayout());
//		testButton.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String str = testText.getText();
//				JOptionPane.showMessageDialog(null, str);
//			}
//		});
	}

}
