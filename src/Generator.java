import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import com.jtattoo.plaf.hifi.*;

public class Generator
{

    private static GeneratorUI _generatorUI;
    private static MenuUI _menuUI;

    private static void runMenu()
    {
        _menuUI = new MenuUI();
        _menuUI.getAddNewCardButton().addActionListener(
                ae ->
                {
                    _menuUI.setVisible(false);
                    runGenerator();
                }
        );
        _menuUI.getCompileDeckButton().addActionListener(
                ae ->
                {
                    runDeckCompiler();
                }
        );
    }

    private static void runGenerator()
    {
        _generatorUI = new GeneratorUI();

        File cardFolder = new File("");
        //Test if Folder exists, else make it
        if (!cardFolder.exists())
            cardFolder.mkdir();



        _generatorUI.getOutputJSONButton().addActionListener
                (
                        ae ->
                        {
                            String json = _generatorUI.getJSONString();
                            StringSelection selection = new StringSelection(json);
                            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                            clipboard.setContents(selection, selection);
                            JOptionPane.showMessageDialog(null, json, "RPG Cards Generator", JOptionPane.PLAIN_MESSAGE);
                        }
                );

    }

    private static void runDeckCompiler()
    {

    }

    public static void main(String[] args)
    {
        //UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
        //setDarkLookAndFeel();
        runMenu();
    }
}
