package equipe_11;

import equipe_11.ihm.CUI;
import equipe_11.metier.Jeu;
import equipe_11.metier.Pion;
import equipe_11.metier.Joueur;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;

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
				this.ihm.mettreIhmAJour();
				Console.println(this.ihm.afficherMenuChoix());


				int choix = Integer.parseInt(getSaisie());

				switch(choix)
				{
					case 1 : { this.construire    (); break; }
					case 2 : { this.ajouterOuvrier(); break; }
					case 3 : { this.obtenirInfo   (); break; }
					case 4 : { this.echangerPiece();  break; }
					case 5 : { System.exit(0)       ; break; }
				}

				this.ihm.mettreIhmAJour();

				if(!this.nourrirOuvrier())
					continue;

			}catch(NumberFormatException e){ System.out.println("Vous avez fait un mauvais choix"); }
		}
	}

	public void construire()
	{
		this.ihm.mettreIhmAJour();

		int iEntreeUtilisateur = 0;
		String sCoord = null;
		String sType = null;
		String sTypeSaisie = null;

		do
		{

			System.out.println(this.ihm.afficherMenuConstructionBatiment());

			try
			{
				iEntreeUtilisateur = Integer.parseInt(getSaisie());
			}catch(NumberFormatException e){ System.out.println("Nombre invalide"); }

			switch(iEntreeUtilisateur)
			{
				case 1 : { 
					this.ihm.mettreIhmAJour();
					System.out.println(this.ihm.afficherMenuSaisie("Coord"));
					sCoord = getSaisie();
					break;
				}

				case 2 : { 
					this.ihm.mettreIhmAJour();
					System.out.println(this.ihm.afficherMenuSaisie("Type"));
					sType = getSaisie();
					break; 
				}

				case 3 : { 
					if(verifierPossibleConstruire(sType, sCoord))
					{
						this.metier.construireBatiment(this.metier.getNumeroJoueurCourant() + 1, sType, Character.getNumericValue(sCoord.charAt(1)),
					        sCoord.charAt(0));

						iEntreeUtilisateur = 4;
						break;
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

		System.out.println(this.ihm.afficherMenuPlacementOuvrier());

		String coord = getSaisie();
		coord = coord.toUpperCase();
		this.metier.ajouterOuvrier(Character.getNumericValue(coord.charAt(1)), coord.charAt(0));
	}

	public void echangerPiece()
	{

		this.ihm.mettreIhmAJour();

		System.out.println(this.ihm.afficherMenuEchangePiece());

		String sRessource = getSaisie();
		sRessource = sRessource.toUpperCase();

		this.metier.echangerPieceContreRessource( sRessource );

	}
	
	public void obtenirInfo()
	{
		this.ihm.afficherInfo();
	}
	
	public ArrayList<String> getLstBat()
	{
		return this.metier.getLstBat();
	}

	public int getNumManche(){ return this.metier.getNumManche(); }

	public boolean nourrirOuvrier()
	{

		System.out.println(this.metier.isToutOuvriersPose());

		if ( !this.metier.isToutOuvriersPose() )return false;
		
		Stack<Integer> pileQuantite = new Stack<Integer>();
		Stack<String> pileRessource = new Stack<String>();

		int iQteRessource;
		int iQuantiteBle;
		int iQuantiteEau; 
		int iQuantitePiece;

		for(Joueur j : this.metier.getJoueurs())
		{
			iQteRessource = 0;
			iQuantiteBle = 0;
			iQuantiteEau = 0;
			iQuantitePiece = 0;

			while(iQteRessource < j.getNbOuvrier())
			{

				this.ihm.mettreIhmAJour();
				System.out.println(this.ihm.afficherMenuNourriture(j));


				int iSaisie = Integer.parseInt(getSaisie());

				switch(iSaisie)
				{
					case 1 : { 
						this.ihm.mettreIhmAJour();

						System.out.println(this.ihm.afficherMenuSaisie("TypeR")); 

						pileRessource.push(getSaisie());

						break;
					}

					case 2 : { 
						this.ihm.mettreIhmAJour();

						System.out.println(this.ihm.afficherMenuSaisie("Qte")); 

						pileQuantite.add(Integer.parseInt(getSaisie()));
						break;
					}

					case 3 : {


						String sRessource = pileRessource.pop();
						sRessource = sRessource.toUpperCase();

						if(sRessource.equals("BLE"))
						{
							iQuantiteBle += pileQuantite.pop();
						}

						if(sRessource.equals("EAU"))
						{
							iQuantiteEau += pileQuantite.pop();
						}

						if(sRessource.equals("PIECE"))
						{
							iQuantitePiece += pileQuantite.pop();
						}

						iQteRessource = iQuantiteEau + iQuantiteBle + iQuantitePiece;
						break;
					}
				}
			}

			this.ihm.mettreIhmAJour();
			System.out.println(this.ihm.afficherMenuNourriture(j));
			System.out.println(iQteRessource + "/" + j.getNbOuvrier());
			System.out.println(j.nourrirOuvrier(iQuantiteEau, iQuantiteBle, iQuantitePiece));
		}
	
		return true;
	}

}
