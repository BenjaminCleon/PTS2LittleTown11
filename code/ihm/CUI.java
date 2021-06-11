package equipe_11.ihm;

import equipe_11.Controleur;
import equipe_11.metier.*;

import java.util.ArrayList;

import iut.algo.CouleurConsole;
import iut.algo.Console;

public class CUI
{
	Controleur ctrl;

	public CUI( Controleur ctrl )
	{
		this.ctrl = ctrl;

		this.choixDebutPartie();
		this.mettreIhmAJour();
	}


	public String getHeader()
	{
		String sRet = "";
		sRet += "================\n===LittleTown===\n================\n";

		return sRet;
	}

	public void afficherPlateau()
	{
		Pion[][] tabPlateau = this.ctrl.getPlateau();

		int  cpt = 0;	

		Console.print("\t");

		for(int i = 'A'; i < tabPlateau[0].length + 'A'; i++)
		{
			Console.print(String.format("    %-7s", (char)i));
		}

		Console.println();

		for(int i = 0; i < tabPlateau.length; i++)
		{
			Console.print(++cpt + "\t|  ");
			for(int j = 0; j < tabPlateau[0].length; j++)
			{
				this.setCouleur(tabPlateau[i][j].getCoul());
				Console.print(String.format("%-6.6s", tabPlateau[i][j].toString()));
				Console.normal();
				Console.print("  |  ");
				/*Pion pTmp = tabPlateau[i][j];
				if ( pTmp.getNom().equals("OUVRIER") )this.setCouleur(pTmp.getCoul());

				Console.print(String.format("%-6.6s", pTmp	.toString()));
				Console.print((!pTmp.getNom ().equals("OUVRIER") &&
					           !pTmp.getCoul().equals("BLANC"))?"*":" ");
				Console.normal();
				Console.print("  |  ");*/
			}
			Console.println();

			Console.print("+-------+");
			for(int nbCol = 0; nbCol < 9; nbCol++)
			{
				Console.print("----------+");
			}
			Console.println();

		}

		Console.println();
	}

	public void setCouleur(String sCoul)
	{
		switch( sCoul.toUpperCase() )
		{
			case "ROUGE"  : { Console.couleurFont( CouleurConsole.ROUGE ); break; }
			case "VERT"   : { Console.couleurFont( CouleurConsole.VERT  ); break; }
			case "BLEU"   : { Console.couleurFont( CouleurConsole.BLEU  ); break; }
			case "JAUNE"  : { Console.couleurFont( CouleurConsole.JAUNE ); break; }
			default       : { Console.normal(); break; }
		}
	}

	public void choixDebutPartie()
	{
		int iNbJoueur;
		int iPlateau;
		String sTmp;
		String sNomJoueur;
		String sRet = "";

		do
		{
			Console.print("Combien de joueurs va participer ?");
		}while(!this.ctrl.setNbJoueur());

		Console.println();

		do
		{
			Console.print("Choisissez le numéro du plateau ?");
		}while(!this.ctrl.setNumPlateau());
	}

	public String afficherMenuChoix()
	{
		String sRet = "";

		sRet += "======================================\n";
		sRet += String.format("|%-36s|", "Manche : " + this.ctrl.getNumManche()) + "\n";
		sRet += "======================================\n";
		sRet += String.format("|%-36s|", "Espace joueur " + this.ctrl.getCouleurJoueur()) + "\n";
		sRet += String.format("|%-36s|", "Score : " + this.ctrl.getScoreJoueur()) + "\n";
		sRet += String.format("|%-36s|", "Piece : " + this.ctrl.getPieceJoueur()) + "\n";
		sRet += "======================================\n";
		sRet += String.format("|%-36s|", "1. Construire batiment") + "\n";
		sRet += String.format("|%-36s|", "2. Placer ouvrier")      + "\n";
		sRet += String.format("|%-36s|", "3. Liste des batiments") + "\n";
		sRet += String.format("|%-36s|", "4. Echanger trois pièces") + "\n";
		sRet += String.format("|%-36s|", "5. Quitter le jeu")      + "\n";
		sRet += "======================================\n";

		return sRet;
	}

	public String afficherMenuNourriture(Joueur j)
	{
		String sRet = "";

		sRet += "======================================\n";
		sRet += String.format("|%-36s|", "Espace nourriture " + j.getCouleur()) + "\n";
		sRet += "======================================\n";
		sRet += String.format("|%-36s|", "1. Choisir ressource") + "\n";
		sRet += String.format("|%-36s|", "2. Entrer valeur") + "\n";
		sRet += String.format("|%-36s|", "3. Valider") + "\n";
		sRet += "======================================\n";

		return sRet;
	}


	public void afficherMenuConstructionBatiment()
	{
		String sRet = "";

		sRet += "======================================\n";
		sRet += String.format("|%-36s|", "Espace Construction " + this.ctrl.getCouleurJoueur()) + "\n";
		sRet += this.afficherRessource();
		sRet += "======================================\n";
		sRet += String.format("|%-36s|", "1. Entrer les coordonnees") + "\n";
		sRet += String.format("|%-36s|", "2. Entrer le type du batiment") + "\n";
		sRet += String.format("|%-36s|", "3. Construire le batiment") + "\n";
		sRet += String.format("|%-36s|", "4. Quitter le menu de construction.") + "\n";
		sRet += "======================================\n";

		Console.println(sRet);
	}

	public void afficherMenuEchangePiece()
	{
		String sRet = "";

		sRet += "======================================\n";
		sRet += String.format("|%-36s|", "Espace changement de piece " + this.ctrl.getCouleurJoueur()) + "\n";
		sRet += "======================================\n";
		sRet += String.format("|%-36s|", "Veuillez entrer une ressource") + "\n";
		sRet += "======================================\n";

		Console.println(sRet);
	}

	public void afficherMenuSaisie(String sTypeSaisie)
	{

		String sRet = "";

		sRet += "======================================\n";
		sRet += String.format("|%-36s|", "Espace Saisie ") + "\n";
		sRet += "======================================\n";


		if(sTypeSaisie.equals("Coord"))
		{
			sRet += String.format("|%-36s|", "Veuillez entrer une coordonnée") + "\n";
		}

		if(sTypeSaisie.equals("Type"))
		{
			sRet += String.format("|%-36s|", "Veuillez entrer un type de batiment") + "\n";
		}

		if(sTypeSaisie.equals("TypeR"))
		{
			sRet += String.format("|%-36s|", "Veuillez entrer un type de ressource") + "\n";
		}

		if(sTypeSaisie.equals("Qte"))
		{
			sRet += String.format("|%-36s|", "Veuillez entrer une quantité") + "\n";
		}


		sRet += "======================================\n";

		Console.println(sRet);
	}
	
	public String afficherRessource()
	{
		String sRet = "";
		sRet += String.format("|%-36s|", "Bois : "   + this.ctrl.getRessourceJoueur("BOIS")) + "\n";
		sRet += String.format("|%-36s|", "Ble : "    + this.ctrl.getRessourceJoueur("BLE")) + "\n";
		sRet += String.format("|%-36s|", "Eau : "    + this.ctrl.getRessourceJoueur("EAU")) + "\n";
		sRet += String.format("|%-36s|", "Pierre : " + this.ctrl.getRessourceJoueur("PIERRE")) + "\n";
		sRet += String.format("|%-36s|", "Piece : "  + this.ctrl.getPieceJoueur()) + "\n";
		
		return sRet;
	}

	public void afficherMenuPlacementOuvrier()
	{
		String sRet = "";

		sRet += "======================================\n";
		sRet += String.format("|%-36s|", "Espace Ouvrier " + this.ctrl.getCouleurJoueur()) + "\n";
		sRet += this.afficherRessource();
		sRet += "======================================\n";
		sRet += String.format("|%-36s|", "1. Saisir coordonnées.") + "\n";
		sRet += String.format("|%-36s|", "2. Quitter."           ) + "\n";
		sRet += "======================================\n";

		Console.println(sRet);
	}

	public void afficherMenuActivation()
	{
		String sRet = "";

		sRet += "======================================\n";
		sRet += String.format("|%-36s|", "1. Afficher detail sur batiment." ) + "\n";
		sRet += String.format("|%-36s|", "2. Saisir coordonnées.") + "\n";
		sRet += String.format("|%-36s|", "3. Joueur suivant."    ) + "\n";
		sRet += "======================================\n";

		Console.println(sRet);
	}

	public void demanderBatiment(ArrayList<BatimentInfo> alBats)
	{
		String sRet = "";

		sRet += "======================================\n";
		sRet += String.format("|%-36s|", "Saisissez le numéro du batiment:" ) + "\n";
		for( BatimentInfo bTmp : alBats )sRet += String.format("|%-36s|",
		                                         String.format("%15s", bTmp.name())) + "\n";
		sRet += "======================================\n";
	

		Console.println(sRet);		
	}
	
	public void afficherInfo()
	{
		String sPrint = "";
		for( BatimentInfo b : ctrl.getLstBat() )
			sPrint += b + "\n";
		
		Console.println( sPrint );
	}

	public void mettreIhmAJour()
	{
		Console.effacerEcran();
		Console.println(this.getHeader());
		this.afficherPlateau();
	}
}
