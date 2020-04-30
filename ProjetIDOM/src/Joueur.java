import java.util.List;

public class Joueur {
	
	private Piece pieceCourante;
	private List<Objet> inventaire;

	public Joueur(Piece debut) {
		pieceCourante = debut;
		inventaire = null;
	}

}
