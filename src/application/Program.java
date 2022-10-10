package application;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import model.entidades.Reserva;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkout = sdf.parse(sc.next());

		if (!checkout.after(checkin)) {
			System.out.println("Error in reservation! Check-out date must be after check-in date");
		} else {
			Reserva reserva = new Reserva(number, checkin, checkout);
			System.out.println("Reserva: " + reserva.toString());
			System.out.println();
			System.out.println("Enter data to update the reservation");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkout = sdf.parse(sc.next());
			
			Date now = new Date();
			if (checkin.before(now) || checkout.before(now)) {
				System.out.println("Error in reservation: Reservatuib dates for update must be furute dates! ");
			}
			else if (!checkout.after(checkin)) {
				System.out.println("Error in reservation! Check-out date must be after check-in date");
				}
			else {
				reserva.atualizardate(checkin, checkout);
				System.out.println("Reserva: " + reserva.toString());
			}
			}
		sc.close();
		}

}
