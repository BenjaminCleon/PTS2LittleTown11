package equipe_11;

import equipe_11.ihm.CUI;
import equipe_11.metier.Jeu;
import equipe_11.metier.Pion;
import java.util.Scanner;

import iut.algo.CouleurConsole;
import iut.algo.Console;

public class Controleur
{
	CUI ihm;
	Jeu     metier;

	public Controleur()
	{
		this.metier = new Jeu();
		this.ihm    = new CUI(this);

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

	public Pion[][] getPlateau(){ return this.metier.getPlateau();}

	public int getRessourceJoueur( String sType )
	{
		return this.metier.getJoueurCourant().getRessource(sType);
	}

	public int getPieceJoueur()
	{
		return this.metier.getJoueurCourant().getNbPiece();
	}

	public int getScoreJoueur()
	{
		return this.metier.getJoueurCourant().getScore();
	}

	public String getCouleurJoueur()
	{
		return this.metier.getJoueurCourant().getCouleur();
	}

	public void bouclePrincipale()
	{
		while(this.metier.getNumManche() != 4)
		{
			try
			{

				int choix = Integer.parseInt(getSaisie());

				switch(choix)
				{
					case 1 -> { this.construire(); }
					case 2 -> { this.ajouterOuvrier(); }
					case 3 -> { this.ObtenirInfo(); }
					case 4 -> { System.exit(0); }
				}

				this.ihm.mettreIhmAJour();
				Console.println(this.ihm.afficherMenuChoix());

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

	public void ajouterOuvrier()
	{
		System.out.println(this.ihm.afficherMenuPlacementOuvrier());

		String coord = getSaisie();
		coord = coord.toUpperCase();

		this.metier.ajouterOuvrier(Character.getNumericValue(coord.charAt(1)), coord.charAt(0));
	}
	
	public void ObtenirInfo()
	{
		ihm.AfficherInfo();
	}
	
	public String getLstBat()
	{
		return metier.getLstBat();
	}

}