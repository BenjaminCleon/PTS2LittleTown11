import equipe_11.metier.Pion;

public class Scenario1
{
    private Controleur ctrl;

    private Pion[][]   plateau;

    public Scenario1( Controleur ctrl )
    {
        this.ctrl = ctrl;
        
        this.plateau = ctrl.getPlateau();

        
    }
}
