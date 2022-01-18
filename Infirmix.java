public class Infirmix extends Soigneur{

	public Infirmix() {
		super("Infirmix", 10, 25);
	}

	public String allInfo(){
		return this.nom +"(" +super.NomClass()+ ")\n"+"PV : "+this.nbVie+"\npoints de soin : "+this.nbSoin;
	}

}

