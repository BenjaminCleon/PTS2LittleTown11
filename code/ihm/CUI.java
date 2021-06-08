package equipe_11.ihm;

import equipe_11.Controleur;
import equipe_11.metier.*;
import equipe_11.metier.utilitaire.Couleur;

import iut.algo.CouleurConsole;
import iut.algo.Console;

public class CUI
{
	Controleur ctrl;

	public CUI( Controleur ctrl )
	{
		this.ctrl = ctrl;

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


	public String afficherMenuChoix()
	{
		String sRet = "";

		sRet += "======================================\n";
		sRet += String.format("|%-36s|", "Espace joueur " + this.ctrl.getCouleurJoueur()) + "\n";
		sRet += String.format("|%-36s|", "Score : " + this.ctrl.getScoreJoueur()) + "\n";
		sRet += String.format("|%-36s|", "Piece : " + this.ctrl.getPieceJoueur()) + "\n";
		sRet += "======================================\n";
		sRet += String.format("|%-36s|", "1. Construire batiment") + "\n";
		sRet += String.format("|%-36s|", "2. Placer ouvrier") + "\n";
		sRet += String.format("|%-36s|", "3. Quitter le jeu") + "\n";
		sRet += "======================================\n";

		return sRet;
	}

	public String afficherMenuConstructionBatiment()
	{
		String sRet = "";

		sRet += "======================================\n";
		sRet += String.format("|%-36s|", "Espace Construction " + this.ctrl.getCouleurJoueur()) + "\n";
		sRet += String.format("|%-36s|", "Bois : " + this.ctrl.getRessourceJoueur("BOIS")) + "\n";
		sRet += String.format("|%-36s|", "Ble : " + this.ctrl.getRessourceJoueur("BLE")) + "\n";
		sRet += String.format("|%-36s|", "Eau : " + this.ctrl.getRessourceJoueur("EAU")) + "\n";
		sRet += String.format("|%-36s|", "Pierre : " + this.ctrl.getRessourceJoueur("PIERRE")) + "\n";
		sRet += "======================================\n";
		sRet += String.format("|%-36s|", "Veuillez entrer les coordonnées.") + "\n";
		sRet += String.format("|%-36s|", "Puis entrez le type du batiment.") + "\n";
		sRet += "======================================\n";

		return sRet;
	}

	public void mettreIhmAJour()
	{
		System.out.print("\033[H\033[2J");  
    	System.out.flush(); 

		Console.println(this.getHeader());
		this.afficherPlateau();
	}
}