package equipe_11;

import equipe_11.ihm.CUI;
import equipe_11.metier.BatimentInfo;
import equipe_11.metier.Jeu;
import equipe_11.metier.Pion;

import java.util.Scanner;
import java.util.ArrayList;

import iut.algo.CouleurConsole;
import iut.algo.Console;

public class Controleur
{
	private CUI ihm;
	private Jeu metier;

	public Controleur()
	{
		this.metier = new Jeu();
		this.ihm    = new CUI(this);

		this.bouclePrincipale();
	}

	public static void main(String[] args)
	{
		new Controleur();
	}
	
	public boolean setNbJoueur()
	{
		String saisie = this.getSaisie();
		
		if (!saisie.matches("^[2-4]$"))return false;

		this.metier.setJoueur(Integer.parseInt(saisie));
		return true;
	}
	
	public boolean setNumPlateau()
	{
		String saisie = this.getSaisie();
		if (!saisie.matches("^[12]$"))return false;

		this.metier.setNumPlateau(Integer.parseInt(saisie));

		return true;
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
					case 1 -> { this.construire    (); }
					case 2 -> { this.ajouterOuvrier(); }
					case 3 -> { this.obtenirInfo   (); }
					case 4 -> { this.echangerPiece();  }
					case 5 -> { System.exit(0)       ; }
				}

				this.ihm.mettreIhmAJour();
				Console.println(this.ihm.afficherMenuChoix());

			}catch(NumberFormatException e){ System.out.println("Vous avez fait un mauvais choix"); }
		}
	}

	public void construire()
	{
		int iEntreeUtilisateur = 0;
		String sCoord = null;
		String sType = null;

		do
		{

			this.ihm.afficherMenuConstructionBatiment();

			try
			{
				iEntreeUtilisateur = Integer.parseInt(getSaisie());
			}catch(NumberFormatException e){ System.out.println("Nombre invalide"); }

			switch(iEntreeUtilisateur)
			{
				case 1 -> { 
					this.ihm.mettreIhmAJour();
					this.ihm.afficherMenuSaisie("Coord");
					sCoord = getSaisie();
				}

				case 2 -> { 
					this.ihm.mettreIhmAJour();
					this.ihm.afficherMenuSaisie("Type");
					sType = getSaisie(); 
				}

				case 3 -> { 
					if(verifierPossibleConstruire(sType, sCoord))
					{
						this.metier.construireBatiment(this.metier.getNumeroJoueurCourant() + 1, sType, Character.getNumericValue(sCoord.charAt(1)),
					        sCoord.charAt(0));

						iEntreeUtilisateur = 4;
					}
				}
			}

			this.ihm.mettreIhmAJour();

		}while(iEntreeUtilisateur != 4);
	}

	public boolean verifierPossibleConstruire(String type, String coord)
	{
		if(type == null || coord == null)
			return false;

		return true;
	}

	public void ajouterOuvrier()
	{
		this.ihm.mettreIhmAJour();
		this.ihm.afficherMenuPlacementOuvrier();
		ArrayList<BatimentInfo> alBat;
		String saisie;

		do
		{
			saisie = this.getSaisie();
			if ( saisie.equals("2") )return;
		}while ( !saisie.matches("^[12]$") );

		do
		{
			this.ihm.mettreIhmAJour();
			this.ihm.afficherMenuSaisie("Coord");
			saisie = this.getSaisie().toUpperCase();
		}while ( !saisie.matches("^[A-I][1-6]$"));

		if ( this.metier.ajouterOuvrier(Character.getNumericValue(saisie.charAt(1)), saisie.charAt(0)))
		{
			do
			{
				this.ihm.mettreIhmAJour();
				this.ihm.afficherMenuActivation();
				alBat = this.metier.getLstBatimentAutourOuvrier  ();
				if ( alBat.size() == 0 )
				{
					saisie = "3";
				}
				else
				{
					saisie = this.getSaisie();
					switch ( saisie )
					{
						case "1" -> { this.ihm.mettreIhmAJour(); this.ihm.demanderBatiment(alBat);}
						case "2" ->
						{
							do
							{
								this.ihm.mettreIhmAJour();
								this.ihm.afficherMenuSaisie("Coord");
								{
									saisie = this.getSaisie().toUpperCase();
								}while ( !saisie.matches("^[A-I][1-6]$"));
							}while(!this.metier.activerBatiment(saisie.charAt(1)-'0', saisie.charAt(0)));
						}
					}
				}
			}
			while ( !saisie.equals("3") );
		}
		this.metier.changerJoueur();
	}

	public void echangerPiece()
	{
		this.ihm.afficherMenuEchangePiece();

		String sRessource = getSaisie();
		sRessource = sRessource.toUpperCase();

		this.metier.echangerPieceContreRessource( sRessource );
	}
	
	public void obtenirInfo()
	{
		this.ihm.afficherInfo();
	}
	
	public String getLstBat()
	{
		return this.metier.getLstBat();
	}

}
