import java.lang.Exception; 

//exception pour tester le personnage est mort ou pas, si oui on le sort de la list
class ExceptionPV extends Exception{
	
	public ExceptionPV(){
		super();
		System.out.println("Le personnage est mort, il sort du jeu");
	}
}

