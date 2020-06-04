# ProjetMaisonIDOM
Objectif :
L’objectif de ce projet est de créer une application qui a pour but de modéliser une maison avec ses équipements. Le projet a donc été de créer un jeu de type escape game en textuel. L’objectif du joueur est de sortir de sa maison dans un temps imparti en ayant réussi tous les objectifs qui lui ont été donnés.

Fonctionnalités :
Pour réussir la mission qui est de sortir de la maison avant une certaine heure et en ayant accompli les différents objectifs, le joueur a accès à un certain nombre de possibilité en jeu.
	Il a possibilité de se balader dans la maison (en utilisant la commande aller [nom de la pièce]) à condition que la pièce qu’il cible soit bien adjacente à celle dans laquelle il se trouve (une porte en commun).
	Il a la possibilité d’utiliser son téléphone (avec la commande telephone). Cette action va lui permettre de gérer plusieurs choses : 
		messages : qui va lui permettre de regarder ses messages
		carte : qui va lui permettre de regarder le plan de la maison
		musique : qui va lui permettre de mettre de la musique dans une pièce où il y une enceinte
		homekit : qui va lui permettre d'interagir avec la domotique de sa maison (lumières, volets, piscine, caméra)
		quitter : qui va lui permettre de ranger son téléphone
	Il a la possibilité d’utiliser des objets présents dans la pièce (avec la commande utiliser [nom de l’objet]) puis chaque objet à 			ses fonctionnalités propres.
	Il a la possibilité de ramasser certains objets dans les pièces (avec la commande prendre [nom de l’objet]) à condition que ce soit 		un objet ramassable, et que la pièce soit assez éclairée (volet ouvert ou lumière allumée).
	Il a la possibilité de regarder ce qu’il possède dans son inventaire (avec la commande inventaire), il verra alors une liste 				d’objets qu’il a ramassé au préalable.
	Il a la possibilité d’avoir les infos sur la pièce où il se trouve (avec la commande infos). Il aura alors accès aux objets présents 		dans cette pièce, l’état de ces objets ainsi que les différentes pièces dans lesquelles il peut se rendre.
	Il a la possibilité de voir l’heure (avec la commande heure) pour savoir où il en est dans sa journée et s’il n’est pas en retard 			sur ses objectifs.
	Il a la possibilité de sortir de la maison (avec la commande sortir) qui n’est utilisable que dans l’entrée et une fois que tous les 		objectifs sont réussis.
	Il a la possibilité de voir tous les objectifs (avec la commande objectifs) ce qui lui indiquera les objectifs réussis, ceux en 			cours et les détails des objectifs longs.
	Il a la possibilité de quitter le jeu (avec la commande quitter) qui lui permet de stopper le jeu à n’importe quel moment (abandon).


Organisation du code :
Le code est organisé en 3 packages : 

main qui comprend l’organisation du projet :
	classe Main : boucle principale du jeu qui va demander à chaque tour ce que souhaite faire le joueur + initialisation de 					l'environnement (déclaration de toutes les pièces et tous les objets (ramassables ou non)).
	classe Objets : classe abstraite représentant tous les objets qui se divise en deux après : classes ObjetRamassable et 						ObjetNonRamassable qui définissent deux types d’objets différents qui devaient distingués. Les objets ramassables peuvent comme 		leur nom l’indique être ramassés et ne possèdent pas d’état. Ils peuvent être utilisés sous certaines conditions. Les objets non 		 ramassables eux peuvent aussi être utilisés, mais pas ramassés. Ils possèdent un état en fonction de comment on les a utilisés.
	classe Piece : classe définissant les pièces de la maison avec un nom, la liste des objets qu’elle contient, la liste de ses pièces 		adjacentes ainsi qu’une information permettant de savoir si elle est au RDC.
	classe Telephone : classe qui définit le téléphone du joueur et que va grâce à sa fonction utiliserTelephone() demander en boucle à 		l’utilisateur ce qu’il veut faire.
	classe Objectifs : classe qui va définir tous les objectifs du jeu avec l’aide de la classe Objectif qui définit un objectif avec un 		 nom, les détails d’un objectif et un boolean permettant de savoir si ce dernier est réussi.
	classe Joueur : la classe qui va définir le joueur avec sa pièce courante (ce qui va permettre le déplacement grâce à la fonction 			changerPiece), son inventaire qui est une liste d’objets ramassables (possibilité d’ajouter ou retirer des objets de cet 				inventaire) et son état vestimentaire (un entier entre 1 et 3 compris qui définit comment le joueur est habillé.

objets qui contient les classes de tous les objets non ramassables. Chacune de ces classes va contenir un constructeur qui va permettre de créer un objet dans le main, une fonction etat qui va permettre d’afficher l’état de l’objet quand la personne change de pièce ou utilise la commande infos. Chaque classe contient aussi sa fonction principale utiliserObjet() qui va permettre à l’utilisateur d’interagir avec cet objet. Un boucle demande alors au joueur de choisir ce qu’il veut faire avec cet objet ce qui va donc l’aider à avancer dans ses objectifs, changer l’état de l’objet ou encore lui permettre d’utiliser d’autres objets.

objetsRamassables qui contient les classes de tous les objets ramassables. Dans ces classes on retrouve un constructeur, ainsi qu’une fonction utiliserObjet() qui va permettre à l’utilisateur d’utiliser l’objet même si ce dernier n’est pas forcément utilisable soit parce qu’il ne respecte pas les conditions d’utilisation (ex : impossible de jeter les animaux gonflables dans la piscine si cette dernière n’est pas ouverte) soit parce que cet objet ne peut pas s’utiliser (certains objets sont inutiles pour ‘embrouiller’ le joueur et lui faire perdre du temps).
