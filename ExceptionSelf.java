import java.lang.Exception;

//exception pour tester le personnage n'a pas attaque lui meme
public class ExceptionSelf extends Exception {
	
	public ExceptionSelf() {
		super();
		System.out.println("Vous ne pouvez pas vous attaquez vous meme ");
	}
}
