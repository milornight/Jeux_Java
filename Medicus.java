public class Medicus extends Soigneur {

	public Medicus() {
		super("Medicus", 5, 5);
	}

	public String allInfo(){
		return this.nom +"(" +super.NomClass()+ ")\n"+"PV : "+this.nbVie+"\npoints de soin : "+this.nbSoin;
	}
	

}
