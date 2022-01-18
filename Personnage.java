import java.util.Random;
import java.lang.*;



public abstract class Personnage{
  protected String nom;
  protected int nbVie; 		//nombre point de vie aleatoire
  protected int nbAtt; 		//nombre de point attaque
  protected int nbSoin; 	//nombre de point soin
  protected int disAtt; 	//distance maximum/minimum pour reussir d'attaque
  protected int disSoin;  	//distance maximum/minimum pour reussir de soin


  public Personnage(String nom) {
		this.nom = nom;
		nbVie = aleatoir(50);	
  }

  public Personnage(String nom,int nbAtt,int nbSoin,int disAtt,int disSoin){
			this.nom = nom;
			nbVie = aleatoir(50);
			this.nbAtt = nbAtt;
			this.nbSoin = nbSoin;
			this.disAtt = disAtt;
			this.disSoin = disSoin;
  }

//methode qui retourne un nombre aleatoire compris entre 0 et n
  public int aleatoir(int n){
    Random res=new Random();
    return res.nextInt(n);
  }

//methode qui affichier les caracteristique des personnages
  public abstract String allInfo();
  
  public int getnbVie(){
	  return this.nbVie;
  }
  
  public String toString(){
	  return this.nom;
  }
  
  public String NomClass() {
		return this.getClass().getName();
	}

}
