package objet;

public class DetecteurIncendie extends ObjetNonRamassable{
	
	private int etat;

	public DetecteurIncendie(String nom, int etat) {
		super(nom);
		this.etat = etat;
	}
	
	public String etat() {
		String res = "";
		if(this.etat==1) {res+= " : incendie en cours";}
		else {res += " : pas de fumée";}
		return res + "\n";
	}
	
	public String toString() {
		String res = "";
		res += " - " + super.getNom() + " " + this.etat();
		return res;
	}
	
	public void setEtat(boolean use) {this.etat = use;}
	
}
