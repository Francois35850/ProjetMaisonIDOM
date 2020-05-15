package objets;

import main.Objet;

public final class Lumiere extends Objet {
	
	private boolean allumee;

	public Lumiere() {
		super("La lumière");
		this.allumee = false;
	}
	
	public void changerEtat() {
		this.allumee = !this.allumee;
	}

	@Override
	public String etat() {
		if (this.allumee)
			return "est allumée";
		else
			return "est éteinte";
	}

	@Override
	public void utiliserObjet() {
		// TODO Auto-generated method stub
		
	}

}