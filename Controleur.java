/**
 * Cette classe permet de controler et lier la classe Interface avec les autres classes métier
 * @author Antione Paunet, IUT du Havre
 * @author Mael Vauthier,  IUT du Havre
 * @author Martin Ravenel, IUT du Havre
 * @version 1.0 , 2024-05-23
 */

public class Controleur
{
    private Interface   ihm;
    private Plateau     plateau;


    /**
     * Constructeur de la classe controleur qui va executer le programme
     */
    public Controleur()
    {
        this.ihm     = new Interface();
        this.plateau = new Plateau();



        //Début du mode CUI
        System.out.println(this.plateau);

        System.out.print( "\n");

        System.out.println("\nAjout des ressources à partir des jetons de la pioche\n");


        for(int i = 0 ; i < Pioche.taillePioche ; i++)

            System.out.print( this.plateau.ajouterRessource(this.plateau.getPioche().tirerJeton()) + "\n" );


        System.out.print("\n");

        this.plateau.score();

        System.out.print( "\n");

        System.out.println(this.plateau + "\n");


        toInterface();
    }


    /**
     * Méthode qui permet de générer les élements dans l'interface graphique en donnant les coordonnées et les
     * types de Jetons à placer dans le plateau graphique
     */
    private void toInterface()
    {
        int x = 80;
        int y = 20;
        for(int i = 0; i < this.plateau.getTabEpices().length ; i++) //Affichage des épices
        {
            for(int j = 0 ; j < this.plateau.getTabEpices()[i].length ; j++)
            {
                if(this.plateau.getTabEpices()[i][j] != null)
                {
                    this.ihm.ajoutElements(x, y,this.plateau.getTabEpices()[i][j].getCouleur().getSymbole());
                }
                x += 160;
            }
            x = 80;
            y += 120;
        }

        x = 77;
        y = 400;

        for(int i = 0 ; i < this.plateau.getTabPieces().length ; i++) //affichage des pièces
        {
            if(this.plateau.getTabPieces()[i] != null)
            {
                this.ihm.ajoutElements(x,y, "bronze.png"); //Démo donc seulement pièces de bronze
                x += 85;
            }
        }
    }



    /**
     * Méthode permettant l'éxecution du programme en créant un nouveau Controleur
     * @param String[] args
     */
    public static void main( String[] args )//Lancement de l'application
    {
        new Controleur();
    }

}