package littletown.metier;

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

	public Jeu()
	{
		this.tabCase    = new String[6][9];
		this.tabJoueurs = new Joueur[2];

		this.initPlateau(1);
	}

	public String[][] getPlateau() { return this.tabCase; }

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
			String[][] tabCase = {{"PIERRE",     "", "BOIS", "PIERRE",    "", "EAU",     "", "PIERRE", "PIERRE"},
								  {      "",     "",     "",       "",    "",    "",     "",       "",       ""},
								  {   "EAU",     "",     "",       "",    "",    "",     "",       "",       ""},
								  {  "BOIS",     "",     "",       "",    "",    "",     "",       "",    "EAU"},
								  {      "",     "",     "",       "",    "",    "", "BOIS",       "",       ""},
								  {      "", "BOIS", "BOIS",       "", "EAU", "EAU",     "",       "",   "BOIS"}};
			this.tabCase = tabCase;
		}
	}

}
