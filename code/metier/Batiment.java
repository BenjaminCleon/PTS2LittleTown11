package equipe_11.metier;

public class Batiment extends Pion
{
    private String sNom;

    public Batiment(int iLig, char cCol, String sCoul, String sNom)
    {
        super(iLig, cCol, sCoul);

        this.sNom = sNom;
    }

    public String getNom(){ return this.sNom; }
}
