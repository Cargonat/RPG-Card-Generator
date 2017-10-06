import javax.swing.*;

public class MenuUI extends JFrame
{
    private JPanel rootMenu;

    JButton getAddNewCardButton()
    {
        return _addNewCardButton;
    }

    JButton getCompileDeckButton()
    {
        return _compileDeckButton;
    }

    private JButton _addNewCardButton;
    private JButton _compileDeckButton;

    MenuUI()
    {
        super("RPC Cards Menu");

        setContentPane(rootMenu);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        pack();
        setVisible(true);
    }
}
