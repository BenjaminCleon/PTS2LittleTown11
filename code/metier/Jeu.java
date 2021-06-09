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
		Pion     pTmp;

		int iPierre = bTmp.getPierreReq();
		int iBle    = bTmp.getBleReq   ();
		int iBois   = bTmp.getBoisReq  ();
		int iEau    = bTmp.getEauReq   ();

		if ( ! sType.toUpperCase().equals("CHAMPSDEBLE") )
		{
			for ( Joueur j : this.tabJoueurs )
				for ( Pion bt : j.getBatiments() )if ( bt.getNom().equals(bTmp.name()) )return false;
		}

		if ( !this.tabPion[iLig - 1][cCol-'A'].getNom().isEmpty() )return false;

		if ( bTmp.estRessource() || 
		     jTmp.getRessource("EAU") < iEau || jTmp.getRessource("PIERRE") < iPierre ||
		     jTmp.getRessource("BLE") < iBle || jTmp.getRessource("BOIS"  ) < iBois   )
			 return false;

		jTmp.gererRessource(-bTmp.getPierreReq(), "PIERRE");
		jTmp.gererRessource(-bTmp.getBleReq   (), "BLE"   );
		jTmp.gererRessource(-bTmp.getBoisReq  (), "BOIS"  );
		jTmp.gererRessource(-bTmp.getEauReq   (), "EAU"   );

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
						this.jCourant.gererRessource(bTmp.getBleRec   (), "BLE"   );
						this.jCourant.gererRessource(bTmp.getBoisRec  (), "BOIS"  );
						this.jCourant.gererRessource(bTmp.getPierreRec(), "PIERRE");
						this.jCourant.gererRessource(bTmp.getEauRec   (), "EAU"   );
					}
				}
			}

		this.tabPion[iLig][cCol - 'A'] = pTmp1; 
		this.jCourant.ajouterOuvrier(pTmp1);

		this.jCourant = this.tabJoueurs[++this.iNumJCourant%this.INB_JOUEURS];
		this.verifierManche();
		return true;
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
		boolean bOk = true;

		for ( Joueur j : this.tabJoueurs )
			if ( ! j.estNourri() )return false;
		
		this.iNumManche ++;
		return true;
	}

	public int getNumManche(){ return this.iNumManche; }
}
