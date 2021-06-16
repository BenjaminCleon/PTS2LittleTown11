package equipe_11.metier;

/**
 *Cette classe correspond au pion du joueur, elle permet d'obtenir les diverses informations
 *
 * @author Equipe 11
 */
public class Pion
{
	/**
	 *	ligne sur laquelle est positionné le pion
	 */
    private int  iLig;
    /**
	 *	collonne sur laquelle est positionné le pion
	 */
    private char cCol;
	/**
	 *	couleur du pion
	 */
    private String sCoul;
    /**
	 *	type du pion
	 */
    private String sNom ;
    
    /**
	 *	Constructeur de Pion
	 *
	 * @param iLig
	 *		ligne sur laquelle est positionné le pion
	 * @param cCol
	 *		colonne sur laquelle est positionné le pion
	 * @param sCoul
	 *		couleur du joueur
	 * @param sNom
	 *		type du pion
	 */
    public Pion(int iLig, char cCol, String sCoul, String sNom)
    {
        this.iLig = iLig;
        this.cCol = cCol;

        this.sCoul = sCoul;
        this.sNom  = sNom ;
    }
	/**
	 * retourne la couleur du pion
	 *
	 * @return
	 *		la couleur du pion
	 */
    public String getCoul(){ return this.sCoul; }
    /**
	 * retourne le type du pion
	 *
	 * @return
	 *		le type du pion
	 */
    public String getNom (){ return this.sNom ; }
	/**
	 * retourne la ligne sur laquelle est positionné le pion
	 *
	 * @return
	 *		la ligne sur laquelle est positionné le pion
	 */
    public int  getLig(){ return this.iLig; }
     /**
	 * retourne la colonne sur laquelle est positionné le pion
	 *
	 * @return
	 *		la colonne sur laquelle est positionné le pion
	 */
    public char getCol(){ return this.cCol; }
    /**
     * Met un type au pion
     */
    public void   setNom ( String sNom ){ this.sNom = sNom; }

	/**
	 * retourne le nom du pion
	 * 
	 * @return
	 * 		le nom du pion
	 */
    public String toString()
    {
        return this.sNom;
    }
}
