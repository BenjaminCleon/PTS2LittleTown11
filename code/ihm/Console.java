package littletown.ihm;

import littletown.Controleur;

public class Console
{
	Controleur ctrl;

	public Console( Controleur ctrl )
	{
		this.ctrl = ctrl;

		this.mettreIhmAJour();

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
				sRet += String.format("%-6.6s",tabPlateau[i][j]) + "  |  ";
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
		sRet += "======================================\n";
		sRet += String.format("|%-36s|", "1. Construire batiment") + "\n";
		sRet += String.format("|%-36s|", "2. Placer ouvrier") + "\n";
		sRet += "======================================\n";

		return sRet;
	}

	public String afficherMenuConstuctionBatiment()
	{
		String sRet = "";

		sRet += "======================================\n";
		sRet += String.format("|%-36s|", "Espace Construction " + this.ctrl.getCouleurJoueur()) + "\n";
		sRet += String.format("|%-36s|", "Bois : " + 9) + "\n";
		sRet += String.format("|%-36s|", "Ble : " + 12) + "\n";
		sRet += String.format("|%-36s|", "Eau : " + 1) + "\n";
		sRet += String.format("|%-36s|", "Pierre : " + 3) + "\n";
		sRet += "======================================\n";
		sRet += String.format("|%-36s|", "Veuillez entrer les coordonnées.") + "\n";
		sRet += "======================================\n";

		return sRet;
	}

	public void mettreIhmAJour()
	{
		System.out.print("\033[H\033[2J");  
    	System.out.flush(); 

		System.out.println(this.getHeader());
		System.out.println(this.afficherPlateau());
		System.out.println(this.afficherMenuChoix());
	}
}