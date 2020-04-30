
public class Objet {
	String nom;
	
	
	public Objet(String nom) {
		this.nom = nom;
	}
	
	public String toString() {
		String res = "";
		res+= nom; //TODO rajouter l'état des objets
		return res;
	}

}
