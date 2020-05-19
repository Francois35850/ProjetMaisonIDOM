package objets;

import main.ObjetNonRamassable;

public class DetecteurOuverture extends ObjetNonRamassable {
	
	private boolean ouverture;

	public DetecteurOuverture(String nom, boolean ouverture) {
		super(nom);
		this.ouverture = ouverture;
	}
	
	public String etat() {
		String res = "";
		if(this.ouverture==true) {res+= " : détecteur ouvert";}
		else {res += " : détecteur fermé";}
		return res + "\n";
	}
	
	public String toString() {
		String res = "";
		res += " - " + super.getNom() + " " + this.etat();
		return res;
	}
	
	public void setEtat(Fenetre fenetre) {
		if(getEtat(fenetre)==true) {this.ouverture=true;}
		else {this.ouverture=false;}
		}
		
		
	public boolean getEtat(DetecteurOuverture detecteurOuverture) {return this.ouverture;}
}
