import java.awt.point;

public class Pion
{
    private Point  point;
    private String sType;
    private String sCouleur;

    public Pion ( String sType, String sCouleur, point point )
    {
        this.sType    = sType.toUpperCase();
        this.sCouleur = sCouleur;
        this.point = point;
    }

    public String getType()    { return this.sType;    }
    public String getCouleur() { return this.sCouleur; }
}