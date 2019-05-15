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
	 * This method defines an entry point to program.
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
		
		/*
		 * Get hourly fee for autopark object. User should give a valid double value.
		 * Otherwise, it will ask until user gives.
		 */
		do {
			hourlyFee = (String)
					JOptionPane.showInputDialog("Otopark saatlik �creti: ");
		} while (!Validate.hourlyFee(hourlyFee));
		
		
		/*
		 * Get autopark capacity. It should be an integer greater than zero.
		 * On other input cases, it will ask it again.
		 */
		do {
			capacity = (String) JOptionPane.showInputDialog("Kapasite: ");
		} while (!Validate.capacity(capacity));
		
		/*
		 * Try to create an autopark object.
		 */
		try {
			autoPark = new AutoPark(Double.valueOf(hourlyFee), 
					Integer.valueOf(capacity));
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "INVALID VALUES");
		}
		
		/*
		 * Init Buttons. Buttons will be the medium 
		 * between user and the program.
		 */
		JButton aracEkle = new JButton("Ara� Ekle");
		JButton aracCikar = new JButton("Ara� ��kar");
		JButton kayitEkle = new JButton("Kay�t Ekle");
		JButton otoparkGoruntule = new JButton("Otopark G�r�nt�le");
		
		/*
		 * Add buttons to pane. If you do not add it, 
		 * it will be initialized but not visible.
		 */
		contentPane.add(aracEkle);
		contentPane.add(aracCikar);
		contentPane.add(kayitEkle);
		contentPane.add(otoparkGoruntule);
		
		/*
		 * Add button click listeners to buttons.
		 * They will listen for button actions.
		 * When user clicks to button, it will call 
		 * appropriate methods for each button.
		 */
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
	
	
	/**
	 * This method handles adding vehicles to autopark.
	 * It takes vehicle plate, enter time and official vehicle
	 * information. Then it will try to add it to autopark.
	 * If a car with the same plate is in the autopark, it should not add it.
	 * It will display an information dialog.
	 * If there is no car with the same plate number, it will add it to 
	 * autopark.
	 */
	private void vehicleEnters() {
		String plate;
		String enterHour;
		String enterMinute;
		
		/*
		 * Take vehicle plate
		 */
		do {
			plate = (String)
					JOptionPane.showInputDialog("Eklenecek arac�n plakas�: ");
		} while (!Validate.plate(plate));

		/*
		 * It will display a spinner with two options: "Evet" or "Hayir"
		 * Answer will be converted to a boolean value.
		 */
		Object[] possibilities = {"Evet", "Hay�r"};
		String isOfficialString = (String)JOptionPane.showInputDialog(
		                    null, "Resmi ara� m�?:\n",
		                    "Resmiyet Bilgisi",
		                    JOptionPane.PLAIN_MESSAGE,
		                    null, possibilities,
		                    "resmiyet");
		
		boolean isOfficial = isOfficialString.equals("Evet");
		
		/*
		 * Take time information. First take hour data then minute data.
		 */
		do {
			enterHour = (String)
					JOptionPane.showInputDialog(
							"Arac�n giri� yapt��� saat(sadece saat bilgisi): ");
		} while (!Validate.hour(enterHour));
		
		do {
			enterMinute = (String)
					JOptionPane.showInputDialog(
							"Arac�n giri� yapt��� dakika(sadece dakika bilgisi): ");
		} while (!Validate.minute(enterMinute));
		
		/*
		 * Try to add it to autopark
		 */
		boolean added = autoPark.vehicleEnters(plate, 
			new Time(Integer.valueOf(enterHour), Integer.valueOf(enterMinute)), 
			isOfficial);
		
		/*
		 * According to boolean value, print information to screen.
		 */
		String message = added ? "Ara� Eklendi" : "Ara� Eklenemedi";
		JOptionPane.showMessageDialog(null, message);
	}

	
	/**
	 * This method handles removing vehicles from autopark.
	 * It takes vehicle plate and exit time informations. 
	 * Then it will try to remove it from autopark.
	 * If it can remove it from autopark, it will display
	 * an information dialog, otherwise, it will prompt an error message.
	 */
	private void vehicleExits() {
		String plate;
		String exitHour;
		String exitMinute;
		
		/*
		 * Take vehicle plate
		 */
		do {
			plate = (String)
					JOptionPane.showInputDialog("��kacak arac�n plakas�: ");
		} while (!Validate.plate(plate));
		
		/*
		 * Take time information. First take hour data then minute data.
		 */
		do {
			exitHour = (String)
					JOptionPane.showInputDialog(
							"Arac�n ��k�� yapt��� saat(sadece saat bilgisi): ");
		} while (!Validate.hour(exitHour));
		
		do {
			exitMinute = (String)
					JOptionPane.showInputDialog(
							"Arac�n ��k�� yapt��� dakika(sadece dakika bilgisi): ");
		} while (!Validate.minute(exitMinute));
		
		/*
		 * Try to remove it from autopark
		 */
		boolean checkOut = autoPark.vehicleExits(plate,
				new Time(Integer.valueOf(exitHour), Integer.valueOf(exitMinute)));
		
		/*
		 * According to boolean value, print information to screen.
		 */
		String message = checkOut ? "Ara� ��k�� Yapt�" : "Ara� ��kart�lamad�";
		JOptionPane.showMessageDialog(null, message);
	}
	
	
	/**
	 * This method handles adding subscribed vehicles to autopark system.
	 * It takes vehicle plate and subscription dates.
	 * Then it will try to add it to autopark system.
	 * It will display an information dialog, or, prompt an error message.
	 */
	private void addVehicle() {
		String plate;
		Date[] dates;
		Subscription subscription;
		SubscribedVehicle vehicle;
		
		/*
		 * Take vehicle plate
		 */
		do {
			plate = (String)
					JOptionPane.showInputDialog("Arac�n plakas�: ");
		} while (!Validate.plate(plate));
		
		/*
		 * Get subscription's begin and end dates.
		 * Then create an appropriate subscription with dates and plate.
		 * Then it will create a vehicle with subscription and plate.
		 * Then it will try to add it to autopark's subscriptedVehicles array.
		 */
		dates = getDate();
		subscription = new Subscription(dates[0], dates[1], plate);
		vehicle = new SubscribedVehicle(subscription, plate);
		
		boolean added = autoPark.addVehicle(vehicle);
		
		/*
		 * According to boolean value, print information to screen.
		 */
		String message = added ? "Ara� eklendi" : "Ara� eklenemedi";
		JOptionPane.showMessageDialog(null, message);
	}
	
	
	/**
	 * This method handles getting subscription begin and end dates from user.
	 * It will take fields then try to validate.
	 * Then it will create Date objects and return them in an array
	 */
	private Date[] getDate() {
		Date[] dates = new Date[2];
		
		String beginDay;
		String beginMonth;
		String beginYear;
		String endDay;
		String endMonth;
		String endYear;
		String beginDate;
		String endDate;
		
		/*
		 * Take begin and end date informations field by field.
		 */
		do {
			beginDay = (String)
					JOptionPane.showInputDialog("Ba�lang�� g�n�: ");
			
			beginMonth = (String)
					JOptionPane.showInputDialog("Ba�lang�� ay�: ");
			
			beginYear = (String)
					JOptionPane.showInputDialog("Ba�lang�� y�l�: ");
			
			
			endDay = (String)
					JOptionPane.showInputDialog("Biti� g�n�: ");
			
			endMonth = (String)
					JOptionPane.showInputDialog("Biti� ay�: ");
			
			endYear = (String)
					JOptionPane.showInputDialog("Biti� y�l�: ");
			
			beginDate = beginDay +"-" + beginMonth + "-" + beginYear;
			endDate = endDay + "-" + endMonth + "-" + endYear;
		} while (!Validate.date(beginDate) || !Validate.date(endDate));
		
		/*
		 * After validating input, create date objects
		 * and return them in an array.
		 */
		dates[0] = new Date(Integer.valueOf(beginDay), 
							Integer.valueOf(beginMonth),
							Integer.valueOf(beginYear));
		dates[1] = new Date(Integer.valueOf(endDay),
							Integer.valueOf(endMonth),
							Integer.valueOf(endYear));
		
		return dates;
	}
}
