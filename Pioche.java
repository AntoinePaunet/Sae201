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
		return this.pioche.get(this.pioche.size()-1);
	}

	private void initPioche() 
	{
		this.pioche = new ArrayList<Jeton>();

		this.pioche.add(new Jeton(Epice.POIVRE   ));
		this.pioche.add(new Jeton(Epice.SUMAC    ));
		this.pioche.add(new Jeton(Epice.CURCUMA  ));
		this.pioche.add(new Jeton(Epice.CARDAMONE));
		this.pioche.add(new Jeton(Piece.OR       ));
		this.pioche.add(new Jeton(Epice.SAFRAN   ));
		this.pioche.add(new Jeton(Epice.SESAME   ));
		this.pioche.add(new Jeton(Epice.POIVRE   ));
		this.pioche.add(new Jeton(Piece.ARGENT   ));
		this.pioche.add(new Jeton(Piece.ARGENT   ));
		this.pioche.add(new Jeton(Epice.PAPRIKA  ));
		this.pioche.add(new Jeton(Epice.SAFRAN   ));
		this.pioche.add(new Jeton(Epice.SAFRAN   ));
		this.pioche.add(new Jeton(Epice.SAFRAN   ));
		this.pioche.add(new Jeton(Epice.CANNELLE ));


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