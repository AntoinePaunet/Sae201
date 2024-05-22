import javax.swing.*;

public class Interface extends JFrame
{
    private JPanel panel;

    public Interface()
    {
        this.setTitle( "La route des epices" );
        this.setSize( 1920 , 1080 );
        this.panel = new JPanel();


        this.setIconImage(new ImageIcon(getClass().getResource("/images/paprika.png")).getImage());

        this.setVisible( true );
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}