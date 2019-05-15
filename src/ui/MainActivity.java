package ui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		
		setSize(screenWidth / 2, screenHeight / 2);
		setLocation(screenWidth / 4, screenHeight / 4);
		setTitle("I'M THE BAAAAAAAD GUUUY. D'UH!");
		
		JButton aracEkle = new JButton("Araç Ekle");
		JButton aracCikar = new JButton("Araç Çýkar");
		JButton kayitEkle = new JButton("Kayýt Ekle");
		
		contentPane.add(aracEkle);
		contentPane.add(aracCikar);
		contentPane.add(kayitEkle);
		
		aracEkle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "ARAC EKLE");
			}
		});
		
		aracCikar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "ARAC CIKAR");
			}
		});
		
		kayitEkle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "KAYIT EKLE");
			}
		});
	}

}
