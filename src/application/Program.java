package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Reservas;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) throws ParseException {
		
	Scanner sc = new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	// colocar todo trecho de código dentro do método try
   try {
		System.out.println("Número do quarto:");
		int numero = sc.nextInt();
		System.out.println("Data de checkin: (dd/MM/yyyy)");
		Date checkIn =sdf.parse(sc.next());
		System.out.println("Data de checkout: (dd/MM/yyyy)");
		Date checkOut = sdf.parse(sc.next());
		
		
	    Reservas reservas = new Reservas(numero,checkIn, checkOut);
	    System.out.println("Resevas: " + reservas);
		
		System.out.println();
		System.out.println("Entre com as datas para atualizar a reserva:");
		System.out.println("Data de checkIn: (dd/MM/yyyy)");
		checkIn = sdf.parse(sc.next());
		System.out.println("Data de checkOut: (dd/MM/yyyy");
		checkOut = sdf.parse(sc.next());
		
		//imprime os dados da reserva atualizado chamando o método alterarDatas
		reservas.atualizarDatas(checkIn, checkOut);
		System.out.println("Resevas: " + reservas);
   }
   //agora por os catch para tratar as exceções
   //primeiro parseexception para verificar se a data esta invalida
   catch(ParseException e) {
	    System.out.println("Formato de data inválido");
  }
   // caso de este erro de argumento la na classe reservas
   //irá executar este catch passando a mensagem que coloquei la na classe reservas
   catch(DomainException e) {
	    System.out.println("Erro em reserva: " + e.getMessage());
  }
   //trato qualquer outro tipo de erro
   catch (RuntimeException e) {
	     System.out.println("Erro inesperado");
}
	sc.close();
	}

}
