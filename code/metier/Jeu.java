package equipe_11.metier;

import equipe_11.metier.BatimentInfo;
import equipe_11.metier.Pion;

public class Jeu 
{
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
	private final int INB_JOUEURS;

	/**
	 * ensemble des cases sur le plateau
	 */
	private Pion[][] tabPion ;

	/**
	 * ensemble des joueurs qui composeront la partie
	 */
	private Joueur[]  tabJoueurs;

	/**
	 * le numéro de la manche courante
	 */
	private int iNumManche;

	/**
	 * Constructeur de la classe Jeu
	 * Initialise tous les attributs
	 */
	public Jeu()
	{
		this.tabPion    = new Pion[6][9];
		this.tabJoueurs = new Joueur[2];

		this.tabJoueurs[0] = new Joueur("Rouge", 5, 7, 4);
		this.tabJoueurs[1] = new Joueur("Bleu" , 5, 7, 4);

		this.iNumJCourant = 0;
		this.jCourant     = this.tabJoueurs[0];
		this.INB_JOUEURS  = 2;

		this.initPlateau(1);
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

		BatimentInfo bTmp = BatimentInfo.rechercherBatiment(sType.toUpperCase());
		Joueur   jTmp = this.tabJoueurs[iNumJoueur-1];

		int iPierre = bTmp.getPierreReq();
		int iBle    = bTmp.getBleReq   ();
		int iBois   = bTmp.getBoisReq  ();
		int iEau    = bTmp.getEauReq   ();

		if ( ! sType.toUpperCase().equals("CHAMPSDEBLE") )
		{
			for ( Joueur j : this.tabJoueurs )
				for ( Batiment bt : j.getBatiments() )if ( bt.getNom().equals(bTmp.name()) )return false;
		}

		if ( !this.tabPion[iLig - 1][cCol-'A'].getNom().isEmpty() )return false;

		if ( jTmp.getRessource("EAU") < iEau || jTmp.getRessource("PIERRE") < iPierre ||
		     jTmp.getRessource("BLE") < iBle || jTmp.getRessource("BOIS"  ) < iBois    )
			 return false;

		jTmp.consommerRessource(-iPierre, "PIERRE");
		jTmp.consommerRessource(-iBle   , "BLE"   );
		jTmp.consommerRessource(-iBois  , "BOIS"  );
		jTmp.consommerRessource(-iEau   , "EAU"   );

		jTmp.ajouterBatiment(bTmp, iLig - 1, cCol);
		this.tabPion[iLig - 1][cCol-'A'].setNom(bTmp.name());

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
		if ( iLig >= 1                          )iLigDepTab = iLig-1; else iLigDepTab = iLig;
		if ( iLig <= this.tabPion[0].length     )iLigFinTab = iLig+1; else iLigDepTab = iLig;

		if ( cCol >= 'B'                        )iColDepTab = cCol-1- 'A'; else iColFinTab=cCol;
		if ( cCol <=  this.tabPion.length + 'A' )iColFinTab = cCol+1- 'A'; else iColFinTab=cCol;

		pTmp1 = new Pion(iLig, cCol, this.jCourant.getCouleur(), "OUVRIER");
		
		for (int iLigTab=iLigDepTab; iLigTab<=iLigFinTab; iLigTab++)
			for (int iColTab=iColDepTab; iColTab<=iColFinTab; iColTab++)
			{
				pTmp2 = this.tabPion[iLigTab][iColTab];
				// activation automatique des ressources qui ne couteront rien au joueur
				if ( pTmp2.getCoul().equals(this.jCourant.getCouleur()) ||
				     pTmp2.getCoul().equals("BLANC") )
				{
					bTmp = BatimentInfo.rechercherBatiment(pTmp2.getNom());
					if ( bTmp != null && bTmp.getBleReq() == 0 && bTmp.getBoisReq  () == 0 &&
					     bTmp.getEauReq() == 0 && bTmp.getPierreReq() == 0 )
					{
						this.jCourant.ajouterRessource(bTmp.getBleRec   (), "BLE"   );
						this.jCourant.ajouterRessource(bTmp.getBoisRec  (), "BOIS"  );
						this.jCourant.ajouterRessource(bTmp.getPierreRec(), "PIERRE");
						this.jCourant.ajouterRessource(bTmp.getEauRec   (), "EAU"   );
					}
				}
			}

		this.tabPion[iLig][cCol - 'A'] = pTmp1; 
		this.jCourant.ajouterOuvrier(iLig, cCol, pTmp1);

		this.jCourant = this.tabJoueurs[++this.iNumJCourant%this.INB_JOUEURS];
		this.verifierManche();
		return true;
	}

	public boolean activerBatiment(int iLig, char cCol)
	{
		Pion pTmp = this.tabPion[iLig][cCol-'A'];

		if ( !pTmp.getCoul().equals(jCourant.getCouleur()) )
		{
			for ( Joueur j : this.tabJoueurs )
				if ( j.getCouleur().equals(pTmp.getCoul()) )j.ajouterPiece(1);
				
			this.jCourant.consommerPiece(1);
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
	 */
	public void verifierManche()
	{
		boolean bOk = true;

		for ( Joueur j : this.tabJoueurs )
			if ( j.getNbOuvrier() != 3 )bOk = false;
		
		if ( bOk ) this.iNumManche ++;
	}

	public int getNumManche(){ return this.iNumManche; }
}
