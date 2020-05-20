package main;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Objectifs {

	List<Objectif> objectifs;

	private class Objectif {

		private String nom;
		private Function<Integer, Boolean> succes;

		public Objectif(String nom, Function<Integer, Boolean> succes) {
			this.nom = nom;
			this.succes = succes;
		}

		public boolean estRempli() {
			return this.succes.apply(0);
		}

		public String toString() {
			return this.nom;
		}

	}

	public Objectifs(String nom) {
		this.objectifs = new ArrayList<Objectif>();

		this.objectifs.add(new Objectif("test", (a) -> testObjectif(a)));
	}

	public boolean allObjectifsComplets() {
		for (Objectif o : this.objectifs) {
			if (!o.estRempli())
				return false;
		}
		return true;
	}

	private boolean testObjectif(int a) {
		return true;
	}

}
