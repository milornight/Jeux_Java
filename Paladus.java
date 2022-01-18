public class Paladus extends Paladin {

	public Paladus() {
		super("Paladus", 10, 5, 30, 20);
	}

	public String allInfo(){
		return this.nom +"(" +super.NomClass()+ ")\n"+"PV : "+this.nbVie+"\npoints de soin : "+this.nbSoin+ "\npoints d'attaque : "+ this.nbAtt;
	}

}
