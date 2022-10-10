package model.entidades;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import model.execptions.FullException;

public class Reserva {
	private Integer numeroQuarto;
	private Date checkin;
	private Date checkout;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reserva(Integer numeroQuarto, Date checkin, Date checkout) throws FullException{
		if (checkin.after(checkout)) {
			throw new FullException( "Check-out date must be after check-in date!");
		}
		this.numeroQuarto = numeroQuarto;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public long duracao() {
		long diff = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

	}

	public void atualizardate(Date teste1,Date teste2, Date checkin, Date checkout) throws FullException{
		if (checkin.before(teste1) || checkout.before(teste2)) {
			throw new FullException( "Reservation dates for update must be furute dates!");
		}
		if (!checkout.after(checkin)) {
			throw new FullException( "Check-out date must be after check-in date");
		}
		this.checkin = checkin;
		this.checkout = checkout;
		
	}

	@Override
	public String toString() {
		return "Room " + numeroQuarto + ", check-in: " + sdf.format(checkin) + ", check-out: " + sdf.format(checkout)
				+ ", " + duracao() + " nights";

	}

}
