package main;

import objets.Enceinte;

public class ITelephone {
	private int musique_telephone;
	private String wifi;
	private String gsm;
	private Enceinte enceinte_telephone;
	private static String utilitaire = "off";

	public ITelephone(int musique_telephone, String wifi, String gsm, Enceinte enceinte_telephone) {
		this.musique_telephone = musique_telephone;
		this.wifi = wifi;
		this.gsm = gsm;
		this.enceinte_telephone = enceinte_telephone;
	}

	public static ITelephone newTelephone() {
		Enceinte enceinte_telephone = new Enceinte("haut parleur téléphone", false);
		String x1 = "";
		String y1 = "";
		int x0 = (int) Math.random();
		int y0 = (int) Math.random();
		if (x0 == 0) {
			x1 = "off";
		} else {
			x1 = "on";
		}
		if (y0 == 0) {
			y1 = "off";
		} else {
			y1 = "on";
		}
		ITelephone iphone = new ITelephone(0, x1, y1, enceinte_telephone);
		return iphone;
	}

//fonction qui retourne l'état de la connexion gsm
	public static String getWifi(ITelephone iphone) {
		return iphone.wifi;
	}

//fonction qui change l'état de la connexion wifi
	public static String setWifi(ITelephone iphone) {
		if (getWifi(iphone).compareTo(utilitaire) == 0) {
			iphone.wifi = "on";
		} else {
			iphone.wifi = "off";
		}
		return iphone.wifi;
	}

//fonction qui retourne l'état de la connexion gsm
	public static String getGsm(ITelephone iphone) {
		return iphone.gsm;
	}

//fonction qui change l'état de la connexion gms
	public static String setGsm(ITelephone iphone) {
		if (getGsm(iphone).compareTo(utilitaire) == 0) {
			iphone.gsm = "on";
		} else {
			iphone.gsm = "off";
		}
		return iphone.gsm;
	}

}