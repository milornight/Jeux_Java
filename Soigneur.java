public abstract class Soigneur extends Personnage implements Soigner{

  public Soigneur(String nom,int nbSoin,int disSoin){
    super(nom);
    this.nbSoin = nbSoin;
    this.disSoin = disSoin;
  }


//le soigneur ne peut soigner que les gens se trouve inferieur a son distance de soin
  public void Soigner(Personnage P) throws ExceptionPerso{

	  if(P == null){
		   throw new ExceptionPerso(); 
	  }
	   
	  int distance=aleatoir(100);  //distance entre la soigneur et la personne soigne
	   
      if (distance<=this.disSoin){
        P.nbVie=P.nbVie+this.nbSoin;
        System.out.println(this.nom+ " soingne "+ this.nbSoin+ " points a " + P.nom );
        System.out.println(P.nom +" reste "+ P.nbVie + " points de vie.");

      }else{
        System.out.println("soin non reussi.");
      }

    }
	

}
