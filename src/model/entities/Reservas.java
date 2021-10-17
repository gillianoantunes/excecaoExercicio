package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservas {
	private Integer numero;
	private Date checkIn;
	private Date checkOut;
	
// para formatar as datas no formato "dd/MM/yyyy"
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservas(Integer numero, Date checkIn, Date checkOut) throws DomainException {
		Date dataAtual = new Date();
		//verifica se datas de checkin e checkout s�o anteriores a data atual
		if((checkIn.before(dataAtual)) || (checkOut.before(dataAtual))){
			//lan�ou a exce��o e depois da erro e tem que colocar
			throw new DomainException("Datas de reserva  tem que ser futuras");
			}
		//verifica se n�o! data de checkout � depois da data de checkin se 
		if(!checkOut.after(checkIn)) {
			throw new DomainException("Data de checkout precisa ser posterior a data de checkin");
		}
		this.numero = numero;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	
	public Date getCheckOut() {
		return checkOut;
	}

	// apaguei os sets checkIn e set do checkOut para n�o deixar mudar
	//as datas arbitrariamento para isso temos o m�todo atualizarDatas
	
	//m�todo para calcular diferen�a entre datas em milissegundos retorna long
	public long duracao() {
		// o gettime me devolve a quantidade da data em milissegundos
		long diferenca = checkOut.getTime() - checkIn.getTime();
		//para convereter milessegundos para dias classe TimeUnit.
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
		
	}
	
	//m�todo para atualizar as datas
	public void atualizarDatas(Date checkIn, Date checkOut) throws DomainException {
		Date dataAtual = new Date();
		//verifica se datas de checkin e checkout s�o anteriores a data atual
		if((checkIn.before(dataAtual)) || (checkOut.before(dataAtual))){
			//chamando o DomainException
			throw new DomainException("Datas de reserva para atualizar tem que ser futuras");
			}
		//verifica se n�o! data de checkout � depois da data de checkin se 
		if(!checkOut.after(checkIn)) {
			throw new DomainException("Data de checkout precisa ser posterior a data de checkin");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	//tem que formatar a data usando l� em cima o simpleDateFormat
	@Override
	public String toString() {
		return "N�mero: " + numero +
				"Check In: " + sdf.format(checkIn) +
				"Check Out: " + sdf.format(checkOut) +
				", " +
				duracao() +
				" noite(s)";
	} 
}
