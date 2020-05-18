package objets;

import Maison.Alarme;

public final class Alarme extends ObjetNonRamassable {

	private int code_digicode;
	
	private int detecteur_incendie_rdc;
	private int detecteur_incendie_r1;;
	
	private int detecteur_mouvement_couloirrdc;
	private int detecteur_mouvement_salon;
	private int detecteur_mouvement_couloirr1;
	private int detecteur_mouvement_garage;
	
	private int detecteur_ouverture_porte;
	private int detecteur_ouverture_bureau;
	private int detecteur_ouverture_salon;
	private int detecteur_ouverture_ch1;
	private int detecteur_ouverture_ch2;
	private int detecteur_ouverture_chp;
	private int detecteur_ouverture_sallejeux;
	private int detecteur_ouverture_auditorium;
	private int detecteur_ouverture_cuisine;
	private int detecteur_ouverture_sallemanger;
	
	private String vue_cam_couloir=
			 "|---------------------------------------------------------------------|"+Newligne+
		     "|              |       |    				     |       |              |"+Newligne+
		     "|              |       |      		         |       |              |"+Newligne+
	    	 "|              |       |                       |       |              |"+Newligne+
		     "|              |       |                       |       |              |"+Newligne+
		     "|              |       |     _____________     |       |              |"+Newligne+
		     "|              |       |    |             |    |       |              |"+Newligne+
		     "|              |       |    |             |    |       |              |"+Newligne+
		     "|              |       |    |             |    |       |              |"+Newligne+
		     "|              |       |    |             |    |       |              |"+Newligne+
		     "|              |       |    |          _| |    |       |              |"+Newligne+
		     "|              |       |    |             |    |       |              |"+Newligne+
		     "|              |       |    |             |    |       |              |"+Newligne+
		     "|              |       |    |             |    |       |              |"+Newligne+
		     "|              |       |____|_____________|____|       |              |"+Newligne+
		     "|              |      /                         \      |              |"+Newligne+
		     "|              |     /                           \     |              |"+Newligne+
		     "|              |    /                             \    |              |"+Newligne+
		     "|	 		     |   /							     \   |			    |"+Newligne+
		     "|              |  /                                 \  |              |"+Newligne+
		     "|              | /                                   \ |              |"+Newligne+
		     "|______________|/        							    \|______________|"+Newligne+
		     "|                          										    |"+Newligne+
		     "|               													    |"+Newligne+
		     "|---------------------------------------------------------------------|";;
	private String vue_cam_jardin=
		     "|---------------------------------------------------------------------|")+Newligne+
			 "|                  |   / 	    	      |  ______ |                   |")+Newligne+
 			 "|                  |  /                 |  |    | |     []_[]         |")+Newligne+  
			 "|       /|         | /                  |  |    | |     ('v')         |")+Newligne+
			 "|      / |         |/           |_| |_| |__|____|_|    / |||)         |")+Newligne+
			 "|     /  |         /                                  (_=*;;          |")+Newligne+
 			 "|    /   |        /                                                   |")+Newligne+
 			 "|   /    |       /                                                    |")+Newligne+
 			 "|   |    |      /               _____________________________         |")+Newligne+
		 	 "|   |    |     /              //|   |    |    |    |    |  //        _|")+Newligne+
 			 "|   |    |    /              // |   |    |    |    |    | //        / |")+Newligne+
 			 "|   |   /    /              //| |   |    |    |    |    |//        /  |")+Newligne+
			 "|   |  /    /              // | |   |    |    |    |    //        /__/|")+Newligne+
			 "|   | /    /              //| | |   |    |    |    |   //        //   |")+Newligne+
 			 "|   |/    /              // | | |   |    |    |    |  //        //    |")+Newligne+
 			 "|        /              //| | | |___|____|____|____|_//    ___________|")+Newligne+
 			 "|       /              // | | | /                   //    /  /  /  /  |")+Newligne+
 			 "|      /              //| | | |/                   //    /  /  /  /  /|")+Newligne+
 			 "|	    /              // | | | /                   //    /__/__/__/__/_|")+Newligne+
 			 "|    /              //| | | |/                   //    //           //|")+Newligne+
 			 "|   /              // | | | /                   //    //           // |")+Newligne+
 			 "|  /              //__|_|_|/___________________//                     |")+Newligne+              
			 "| /                         										    |")+Newligne+
			 "|/              													    |")+Newligne+
			 "|---------------------------------------------------------------------|");
	private String vue_cam3="Systeme defaillant, veuillez contacter le service maintenance !";
	
;
	public Alarme(int code_digicode, int detecteur_incendie_rdc, int detecteur_incendie_r1, int detecteur_mouvement_couloirrdc, int detecteur_mouvement_salon, int detecteur_mouvement_couloirr1,  int detecteur_mouvement_garage, int detecteur_ouverture_porte, int detecteur_ouverture_bureau, int detecteur_ouverture_salon, int detecteur_ouverture_ch1,  int detecteur_ouverture_ch2, int detecteur_ouverture_chp, int detecteur_ouverture_sallejeux, int detecteur_ouverture_auditorium,  int detecteur_ouverture_cuisine, int detecteur_ouverture_sallemanger, String vue_cam_couloir, String vue_cam_jardin, String vue_cam3) {	
	this.code_digicode=code_digicode;
	this.detecteur_incendie_rdc=detecteur_incendie_rdc;
	this.detecteur_incendie_r1=detecteur_incendie_r1;
	this.detecteur_mouvement_couloirrdc=detecteur_mouvement_couloirrdc;
	this.detecteur_mouvement_couloirrdc=detecteur_mouvement_couloirrdc;
	this.detecteur_mouvement_garage=detecteur_mouvement_garage;
	this.detecteur_mouvement_salon=detecteur_mouvement_salon;
	this.detecteur_ouverture_auditorium=detecteur_ouverture_auditorium;
	this.detecteur_ouverture_bureau=detecteur_ouverture_bureau;
	this.detecteur_ouverture_ch1=detecteur_ouverture_ch1;
	this.detecteur_ouverture_ch2=detecteur_ouverture_ch2;
	this.detecteur_ouverture_chp=detecteur_ouverture_chp;
	this.detecteur_ouverture_cuisine=detecteur_ouverture_cuisine;
	this.detecteur_ouverture_porte=detecteur_ouverture_porte;
	this.detecteur_ouverture_sallemanger=detecteur_ouverture_sallemanger;
	this.detecteur_ouverture_sallejeux=detecteur_ouverture_sallejeux;
	this.detecteur_ouverture_salon=detecteur_ouverture_salon;
	this.vue_cam3=vue_cam3;
	this.vue_cam_couloir=vue_cam_couloir;
	this.vue_cam_jardin=vue_cam_couloir;
	}
	
	public static Alarme newAlarme () {
		Alarme alarm = new Alarme(2020,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,vue_cam_couloir,vue_cam_couloir,vue_cam3);
		return alarm;
	}
	
	public static int getCodeDigicode(Alarme alarm)	{return this.code_digicode;}
	
	public static int getEtat_DI_rdc(Alarme alarm) {return alarm.;}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Alarme(String nom) {
		super(nom);
		// TODO Auto-generated constructor stub
	}


<<<<<<< HEAD
	
	
	
	
	
	
	
	
	
	
	
=======
	@Override
	public void utiliserObjet() {
		// TODO Auto-generated method stub
		
	}

>>>>>>> branch 'master' of https://github.com/Francois35850/ProjetMaisonIDOM.git
}
