package littletown;

import java.util.Scanner;

import littletown.ihm.Console;
import littletown.metier.Jeu;

public class Controleur
{
	Console ihm;
	Jeu     metier;

	public Controleur()
	{
		this.metier = new Jeu();
		this.ihm    = new Console(this);

		this.effectuerActionsSelonChoix();

	}

	public static void main(String[] args)
	{
		new Controleur();
	}

	public String[][] getPlateau()
	{
		return this.metier.getPlateau();
	}


	public String intercepterSaisie()
	{
		Scanner in = new Scanner(System.in);

		String sRet = in.nextLine();

		return sRet;
	}

	public void effectuerActionsSelonChoix()
	{
		String choix = intercepterSaisie();

		if(choix.equals("1"))
			this.metier.getPlateau()[3][4] = "Yikes";
		
		if(choix.equals("2"))
			System.out.println("Choix 2 effectué");

		this.ihm.mettreIhmAJour();
	}

	public int getScoreJoueur()
	{
		return 1212221;
	}

	public String getCouleurJoueur()
	{
		return "Rouge";
	}
}