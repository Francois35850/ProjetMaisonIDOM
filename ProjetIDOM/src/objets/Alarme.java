package objets;

public final class Alarme {

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
		     "|              |      /                         \\      |              |"+Newligne+
		     "|              |     /                           \\     |              |"+Newligne+
		     "|              |    /                             \\    |              |"+Newligne+
		     "|	 		     |   /							     \\   |			     |"+Newligne+
		     "|              |  /                                 \\  |              |"+Newligne+
		     "|              | /                                   \\ |              |"+Newligne+
		     "|______________|/        							    \\|______________|"+Newligne+
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
	private String vue_cam_devantMaison="Systeme defaillant, veuillez contacter le service maintenance !";
	
;
	public Alarme(int code_digicode, int detecteur_incendie_rdc, int detecteur_incendie_r1, int detecteur_mouvement_couloirrdc,int detecteur_mouvement_couloirr1, int detecteur_mouvement_salon, int detecteur_mouvement_garage, int detecteur_ouverture_porte, int detecteur_ouverture_bureau, int detecteur_ouverture_salon, int detecteur_ouverture_ch1,  int detecteur_ouverture_ch2, int detecteur_ouverture_chp, int detecteur_ouverture_sallejeux, int detecteur_ouverture_auditorium,  int detecteur_ouverture_cuisine, int detecteur_ouverture_sallemanger, String vue_cam_couloir, String vue_cam_jardin, String vue_cam3) {	
	
	this.code_digicode=code_digicode;
	
	this.detecteur_incendie_rdc=detecteur_incendie_rdc;
	this.detecteur_incendie_r1=detecteur_incendie_r1;
	
	this.detecteur_mouvement_couloirrdc=detecteur_mouvement_couloirrdc;
	this.detecteur_mouvement_couloirr1=detecteur_mouvement_couloirr1;
	this.detecteur_mouvement_salon=detecteur_mouvement_salon;
	this.detecteur_mouvement_garage=detecteur_mouvement_garage;
	
	this.detecteur_ouverture_porte=detecteur_ouverture_porte;
	this.detecteur_ouverture_bureau=detecteur_ouverture_bureau;
	this.detecteur_ouverture_salon=detecteur_ouverture_salon;
	this.detecteur_ouverture_ch1=detecteur_ouverture_ch1;
	this.detecteur_ouverture_ch2=detecteur_ouverture_ch2;
	this.detecteur_ouverture_chp=detecteur_ouverture_chp;
	this.detecteur_ouverture_sallejeux=detecteur_ouverture_sallejeux;
	this.detecteur_ouverture_auditorium=detecteur_ouverture_auditorium;
	this.detecteur_ouverture_cuisine=detecteur_ouverture_cuisine;
	this.detecteur_ouverture_sallemanger=detecteur_ouverture_sallemanger;
	
	this.vue_cam_couloir=vue_cam_couloir;
	this.vue_cam_jardin=vue_cam_jardin;
	this.vue_cam3=vue_cam_devantMaison;
	}
	
	public static Alarme newAlarme () {
		Alarme alarm = new Alarme(2020,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,vue_cam_couloir,vue_cam_couloir,vue_cam3);
		return alarm;
	}
	
	//fonction qui retourne le code de l'alarme
	public static int getCodeDigicode(Alarme alarm)	{return this.code_digicode;}
	
	
	//fonction qui retourne l'état du détecteur incendie du rdc: 1 quand détection de fumée
	public static int getEtat_DI_rdc(Alarme alarm) {return this.detecteur_incendie_rdc;}

	//fonction qui retourne l'état du détecteur incendie du r+1: 1 quand détection de fumée
	public static int getEtat_DI_r1(Alarme alarm) {return this.detecteur_incendie_r1;}
	
	
	//fonction qui retourne l'état du détecteur de mouvement du couloir au rdc: 1 quand détection infrarouge
	public static int getEtat_DM_couloirRdc(Alarme alarm) {return this.detecteur_mouvement_rdc;}
	
	//fonction qui retourne l'état du détecteur de mouvement du couloir au r+1: 1 quand détection infrarouge
	public static int getEtat_DM_couloirR1(Alarme alarm) {return this.detecteur_mouvement_r1;}
			
	//fonction qui retourne l'état du détecteur de mouvement du salon: 1 quand détection infrarouge
	public static int getEtat_DM_salon(Alarme alarm) {return this.detecteur_mouvement_salon;}
	
	//fonction qui retourne l'état du détecteur de mouvement du garage: 1 quand détection infrarouge
	public static int getEtat_DM_garage(Alarme alarm) {return this.detecteur_mouvement_garage;}
	
	
	//fonction qui retourne l'état du détecteur d'ouverture du garage: 1 quand la fenetre est ouverte
	public static int getEtat_DO_porte(Alarme alarm) {return this.detecteur_ouverture_porte;}
	
	//fonction qui retourne l'état du détecteur d'ouverture du bureau: 1 quand la fenetre est ouverte
	public static int getEtat_DO_bureau(Alarme alarm) {return this.detecteur_ouverture_bureau;}
	
	//fonction qui retourne l'état du détecteur d'ouverture du salon: 1 quand la fenetre est ouverte
	public static int getEtat_DO_salon(Alarme alarm) {return this.detecteur_ouverture_salon;}
	
	//fonction qui retourne l'état du détecteur d'ouverture de la chambre 1: 1 quand la fenetre est ouverte
	public static int getEtat_DO_ch1(Alarme alarm) {return this.detecteur_ouverture_ch1;}
	
	//fonction qui retourne l'état du détecteur d'ouverture de la chambre 2: 1 quand la fenetre est ouverte
	public static int getEtat_DO_ch2(Alarme alarm) {return this.detecteur_ouverture_ch2;}
	
	//fonction qui retourne l'état du détecteur d'ouverture de la chambre parentale: 1 quand la fenetre est ouverte
	public static int getEtat_DO_chp(Alarme alarm) {return this.detecteur_ouverture_chp;}
	
	//fonction qui retourne l'état du détecteur d'ouverture de la salle de jeux: 1 quand la fenetre est ouverte
	public static int getEtat_DO_sallejeux(Alarme alarm) {return this.detecteur_ouverture_sallejeux;}
	
	//fonction qui retourne l'état du détecteur d'ouverture de l'auditorium: 1 quand la fenetre est ouverte
	public static int getEtat_DO_auditorium(Alarme alarm) {return this.detecteur_ouverture_auditorium;}
	
	//fonction qui retourne l'état du détecteur d'ouverture de la cuisine: 1 quand la fenetre est ouverte
	public static int getEtat_DO_cuisine(Alarme alarm) {return this.detecteur_ouverture_cuisine;}
	
	//fonction qui retourne l'état du détecteur d'ouverture de la salle a manger: 1 quand la fenetre est ouverte
	public static int getEtat_DO_sallemanger(Alarme alarm) {return this.detecteur_ouverture_sallemanger;}
	
	
	//fonction qui retourne la vue de la caméra du couloir au rdc
	public static String getCam_couloir(Alarme alarm) {return this.vue_cam_couloir;}
	
	//fonction qui retourne la vue de la caméra du jardin
	public static String getCam_jardin(Alarme alarm) {return this.vue_cam_jardin;}
	
	//fonction qui retourne la vue de la caméra de l'avant de la maison (purement scénaristique)
	public static String getCam_devantMaison(Alarme alarm) {return this.vue_cam_devantMaison;}
	
	//fonction utilitaire qui retourne le dialogue pour le détecteur incendie
	public static String affichageDI(int valeur) {
		String res="";
		if(valeur==1) {res+=" incendie en cours"}
		else {res+=" pas de fumée dans la piece"}
		return res;
	}
	
	//fonction utilitaire qui retourne le dialogue pour le détecteur de mouvement
	public static String affichageDM(int valeur) {
		String res="";
		if(valeur==1) {res+=" une personne est présente dans la piece"}
		else {res+=" personne dans la piece"}
		return res;
	}
	
	//fonction utilitaire qui retourne le dialogue pour le détecteur d'ouverture
	public static String affichageDO(int valeur) {
		String res="";
		if(valeur==1) {res+=" la fenetre est ouverte"}
		else {res+=" la fenetre est fermée"}
		return res;
	}
	
	
	//fonction qui retourne létat global de l'alarme de la maison
	public static void getEtat_global(Alarme alarm) {	
	System.out.println("Etat des détecteurs incendie :")
	System.out.println(" - Détecteur rdc :" + affichageDI(this.detecteur_incendie_rdc) + "."); 
	System.out.println(" - Détecteur r+1 :" + affichageDI(this.detecteur_incendie_r1) + "."); 
	
	System.out.println("Etat des détecteurs de mouvement : ")
	System.out.println(" - Détecteur couloir rdc :") + affichageDM(this.detecteur_mouvement_rdc) + ".");
	System.out.println(" - Détecteur couloir r+1 :") + affichageDM(this.detecteur_mouvement_r1) + ".");
	System.out.println(" - Détecteur salon :") + affichageDM(this.detecteur_mouvement_salon) + ".");
	System.out.println(" - Détecteur garage :") + affichageDM(this.detecteur_mouvement_garage) + ".");
			
	System.out.println("Etat des détecteurs d'ouverture :")
	System.out.println(" - Détecteur porte :") + affichageDO(this.detecteur_ouverture_porte) + ".");
	System.out.println(" - Détecteur bureau :") + affichageDO(this.detecteur_ouverture_bureau) + ".");
	System.out.println(" - Détecteur salon :") + affichageDO(this.detecteur_ouverture_salon) + ".");
	System.out.println(" - Détecteur chambre 1 :") + affichageDO(this.detecteur_ouverture_ch1) + ".");
	System.out.println(" - Détecteur chambre 2 :") + affichageDO(this.detecteur_ouverture_ch2) + ".");
	System.out.println(" - Détecteur chambre parentale :") + affichageDO(this.detecteur_ouverture_chp) + ".");
	System.out.println(" - Détecteur salle de jeux :") + affichageDO(this.detecteur_ouverture_sallejeux) + ".");
	System.out.println(" - Détecteur auditorium :") + affichageDO(this.detecteur_ouverture_auditorium) + ".");
	System.out.println(" - Détecteur cuisine :") + affichageDO(this.detecteur_ouverture_cuisine) + ".");
	System.out.println(" - Détecteur salle � manger :") + affichageDO(this.detecteur_ouverture_sallemanger) + ".");
	
	System.out.println("Etat de la connexion avec les caméra :")
	System.out.println(" - Caméra couloir rdc : on.")
	System.out.println(" - Caméra jardin : on.")
	System.out.println(" - Caméra devant maison : off.")
	
	System.out.println("Code d'activation :" + getCodeDigicode(Alarme alarm) + ".");
		}
			
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

