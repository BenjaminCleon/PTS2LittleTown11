package equipe_11.metier;

public class Pion
{
    private int  iLig;
    private char cCol;

    private String sCoul;
    
    public Pion(int iLig, char cCol, String sCoul)
    {
        this.iLig = iLig;
        this.cCol = cCol;

        this.sCoul = sCoul;
    }

    public String getCoul(){ return this.sCoul; }
}
