import java.lang.*;

public class Archeus extends Guerrier {

	public Archeus() {
		super("Archeus", 5, 20);
	}
	
	public String allInfo(){
		return this.nom +"(" +super.NomClass()+ ")\n"+"PV : "+this.nbVie+"\npoints d'attaque : "+this.nbAtt;
	}
	
}
