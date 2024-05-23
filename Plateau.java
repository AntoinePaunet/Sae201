import java.util.Arrays;

import inter.IRessource;

/**
 * Cette classe créé le Plateau, composé des Jetons.
 * Elle se charge aussi du calcul du score du joueur.
 * @author Antione Paunet, IUT du Havre
 * @author Mael Vauthier,  IUT du Havre
 * @author Martin Ravenel, IUT du Havre
 * @version 1.0 , 2024-05-23
*/

public class Plateau implements IRessource
{
	private static final int NB_PIECE_MAX = 15 ;

	private int 		nbPiece ,score;
	private String 		detailScore;

	private Pioche 		pioche;

	private Epice[][] 	tabEpices;
	private Piece[] 	tabPieces;


/**
 * Constructeur de Plateau
 * Initialise la Pioche ainsi que les tableaux de Pieces et Epices.
*/

	public Plateau()
	{
		this.pioche 	= 	new Pioche();
		this.tabEpices 	= 	new Epice[3][5];
		this.tabPieces 	= 	new Piece[8];
	}

	public Epice[][] getTabEpices()
	{
		return Arrays.copyOf(this.tabEpices, this.tabEpices.length);
	}

	public Piece[] getTabPieces()
	{
		return Arrays.copyOf(this.tabPieces, this.tabPieces.length);
	}

	public Pioche getPioche()
	{
		return pioche;
	}

	public int getScore() { return this.score;}

	public String getDetailScore() { return this.detailScore;}



	public boolean ajouterRessource( Jeton r )
	{
		boolean bOk = false;

		if( r.getType() instanceof Epice) // Gestion des Epices
		{
			for(int i = 0 ; i < this.tabEpices[0].length ; i++)
			{
				if(this.tabEpices[1][i] == null || this.tabEpices[2][i] == null || this.tabEpices[0][i] == null) //Il faut que les cases soient vides pour y placer les éléments
				{
					if(this.tabEpices[2][i] != null && this.tabEpices[2][i].name().equals(((Epice) r.getType()).name())) //Si on a la même ressource que dans le tableau
					{
						for(int i2 = tabEpices.length-1 ; i2 > -1 ; i2--) //On fait dans le sens inverse afin de placer les éléments de bas en haut dans le tableau
						{
							if(this.tabEpices[i2][i] == null)
							{
								this.tabEpices[i2][i] = (Epice) r.getType();
								bOk = true;
								break;
							}
						}

					}
					else if(this.tabEpices[2][i] == null && !bOk) //Si la ressource n'est pas la même
					{
						this.tabEpices[2][i] = (Epice) r.getType();
						bOk = true;
					}
				}
			}

		}
		else if ( r.getType() instanceof Piece) // Gestion des Epices
		{
			int cpt = ((Piece) r.getType()).getvaleur();
			int nbSlotsLibre = 0;



			for(int i = 0 ; i < this.tabPieces.length ; i++)
			{
				if(this.tabPieces[i] == null)
					nbSlotsLibre++;
			}

			if(nbSlotsLibre >= cpt) //Si il y a assez de slots de libre par rapport au prix de la pièce
			{
				for(int i = 0 ; i < this.tabPieces.length ; i++)
				{
					if (cpt == 0)
						bOk = true;

					if (this.tabPieces[i] == null && !bOk)
					{
						this.tabPieces[i] = Piece.BRONZE;
						this.nbPiece++;
						cpt--;
					}
				}
			}
		}

		System.out.print( String.format( "%-20s", r.getType()) + ": ");

		return bOk ;
	}


	public void score()
	{
		//Affichage des détails
		int score, scorePiece, scoreCol, scoreLig;
		String detail = "Detail :\n ";


		//Compteur pour le score des pièces
		scorePiece = 0;
		for (int i = 1; i < tabPieces.length; i++)
		{
			if (tabPieces[i] != null)
				scorePiece = (i+1)*(i+1);
		}

		detail += "Pièces      : " + scorePiece + " pt \n ";

		score = scorePiece;


		//Compteur pour le score des colonnes
		int cptCol = 1;
		for (int col = 0; col < tabEpices[0].length; col++) // 0 - 5
		{
			scoreCol = 0;
			if      (tabEpices[0][col] != null)
				scoreCol=10;
			else if (tabEpices[1][col] != null)
				scoreCol= 2;

			detail += "Colonne " + cptCol + "   : " + String.format("%2d", scoreCol) + " pt\n ";
			score += scoreCol;

			cptCol++;
		}




		//Compteur pour le score des colonnes
		int cptEpices 	= 0;
		int cptLig 		= 1;
		int cptPieceLig = 0;
		scoreLig 		= 0;


		for(int i = this.tabEpices.length-1 ; i > -1 ; i--)
		{
			scoreLig = 0;
			for(int j = 0 ; j < this.tabEpices[i].length ; j++)
			{
				if(this.tabEpices[i][j] != null)
				{
					cptEpices++;
					if (cptEpices>=2)
						scoreLig += cptEpices;
					
				}

			}

			detail += "Ligne   " + (this.tabEpices.length - i) + "   : " + String.format("%2d", scoreLig) + " pt\n ";
			score  += scoreLig;
			cptEpices = 0;
		}

		this.score = score;
		this.detailScore = detail;

	}


	public String toString()
	{
		String s = "";
		if(this.tabEpices[0][0] == null && this.tabPieces[0] == null)
			s = "Etat initial du Plateau\n";
		
		else
			s = "Etat final du Plateau\n";


		for( int i1 = 0 ; i1 < 3 ; i1 ++ )
		{
			for( int i2 = 0 ; i2 < 5 ; i2 ++ )
				s += "+-----";
			s += "+\n|";

			for( int i2 = 0 ; i2 < 5 ; i2 ++ )
				if(this.tabEpices[i1][i2] != null)
					s += " " + this.tabEpices[i1][i2].getLibCourt() +  " |" ;
				else
					s+= "     |";
			s += "\n";
		}

		for( int i2 = 0 ; i2 < 5 ; i2 ++ )
			s += "+-----";

		if(nbPiece > 1)
			s += "+\n" + nbPiece + " pièces";
		else
			s += "+\n" + nbPiece + " pièce";

		if (getDetailScore() != null)
		{
			s += "\nScore : " + getScore() + " point" + (getScore()>1?"s":"") + "\n";
			s += "\n" + getDetailScore();
		}

		return s;
	}
}