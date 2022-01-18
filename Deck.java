import java.util.*;
import java.util.Random;
	
public class Deck{
	private final static int nbPer = 5;
	private ArrayList<Personnage> list;

	public Deck(){
		list = new ArrayList<Personnage>();
		
		Random r = new Random();
		
		for(int i = 0; i<nbPer; i++) {
			int n = r.nextInt(nbPer); //indice
			
			switch (n) {
				case 0: list.add(new Medicus());
					break;
				case 1: list.add(new Infirmix());
					break;
				case 2: list.add(new Escrimus());
					break;
				case 3: list.add(new Archeus());
					break;
				case 4: list.add(new Paladus());
					break;
			}
		}	

	}
	
	public ArrayList<Personnage> getList(){
		return list;
	}
	
	
	public void round(Deck Adversaire) throws ExceptionPV, ExceptionSelf, ExceptionPerso{
		Random r = new Random();
		int nAdv = r.nextInt(Adversaire.list.size()-1); //indice de adversaire dans la lite d'adversaire
		int nLis = r.nextInt(this.list.size()-1);		//indice de personnage dans leur propre list
		
		if((this.list.get(nLis)) instanceof Guerrier) {
			try {
			((Guerrier)(this.list.get(nLis))).Attaque(Adversaire.list.get(nAdv));
			}
			catch(ExceptionPV e) {
				System.out.println("Vous etes mort"); 
				Adversaire.list.remove(Adversaire.list.get(nAdv));
			}
										
		}
		
		if((this.list.get(nLis)) instanceof Combattant) {
			try {
			((Guerrier)(this.list.get(nLis))).Attaque(Adversaire.list.get(nAdv));
			}
			catch(ExceptionPV e) {
				System.out.println("Vous etes mort"); 
				Adversaire.list.remove(Adversaire.list.get(nAdv));
			}
										
		}
		
		if((this.list.get(nLis)) instanceof Soigneur) {
			((Soigneur)(this.list.get(nLis))).Soigner(this.list.get(r.nextInt(this.list.size())));
		}
			
		
		if((this.list.get(nLis)) instanceof Paladin) { //on prend aleatoire de la fonction du paladin
			if (r.nextInt(1) == 0) {
				try{
					((Paladin)(this.list.get(nLis))).Soigner(this.list.get(r.nextInt(this.list.size())));
				}
				catch (ExceptionPV e){
					System.out.println("Vous etes mort"); 
					this.list.remove(nLis);
				}
				
			}else{
				try{
					((Paladin)(this.list.get(nLis))).Attaque(Adversaire.list.get(nAdv));
				}
				catch(ExceptionPV e){
					System.out.println("Vous etes mort"); 
					Adversaire.list.remove(Adversaire.list.get(nAdv));
				}
			}
		}
		
	}
		
}
