package equipe_11.metier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import equipe_11.metier.BatimentInfo;
import equipe_11.metier.Pion;

import java.util.ArrayList;

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
	private int nbChampsDeBle;

	/**
	 * Constructeur de la classe Jeu
	 * Initialise uniquement tabPion
	 */
	public Jeu()
	{
		this.nbChampsDeBle = 5;
		this.tabPion       = new Pion[6][9];
		this.alBat         = BatimentInfo.getLstBat();

		this.alBat.remove(BatimentInfo.CHAMPSDEBLE);
		this.alBat.remove(BatimentInfo.PIERRE     );
		this.alBat.remove(BatimentInfo.BOIS       );
		this.alBat.remove(BatimentInfo.EAU        );

		Collections.shuffle(this.alBat);

		for ( int i=0;this.alBat.size()>12;i++)this.alBat.remove(i);
		this.alBat.add(BatimentInfo.CHAMPSDEBLE);
	}
	
	public void setNumJoueur(int iNbJoueur)
	{
		this.tabJoueurs[iNbJoueur-1].setNumJoueur(iNbJoueur+1);
	}
	
	public void setNomJoueur(int iNbJoueur, String sNomJoueur)
	{
		this.tabJoueurs[iNbJoueur-1].setNomJoueur(sNomJoueur);
	}

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
			default -> { this.iNbOuvrierMax = 5; this.iNbBatimentMax = 7; }
		}

		for ( int i=0;i<this.iNbJoueur;i++)
			this.tabJoueurs[i] = new Joueur(ensCouleur[i], this.iNbOuvrierMax, this.iNbBatimentMax, 4);
		
		this.jCourant    = this.tabJoueurs[0];
		
		return true;
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
			String[][] tabCase = {{"PIERRE",     "", "BOIS", "PIERRE",    "", "EAU",     "", "PIERRE", "PIERRE"},
								  {      "",     "",     "",       "",    "",    "",     "",       "",       ""},
								  {   "EAU",     "",     "",       "",    "",    "",     "",       "",       ""},
								  {  "BOIS",     "",     "",       "",    "",    "",     "",       "",    "EAU"},
								  {      "",     "",     "",       "",    "",    "", "BOIS",       "",       ""},
								  {      "", "BOIS", "BOIS",       "", "EAU", "EAU",     "",       "",   "BOIS"}};
			ensCase = tabCase;
		}

		if ( iNumPlateau == 2 )
		{
			String[][] tabCase = {{"BOIS", "",     "", "PIERRE", "PIERRE",    "", "EAU", "",   "BOIS"},
								  {    "", "", "BOIS",       "",       "",    "",    "", "",       ""},
								  {"BOIS", "",     "",       "",       "",    "",    "", "",    "EAU"},
								  {    "", "",     "",       "",       "",    "",    "", "",   "BOIS"},
								  { "EAU", "",     "",       "",   "BOIS",    "",    "", "",       ""},
								  { "EAU", "",     "", "PIERRE",       "",    "", "EAU", "", "PIERRE"}};
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
		sType = sType.toUpperCase();

		BatimentInfo bTmp = BatimentInfo.rechercherBatiment(sType);
		Joueur   jTmp = this.tabJoueurs[iNumJoueur-1];
		Pion     pTmp;

		if ( bTmp == null )return false;

		int iPierre = bTmp.getPierreReq();
		int iBle    = bTmp.getBleReq   ();
		int iBois   = bTmp.getBoisReq  ();
		int iEau    = bTmp.getEauReq   ();

		if ( this.jCourant.getNbBatiment() == this.iNbBatimentMax )return false;

		if ( ! sType.equals("CHAMPSDEBLE") )
		{
			for ( Joueur j : this.tabJoueurs )
				for ( Pion bt : j.getBatiments() )if ( bt.getNom().equals(bTmp.name()) )return false;
		}

		if ( !this.tabPion[iLig - 1][cCol-'A'].getNom().isEmpty() )return false;

		if ( bTmp.estRessource() || 
		     jTmp.getRessource("EAU") < iEau || jTmp.getRessource("PIERRE") < iPierre ||
		     jTmp.getRessource("BLE") < iBle || jTmp.getRessource("BOIS"  ) < iBois   )
			 return false;

		this.gererRessourceReq(bTmp);

		pTmp = new Pion(iLig-1, cCol, this.jCourant.getCouleur(), sType);
		jTmp.ajouterBatiment(pTmp, bTmp);
		this.tabPion[iLig - 1][cCol-'A'] = pTmp;

		this.verifierManche();
		this.jCourant = this.tabJoueurs[++this.iNumJCourant%2];

		return true;
	}

	/**
	 * 
	 * @param iLig
	 *     Position de la ligne de l'ouvrier
	 * @param cCol
	 *     Position de la colonne de l'ouvrier
	 */
	public boolean ajouterOuvrier(int iLig, char cCol)
	{
		if ( !this.tabPion[iLig-1][cCol - 'A'].getNom().isEmpty() )return false;
		
		Pion pTmp1, pTmp2;
		BatimentInfo bTmp;		
		
		int iLigDepTab = 0, iLigFinTab = 0;
		int iColDepTab = 0, iColFinTab = 0;

		iLig--;
		if ( iLig > 0                        )iLigDepTab = iLig-1; else iLigDepTab = iLig;
		if ( iLig <  this.tabPion.length - 1 )iLigFinTab = iLig+1; else iLigFinTab = iLig;

		if ( cCol > 'A'                              )iColDepTab = cCol-1- 'A'; else iColDepTab=cCol-'A';
		if ( cCol <  this.tabPion[0].length + 'A' -1 )iColFinTab = cCol+1- 'A'; else iColFinTab=cCol-'A';

		pTmp1 = new Pion(iLig, cCol, this.jCourant.getCouleur(), "OUVRIER");
		
		bTmp = null;
		for (int iLigTab=iLigDepTab; iLigTab<=iLigFinTab; iLigTab++)
			for (int iColTab=iColDepTab; iColTab<=iColFinTab; iColTab++)
			{
				pTmp2 = this.tabPion[iLigTab][iColTab];
				// activation automatique des ressources qui ne couteront rien au joueur
				if ( pTmp2.getCoul().equals(this.jCourant.getCouleur()) ||
				     pTmp2.getCoul().equals("BLANC") )
				{
					bTmp = BatimentInfo.rechercherBatiment(pTmp2.getNom());
					this.gererActivation(bTmp);
				}
			}

		this.tabPion[iLig][cCol - 'A'] = pTmp1; 
		this.jCourant.ajouterOuvrier(pTmp1);

		this.jCourant = this.tabJoueurs[++this.iNumJCourant%this.iNbJoueur];
		this.verifierManche();
		return true;
	}

	public void gererActivation(BatimentInfo bTmp)
	{
		if ( bTmp != null )
		{
			if( bTmp.estGain() || bTmp.estRessource() )
				this.gererRessourceRec(bTmp);
			else if ( bTmp.estEchange() &&
			          this.verifierEchange(bTmp.getBleReA(), bTmp.getPierreReA(),
					                       bTmp.getEauReA(), bTmp.getBoisReA  (),
										   bTmp.getPieceReA()  ))
				 	this.gererRessourceRec(bTmp);
				 else
				 {;
					// this.ctrl.demanderRessource();
					// this.ctrl.demanderRessource();
				 }

		}
	}

	public boolean verifierEchange( int iBle, int iPierre, int iEau, int iBois, int iPiece )
	{
		if ( this.jCourant.getRessource("BLE") < iBle || this.jCourant.getRessource("BOIS")   < iBois   ||
		     this.jCourant.getRessource("EAU") < iEau || this.jCourant.getRessource("PIERRE") < iPierre ||
			 this.jCourant.getNbPiece() < iPiece )return false;

		return true;
	}

	public void gererRessourceRec( BatimentInfo bTmp )
	{
		this.jCourant.gererRessource(bTmp.getBleRec   (), "BLE"   );
		this.jCourant.gererRessource(bTmp.getBoisRec  (), "BOIS"  );
		this.jCourant.gererRessource(bTmp.getPierreRec(), "PIERRE");
		this.jCourant.gererRessource(bTmp.getEauRec   (), "EAU"   );
	}

	public void gererRessourceReq( BatimentInfo bTmp )
	{
		this.jCourant.gererRessource(-bTmp.getBleReq   (), "BLE"   );
		this.jCourant.gererRessource(-bTmp.getBoisReq  (), "BOIS"  );
		this.jCourant.gererRessource(-bTmp.getPierreReq(), "PIERRE");
		this.jCourant.gererRessource(-bTmp.getEauReq   (), "EAU"   );
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
		Pion pTmp = this.tabPion[iLig][cCol-'A'];

		if ( !pTmp.getCoul().equals(jCourant.getCouleur()) )
		{
			for ( Joueur j : this.tabJoueurs )
				if ( j.getCouleur().equals(pTmp.getCoul()) )j.setPiece(1);
				
			this.jCourant.setPiece(-1);
		}

		return false;
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
	 *        Si la macnhe est passé ou non
	 */
	public boolean verifierManche()
	{
		for ( Joueur j : this.tabJoueurs )
		{
			System.out.println(!j.estNourri());
			if ( ! j.estNourri() )return false;
		}
		

		for( int i = 0; i < tabPion.length; i++)
		{
			for( int j = 0; j < tabPion[0].length; j++)
			{
				Pion pTmp = this.tabPion[i][j];

				if ( pTmp.getNom().equals("OUVRIER") ) pTmp = new Pion(pTmp.getLig(), pTmp.getCol(), "BLANC", "");
			}
		}

		this.iNumManche ++;

		for( Joueur j : this.tabJoueurs)
			j.resetJoueur();

		return true;
	}

	public boolean isToutOuvriersPose()
	{
		for( int i = 0; i < this.tabJoueurs.length; i++ )
		{
			Joueur jTmp = this.tabJoueurs[i];

			if ( jTmp.getNbOuvrier() != this.iNbOuvrierMax )return false;
		}
		return true;
	}

	public int getNumManche(){ return this.iNumManche; }

	public ArrayList<BatimentInfo> getLstNomBat()
	{
		return this.alBat;
	}

	public boolean echangerPieceContreRessource( String sTypeRes )
	{

		if(!sTypeRes.matches("^(BLE|BOIS|PIERRE|EAU)$"))
			return false;

		if(this.jCourant.getNbPiece() >= 3)
		{
			this.jCourant.gererRessource( 1, sTypeRes );
			this.jCourant.setPiece(-3);
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

	public Joueur[] getJoueurs()
	{
		return this.tabJoueurs;
	}
}
