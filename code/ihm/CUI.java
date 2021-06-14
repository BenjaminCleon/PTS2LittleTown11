package equipe_11.ihm;

import equipe_11.Controleur  ;
import equipe_11.BatimentInfo;
import equipe_11.metier.Pion ;

import java.util.ArrayList;

import javax.lang.model.util.ElementScanner14;

import iut.algo.CouleurConsole;
import iut.algo.Console;

public class CUI
{
	Controleur ctrl;

	public CUI( Controleur ctrl )
	{
		this.ctrl = ctrl;
	}

	public void initCUI()
	{
		Console.effacerEcran ();
		this.choixDebutPartie();
		this.mettreIhmAJour  ();
	}


	public String getHeader()
	{
		String sRet = "";
		sRet += "================\n===LittleTown===\n================\n";

		return sRet;
	}

	public void afficherPlateau()
	{
		Pion[][] tabPlateau      = this.ctrl.getPlateau();
		BatimentInfo[] tabPioche = this.ctrl.getLstBat().toArray(new BatimentInfo[this.ctrl.getLstBat().size()]);

		int  cpt       = 0;
		int  cptPioche = 0;

		Console.print("\n+---+");
		for(int nbCol = 0; nbCol < 9; nbCol++)
				Console.print("-----------+");
			
		Console.print("----------------------+");

		Console.print("\n|   |");
		for(int i = 'A'; i < tabPlateau[0].length + 'A'; i++)
			Console.print("     " + (char)i + "     |");
		
		Console.print(String.format("  %-18.18s  |", String.format("%2d", cptPioche+1) + ". " + tabPioche[cptPioche++]));
		
		Console.print("\n+---+");
		for(int nbCol = 0; nbCol < 9; nbCol++)
				Console.print("-----------+");

		Console.println(String.format("  %-18.18s  |", String.format("%2d", cptPioche+1) + ". " + tabPioche[cptPioche++]));


		for(int i = 0; i < tabPlateau.length; i++)
		{
			Console.print("| " + ++cpt + " |  ");
			for(int j = 0; j < tabPlateau[0].length; j++)
			{
				Pion pTmp = tabPlateau[i][j];
				if ( pTmp.getNom().equals("OUVRIER") )this.setCouleur(pTmp.getCoul());

				Console.print(String.format("%-7.7s", pTmp	.toString()));
				this.setCouleur(tabPlateau[i][j].getCoul());
				Console.print((!pTmp.getNom ().equals("OUVRIER") &&
					           !pTmp.getCoul().equals("BLANC"))?"*":" ");
				Console.normal();
				Console.print(j==tabPlateau[0].length-1?" |":" |  ");
			}

			if ( cptPioche < tabPioche.length )
				Console.print(String.format("  %-18.18s  |", String.format("%2d", cptPioche+1) + ". " + tabPioche[cptPioche++] + 
				               ((cptPioche==tabPioche.length)?" x" + this.ctrl.getNbChampsDeble():"")));
			else
			     	Console.print(String.format("  %-18s  |", ""));

			Console.println();
			
			Console.print("+---+");
			for(int nbCol = 0; nbCol < 9; nbCol++)
				Console.print("-----------+");

			if ( cptPioche < tabPioche.length )
				Console.print(String.format("  %-18s  |", String.format("%2d", cptPioche+1) + ". " + tabPioche[cptPioche++] + 
				                           ((cptPioche==tabPioche.length)?" x" + this.ctrl.getNbChampsDeble():"")));
			else if ( i < tabPlateau.length - 1)
					Console.print(String.format("  %-18s  |", ""));
		
			if ( i < tabPlateau.length - 1 )Console.println();
		}
		Console.println("----------------------+");
	}

	public void plateauBas(String sMess)
	{
		String sRet = "";
		Console.print("+-----------+-------------+--------------------+----------------------+" +
		              "----------+------------+---------+-------------+----------------+\n"                     +
		                 "|Manche : " + this.ctrl.getNumManche() + " |Joueur "                   );
		this.setCouleur(this.ctrl.getCouleurJoueur());
		Console.print(String.format("%-6s", "" + this.ctrl.getCouleurJoueur().toUpperCase()));
		Console.normal();
		Console.println("|Ouvrier restants: "    + this.ctrl.getNbOuvrierRestantCourant ()
		                + " " +
		                "|Batiments restants: " + this.ctrl.getNbBatimentRestantCourant()
						+ " |Bois : "   + String.format("%2d", this.ctrl.getQteRessourceStock("BOIS")) 
						+ " |Pierre : " + String.format("%2d", this.ctrl.getQteRessourceStock("PIERRE"))
						+ " |Blé : "    + String.format("%2d", this.ctrl.getQteRessourceStock("BLE"))
						+ " |Poisson : "+ String.format("%2d", this.ctrl.getQteRessourceStock("POISSON"))
						+ String.format("%-18s|"," |Piece : "  + 
						                String.format("%2d", this.ctrl.getQteRessourceStock("PIECE"))));
		Console.println("+-----------+-------------+--------------------+----------------------+" +
		                "----------+------------+---------+-------------+----------------+\n"     );
		if ( !sMess.equals("") )
			Console.println("+==========================================================+\n"+
				            String.format("|%-57s|", sMess) + "\n"    +
			                "+==========================================================+\n" );

		Console.println(this.getRessourceAllJoueur());
	}

	public String getRessourceAllJoueur()
	{
		String sRet = "";
		String[] sRetSplit;
		int    iNbJoueur = this.ctrl.getNbJoueur();

		sRet = this.ctrl.getRessourceAllJoueur();

		sRetSplit = sRet.split("\n");

		sRet = "";
		for (int i=0;i<9; i++)
		{
			sRet += sRetSplit[i  ];
			sRet += sRetSplit[i+9];
			if ( iNbJoueur >= 3 )sRet += sRetSplit[i+9*2];
			if ( iNbJoueur == 4 )sRet += sRetSplit[i+9*3];

			if ( i != 0 && i != 8 )sRet += "|";
			if ( i == 0 || i == 8 )sRet += "+";
			sRet += "\n";
		}
		
		return sRet;
	}

	public void setCouleur(String sCoul)
	{
		switch( sCoul.toUpperCase() )
		{
			case "ROUGE"  -> Console.couleurFont( CouleurConsole.ROUGE );
			case "VERT"   -> Console.couleurFont( CouleurConsole.VERT  );
			case "BLEU"   -> Console.couleurFont( CouleurConsole.CYAN );
			case "JAUNE"  -> Console.couleurFont( CouleurConsole.JAUNE );
			default       -> Console.normal();
		}
	}

	public void choixDebutPartie()
	{
		int iNbJoueur;
		int iPlateau;
		String sTmp;
		String sNomJoueur;
		String sRet = "";

		do
		{
			Console.print("Combien de joueurs vont participer ?");
		}while(!this.ctrl.setNbJoueur());

		for (int i=0;i<this.ctrl.getNbJoueur();i++)
		{
			Console.print("Nom du joueur "+ (i+1) +" : ");
			this.ctrl.setNomJoueur(i);
		}

		Console.println();

		do
		{
			Console.print("Choisissez le numéro du plateau ?");
		}while(!this.ctrl.setNumPlateau());
	}

	public void demanderNom(int iVal)
	{
		Console.println("Nom du joueur n°" + iVal);
	}

	public void afficherMenuChoix()
	{
		String sRet = "";

		sRet += "+=====================================+\n";
		sRet += String.format("|%-37s|", "1. Construire batiment") + "\n";
		sRet += String.format("|%-37s|", "2. Placer ouvrier")      + "\n";
		sRet += String.format("|%-37s|", "3. Echanger trois pièces") + "\n";
		sRet += String.format("|%-37s|", "4. Quitter le jeu")      + "\n";
		sRet += "+=====================================+\n";

		Console.println(sRet);
	}

	public void afficherMenuNourriture(String sCoul)
	{
		String sRet = "";

		sRet += "=======================================\n";
		sRet += String.format("|%-37s|", "Espace nourriture " + sCoul) + "\n";
		sRet += "=======================================\n";
		sRet += String.format("|%-37s|", "   Quantite à 0 par défaut"  ) + "\n";
		sRet += String.format("|%-37s|", "1. Quantite de poisson"  ) + "\n";
		sRet += String.format("|%-37s|", "2. Quantite de blé"  ) + "\n";
		sRet += String.format("|%-37s|", "3. Quantité de pièce") + "\n";
		sRet += String.format("|%-37s|", "4. Valider") + "\n";
		sRet += "=======================================\n";

		Console.println(sRet);
	}

	public void afficherDemandePourNourriture(String sType)
	{
		Console.println("=======================================\n" +
		                String.format("|%-37s|", "Saisir quantité de " + sType) + "\n" +
		                "=======================================\n");
	}

	public void afficherMenuConstructionBatiment()
	{
		String sRet = "";

		sRet += "=======================================\n";
		sRet += String.format("|%-37s|", "Espace Construction " + this.ctrl.getCouleurJoueur()) + "\n";
		sRet += "=======================================\n";
		sRet += String.format("|%-37s|", "1. Entrer les coordonnees") + "\n";
		sRet += String.format("|%-37s|", "2. Entrer le numéro du batiment") + "\n";
		sRet += String.format("|%-37s|", "3. Construire le batiment") + "\n";
		sRet += String.format("|%-37s|", "4. Afficher Objectifs.") + "\n";
        sRet += String.format("|%-37s|", "5. Quitter le menu de construction.") + "\n";
		sRet += "=======================================\n";

		Console.println(sRet);
	}

	public void afficherMenuEchangePiece()
	{
		String sRet = "";

		sRet += "=======================================\n";
		sRet += String.format("|%-37s|", "Espace changement de piece " + this.ctrl.getCouleurJoueur()) + "\n";
		sRet += "=======================================\n";
		sRet += String.format("|%-37s|", "Veuillez entrer une ressource") + "\n";
		sRet += "=======================================\n";

		Console.println(sRet);
	}

	public void afficherMenuSaisie(String sTypeSaisie)
	{

		String sRet = "";

		sRet += "=======================================\n";
		sRet += String.format("|%-37s|", "Espace Saisie ") + "\n";
		sRet += "=======================================\n";


		if(sTypeSaisie.equals("Coord"))
			sRet += String.format("|%-37s|", "Veuillez entrer une coordonnée") + "\n";

		if(sTypeSaisie.equals("Type"))
			sRet += String.format("|%-37s|", "Veuillez entrer un numéro de batiment") + "\n";

		if(sTypeSaisie.equals("TypeR"))
			sRet += String.format("|%-37s|", "Veuillez entrer un type de ressource") + "\n";

		if(sTypeSaisie.equals("Qte"))
			sRet += String.format("|%-37s|", "Veuillez entrer une quantité") + "\n";

		if (sTypeSaisie.equals("Donner"))
			sRet += String.format("|%-37s|", "Ressources à donner : ") + "\n";

		if (sTypeSaisie.equals("Obtenir"))
			sRet += String.format("|%-37s|", "Ressources à obtenir : ") + "\n"; 

		sRet += "=======================================\n";

		Console.println(sRet);
	}


	public String afficherCoord()
	{
		return String.format("|%-37s|", "Veuillez entrer une coordonnée") + "\n";
	}

	public void afficherMenuPlacementOuvrier()
	{
		String sRet = "";

		sRet += "=======================================\n";
		sRet += String.format("|%-37s|", "Espace Ouvrier " + this.ctrl.getCouleurJoueur()) + "\n";
		sRet += "=======================================\n";
		sRet += String.format("|%-37s|", "1. Saisir coordonnées.") + "\n";
		sRet += String.format("|%-37s|", "2. Quitter."           ) + "\n";
		sRet += "=======================================\n";

		Console.println(sRet);
	}

	public void afficherMenuActivation()
	{
		String sRet = "";

		sRet += "=======================================\n";
		sRet += String.format("|%-37s|", "1. Afficher detail sur batiment." ) + "\n";
		sRet += String.format("|%-37s|", "2. Saisir coordonnées.") + "\n";
		sRet += String.format("|%-37s|", "3. Joueur suivant."    ) + "\n";
		sRet += "=======================================\n";

		Console.println(sRet);
	}

	public void demanderBatiment()
	{
		String sRet = "";

		sRet += "=======================================\n";
		sRet += String.format("|%-37s|", "Saisissez le numéro du batiment:" ) + "\n";
		sRet += "=======================================\n";
	

		Console.println(sRet);		
	}
	
	public void afficherInfo(BatimentInfo b)
	{
		if ( b != null )Console.println( b.toStringInfoActivation() );
	}

	public void mettreIhmAJour(){ this.mettreIhmAJour(""); }

	public void mettreIhmAJour(String sMess)
	{
		//Console.effacerEcran();
		Console.println(this.getHeader());
		this.afficherPlateau();
		this.plateauBas(sMess);
	}

    public void afficherObj()
    {
        Console.println( ctrl.getObj1() );

        Console.println( ctrl.getObj2() );
    }

	public void afficherPreteurSurGage()
	{
		Console.println( "+==========================================+\n" +
			             "|Preteur sur Gage :                        |\n" +
		                 "+==========================================+\n" +
		                 "|Quelles ressources souhaitez vous echanger|\n" +
						 "|Au format(ressource1 ressource2)          |\n" +
						 "|Exemple : \"BOIS BLE\"                      |\n" +  
		                 "+==========================================+");
	}


}
