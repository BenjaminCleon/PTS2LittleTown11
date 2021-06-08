package equipe_11;

import equipe_11.ihm.Console;
import equipe_11.metier.Jeu;
import java.util.Scanner;

public class Controleur
{
	Console ihm;
	Jeu     metier;

	public Controleur()
	{
		this.metier = new Jeu();
		this.ihm    = new Console(this);

		bouclePrincipale();
	}

	public static void main(String[] args)
	{
		new Controleur();
	}

	public String getSaisie()
	{
		Scanner in = new Scanner(System.in);

		return in.nextLine();
	}

	public String[][] getPlateau()
	{
		return this.metier.getPlateau();
	}

	public int getScoreJoueur()
	{
		return 1212221;
	}

	public String getCouleurJoueur()
	{
		return "Rouge";
	}

	public void bouclePrincipale()
	{

		int cpt = 0;
		while(cpt != 4)
		{
			try
			{
				
				int choix = Integer.parseInt(getSaisie());

				switch(choix)
				{
					case 1 -> { construire(); }
					case 3 -> { System.exit(0); }
				}

				this.ihm.mettreIhmAJour();
				System.out.println(this.ihm.afficherMenuChoix());
				cpt++;

			}catch(NumberFormatException e){ System.out.println("Vous avez fait un mauvais choix"); }
		}
	}

	public void construire()
	{
		System.out.println(this.ihm.afficherMenuConstructionBatiment());

		String coord = getSaisie();
		coord = coord.toUpperCase();
		String type  = getSaisie();

		this.metier.construireBatiment(1, type, Character.getNumericValue(coord.charAt(1)),
					coord.charAt(0));
	}

}