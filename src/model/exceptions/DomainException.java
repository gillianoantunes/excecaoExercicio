package model.exceptions;

// extende a classe Exception
//quando a classe é execeção colocamos o sufixo Exception
// se ela estender a classe Exception ou RunTimeException
//RunTimeException não obriga você colocar o tryCatch
//Exception obriga a tratar
//se eu trocar por RunTimeException eu posso tirar os Throw na frente dos métodos
//mas mantenho a clausula catch(DomainException)
public class DomainException extends Exception {
	//vai dar um erro quando extender colocar add serial
	private static final long serialVersionUID = 1L;
	
	//construtor padrão passando uma mensagem que será personalizada
	//permite que instancie
	public DomainException(String msg) {
		super(msg);
	}

}
