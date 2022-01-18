import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Random;


public class Fenetre extends JFrame implements ListSelectionListener, ActionListener{
  private JPanel panneau,ligne1,ligne2;
  private JTextField InfoA,InfoB;
  private JButton combat,soigne;
  private JList<Object> A,B;
  private DefaultListModel listModel;
  private Personnage Perso;
  private int Index;
  private Deck equipeA,equipeB;

  public Fenetre(){
	super();
    this.setTitle("Jeu"); 	//nom de l'interface graphique  
    this.setSize(1000,200);		//taille
    this.setLocationRelativeTo(null); // se positionner au centre de l'ecran
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // termine le processus si on clique sur la croix
    this.setVisible(true);	//rend visible
    
    Perso = null;
    
    // la fenetre se compose en 3 parties
    panneau = new JPanel();
    ligne1 = new JPanel();
    ligne2 = new JPanel();

	//deux bouttons
    combat= new JButton("Combat");
    soigne= new JButton("Soigne");
	
	//on cree la case pour affichier les caracteristique
    InfoA = new JTextField();
    InfoA.setColumns(35); // tailles des cases
    InfoB = new JTextField();
    InfoB.setColumns(35);
    
    //on instancie deux lists 
    equipeA = new Deck();
	equipeB = new Deck();
	
	//on ajoute des informations de personnage dans le Jlist
    A = new JList<Object>((equipeA.getList()).toArray());
    B = new JList<Object>((equipeB.getList()).toArray());
    A.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    B.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    
	//on ajoute des infos sur le panneau
    ligne1.add(A);
    ligne1.add(combat);
    ligne1.add(soigne);
    ligne1.add(B);

    ligne2.add(InfoA);
    ligne2.add(InfoB);

    panneau.setLayout(new GridLayout(2,1));
    panneau.add(ligne1);
    panneau.add(ligne2);

    this.setContentPane(panneau); //mettre le panneau dans l'interface

    
    //initialisation les textes et les bouttons
	A.addListSelectionListener(this);
	B.addListSelectionListener(this);
	combat.addActionListener(this);
	soigne.addActionListener(this);
	InfoA.addActionListener(this);
	InfoB.addActionListener(this);
	
	

    }
    
    // on gere ici la selection dans la JList
    public void valueChanged(ListSelectionEvent e){ 
		if (e.getSource()==A) { // si on selection un element de la JLIST de l'equipe A	
			InfoA.setText(((Personnage)(A.getSelectedValue())).allInfo());	 //on affiche son information dans leur JText
			Perso = (Personnage)A.getSelectedValue(); //Le personnage choisi	
			Index = A.getSelectedIndex();				//Le indice de cette personnage dans la liste
		}
	
		if(e.getSource() == B) {
			InfoB.setText(((Personnage)(B.getSelectedValue())).allInfo());
			Perso = (Personnage)B.getSelectedValue();
			Index = B.getSelectedIndex();
		
		}
	
	}
	

	
	public void actionPerformed(ActionEvent event) {
		Random r = new Random();
		int nSoigne = r.nextInt(equipeA.getList().size());  //on prend de facon aleatoire le personne soigne
		int nAdv = r.nextInt(equipeB.getList().size());		//on prend de facon aleatoire l'adversaire
		
		try {
			if (event.getSource().equals(soigne) && Perso!=null){ //si on clique sur boutton soigne et on a choisi un personnage
				Personnage P = equipeA.getList().get(nSoigne);
				if(Perso instanceof  Paladin) {
					((Paladin) Perso).Soigner(P);
				}
				
				if(Perso instanceof  Soigneur) {
				((Soigneur) Perso).Soigner(P);
				}
				InfoA.setText(P.allInfo()); // affiche le caracteristique du perso soigne
			}

		
			if(event.getSource().equals(combat) && Perso!=null) { //si on clique sur boutton combat et on a choisi un personnage
				Personnage adversaire = equipeB.getList().get(nAdv);
				if(Perso instanceof Guerrier) {
					((Guerrier)Perso).Attaque(adversaire);
					
				}
			
				if(Perso instanceof Combattant) {
					((Combattant)Perso).Attaque(adversaire);
				} 
			
				if(Perso instanceof Paladin) {
					((Guerrier)Perso).Attaque(adversaire);
				}
				InfoB.setText(adversaire.allInfo());
			}
		}
		catch (ExceptionSelf e) { }
		catch (ExceptionPV e) { }
		catch (ExceptionPerso e){} 
		
	}
	
}
