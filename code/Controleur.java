package equipe_11;

import equipe_11.ihm.CUI;
import equipe_11.BatimentInfo;
import equipe_11.metier.CartesObjectifs;
import equipe_11.metier.Jeu;
import equipe_11.metier.Pion;

import equipe_11.scenario.*;

import java.util.Scanner;
import java.util.ArrayList;

import java.io.*;
import java.awt.Point;

import iut.algo.CouleurConsole;
import iut.algo.Console;

public class Controleur
{
	private CUI ihm;
	private Jeu metier;

	public Controleur(String fic)
	{

		this.ihm    = new CUI(this);
		if ( fic == null )
		{
			this.metier       = new Jeu ();
			this.ihm.initCUI();
		}
		else
		{
			switch ( fic.toUpperCase() )
			{
				case "SCENARIO1" -> this.metier = new Scenario1();
				case "SCENARIO2" -> this.metier = new Scenario2();
				case "SCENARIO3" -> this.metier = new Scenario3();
			}
		}

		this.bouclePrincipale();
	}

	public boolean setNbJoueur()
	{
		String saisie = this.getSaisie();
		
		if (!saisie.matches("^[2-4]$"))return false;

		this.metier.setJoueur(Integer.parseInt(saisie));

		return true;
	}

	public void setNomJoueur(int iNbJoueur)
	{
		String saisie = this.getSaisie();

		this.metier.setNomJoueur(iNbJoueur, saisie);
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

	public String getCouleurJoueur()
	{
		return this.metier.getJoueurCourant().getCouleur();
	}

	public int getQteRessourceStock(String sType)
	{
		return this.metier.getQteRessourceStock(sType);
	}

	public void bouclePrincipale()
	{
		while(this.metier.getNumManche() != 5)
		{
			try
			{
				this.ihm.mettreIhmAJour();
				this.ihm.afficherObj   ();
				this.ihm.afficherMenuChoix();

				int choix = Integer.parseInt(getSaisie());

				switch(choix)
				{
					case 1 -> this.construire    ();
					case 2 -> this.ajouterOuvrier();
					case 3 -> this.echangerPiece ();
					case 4 -> System.exit(0)       ;
				}

				this.ihm.mettreIhmAJour();

				this.nourrirOuvrier();
				this.metier.verifierObjectif();

			}catch(NumberFormatException e){ Console.println("Vous avez fait un mauvais choix"); }
		}
		this.metier.gererChateau();
		this.metier.gererTourDeGarde();
		this.metier.gererFinDePartie();

		this.ihm.afficherFinDePartie();
	}

	public CartesObjectifs getObj(int i){ return  this.metier.getJoueurCourant().getObj(i); }

	public int getNbCartesObjectif()
	{
		switch ( this.getNbJoueur() )
		{
			case 2  -> { return 4; }
			case 3  -> { return 3; }
			default -> { return 2; }
		}
	}

	public void construire()
	{
		this.ihm.mettreIhmAJour();


		int iEntreeUtilisateur = 0;
		String sCoord = null;
		String sType  = null;
		String saisie = null;
		ArrayList<BatimentInfo> alBat = this.getLstBat();
		BatimentInfo b = null;

		do
		{
			this.ihm.afficherObj   ();
			this.ihm.afficherMenuConstructionBatiment();
			this.ihm.afficherInfo(b);
			b = null;
			try
			{
				iEntreeUtilisateur = Integer.parseInt(getSaisie());
			}catch(NumberFormatException e){ Console.println("Nombre invalide"); }

			switch(iEntreeUtilisateur)
			{
				case 1 -> { 
					this.ihm.mettreIhmAJour();
					this.ihm.afficherObj   ();
					this.ihm.afficherMenuSaisie("Coord");
					sCoord = getSaisie().toUpperCase();
				}

				case 2 -> { 
					this.ihm.mettreIhmAJour();
					this.ihm.afficherObj   ();
					this.ihm.afficherMenuSaisie("Type");
					sType = getSaisie().toUpperCase();
					if ( sType.matches("^([1-9]|1[0-3])$") && alBat.size() >= (Integer.parseInt(sType)))
						sType = alBat.get(Integer.parseInt(sType)-1).name();
				}
				case 3 -> {
					this.ihm.mettreIhmAJour();
					this.ihm.afficherObj   ();
					this.ihm.afficherMenuSaisie("Type");
					saisie = this.getSaisie().toUpperCase();
					if ( saisie.matches("^([1-9]|1[0-3])$") && alBat.size() >= (Integer.parseInt(saisie)))
						b = this.metier.getLstBat().get(Integer.parseInt(saisie)-1);
				}

				case 4 -> { 
					if(verifierParametreConstruction(sType, sCoord))
					{
						this.metier.construireBatiment(this.metier.getNumeroJoueurCourant() + 1, sType, Character.getNumericValue(sCoord.charAt(1)),
					        sCoord.charAt(0));

						iEntreeUtilisateur = 5;
					}
				}
			}

			this.ihm.mettreIhmAJour();

		}while(iEntreeUtilisateur != 5);
	}

	public boolean verifierParametreConstruction(String type, String coord)
	{
		if(type == null || coord == null)return false;

		return true;
	}

	public void ajouterOuvrier()
	{
		this.ihm.mettreIhmAJour();
		this.ihm.afficherMenuPlacementOuvrier();
		ArrayList<BatimentInfo> alBatPioche;
		String saisie;
		BatimentInfo b = null;

		alBatPioche = this.getLstBat();

		do
		{
			do
			{
				this.ihm.mettreIhmAJour();
				this.ihm.afficherObj   ();
				this.ihm.afficherMenuPlacementOuvrier();
				saisie = this.getSaisie();
				if ( saisie.equals("2") )return;
			}while ( !saisie.matches("^[12]$") );
	
			saisie = "";
			this.ihm.mettreIhmAJour();
			this.ihm.afficherObj   ();
			this.ihm.afficherMenuSaisie("Coord");
			saisie = this.getSaisie().toUpperCase();
		}while( !saisie.matches("^[A-I][1-6]$"));
		

		if ( this.metier.ajouterOuvrier(Character.getNumericValue(saisie.charAt(1)), saisie.charAt(0)))
		{
			do
			{
				if ( !this.metier.verifierActivation() )
				{
					saisie = "3";
				}
				else
				{
					this.ihm.mettreIhmAJour();
					this.ihm.afficherObj   ();
					this.ihm.afficherMenuActivation();
					this.ihm.afficherInfo(b);
					b = null;
					saisie = this.getSaisie();
					b = this.activationCas(saisie);
				}
			}
			while ( !saisie.equals("3") );
			this.metier.changerJoueur();
		}
	}

	public BatimentInfo activationCas(String saisie){ return this.activationCas(saisie, null); }

	public BatimentInfo activationCas(String saisie, ArrayList<BatimentInfo> alBat)
	{
		BatimentInfo b= null;
		String[] sEnsRessourceADonner;
		String[] sEnsRessourceAObtenir;

		if ( alBat == null )alBat = this.metier.getLstBatimentAutourOuvrier();

		switch ( saisie )
		{
			case "1" ->
			{
				this.ihm.mettreIhmAJour();
				this.ihm.afficherObj   ();
				this.ihm.afficherMenuSaisie("Coord");
				saisie = this.getSaisie().toUpperCase();
				if ( saisie.matches("^[A-I][1-6]$"))
					b = this.metier.getBatimentDansPlateau(
						saisie.charAt(1) - '1', saisie.charAt(0) - 'A');
			}
			case "2" ->
			{
				this.ihm.mettreIhmAJour();
				this.ihm.afficherObj   ();
				this.ihm.afficherMenuSaisie("Coord");
				saisie = this.getSaisie().toUpperCase();
				if ( !saisie.matches("^([A-I])[1-6]$"))return null;
				if ( this.metier.activerBatiment(saisie.charAt(1)-'0', saisie.charAt(0)))
					alBat.remove(this.metier.getBatimentDansPlateau(saisie.charAt(1) - '1', saisie.charAt(0) - 'A'));

				if( this.metier.getPreteurSurGage() )
				{
					this.ihm.mettreIhmAJour();
					this.ihm.afficherObj   ();
					this.ihm.afficherPreteurSurGage();
					this.ihm.afficherMenuSaisie("Donner");
					saisie = this.getSaisie();
					sEnsRessourceADonner = saisie.split(" ");
					this.ihm.mettreIhmAJour();
					this.ihm.afficherObj   ();
					this.ihm.afficherPreteurSurGage();
					this.ihm.afficherMenuSaisie("Obtenir");
					saisie = this.getSaisie();
					sEnsRessourceAObtenir = saisie.split(" ");
					if ( sEnsRessourceADonner.length == 2 && sEnsRessourceAObtenir.length == 2 )
						this.metier.activerPreteurSurGage(sEnsRessourceADonner [0],
															sEnsRessourceADonner [1],
															sEnsRessourceAObtenir[0],
															sEnsRessourceAObtenir[1]);
				}
			}
		}
		return b;
	}

	public void echangerPiece()
	{
		this.ihm.afficherMenuEchangePiece();

		String sRessource = getSaisie().toUpperCase();

		this.metier.echangerPieceContreRessource( sRessource );
	}

	public ArrayList<BatimentInfo> getLstBat()
	{
		return this.metier.getLstBat();
	}

	public int getNbChampsDeble(){ return this.metier.getNbChampsDeble(); }

	public int getNumManche(){ return this.metier.getNumManche(); }

	public String getRessourceAllJoueur()
	{
		return this.metier.getRessourceAllJoueur();
	}

	public int getNbJoueur(){ return this.metier.getNbJoueur(); }

	public int getNbOuvrierRestantCourant()
	{
		return this.metier.getNbOuvrierRestantCourant();
	}

	public int getNbBatimentRestantCourant()
	{
		return this.metier.getNbBatimentRestantCourant();
	}

	public boolean nourrirOuvrier()
    {
		String sRet = "";
		String saisie = "";
        int iQuantiteBle;
        int iQuantitePoisson; 
        int iQuantitePiece  ; 
		int iNumFuturJoueur ;

        if ( !this.metier.isToutOuvriersPose() )return false;
		this.gererResidence();

		iNumFuturJoueur = (this.metier.getNumeroJoueurCourant()+1)%this.metier.getNbJoueur();
		this.metier.mettreJoueurA(0);
		for ( int i=0; i<this.getNbJoueur();i++)
		{
			if ( !this.metier.nourrirOuvrier(i) )
			{
				iQuantiteBle     = 0;
				iQuantitePoisson = 0;
				iQuantitePiece   = 0;
				do
				{
					this.ihm.mettreIhmAJour(sRet);
					this.ihm.afficherObj   ();
					this.ihm.afficherMenuNourriture(this.metier.getCouleurJoueur(i));
					switch(this.getSaisie())
					{
						case "1" ->
						{
							this.ihm.mettreIhmAJour();
							this.ihm.afficherObj   ();
							this.ihm.afficherDemandePourNourriture("poisson"  );
							saisie = this.getSaisie();
							if(saisie.matches("^\\d$" )) iQuantitePoisson = Integer.parseInt(saisie);
							sRet = "";
						} 
						case "2" ->
						{
							this.ihm.mettreIhmAJour();
							this.ihm.afficherObj   ();
							this.ihm.afficherDemandePourNourriture("blé"  );
							saisie = this.getSaisie();
							if(saisie.matches("^\\d$" )) iQuantiteBle   = Integer.parseInt(saisie);
							sRet = "";
						} 
						case "3" ->
						{
							this.ihm.mettreIhmAJour();
							this.ihm.afficherObj   ();
							this.ihm.afficherDemandePourNourriture("pièce");
							saisie = this.getSaisie();
							if(saisie.matches("^\\d$")) iQuantitePiece = Integer.parseInt(saisie);
							sRet = "";
						}
						case "4" ->
						{
							sRet = this.metier.nourrirOuvrier(iQuantitePoisson, iQuantiteBle, iQuantitePiece, i);
							iQuantitePoisson = 0;
							iQuantiteBle     = 0;
							iQuantitePiece   = 0;
						}
					}
					Console.println(sRet);
				}while( !sRet.equals("Ouvrier nourri avec succès") );
			}
			this.metier.changerJoueur();
		}
		
		this.metier.mettreJoueurA(iNumFuturJoueur);
        this.metier.passerManche();

        return true;
    }

	public void gererResidence()
	{
		String  saisie = ""  ;
		BatimentInfo b = null;
		int iNumJoueur;
		ArrayList<BatimentInfo> alBat;

		if ( !this.metier.contientResidence() )return;


		iNumJoueur = this.metier.getNumJoueurResidence();
		this.metier.mettreJoueurA(iNumJoueur);
		this.metier.remplirPourResidence();
		alBat = this.metier.getLstBatimentAutourOuvrier();

		do
		{
			this.ihm.mettreIhmAJour();
			this.ihm.afficherObj   ();
			this.ihm.afficherMenuActivation(true);
			this.ihm.afficherInfo(b);
			saisie = this.getSaisie();
			b = this.activationCas (saisie, alBat);
		}while ( !saisie.equals("3") );
	}

	public String[][] getClassemenentJoueur()
	{
		return this.metier.getClassemenentJoueur();
	}

	public static void main(String[] args)
	{
		if ( args.length == 1 )new Controleur(args[0]);
		else                   new Controleur(  null );
	}
}
