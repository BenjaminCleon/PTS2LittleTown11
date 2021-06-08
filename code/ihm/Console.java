package equipe_11.ihm;

import equipe_11.Controleur;

public class Console
{
	final String  ANSI_RED   = "\u001B[31m";
	final String  ANSI_BLUE   = "\u001B[34m";
	final String  ANSI_RESET = "\u001B[0m";


	Controleur ctrl;

	public Console( Controleur ctrl )
	{
		this.ctrl = ctrl;

		this.mettreIhmAJour();
		System.out.println(this.afficherMenuChoix());
	}


	public String getHeader()
	{
		String sRet = "";
		sRet += "================\n===LittleTown===\n================\n";

		return sRet;
	}

	public String afficherPlateau()
	{
		String sRet = "";
		String[][] tabPlateau = this.ctrl.getPlateau();

		int  cpt = 0;	

		sRet += "\t";

		for(int i = 'A'; i < tabPlateau[0].length + 'A'; i++)
		{
			 sRet += String.format("    %-7s", (char)i);
		}

		sRet += "\n";

		for(int i = 0; i < tabPlateau.length; i++)
		{
			sRet += ++cpt + "\t| ";
			for(int j = 0; j < tabPlateau[0].length; j++)
			{
				sRet += String.format("%-6.6s", tabPlateau[i][j]) + "  |  ";
			}

			sRet += "\n";
		}

		return sRet;
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

		System.out.println(this.getHeader());
		System.out.println(this.afficherPlateau());
	}
}