public class Escrimus extends Combattant{

	public Escrimus() {
		super("Escrimus", 2, 5);
	}

	public String allInfo(){
		return this.nom +"(" +super.NomClass()+ ")\n"+"PV : "+this.nbVie+"\n points d'attaque : "+this.nbAtt;
	}
}
