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
import ce.yildiz.oop.Date;
import ce.yildiz.oop.Subscription;
import ce.yildiz.oop.Time;
import vehicle.SubscribedVehicle;

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
		} while (!Validate.hour(enterHour));
		
		do {
			enterMinute = (String)
					JOptionPane.showInputDialog(
							"Aracýn giriþ yaptýðý dakika(sadece dakika bilgisi): ");
		} while (!Validate.minute(enterMinute));
		
		boolean added = autoPark.vehicleEnters(plate, 
			new Time(Integer.valueOf(enterHour), Integer.valueOf(enterMinute)), 
			isOfficial);
		
		String message = added ? "Araç Eklendi" : "Araç Eklenemedi";
		JOptionPane.showMessageDialog(null, message);
	}

	private void vehicleExits() {
		String plate;
		String exitHour;
		String exitMinute;
		
		do {
			plate = (String)
					JOptionPane.showInputDialog("Çýkacak aracýn plakasý: ");
		} while (!Validate.plate(plate));
		
		do {
			exitHour = (String)
					JOptionPane.showInputDialog(
							"Aracýn çýkýþ yaptýðý saat(sadece saat bilgisi): ");
		} while (!Validate.hour(exitHour));
		
		do {
			exitMinute = (String)
					JOptionPane.showInputDialog(
							"Aracýn çýkýþ yaptýðý dakika(sadece dakika bilgisi): ");
		} while (!Validate.minute(exitMinute));
		
		boolean checkOut = autoPark.vehicleExits(plate,
				new Time(Integer.valueOf(exitHour), Integer.valueOf(exitMinute)));
		
		String message = checkOut ? "Araç Çýkýþ Yaptý" : "Araç Çýkartýlamadý";
		JOptionPane.showMessageDialog(null, message);
	}
	
	private void addVehicle() {
		String plate;
		Date[] dates;
		Subscription subscription;
		SubscribedVehicle vehicle;
		
		do {
			plate = (String)
					JOptionPane.showInputDialog("Aracýn plakasý: ");
		} while (!Validate.plate(plate));
		
		dates = getDate();
		subscription = new Subscription(dates[0], dates[1], plate);
		vehicle = new SubscribedVehicle(subscription, plate);
		
		boolean added = autoPark.addVehicle(vehicle);
		
		String message = added ? "Araç eklendi" : "Araç eklenemedi";
		JOptionPane.showMessageDialog(null, message);
	}
	
	private Date[] getDate() {
		// public Date(int day, int month, int year)
		Date[] dates = new Date[2];
		
		String beginDay;
		String beginMonth;
		String beginYear;
		String endDay;
		String endMonth;
		String endYear;
		String beginDate;
		String endDate;
		
		do {
			beginDay = (String)
					JOptionPane.showInputDialog("Baþlangýç günü: ");
			
			beginMonth = (String)
					JOptionPane.showInputDialog("Baþlangýç ayý: ");
			
			beginYear = (String)
					JOptionPane.showInputDialog("Baþlangýç yýlý: ");
			
			
			endDay = (String)
					JOptionPane.showInputDialog("Bitiþ günü: ");
			
			endMonth = (String)
					JOptionPane.showInputDialog("Bitiþ ayý: ");
			
			endYear = (String)
					JOptionPane.showInputDialog("Bitiþ yýlý: ");
			
			beginDate = beginDay +"-" + beginMonth + "-" + beginYear;
			endDate = endDay + "-" + endMonth + "-" + endYear;
		} while (!Validate.date(beginDate) || !Validate.date(endDate));
		
		dates[0] = new Date(Integer.valueOf(beginDay), 
							Integer.valueOf(beginMonth),
							Integer.valueOf(beginYear));
		dates[1] = new Date(Integer.valueOf(endDay),
							Integer.valueOf(endMonth),
							Integer.valueOf(endYear));
		
		return dates;
	}
}
