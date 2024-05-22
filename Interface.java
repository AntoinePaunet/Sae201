import javax.swing.*;

public class Interface extends JFrame
{
    private JPanel panel;

    public Interface()
    {
        this.setTitle( "La route des epices" );
        this.setSize( 900 , 535 );
        this.panel = new JPanel();


        this.setIconImage(new ImageIcon(getClass().getResource("/images/paprika.png")).getImage());

        this.imgBG();
        this.add(this.panel);

        this.setVisible( true );
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    public void imgBG()
    {
        //Mise en place du fond d'écran

        ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/images/plateau.png"));
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        this.panel.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);
    }


    public void ajoutElements(int x, int y, String url)
    {

    }



}