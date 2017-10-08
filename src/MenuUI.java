import javax.swing.*;
import java.awt.*;

public class MenuUI extends JFrame
{
    private JPanel rootMenu;
    private JButton _addNewCardButton;
    private JButton _compileDeckButton;
    private JButton _openRPGCardsInButton;
    MenuUI()
    {
        super("RPC Cards Menu");

        setContentPane(rootMenu);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        pack();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setVisible(true);
    }

    JButton getAddNewCardButton()
    {
        return _addNewCardButton;
    }

    JButton getCompileDeckButton()
    {
        return _compileDeckButton;
    }

    JButton getOpenRPGCardsInButton()
    {
        return _openRPGCardsInButton;
    }
}
