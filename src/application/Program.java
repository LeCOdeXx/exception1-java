package application;

import java.util.Date;
import java.util.InputMismatchException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import model.entidades.Reserva;
import model.execptions.FullException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkin = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkout = sdf.parse(sc.next());
			Date teste1 = checkin;
			Date teste2 = checkout;

			Reserva reserva = new Reserva(number, checkin, checkout);
			System.out.println("Reserva: " + reserva.toString());

			System.out.println();
			System.out.println("Enter data to update the reservation");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkout = sdf.parse(sc.next());

			reserva.atualizardate(teste1, teste2, checkin, checkout);
			System.out.println("Reservation: " + reserva.toString());
		} catch (ParseException e) {
			System.out.println("Data Invalida");
		} catch (FullException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println("Valor digitado não segue o seguimento informado");
		} catch (RuntimeException e) {
			System.out.println("Erro inesperado!!");
		}
		
		sc.close();
	}

}
