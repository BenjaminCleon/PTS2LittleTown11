package equipe_11.ihm;

import equipe_11.Controleur  ;
import equipe_11.BatimentInfo;
import equipe_11.metier.Pion ;
import equipe_11.metier.Joueur ;

import java.util.ArrayList;

import javax.lang.model.util.ElementScanner14;

import iut.algo.CouleurConsole;
import iut.algo.Console;

/**
 * Cette class est l'IHM CUI, elle gère l'affichage
 * 
 * @author Equipe 11
 */
 
public class CUI
{
	/**
	 * Controleur de l'application
	 */
	Controleur ctrl;

	/**
	 * Constructeur de CUI
	 *
	 * @param ctrl
	 *		Controleur
	 */
	public CUI( Controleur ctrl )
	{
		this.ctrl = ctrl;
	}

	/**
	 * Affiche les choix de l'initialisation du plateau
	 */
	public void initCUI()
	{
		Console.effacerEcran ();
		this.choixDebutPartie();
	}

	/**
	 * Retourne l'entête du jeu
	 *
	 * @return
	 *		l'entête du jeu
	 */
	public String getHeader()
	{
		String sRet = "";
		sRet += "================\n===LittleTown===\n================\n";

		return sRet;
	}
	/**
	 * Affiche le Plateau
	 */
	public void afficherPlateau()
	{
		Pion[][] tabPlateau      = this.ctrl.getPlateau();
		BatimentInfo[] tabPioche = this.ctrl.getLstBat().toArray(new BatimentInfo[this.ctrl.getLstBat().size()]);

		int  cpt       = 0;
		int  cptPioche = 0;

		Console.print("\n+---+");
		for(int nbCol = 0; nbCol < 9; nbCol++)
				Console.print("-----------+");
			
		Console.print("----------------------+");

		Console.print("\n|   |");
		for(int i = 'A'; i < tabPlateau[0].length + 'A'; i++)
			Console.print("     " + (char)i + "     |");
		
		if ( tabPioche.length > 0)
			Console.print(String.format("  %-18.18s  |", String.format("%2d", cptPioche+1) +
			                                                           ". " + tabPioche[cptPioche++]));
		else
			Console.print(String.format("  %-18.18s  |", ""));

		Console.print("\n+---+");
		for(int nbCol = 0; nbCol < 9; nbCol++)
				Console.print("-----------+");

		if ( tabPioche.length > 1)
			Console.println(String.format("  %-18.18s  |", String.format("%2d", cptPioche+1) +
			                                                             ". " + tabPioche[cptPioche++]));
		else
			Console.println(String.format("  %-18.18s  |", ""));

		for(int i = 0; i < tabPlateau.length; i++)
		{
			Console.print("| " + ++cpt + " |  ");
			for(int j = 0; j < tabPlateau[0].length; j++)
			{
				Pion pTmp = tabPlateau[i][j];
				if ( pTmp.getNom().equals("OUVRIER") )this.setCouleur(pTmp.getCoul());

				Console.print(String.format("%-7.7s", pTmp	.toString()));
				this.setCouleur(tabPlateau[i][j].getCoul());
				Console.print((!pTmp.getNom ().equals("OUVRIER") &&
					           !pTmp.getCoul().equals("BLANC"))?"*":" ");
				Console.normal();
				Console.print(j==tabPlateau[0].length-1?" |":" |  ");
			}

			if ( cptPioche < tabPioche.length )
				Console.print(String.format("  %-18.18s  |", String.format("%2d", cptPioche+1)
				              + ". " + tabPioche[cptPioche++] + ((cptPioche==tabPioche.length &&
							  this.ctrl.getNbChampsDeble() > 0)?" x" + this.ctrl.getNbChampsDeble():"")));
			else
			     	Console.print(String.format("  %-18s  |", ""));

			Console.println();
			
			Console.print("+---+");
			for(int nbCol = 0; nbCol < 9; nbCol++)
				Console.print("-----------+");

			if ( cptPioche < tabPioche.length )
				Console.print(String.format("  %-18s  |", String.format("%2d", cptPioche+1) + ". " +
				              tabPioche[cptPioche++] + ((cptPioche==tabPioche.length  &&
							  this.ctrl.getNbChampsDeble() > 0)?" x" + this.ctrl.getNbChampsDeble():"")));

			else if ( i < tabPlateau.length - 1)
					Console.print(String.format("  %-18s  |", ""));
		
			if ( i < tabPlateau.length - 1 )Console.println();
		}
		Console.println("----------------------+");
	}
	/**
	 * Affiche les information sur le déroulement du tour et sur le stock
	 */
	public void plateauBas(String sMess)
	{
		String sRet = "";
		Console.print("+-----------+-------------+--------------------+----------------------+" +
		              "----------+------------+---------+-------------+----------------+\n"                     +
		                 "|Manche : " + this.ctrl.getNumManche() + " |Joueur "                   );
		this.setCouleur(this.ctrl.getCouleurJoueur());
		Console.print(String.format("%-6s", "" + this.ctrl.getCouleurJoueur().toUpperCase()));
		Console.normal();
		Console.println("|Ouvrier restants: "    + this.ctrl.getNbOuvrierRestantCourant ()
		                + " " +
		                "|Batiments restants: " + this.ctrl.getNbBatimentRestantCourant()
						+ " |Bois : "   + String.format("%2d", this.ctrl.getQteRessourceStock("BOIS")) 
						+ " |Pierre : " + String.format("%2d", this.ctrl.getQteRessourceStock("PIERRE"))
						+ " |Blé : "    + String.format("%2d", this.ctrl.getQteRessourceStock("BLE"))
						+ " |Poisson : "+ String.format("%2d", this.ctrl.getQteRessourceStock("POISSON"))
						+ String.format("%-18s|"," |Piece : "  + 
						                String.format("%2d", this.ctrl.getQteRessourceStock("PIECE"))));
		Console.println("+-----------+-------------+--------------------+----------------------+" +
		                "----------+------------+---------+-------------+----------------+\n"     );
		if ( !sMess.equals("") )
			Console.println("+==========================================================+\n"+
				            String.format("|%-58.58s|", sMess) + "\n"    +
			                "+==========================================================+\n" );

		Console.println(this.getRessourceAllJoueur());
	}

	/**
	 * Retourne les toString de chaque joueur en une seule String
	 */
	public String getRessourceAllJoueur()
	{
		String sRet = "";
		String[] sRetSplit;
		int    iNbJoueur = this.ctrl.getNbJoueur();

		sRet = this.ctrl.getRessourceAllJoueur();

		sRetSplit = sRet.split("\n");

		sRet = "";
		for (int i=0;i<9; i++)
		{
			sRet += sRetSplit[i  ];
			sRet += sRetSplit[i+9];
			if ( iNbJoueur >= 3 )sRet += sRetSplit[i+9*2];
			if ( iNbJoueur == 4 )sRet += sRetSplit[i+9*3];

			if ( i != 0 && i != 8 )sRet += "|";
			if ( i == 0 || i == 8 )sRet += "+";
			sRet += "\n";
		}
		
		return sRet;
	}
	/**
	 * change la couleur en fonction du joueur
	 * 
	 * @param sCoul
	 * 		Couleur souhaitée
	 */
	public void setCouleur(String sCoul)
	{
		switch( sCoul.toUpperCase() )
		{
			case "ROUGE"  -> Console.couleurFont( CouleurConsole.ROUGE );
			case "VERT"   -> Console.couleurFont( CouleurConsole.VERT  );
			case "BLEU"   -> Console.couleurFont( CouleurConsole.CYAN );
			case "JAUNE"  -> Console.couleurFont( CouleurConsole.JAUNE );
			default       -> Console.normal();
		}
	}
	/**
	 * Affichage de saisi des informations du début de partie
	 */
	public void choixDebutPartie()
	{
		int iNbJoueur;
		int iPlateau;
		String sTmp;
		String sNomJoueur;
		String sRet = "";

		do
		{
			Console.print("Combien de joueurs vont participer ?");
		}while(!this.ctrl.setNbJoueur());

		for (int i=0;i<this.ctrl.getNbJoueur();i++)
		{
			Console.print("Nom du joueur "+ (i+1) +" : ");
			this.ctrl.setNomJoueur(i);
		}

		Console.println();

		do
		{
			Console.print("Choisissez le numéro du plateau ?");
		}while(!this.ctrl.setNumPlateau());
	}
	/**
	 * Affichage pour demmander au joueur son nom
	 */
	public void demanderNom(int iVal)
	{
		Console.println("Nom du joueur n°" + iVal);
	}
	/**
	 * Affichage du menu des différents choix en début de tour
	 */
	public void afficherMenuChoix()
	{
		String sRet = "";

		sRet += "+=====================================+\n";
		sRet += String.format("|%-37s|", "1. Construire batiment") + "\n";
		sRet += String.format("|%-37s|", "2. Placer ouvrier")      + "\n";
		sRet += String.format("|%-37s|", "3. Echanger trois pièces") + "\n";
		sRet += String.format("|%-37s|", "4. Quitter le jeu")      + "\n";
		sRet += "+=====================================+\n";

		Console.println(sRet);
	}
	/**
	 * Affichage pour nourrir les ouvriers
	 */
	public void afficherMenuNourriture(String sCoul)
	{
		String sRet = "";

		sRet += "=======================================\n";
		sRet += String.format("|%-37s|", "Espace nourriture " + sCoul) + "\n";
		sRet += "=======================================\n";
		sRet += String.format("|%-37s|", "   Quantite à 0 par défaut"  ) + "\n";
		sRet += String.format("|%-37s|", "1. Quantite de poisson"  ) + "\n";
		sRet += String.format("|%-37s|", "2. Quantite de blé"  ) + "\n";
		sRet += String.format("|%-37s|", "3. Quantité de pièce") + "\n";
		sRet += String.format("|%-37s|", "4. Valider") + "\n";
		sRet += "=======================================\n";

		Console.println(sRet);
	}
	/**
	 * Affichage pour saisir la quantité de nourriture à donner
	 */
	public void afficherDemandePourNourriture(String sType)
	{
		Console.println("=======================================\n" +
		                String.format("|%-37s|", "Saisir quantité de " + sType) + "\n" +
		                "=======================================\n");
	}
	/**
	 * Affichage pour saisir les différentes informations à saisir lors de la construction d'un
	 * batiment
	 */
	public void afficherMenuConstructionBatiment()
	{
		String sRet = "";

		sRet += "=======================================\n";
		sRet += String.format("|%-37s|", "Espace Construction " + this.ctrl.getCouleurJoueur()) + "\n";
		sRet += "=======================================\n";
		sRet += String.format("|%-37s|", "1. Entrer les coordonnees") + "\n";
		sRet += String.format("|%-37s|", "2. Entrer le numéro du batiment") + "\n";
		sRet += String.format("|%-37s|", "3. Information sur batiment") + "\n";
		sRet += String.format("|%-37s|", "4. Construire le batiment") + "\n";
		sRet += String.format("|%-37s|", "5. Quitter le menu de construction.") + "\n";
		sRet += "=======================================\n";

		Console.println(sRet);
	}
	/**
	 * Affichage pour saisir la ressource à échanger
	 */
	public void afficherMenuEchangePiece()
	{
		String sRet = "";

		sRet += "=======================================\n";
		sRet += String.format("|%-37s|", "Espace changement de piece " + this.ctrl.getCouleurJoueur()) + "\n";
		sRet += "=======================================\n";
		sRet += String.format("|%-37s|", "Veuillez entrer une ressource") + "\n";
		sRet += "=======================================\n";

		Console.println(sRet);
	}

	/**
	 * Affichage de saisi en fonction de l'action souhaité
	 */
	public void afficherMenuSaisie(String sTypeSaisie)
	{

		String sRet = "";

		sRet += "=======================================\n";
		sRet += String.format("|%-37s|", "Espace Saisie ") + "\n";
		sRet += "=======================================\n";


		if(sTypeSaisie.equals("Coord"))
			sRet += String.format("|%-37s|", "Veuillez entrer une coordonnée") + "\n";

		if(sTypeSaisie.equals("Type"))
			sRet += String.format("|%-37s|", "Veuillez entrer un numéro de batiment") + "\n";

		if(sTypeSaisie.equals("TypeR"))
			sRet += String.format("|%-37s|", "Veuillez entrer un type de ressource") + "\n";

		if(sTypeSaisie.equals("Qte"))
			sRet += String.format("|%-37s|", "Veuillez entrer une quantité") + "\n";

		if (sTypeSaisie.equals("Donner"))
			sRet += String.format("|%-37s|", "Ressources à donner : ") + "\n";

		if (sTypeSaisie.equals("Obtenir"))
			sRet += String.format("|%-37s|", "Ressources à obtenir : ") + "\n"; 

		sRet += "=======================================\n";

		Console.println(sRet);
	}

	/**
	 * Retourne l'affichage de saisie de coordonnées
	 *
	 * @return 
	 *		l'affichage de saisie de coordonnées
	 */
	public String afficherCoord()
	{
		return String.format("|%-37s|", "Veuillez entrer une coordonnée") + "\n";
	}
	/**
	 * Affichage de saisi pour le placement des ouvriers
	 */
	public void afficherMenuPlacementOuvrier()
	{
		String sRet = "";

		sRet += "=======================================\n";
		sRet += String.format("|%-37s|", "Espace Ouvrier " + this.ctrl.getCouleurJoueur()) + "\n";
		sRet += "=======================================\n";
		sRet += String.format("|%-37s|", "1. Saisir coordonnées.") + "\n";
		sRet += String.format("|%-37s|", "2. Quitter."           ) + "\n";
		sRet += "=======================================\n";

		Console.println(sRet);
	}
	/**
	 * Affichage de saisi pour l'activation des divers batiments
	 */
	public void afficherMenuActivation(){ this.afficherMenuActivation(false);}

	public void afficherMenuActivation(boolean bOk)
	{
		String sRet = "";
		if (bOk)
		{
			sRet += "=======================================\n";
			sRet += String.format("|%-37s|", "Espace Residence") + "\n";
		}
		sRet += "=======================================\n";
		sRet += String.format("|%-37s|", "1. Afficher detail sur batiment." ) + "\n";
		sRet += String.format("|%-37s|", "2. Saisir coordonnées.") + "\n";
		if ( !bOk ) sRet += String.format("|%-37s|", "3. Joueur suivant."    ) + "\n";
		else        sRet += String.format("|%-37s|", "3. Quitter")             + "\n";
		sRet += "=======================================\n";

		Console.println(sRet);
	}
	/**
	 * Affichage pour demande le numéro du batiment
	 */
	public void demanderBatiment()
	{
		String sRet = "";

		sRet += "=======================================\n";
		sRet += String.format("|%-37s|", "Saisissez le numéro du batiment:" ) + "\n";
		sRet += "=======================================\n";
	

		Console.println(sRet);		
	}
	
	/**
	 * Affiche toute les informations sur l'activation des batiments
	 *
	 * @param b
	 *		BatimentInfo
	 */
	public void afficherInfoActivation(BatimentInfo b)
	{
		if ( b != null )Console.println( b.toStringInfoActivation() );
	}

	/**
	 * Affiche toute les informations sur la construction des batiments
	 *
	 * @param b
	 *		BatimentInfo
	 */
	public void afficherInfoConstruction(BatimentInfo b)
	{
		if ( b != null )Console.println(b.toStringInfoConstruction() );
	}
	/**
	 *Met à jour l'IHM		
	 */
	public void mettreIhmAJour(){ this.mettreIhmAJour(""); }
	/**
	 *Met à jour l'IHM
	 */
	public void mettreIhmAJour(String sMess)
	{
		Console.effacerEcran();
		Console.println(this.getHeader());
		this.afficherPlateau();
		this.plateauBas(sMess);
	}
	/**
	 *Affiche la demande d'information pour preteur sur gage
	 */
	public void afficherPreteurSurGage()
	{
		Console.println( "+==========================================+\n" +
			             "|Preteur sur Gage :                        |\n" +
		                 "+==========================================+\n" +
		                 "|Quelles ressources souhaitez vous echanger|\n" +
						 "|Au format(ressource1 ressource2)          |\n" +
						 "|Exemple : \"BOIS BLE\"                      |\n" +  
		                 "+==========================================+");
	}
	/**
	 *Affichage des différents objectifs
	 */
	public void afficherObj()
    {
		Console.println("+===========================================================================================================+==========+");
		for ( int i=0; i<this.ctrl.getNbCartesObjectif(); i++)
        	Console.println( ctrl.getObj(i) );
		Console.println("+===========================================================================================================+==========+");
	}
	
	/**
	 *Affichage de fin de partie avec le classement des joueurs
	 */
	public void afficherFinDePartie()
	{
		String[][] sDataJoueurs = this.ctrl.getClassemenentJoueur();

		String mess = "+==========================================+\n" +
			          "|Classement :                              |\n" +
		              "+==========================================+\n";
		
		for ( int i=0; i<sDataJoueurs.length; i++)
				mess += "|" + String.format("%-6s", sDataJoueurs[i][0] ) + " : " + String.format( "%-33.33s", sDataJoueurs[i][1] ) + "|\n"; 
		
		mess += "+==========================================+";
		
		Console.println( mess );
	}

}
