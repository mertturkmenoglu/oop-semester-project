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

import ce.yildiz.oop.AutoPark;
import ce.yildiz.oop.Time;

@SuppressWarnings("serial")
public class MainActivity extends JFrame {

	private JPanel contentPane;
	private AutoPark autoPark;

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
		setTitle("JAVA SEMESTER PROJECT MERT TURKMENOGLU - CAGDAS AYYILDIZ");
		String hourlyFee;
		String capacity;
		
		do {
			hourlyFee = (String)
					JOptionPane.showInputDialog("Otopark saatlik ücreti: ");
		} while (!Validate.hourlyFee(hourlyFee));
		
		do {
			capacity = (String) JOptionPane.showInputDialog("Kapasite: ");
		} while (!Validate.capacity(capacity));
		
		try {
			autoPark = new AutoPark(Double.valueOf(hourlyFee), 
					Integer.valueOf(capacity));
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "INVALID VALUES");
		}
		
		JButton aracEkle = new JButton("Araç Ekle");
		JButton aracCikar = new JButton("Araç Çýkar");
		JButton kayitEkle = new JButton("Kayýt Ekle");
		JButton otoparkGoruntule = new JButton("Otopark Görüntüle");
		
		contentPane.add(aracEkle);
		contentPane.add(aracCikar);
		contentPane.add(kayitEkle);
		contentPane.add(otoparkGoruntule);
		
		aracEkle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vehicleEnters();
			}
		});
		
		aracCikar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vehicleExits();
			}
		});
		
		kayitEkle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addVehicle();
			}
		});
		
		otoparkGoruntule.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, autoPark.toString());	
			}
		});
	}
	
	private void vehicleEnters() {
		String plate;
		String enterHour;
		String enterMinute;
		
		do {
			plate = (String)
					JOptionPane.showInputDialog("Eklenecek aracýn plakasý: ");
		} while (!Validate.plate(plate));

		Object[] possibilities = {"Evet", "Hayýr"};
		String isOfficialString = (String)JOptionPane.showInputDialog(
		                    null, "Resmi araç mý?:\n",
		                    "Resmiyet Bilgisi",
		                    JOptionPane.PLAIN_MESSAGE,
		                    null, possibilities,
		                    "resmiyet");
		
		boolean isOfficial = isOfficialString.equals("Evet");
		
		do {
			enterHour = (String)
					JOptionPane.showInputDialog(
							"Aracýn giriþ yaptýðý saat(sadece saat bilgisi): ");
		} while (!Validate.enterHour(enterHour));
		
		do {
			enterMinute = (String)
					JOptionPane.showInputDialog(
							"Aracýn giriþ yaptýðý dakika(sadece dakika bilgisi): ");
		} while (!Validate.enterMinute(enterMinute));
		
		boolean added = autoPark.vehicleEnters(plate, 
			new Time(Integer.valueOf(enterHour), Integer.valueOf(enterMinute)), 
			isOfficial);
		
		String message = added ? "Araç Eklendi" : "Araç Eklenemedi";
		JOptionPane.showMessageDialog(null, message);
	}

	private void vehicleExits() {
		// TODO: IMPLEMENT
	}
	
	private void addVehicle() {
		// TODO: IMPLEMENT
	}
}
