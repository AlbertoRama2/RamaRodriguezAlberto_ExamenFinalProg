package Models;

import java.util.Date;

public class Coche {

	private Date HoraEntrada;
	private Date HoraSalida;
	private float PrecioTotal;
	
	public Coche(Date horaEntrada, Date horaSalida, float precioTotal) {
		super();
		HoraEntrada = horaEntrada;
		HoraSalida = horaSalida;
		PrecioTotal = precioTotal;
	}

	public Date getHoraEntrada() {
		return HoraEntrada;
	}

	public void setHoraEntrada(Date horaEntrada) {
		HoraEntrada = horaEntrada;
	}

	public Date getHoraSalida() {
		return HoraSalida;
	}

	public void setHoraSalida(Date horaSalida) {
		HoraSalida = horaSalida;
	}

	public float getPrecioTotal() {
		return PrecioTotal;
	}

	public void setPrecioTotal(float precioTotal) {
		PrecioTotal = precioTotal;
	}

	@Override
	public String toString() {
		return "Registro [HoraEntrada=" + HoraEntrada + ", HoraSalida=" + HoraSalida + ", PrecioTotal=" + PrecioTotal
				+ "]";
	}
}
