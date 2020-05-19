
public class Volet {
	
	//Attributs
	private boolean etat_volet
	private boolean utilisation;
	
	//Constructeur
	public Volet(String nom, boolean utilisation, boolean etat_volet) {
		super(nom);
		this.utilisation=utilisation;
		this.etat_volet=etat_volet;
	}
	
	//fonction qui initialise les fenetre de la maison
	public static void initialisationFenetreMaison(){
		Volet volet_bureau = new Volet("volet_bureau", false, false);
		Volet volet_salon1 = new Volet("volet__salon1", false, false);
		Volet volet_salon2 = new Volet("volet__salon2", false, false);
		Volet volet_ch1 = new Volet("volet_ch1", false, false);
		Volet volet_ch2 = new Volet("volet_ch2", false, false);
		Volet volet_chp = new Volet("volet_chp", false, false);
		Volet volet_sallejeux = new Volet("volet_sallejeux", false, false);
		Volet volet_studio = new Volet("volet_studio", false, false);
		Volet volet_cuisine = new Volet("volet_cuisine", false, false);
		Volet volet_sallemanger = new Volet("volet_sallemanger", false, false);
		}
	
	public String etat() {
		String res = "";
		if(this.etat_volet==true) {res+=" : ouvert";}
		else {res+=" : fermé";}
		return res + "\n";
	}
	
	//fonction qui permet d'utiliser la fenetre 			
	public void utiliserObjet() {
		this.setUtilisation(true);
		Scanner sc = new Scanner(System.in);
		System.out.println("Vous utilisez " + this.getNom() +".");
		while(this.utilisation==true){
			System.out.println("Liste des actions possibles pour cet objet :\n  - ouvrir le volet\n  - fermer le volet\n  - retour");
			String entree = input.nextLine();
			switch (entree) {
				case "OUVRIR":
					setEtat(true);
					break;
				case "FERMER":
					setEtat(false);
					break;
				case "RETOUR" :
					this.setUtilisation(false);
					System.out.println("Vous arrêtez d'utiliser l'objet");
					break;	
				default :
					System.out.println("La commande n'est pas valide");
					break;
			}

	public String toString() {
		String res = "";
		res += " - " + super.getNom() + " " + this.etat();
		return res;
	}
	
	public boolean getEtat(Volet volet) {return this.etat_volet;}
	
	public void setEtat(boolean use) {this.etat_volet = use;}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
}
