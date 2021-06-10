package equipe_11.ihm;

import equipe_11.Controleur;
import equipe_11.metier.*;

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
	 	Console.println(this.afficherMenuChoix());
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
			Console.print(++cpt + "\t| ");
			for(int j = 0; j < tabPlateau[0].length; j++)
			{
				this.setCouleur(tabPlateau[i][j].getCoul());
				Console.print(String.format("%-6.6s", tabPlateau[i][j].toString()));
				Console.normal();
				Console.print("  |  ");
			}
			Console.println();
		}

		Console.println();
	}

	public void setCouleur(String sCoul)
	{
		switch( sCoul.toUpperCase() )
		{
			case "ROUGE"  -> Console.couleurFont( CouleurConsole.ROUGE );
			case "VERT"   -> Console.couleurFont( CouleurConsole.VERT  );
			case "BLEU"   -> Console.couleurFont( CouleurConsole.BLEU  );
			case "JAUNE"  -> Console.couleurFont( CouleurConsole.JAUNE );
			default       -> Console.normal();
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

	public String afficherMenuNourriture()
	{
		String sRet = "";

		sRet += "======================================\n";
		sRet += String.format("|%-36s|", "Espace nourriture " + this.ctrl.getCouleurJoueur()) + "\n";
		sRet += "======================================\n";
		sRet += String.format("|%-36s|", "1. Choisir ressource") + "\n";
		sRet += String.format("|%-36s|", "2. Entrer valeur") + "\n";
		sRet += String.format("|%-36s|", "3. Valider") + "\n";
		sRet += "======================================\n";

		return sRet;
	}


	public String afficherMenuConstructionBatiment()
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

		return sRet;
	}

	public String afficherMenuEchangePiece()
	{
		String sRet = "";

		sRet += "======================================\n";
		sRet += String.format("|%-36s|", "Espace changement de piece " + this.ctrl.getCouleurJoueur()) + "\n";
		sRet += "======================================\n";
		sRet += String.format("|%-36s|", "Veuillez entrer une ressource") + "\n";
		sRet += "======================================\n";

		return sRet;
	}

	public String afficherMenuSaisie(String sTypeSaisie)
	{

		String sRet = "";

		if(sTypeSaisie.equals("Coord"))
		{
			sRet += "======================================\n";
			sRet += String.format("|%-36s|", "Espace Saisie ") + "\n";
			sRet += "======================================\n";
			sRet += String.format("|%-36s|", "Veuillez entrer une coordonnée") + "\n";
			sRet += "======================================\n";
		}

		if(sTypeSaisie.equals("Type"))
		{
			sRet += "======================================\n";
			sRet += String.format("|%-36s|", "Espace Saisie ") + "\n";
			sRet += "======================================\n";
			sRet += String.format("|%-36s|", "Veuillez entrer un type de batiment") + "\n";
			sRet += "======================================\n";
		}

		return sRet;
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

	public String afficherMenuPlacementOuvrier()
	{
		String sRet = "";

		sRet += "======================================\n";
		sRet += String.format("|%-36s|", "Espace Ouvrier " + this.ctrl.getCouleurJoueur()) + "\n";
		sRet += this.afficherRessource();
		sRet += "======================================\n";
		sRet += String.format("|%-36s|", "Veuillez entrer les coordonnées.") + "\n";
		sRet += "======================================\n";

		return sRet;
	}
	
	public void afficherInfo()
	{
		String sPrint = "";
		for( BatimentInfo b : ctrl.getLstNomBat() )
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
