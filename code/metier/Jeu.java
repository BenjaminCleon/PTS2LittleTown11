package equipe_11.metier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Function;

import equipe_11.BatimentInfo;
import equipe_11.metier.Pion;

public class Jeu 
{
	/**
	 * Nombre de batiment max
	 */
	private int iNbBatimentMax;

	/**
	 * Nombre d'ouvrier max
	 */
	private int iNbOuvrierMax;

	/**
	 * Joueur en train de jouer
	 */
	private Joueur jCourant;

	/**
	 * Numero du joueur courant
	 */
	private int iNumJCourant;

	/**
	 * Le nombre de joueurs de la partie
	 */
	private int iNbJoueur;

	/**
	 * ensemble des cases sur le plateau
	 */
	private Pion[][] tabPion ;

	/**
	 * ensemble des joueurs qui composeront la partie
	 */
	private Joueur[]  tabJoueurs;

	/**
	 * ensemble des batiment sur le marché
	 */
	private ArrayList<BatimentInfo> alBat;

	/**
	 * le numéro de la manche courante
	 */
	private int iNumManche;

	/**
	 * Le nombre de champs de blé dans le jeu
	 */
	private int iNbChampsDeBle;

	private boolean preteurSurGage;

	/**
	 * Constructeur de la classe Jeu
	 * Initialise uniquement tabPion
	 */
	public Jeu()
	{
		this.iNbChampsDeBle = 5;
		this.iNumManche     = 1;
		this.tabPion        = new Pion[6][9];
		this.alBat          = BatimentInfo.getLstBat();

		this.alBat.remove(BatimentInfo.CHAMPSDEBLE);
		this.alBat.remove(BatimentInfo.PIERRE     );
		this.alBat.remove(BatimentInfo.BOIS       );
		this.alBat.remove(BatimentInfo.POISSON    );

		Collections.shuffle(this.alBat);

		for ( int i=0;this.alBat.size()>12;i++)this.alBat.remove(i);
		this.alBat.add(BatimentInfo.CHAMPSDEBLE);
	}
	
	/**
	 * Permet d'affecter un nom au joueur
	 * @param iNbJoueur
	 *       Le numéro du joueur dans le tableau de joueur du jeu
	 * @param sNomJoueur
	 *       Le nom du joueur
	 */
	public void setNomJoueur(int iNbJoueur, String sNomJoueur)
	{
		this.tabJoueurs[iNbJoueur].setNomJoueur(sNomJoueur);
	}

	/**
	 * Retourne le nombre de joueurs
	 * @return
	 *    Le nombre de joueurs
	 */
	public int getNbJoueur(){ return this.tabJoueurs.length; }

	/**
	 * Cette methode permet d'initialiser le plateau selon le numéro
	 * @param iNumPlateau
	 *        numéro du plateau 1 ou 2
	 * @return
	 *        true si le plateau est bien créer
	 */
	public boolean setNumPlateau( int iNumPlateau )
	{
		if ( iNumPlateau != 1 && iNumPlateau != 2 )return false;

		this.initPlateau(iNumPlateau);
		return true;
	}

	/**
	 * Permet d'obtenir toutes les toString de chaque joueur dans une seule String
	 * @return
	 *        Une String contenant la toString de chaque joueur
	 */
	public String getRessourceAllJoueur()
	{
		String sRet = "";
		for ( Joueur j : this.getJoueurs() )
			sRet += j.toString();

		return sRet;
	}

	/**
	 * Appel la méthode nourrir ouvrier simple du joueur en paramètre
	 * La méthode appeler nourri les ouvriers d'un joeur avec des réglages par défaut s'il n'a pas assez de ressources
	 * ou exactement le compte
	 * @param iNumJoueur
	 * @return
	 */
	public boolean nourrirOuvrier(int iNumJoueur)
	{
		return this.tabJoueurs[iNumJoueur].nourrirOuvrier();
	}

	public String nourrirOuvrier(int iQtePoisson, int iQteBle, int iQtePiece, int iNumJoueur)
	{
		return this.tabJoueurs[iNumJoueur].nourrirOuvrier(iQtePoisson, iQteBle, iQtePiece);
	}

	public String getCouleurJoueurCourant(){ return this.jCourant.getCouleur();	}

	/**
	 * Créer le tableau de joueur avec lenombre de joueur donné en paramètre
	 * Initialise le joueur courant au premier joueur
	 * Initialise la constante iNbJoueur
	 * @param iNbJoueur
	 *       le nombre de joueur
	 * @return
	 *       true si cela à réussi
	 */
	public boolean setJoueur( int iNbJoueur )
	{
		String[] ensCouleur = { "Rouge", "Bleu", "Jaune", "Vert" };

		this.iNbJoueur = iNbJoueur;
		this.tabJoueurs  = new Joueur[this.iNbJoueur];

		switch ( this.iNbJoueur )
		{
			case 3  -> { this.iNbOuvrierMax = 4; this.iNbBatimentMax = 6; }
			case 4  -> { this.iNbOuvrierMax = 3; this.iNbBatimentMax = 6; }
			default -> { this.iNbOuvrierMax = 2; this.iNbBatimentMax = 7; }
		}

		for ( int i=0;i<this.iNbJoueur;i++)
			this.tabJoueurs[i] = new Joueur(ensCouleur[i], this.iNbOuvrierMax, this.iNbBatimentMax, 4);
		
		this.jCourant    = this.tabJoueurs[0];

		return true;
	}

	public String getCouleurJoueur(int i)
	{
		return this.tabJoueurs[i].getCouleur().toLowerCase();
	}

	/**
	 * Retourne le plateau
	 * @return un tableau à deux dimensions de String
	 */
	public Pion[][] getPlateau() { return this.tabPion; }

	/**
	 * Permet de charger le plateau avec les cases par défauts.
	 * @param iNumPlateau
	 *        Le numéro du plateau sur lequel on veux jouer ( 1 ou 2 )
	 */
	public void initPlateau(int iNumPlateau)
	{
		String[][] ensCase = new String[6][9];

		if ( iNumPlateau == 1 )
		{
			String[][] tabCase = {{    "PIERRE",     "", "BOIS", "PIERRE",        "", "POISSON",     "", "PIERRE", "PIERRE"},
								  {          "",     "",     "",       "",        "",        "",     "",       "",       ""},
								  {   "POISSON",     "",     "",       "",        "",        "",     "",       "",       ""},
								  {      "BOIS",     "",     "",       "",        "",        "",     "",       "","POISSON"},
								  {          "",     "",     "",       "",        "",        "", "BOIS",       "",       ""},
								  {          "", "BOIS", "BOIS",       "", "POISSON", "POISSON",     "",       "",   "BOIS"}};
			ensCase = tabCase;
		}

		if ( iNumPlateau == 2 )
		{
			String[][] tabCase = {{    "BOIS", "",     "", "PIERRE", "PIERRE",    "", "POISSON", "",   "BOIS"},
								  {        "", "", "BOIS",       "",       "",    "",        "", "",       ""},
								  {    "BOIS", "",     "",       "",       "",    "",        "", "","POISSON"},
								  {        "", "",     "",       "",       "",    "",        "", "",   "BOIS"},
								  { "POISSON", "",     "",       "",   "BOIS",    "",        "", "",       ""},
								  { "POISSON", "",     "", "PIERRE",       "",    "", "POISSON", "", "PIERRE"}};
			ensCase = tabCase;
		}

		for ( int lig=0;lig<this.tabPion.length;lig++)
			for ( int col=0;col<this.tabPion[0].length;col++)
				this.tabPion[lig][col] = new Pion(lig, (char)('A' + col), "BLANC", ensCase[lig][col]);
	}

	/**
	 * 
	 * @param iNumJoueur
	 *      Le numéro du Joueur
	 * @param sType
	 *      Le type du batiment que l'on veux construire
	 * @param iCol
	 *      La colonne où l'on veux construire le batiment
	 * @param iLig
	 *      La ligne où l'on veux construire le batiment
	 * @return
	 *      true si le batiment est construit
	 */
	public boolean construireBatiment(int iNumJoueur, String sType, int iLig, char cCol)
	{
		if ( iLig >       this.tabPion   .length    || iLig < 0 ||
		     cCol > 'A' + this.tabPion[0].length -1 || cCol < 'A' ) return false;

		BatimentInfo bTmp = BatimentInfo.rechercherBatiment(sType);
		Joueur   jTmp = this.tabJoueurs[iNumJoueur-1];
		Pion     pTmp;
		boolean bOk = false;

		if ( bTmp == null )return false;

		for ( BatimentInfo b : this.alBat )
			if ( b == bTmp )bOk = true;

		System.out.println(bOk);
		if ( !bOk )return false;

		int iPierre  = bTmp.getPierreReq ();
		int iBle     = bTmp.getBleReq    ();
		int iBois    = bTmp.getBoisReq   ();
		int iPoisson = bTmp.getPoissonReq();

		if ( this.jCourant.getNbBatiment() == this.iNbBatimentMax )return false;

		if ( ! sType.equals("CHAMPSDEBLE") )
		{
			for ( Joueur j : this.tabJoueurs )
				for ( Pion bt : j.getBatiments() )if ( bt.getNom().equals(bTmp.name()) )return false;
		}

		if ( !this.tabPion[iLig - 1][cCol-'A'].getNom().isEmpty() )return false;

		if ( bTmp.estRessource() || 
		     jTmp.getQteRessource("POISSON") < iPoisson || jTmp.getQteRessource("PIERRE") < iPierre ||
		     jTmp.getQteRessource("BLE")     < iBle     || jTmp.getQteRessource("BOIS"  ) < iBois   )
			 return false;

		this.gererRessource(bTmp::getReq, -1);

		pTmp = new Pion(iLig-1, cCol, this.jCourant.getCouleur(), sType);
		jTmp.ajouterBatiment(pTmp, bTmp);
		this.tabPion[iLig - 1][cCol-'A'] = pTmp;

		if( bTmp == BatimentInfo.CHAMPSDEBLE && this.iNbChampsDeBle > 0)
		{
			this.iNbChampsDeBle--;
			if( this.iNbChampsDeBle == 0 )
				this.alBat.remove(bTmp);
		}
		else
			this.alBat.remove(bTmp);

		this.changerJoueur();

		return true;
	}

	public int[] gererCoordonneeAutourDuJoueur(int iLig, char cCol)
	{
		//                 ligDeb, ligFin, colDeb, colFin
		int[] coordonees = {    0,      0,      0,      0};

		iLig--;
		if ( iLig > 0                        )coordonees[0] = iLig-1; else coordonees[0] = iLig;
		if ( iLig <  this.tabPion.length - 1 )coordonees[1] = iLig+1; else coordonees[1] = iLig;

		if ( cCol > 'A'                              )coordonees[2] = cCol-1- 'A'; else coordonees[3]=cCol-'A';
		if ( cCol <  this.tabPion[0].length + 'A' -1 )coordonees[3] = cCol+1- 'A'; else coordonees[3]=cCol-'A';

		return coordonees;
	}

	/**
	 * Permet d'ajouter des ouvriers au joueur courant
	 * Active les batiments qui n'engendre aucune perte au joueur
	 * @param iLig
	 *     Position de la ligne de l'ouvrier
	 * @param cCol
	 *     Position de la colonne de l'ouvrier
	 */
	public boolean ajouterOuvrier(int iLig, char cCol)
	{
		this.jCourant.clearLstBatimentAutourOuvrier();
		if ( !this.tabPion[iLig-1][cCol - 'A'].getNom().isEmpty() )return false;
		
		Pion pTmp1, pTmp2;
		BatimentInfo bTmp;		
		
		int[] coordonees = this.gererCoordonneeAutourDuJoueur(iLig, cCol);		

		pTmp1 = new Pion(iLig-1, cCol, this.jCourant.getCouleur(), "OUVRIER");
		
		bTmp = null;

		for (int iLigTab=coordonees[0]; iLigTab<=coordonees[1]; iLigTab++)
			for (int iColTab=coordonees[2]; iColTab<=coordonees[3]; iColTab++)
			{
				pTmp2 = this.tabPion[iLigTab][iColTab];
				if ( !pTmp2.getNom().equals ("") )
				{
					bTmp = BatimentInfo.rechercherBatiment(pTmp2.getNom());
					this.gererActivation(bTmp);
				}
			}

		this.tabPion[iLig-1][cCol - 'A'] = pTmp1; 
		this.jCourant.ajouterOuvrier(pTmp1);

		return true;
	}

	/**
	 * Permet d'activer les batiments qui n'engendre pas de perte au joueur
	 * Permet d'ajouter les batiments engendrant des pertes à l'utilisateur dans une liste tmporaire
	 * @param
	 *     Le batiment que l'on souhaite activer
	 */
	public void gererActivation(BatimentInfo bTmp)
	{
		if ( bTmp != null )
		{
			if ( bTmp.estRessource() )this.gererRessource(bTmp::getRec, 1);
			else if ( ! bTmp.estSpecial() )
			{
				this.jCourant.ajouterBatimentAListeTmp(bTmp);
			}
		}
	}

	/**
	 * Retourne les batiments autres que des ressources autour du dernier ouvrier posé
	 * @return
	 *     La liste des batiments autour du dernier ouvrier posé ( autre que les ressources )
	 */
	public ArrayList<BatimentInfo> getLstBatimentAutourOuvrier()
	{
		return this.jCourant.getLstBatimentAutourOuvrier();
	}

	public boolean verifierEchange( int iBle, int iPierre, int iPoisson, int iBois, int iPiece )
	{
		if ( this.jCourant.getQteRessource("BLE")     < iBle     || this.jCourant.getQteRessource("BOIS")   < iBois   ||
		     this.jCourant.getQteRessource("POISSON") < iPoisson || this.jCourant.getQteRessource("PIERRE") < iPierre ||
			 this.jCourant.getQteRessource("PIECE")   < iPiece )return false;

		return true;
	}

	/**
	 * Cette méthode permet d'ajuster les ressources du joueur courant
	 * @param function
	 * 		Une référence sur méthode pour la gestion des ressource
	 * 		(getRea, getRec, getReq)
	 */
	public void gererRessource( Function<String, Integer> function, int signe )
	{
		this.jCourant.gererRessource(signe*function.apply("BLE"    ), "BLE"    );
		this.jCourant.gererRessource(signe*function.apply("POISSON"), "POISSON");
		this.jCourant.gererRessource(signe*function.apply("BOIS"   ), "BOIS"   );
		this.jCourant.gererRessource(signe*function.apply("PIERRE" ), "PIERRE" );
		this.jCourant.gererRessource(signe*function.apply("PIECE"  ), "PIECE"  );
	}

	public void changerJoueur()
	{
		this.jCourant = this.tabJoueurs[++this.iNumJCourant%this.iNbJoueur];
	}

	/**
	 * Cette méthode permet d'activer un batiment avec les coordonées en paramètre
	 * @param
	 *      Le numéro de la ligne pour le joueur
	 * @param
	 *      Le caractère de la colonne correspondante
	 */
	public boolean activerBatiment(int iLig, char cCol)
	{
		Pion         pTmp = this.tabPion[iLig-1][cCol-'A'];
		BatimentInfo bTmp = BatimentInfo.rechercherBatiment(pTmp.getNom());

		if ( !this.jCourant.getLstBatimentAutourOuvrier().contains(bTmp) )return false;

		if ( bTmp.estEchange() && !this.verifierEchange(bTmp.getBleReA     (), bTmp.getPierreReA(),
                                                        bTmp.getPoissonReA (), bTmp.getBoisReA  (),
			                                            bTmp.getPcReq      ()))return false;

		if( bTmp.estPreteurSurGage() ){this.preteurSurGage = true; return false;}

		this.gererPiecePendantActivation(iLig, cCol);

		if ( bTmp.estSpecial() || bTmp.estRessource() )return false;

		if (bTmp.estEchange() ) this.gererRessource(bTmp::getRea, -1);

		this.gererRessource(bTmp::getRec, 1 );

		this.jCourant.setScore(bTmp.getPtRec());
		this.jCourant.retirerBatimentAListeTmp(bTmp);

		return true;
	}

	private void gererPiecePendantActivation(int iLig, char cCol)
	{
		Pion         pTmp = this.tabPion[iLig-1][cCol-'A'];
		BatimentInfo bTmp = BatimentInfo.rechercherBatiment(pTmp.getNom());

		if ( !pTmp.getCoul().equals(jCourant.getCouleur()) )
		{
			if ( this.jCourant.getQteRessource("PIECE") == 0 )return;
			for ( Joueur j : this.tabJoueurs )
				if ( j.getCouleur().equals(pTmp.getCoul()) )
				{
					j.gererRessource(1, "PIECE");
					this.jCourant.gererRessource(-1, "PIECE");
				}
		}
	}

	public BatimentInfo getBatimentDansPlateau(int iLig, int iCol)
	{
		return  BatimentInfo.rechercherBatiment(this.tabPion[iLig][iCol].getNom());
	}

	/**
	 * Retourne le joueur en train de jouer
	 * @return 
	 *    Le joueur en train de jouer
	 */
	public Joueur getJoueurCourant(){ return this.jCourant; }

	/**
	 * Verifie si nous devons passer la manche
	 * @return
	 *        Si la manche est passé ou non
	 */
	public boolean passerManche()
	{
		for( int i = 0; i < tabPion.length; i++)
		{
			for( int j = 0; j < tabPion[0].length; j++)
				if ( this.tabPion[i][j].getNom().equals("OUVRIER") )
						this.tabPion[i][j] = new Pion(i, (char)(j + 'A'), "BLANC", "");
		}

		this.iNumManche++;

		for( Joueur j : this.tabJoueurs)
			j.resetJoueur();

		this.changerJoueur();

		return true;
	}

	public int getQteRessourceStock(String sType)
	{
		switch( sType )
		{
			case "BOIS"   -> { return Ressource.getQteBois   (); }
			case "PIERRE" -> { return Ressource.getQtePierre (); }
			case "POISSON"-> { return Ressource.getQtePoisson(); }
			case "BLE"    -> { return Ressource.getQteBle    (); }
			default       -> { return Ressource.getQtePiece  (); }
		}
	}

	public int getNbOuvrierRestantCourant()
	{
		return this.iNbOuvrierMax - this.jCourant.getNbOuvrier();
	}

	public int getNbBatimentRestantCourant()
	{
		return this.iNbBatimentMax - this.jCourant.getNbBatiment();
	}

	/**
	 * Vérifie si tous les ouvriers de tous les joueurs sont posés
	 * @return
	 *    true si tous les ouvriers sont posés
	 */
	public boolean isToutOuvriersPose()
	{
		for( int i = 0; i < this.tabJoueurs.length; i++ )
		{
			Joueur jTmp = this.tabJoueurs[i];

			if ( jTmp.getNbOuvrier() != this.iNbOuvrierMax )return false;
		}
		return true;
	}

	public boolean verifierConstruction()
	{
		boolean bOk = true;

		if ( this.jCourant.getLstBatimentAutourOuvrier().size() == 0 ) return false;

		if ( this.jCourant.getQteRessource("PIECE") == 0 )
		{
			bOk = false;
			for ( BatimentInfo b : this.jCourant.getLstBatimentAutourOuvrier() )
				for ( Pion p : this.jCourant.getBatiments())
					if ( b.name().equals(p.getNom()) )bOk = true;
		}
		
		return bOk;
	}

	public int getNbChampsDeble(){ return this.iNbChampsDeBle; }
	public int getNumManche    (){ return this.iNumManche    ; }

	public ArrayList<BatimentInfo> getLstBat()
	{
		return this.alBat;
	}

	public ArrayList<String> getLstNomBat()
	{
		return BatimentInfo.getLstNomBat();
	}

	public boolean echangerPieceContreRessource( String sTypeRes )
	{

		if(!sTypeRes.matches("^(BLE|BOIS|PIERRE|POISSON)$"))
			return false;

		if(this.jCourant.getQteRessource("PIECE") >= 3)
		{
			this.jCourant.gererRessource( 1, sTypeRes );
			this.jCourant.gererRessource(-3, "PIECE");
			return true;
		}
		
		return false;
	}

	public int getNumeroJoueurCourant()
	{
		for (int i=0;i<this.tabJoueurs.length;i++)
			if ( this.tabJoueurs[i] == this.jCourant )return i;

		return 0;
	}

	public void mettreJoueurA(int iNum){ this.jCourant = this.tabJoueurs[iNum]; }

	public Joueur[] getJoueurs()
	{
		return this.tabJoueurs;
	}

	public Joueur detVainqueur()
	{

		ArrayList<Integer> alInt = new ArrayList<Integer>();

		for ( int cpt = 0; cpt < this.tabJoueurs.length; cpt++)
			alInt.add(this.getJoueurs()[cpt].getScore());

		alInt.sort(null);

		for ( Joueur j : this.tabJoueurs )
			if ( j.getScore() == alInt.get(1) )
				return j;

		return null;
	}
	
	public void activerPreteurSurGage( String ressourceSaisi1, String ressourceSaisi2, String ressourceVoulu1, String ressourceVoulu2 )
	{
		BatimentInfo bTmp = BatimentInfo.rechercherBatiment("PRETEURSURGAGE");
		int  iLig = 0;
		char cCol = 0;

		for ( Pion[] subTabPion : this.tabPion )
			for ( Pion p2 : subTabPion )
				if ( p2.getNom().equals("PRETEURSURGAGE") )
				{
					iLig = p2.getLig()+1;
					cCol = p2.getCol();
					break;
				}

		if(
		    this.jCourant.consommerRessourcePossible(  1, ressourceSaisi1 ) &&
		    this.jCourant.consommerRessourcePossible(  1, ressourceSaisi2 ) &&
		    this.jCourant.ajouterRessourcePossible  ( -1, ressourceVoulu1 ) &&
		    this.jCourant.ajouterRessourcePossible  ( -1, ressourceVoulu2 )
		  )
		{
			this.gererPiecePendantActivation(iLig, cCol);
			this.jCourant.gererRessource(-1, ressourceSaisi1);
			this.jCourant.gererRessource(-1, ressourceSaisi2);
			this.jCourant.gererRessource( 1, ressourceVoulu1);
			this.jCourant.gererRessource( 1, ressourceVoulu2);
			this.preteurSurGage = false;
			this.jCourant.retirerBatimentAListeTmp(bTmp);
		}
	}

	public boolean getPreteurSurGage()
	{
		return this.preteurSurGage;
	}
}
