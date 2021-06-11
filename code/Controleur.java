package equipe_11;

import equipe_11.ihm.CUI;
import equipe_11.metier.BatimentInfo;
import equipe_11.metier.Jeu;
import equipe_11.metier.Pion;
import equipe_11.metier.Joueur;

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

	public Joueur[] getJoueurs()
	{
		return this.metier.getJoueurs();
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

	public boolean nourrirOuvrier()
    {

        System.out.println(this.metier.isToutOuvriersPose());

        if ( !this.metier.isToutOuvriersPose() )return false;

        Stack<Integer> pileQuantite = new Stack<Integer>();
        Stack<String> pileRessource = new Stack<String>();

		String sRet = "";
        int iQteRessource;
        int iQuantiteBle;
        int iQuantiteEau; 
        int iQuantitePiece;

        for(Joueur j : this.metier.getJoueurs())
        {
            if(!j.nourrirOuvrier().equals("Vous pouvez nourrir vos ouvriers en choisissant vos ressources"))continue;

            iQteRessource  = 0;
            iQuantiteBle   = 0;
            iQuantiteEau   = 0;
            iQuantitePiece = 0;

            while(iQteRessource < j.getNbOuvrier())
            {

                this.ihm.mettreIhmAJour();
                this.ihm.afficherMenuNourriture(j, "");

				sRet = "";
				
				String saisie;

				do
				{
					saisie = getSaisie();
				}while(!saisie.matches("^[1-3]$"));

				int iSaisie = Integer.parseInt(saisie);

				System.out.println(iSaisie);

                switch(iSaisie)
                {
                    case 1 : { 
                        this.ihm.mettreIhmAJour();

                        this.ihm.afficherMenuSaisie("TypeR"); 

                        pileRessource.push(getSaisie());

                        break;
                    }

                    case 2 : { 
                        this.ihm.mettreIhmAJour();

                        this.ihm.afficherMenuSaisie("Qte"); 

                        int valeur = Integer.parseInt(getSaisie());

                    	if(iQteRessource + valeur > j.getNbOuvrier())
                    	valeur = j.getNbOuvrier() - iQteRessource;

                        pileQuantite.add(valeur);

                        break;
                    }

					case 3 : {
						if ( !pileRessource.isEmpty() || !pileQuantite.isEmpty() )
						{
							System.out.println("cc");
							String sRessource = pileRessource.pop();
	                        sRessource = sRessource.toUpperCase();

	                        if(sRessource.equals("BLE")  )iQuantiteBle += pileQuantite.pop();
	                        if(sRessource.equals("EAU")  )iQuantiteEau += pileQuantite.pop();
	                        if(sRessource.equals("PIECE"))iQuantitePiece += pileQuantite.pop();

	                        iQteRessource = iQuantiteEau + iQuantiteBle + iQuantitePiece/3;
						}
                        
                        break;
                    }
                }
            }
            System.out.println(iQteRessource + "/" + j.getNbOuvrier());


            sRet = j.nourrirOuvrier(iQuantiteEau, iQuantiteBle, iQuantitePiece);
        }
        this.metier.passerManche();

        return true;
    }


	public void activerPreteurSurGage( String ressourceSaisi1, String ressourceSaisi2, String ressourceVoulu1, String ressourceVoulu2 )
	{
		metier.activerPreteurSurGage( ressourceSaisi1, ressourceSaisi2, ressourceVoulu1, ressourceVoulu2 );
	}

}
