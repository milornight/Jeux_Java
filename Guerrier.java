public abstract class Guerrier extends Personnage implements Attaque{


  public Guerrier(String nom,int nbAtt,int disAtt){
    super(nom);
    this.nbAtt = nbAtt;
    this.disAtt = disAtt;
  }


//le guerrier ne peut attaquer que les gens se trouve inferieur a son distance d'attaque
  public void Attaque(Personnage P) throws ExceptionPV, ExceptionSelf, ExceptionPerso{
	  
	if(P == null){
		   throw new ExceptionPerso(); 
	}
	
    int distance=aleatoir(100); //distance entre le gurrier et la personne attaque
	
	if (P == this){ //tester si le personnage attque est lui meme
		throw new ExceptionSelf();
	}else{
			
		if (distance<=this.disAtt){
			P.nbVie=P.nbVie-this.nbAtt;
			System.out.println(this.nom+ " attaque "+ this.nbAtt+ " points a " + P.nom );

			if (P.nbVie<=0){ //tester le personnage est mort ou pas
				System.out.println(P.nom);
				throw new ExceptionPV();
			}

		}else{
			System.out.println("attaque non reussi.");
		}
	}

  }

}
