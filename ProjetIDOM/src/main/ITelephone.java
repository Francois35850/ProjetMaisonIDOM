package main;

public class ITelephone {
	private int mu_tel;
	private int mu_nbr_piece;
	private String wifi;
	private String gsm;
	private static String utilitaire="off";
	
public ITelephone(int mu_tel, int mu_nbr_piece, String wifi, String gsm) {
		this.mu_tel= mu_tel;
		this.mu_nbr_piece=mu_nbr_piece;
		this.wifi=wifi;
		this.gsm=gsm;
	}

public static ITelephone newTelephone() {
	String x1="";
	String y1="";		
	int x0=(int) Math.random();
	int y0=(int) Math.random();
	if (x0==0){x1="off";}
	else {x1="on";}
	if (y0==0){y1="off";}
	else {y1="on";}
	ITelephone iphone = new ITelephone(0,0,x1,y1);
	return iphone;
}

//fonction qui retourne l'état de la musique sur le ttéléphone
public static int getMusique(ITelephone iphone) {return iphone.mu_tel;}

//fonction qui retourne le nombre d'enceintes connectées sur le téléphone
public static int getPiece(ITelephone iphone) {return iphone.mu_nbr_piece;}

//fonction qui retourne l'état de la connexion gsm
public static String getWifi(ITelephone iphone) {return iphone.wifi;}

//fonction qui change l'état de la connexion wifi
public static String setWifi(ITelephone iphone) {
	if(getWifi(iphone).compareTo(utilitaire)==0) {iphone.wifi="on";}
	else {iphone.wifi="off";}
	return iphone.wifi;
		}	
//fonction qui retourne l'état de la connexion gsm
public static String getGsm(ITelephone iphone) {return iphone.gsm;}

//fonction qui change l'état de la connexion gms
public static String setGsm(ITelephone iphone) {
	if(getGsm(iphone).compareTo(utilitaire)==0) {iphone.gsm="on";}
	else {iphone.gsm="off";}
	return iphone.gsm;
}

}