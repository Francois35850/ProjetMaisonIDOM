package main;

import java.util.ArrayList;
import java.util.ListIterator;

public class Objectif {

	private String nom;
	private boolean succes, displayed;
	private String[] details;
	
	public Objectif(String nom, boolean succes, String[] details) {
		this.nom = nom;
		this.succes = succes;
		this.displayed = false;
		this.details = details;
	}

	public void setSucces(boolean s) {
		this.succes = s;
		if (s)
			this.displaySucces();
	}

	public boolean estRempli() {
		return this.succes;
	}

	public String getNom() {
		return this.nom;
	}

	public String toString() {
		return this.nom;
	}

	private void displaySucces() {
		if (!this.displayed)
			System.out.println("Vous avez rempli l'objectif : " + this.toString() + " !");
		this.displayed = true;
	}
	
	public void printlnDetails() {
		System.out.println("     Détails de l'objectif :");
		for (String s : this.details) {
			System.out.println("       • " + s);
		}
	}

}