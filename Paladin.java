public abstract class Paladin extends Personnage implements Attaque, Soigner{

  public Paladin(String nom,int nbAtt,int nbSoin,int disAtt,int disSoin){
    super(nom,nbAtt,nbSoin,disAtt,disSoin);
  }

//le paladin peut attaquer les gens qui se trouve n'importe ou
//il peut rendre le point d'attque double quand le personne attaque se trouve superieur a son distance d'attaque
//si le personne attaque se trouve inferieur a son  distance d'attaque, le paladin peut produire un attaque normal, en plus il perd du point aussi
  public void Attaque(Personnage P) throws ExceptionPV, ExceptionSelf, ExceptionPerso{
	  
	    if(P == null){
		   throw new ExceptionPerso(); 
		}
	    
        int distance=aleatoir(100);	//distance entre le gurrier et la personne attaque
		
		if (P == this){ //tester si le personnage attque est lui meme
		throw new ExceptionSelf();
		
		}else{
			
			if (distance>=this.disAtt){
				P.nbVie=P.nbVie-2*this.nbAtt;
				System.out.println(this.nom+ " attaque "+ 2*this.nbAtt+ " points a " + P.nom );

			}else{
				P.nbVie=P.nbVie-this.nbAtt;
				System.out.println(this.nom+ " attaque "+ this.nbAtt+ " points a " + P.nom );
				this.nbVie=this.nbVie-this.nbAtt;
				System.out.println(this.nom+ " perd "+ this.nbAtt+ " points" );
			}

			if (P.nbVie<=0){ //tester le personnage est mort ou pas
				System.out.println(P.nom);
				throw new ExceptionPV();
			}

			if (this.nbVie<=0){ //tester le personnage est mort ou pas
				System.out.println(this.nom);
				throw new ExceptionPV();
			}
		}

  }


//le paladin ne peut soigner que les gens se trouve inferieur a son distance de soin
//le paladin perd des points de vie lorsqu'il soigne
  public void Soigner(Personnage P) throws ExceptionPV, ExceptionPerso{
	  
	if(P == null){
		throw new ExceptionPerso(); 
	}
	  
    int distance=aleatoir(100);	//distance entre le gurrier et la personne attaque

    if (distance<=this.disSoin){
      P.nbVie=P.nbVie+this.nbSoin;
      System.out.println(this.nom+ " soingne "+ this.nbSoin+ " points a " + P.nom );
      System.out.println(P.nom +" reste "+ P.nbVie + " points de vie.");
      this.nbVie=this.nbVie-nbSoin;
      System.out.println(this.nom+ " perd "+ this.nbSoin+ " points " );
      
      if(this.nbVie<=0){ //tester le personnage est mort ou pas
        System.out.println(this.nom);
        throw new ExceptionPV();
	  }

	 }else{
		System.out.println("soin non reussi.");

	}
  }
}
