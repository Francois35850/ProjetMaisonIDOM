package main;
import java.util.List;
import java.util.ListIterator;

public class Objectif {
	private String nom;
	private boolean objectif;
	
	public Objectif(String nom) {
		this.nom = nom;
		objectif = false;
	}

	public boolean update(){
		return Joueur.getEtatVetements()==1&&true;
	}
}
