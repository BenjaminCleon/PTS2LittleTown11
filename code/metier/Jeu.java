package equipe_11.metier;

import equipe_11.metier.BatimentInfo;

public class Jeu 
{
	/**
	 * ensemble des cases sur le plateau
	 */
	private String[][] tabCase ;

	/**
	 * ensemble des joueurs qui composeront la partie
	 */
	private Joueur[]  tabJoueurs;

	/**
	 * Constructeur de la classe Jeu
	 * Initialise tous les attributs
	 */
	public Jeu()
	{
		this.tabCase    = new String[6][9];
		this.tabJoueurs = new Joueur[2];

		this.tabJoueurs[0] = new Joueur("Rouge", 5, 7, 4);
		this.tabJoueurs[1] = new Joueur("Bleu" , 5, 7, 4);

		this.initPlateau(1);
	}

	/**
	 * Retourne le plateau
	 * @return un tableau à deux dimensions de String
	 */
	public String[][] getPlateau() { return this.tabCase; }

	/**
	 * Permet de charger le plateau avec les cases par défauts.
	 * @param iNumPlateau
	 *        Le numéro du plateau sur lequel on veux jouer ( 1 ou 2 )
	 */
	public void initPlateau(int iNumPlateau)
	{
		if ( iNumPlateau == 1 )
		{
			String[][] tabCase = {{"PIERRE",     "", "BOIS", "PIERRE",    "", "EAU",     "", "PIERRE", "PIERRE"},
								  {      "",     "",     "",       "",    "",    "",     "",       "",       ""},
								  {   "EAU",     "",     "",       "",    "",    "",     "",       "",       ""},
								  {  "BOIS",     "",     "",       "",    "",    "",     "",       "",    "EAU"},
								  {      "",     "",     "",       "",    "",    "", "BOIS",       "",       ""},
								  {      "", "BOIS", "BOIS",       "", "EAU", "EAU",     "",       "",   "BOIS"}};
			this.tabCase = tabCase;
		}

		if ( iNumPlateau == 2 )
		{
			String[][] tabCase = {{"BOIS", "",     "", "PIERRE", "PIERRE",    "", "EAU", "",   "BOIS"},
								  {    "", "", "BOIS",       "",       "",    "",    "", "",       ""},
								  {"BOIS", "",     "",       "",       "",    "",    "", "",    "EAU"},
								  {    "", "",     "",       "",       "",    "",    "", "",   "BOIS"},
								  { "EAU", "",     "",       "",   "BOIS",    "",    "", "",       ""},
								  { "EAU", "",     "", "PIERRE",       "",    "", "EAU", "", "PIERRE"}};
			this.tabCase = tabCase;
		}
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
		if ( iLig >       this.tabCase   .length -1 || iLig < 0 ||
		     cCol > 'A' + this.tabCase[0].length -1 || cCol < 'A' ) return false;

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

		if ( !this.tabCase[iLig][cCol-'A'].isEmpty() )return false;

		if ( jTmp.getRessource("EAU") < iEau || jTmp.getRessource("PIERRE") < iPierre ||
		     jTmp.getRessource("BLE") < iBle || jTmp.getRessource("BOIS"  ) < iBois    )
			 return false;

		jTmp.consommerRessource(iPierre, "PIERRE");
		jTmp.consommerRessource(iBle   , "BLE"   );
		jTmp.consommerRessource(iBois  , "BOIS"  );
		jTmp.consommerRessource(iEau   , "EAU"   );

		jTmp.ajouterBatiment(bTmp, iLig, cCol);
		this.tabCase[iLig][cCol-'A'] = bTmp.name();

		return true;
	}
}
