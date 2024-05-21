import inter.IRessource;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class Pioche implements IRessource
{
	private ArrayList<Jeton> pioche ;

	public Pioche()
	{
		this.initPioche();
	}

	public Jeton tirerJeton()
	{
		return this.pioche.get(this.pioche.size());
	}

	private void initPioche() 
	{
		this.pioche = new ArrayList<Jeton>();

		this.pioche.add(Epice.POIVRE);


/*	Ordre des jetons : 

Poivre
Sumac
Curcuma
Cardamone
Or
Safran
Sesame
Poivre
Argent
Argent
Paprika
Safran
Safran
Safran
Cannelle

*/
	}

}