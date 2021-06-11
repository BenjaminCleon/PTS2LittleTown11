package equipe_11;

import equipe_11.ihm.CUI;
import equipe_11.BatimentInfo;
import equipe_11.metier.Jeu;
import equipe_11.metier.Pion;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;
import java.util.EmptyStackException;

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

		this.ihm.initCUI();
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

	public int getQteRessourceJoueur( String sType )
	{
		return this.metier.getJoueurCourant().getQteRessource(sType);
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

	public String getCouleurJoueur(int i)
	{
		return this.metier.getCouleurJoueur(i);
	}

	public void bouclePrincipale()
	{
		while(this.metier.getNumManche() != 4)
		{
			try
			{
				this.ihm.mettreIhmAJour();
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

			}catch(NumberFormatException e){ Console.println("Vous avez fait un mauvais choix"); }
		}
	}

	public void construire()
	{
		this.ihm.mettreIhmAJour();

		int iEntreeUtilisateur = 0;
		String sCoord = null;
		String sType = null;

		do
		{
			this.ihm.afficherMenuConstructionBatiment();

			try
			{
				iEntreeUtilisateur = Integer.parseInt(getSaisie());
			}catch(NumberFormatException e){ Console.println("Nombre invalide"); }

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
					if(verifierParametereConstruction(sType, sCoord))
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

	public boolean verifierParametereConstruction(String type, String coord)
	{
		if(type == null || coord == null)return false;

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
		}while ( !saisie.matches("^([a-i]|[A-I])[1-6]$"));

		if ( this.metier.ajouterOuvrier(Character.getNumericValue(saisie.charAt(1)), saisie.charAt(0)))
		{
			do
			{
				this.ihm.mettreIhmAJour();
				this.ihm.afficherMenuActivation();
				alBat = this.metier.getLstBatimentAutourOuvrier  ();
				if ( !this.metier.verifierConstruction() )
				{
					saisie = "3";
				}
				else
				{
					saisie = this.getSaisie();
					switch ( saisie )
					{
						case "1" -> { this.ihm.mettreIhmAJour(); this.ihm.demanderBatiment(alBat); }
						case "2" ->
						{
							do
							{
								this.ihm.mettreIhmAJour();
								this.ihm.afficherMenuSaisie("Coord");
								{
									saisie = this.getSaisie().toUpperCase();
								}while ( !saisie.matches("^([a-i]|[A-I])[1-6]$"));

							}while(!this.metier.activerBatiment(saisie.charAt(1)-'0', saisie.charAt(0)));

							if( metier.getPreteurSurGage() )
							{
								this.ihm.afficherPreteurSurGage();
							}
						}
					}
				}
			}
			while ( !saisie.equals("3") );
			this.metier.changerJoueur();
		}
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
	
	public ArrayList<BatimentInfo> getLstBat()
	{
		return this.metier.getLstBat();
	}

	public ArrayList<String> getLstNomBat()
	{
		return this.metier.getLstNomBat();
	}

	public int getNbChampsDeble(){ return this.metier.getNbChampsDeble(); }

	public int getNumManche(){ return this.metier.getNumManche(); }

	public String getRessourceAllJoueur()
	{
		return this.metier.getRessourceAllJoueur();
	}

	public int getNbJoueur(){ return this.metier.getNbJoueur(); }

	public boolean nourrirOuvrier()
    {
		String sRet = "";
		String saisie = "";
        int iQuantiteBle;
        int iQuantiteEau; 
        int iQuantitePiece; 

        if ( !this.metier.isToutOuvriersPose() )return false;

		for ( int i=0; i<this.getNbJoueur();i++)
		{
			if ( !this.metier.nourrirOuvrier(i) )
			{
				iQuantiteBle   = 0;
				iQuantiteEau   = 0;
				iQuantitePiece = 0;
				do
				{
					this.ihm.mettreIhmAJour(sRet);
					this.ihm.afficherMenuNourriture(this.metier.getCouleurJoueur(i));
					switch(this.getSaisie())
					{
						case "1" ->
						{
							this.ihm.mettreIhmAJour();
							this.ihm.afficherDemandePourNourriture("eau"  );
							saisie = this.getSaisie();
							if(saisie.matches("^[0-5]$" )) iQuantiteEau   = Integer.parseInt(saisie);
							sRet = "";
						} 
						case "2" ->
						{
							this.ihm.mettreIhmAJour();
							this.ihm.afficherDemandePourNourriture("blé"  );
							saisie = this.getSaisie();
							if(saisie.matches("^[0-5]$" )) iQuantiteBle   = Integer.parseInt(saisie);
							sRet = "";
						} 
						case "3" ->
						{
							this.ihm.mettreIhmAJour();
							this.ihm.afficherDemandePourNourriture("pièce");
							saisie = this.getSaisie();
							if(saisie.matches("^([0-9]|1[0-5])$")) iQuantitePiece = Integer.parseInt(saisie);
							sRet = "";
						}
						case "4" ->
						{
							sRet = this.metier.nourrirOuvrier(iQuantiteEau, iQuantiteBle, iQuantitePiece, i);
							iQuantiteEau   = 0;
							iQuantiteBle   = 0;
							iQuantitePiece = 0;
						}
					}
					Console.println(sRet);
				}while( !sRet.equals("Ouvrier nourri avec succès") );
			}
		}
		
        this.metier.passerManche();

        return true;
    }


	public void activerPreteurSurGage( String ressourceSaisi1, String ressourceSaisi2, String ressourceVoulu1, String ressourceVoulu2 )
	{
		metier.activerPreteurSurGage( ressourceSaisi1, ressourceSaisi2, ressourceVoulu1, ressourceVoulu2 );
	}

}
