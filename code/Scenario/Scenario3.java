package equipe_11.scenario;

import equipe_11.Controleur;

import java.io.PrintWriter;
import java.io.IOException;

public class Scenario3
{
	public Scenario3(Controleur ctrl)
	{
		// try
		// {
			PrintWriter pw = new PrintWriter(System.out);
			ctrl.bouclePrincipale();
			pw.println("2");
			pw.println("Benjamin");
			pw.println("Maxence");
			pw.println("1");

			pw.close();
		// }catch(IOException e){ e.printStackTrace(); }
	}
}
