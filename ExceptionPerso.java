import java.lang.Exception;

//exception pour tester  si le personnage existe
public class ExceptionPerso extends Exception {
	
	public ExceptionPerso() {
		super();
		System.out.println("Cette personnage n'existe plus ");
	}
}
