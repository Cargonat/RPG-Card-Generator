import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import com.jtattoo.plaf.hifi.*;

public class Generator
{

    private static GeneratorUI _generatorUI;
    private static MenuUI _menuUI;

    private static File _cardsFolder = new File("cards");
    private static File _decksFolder = new File("decks");

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
        JFileChooser chooser = new JFileChooser(_cardsFolder);
        chooser.setMultiSelectionEnabled(true);
        int returnValueOpener = chooser.showOpenDialog(null);
        if (returnValueOpener == JFileChooser.APPROVE_OPTION)
        {
            File[] files = chooser.getSelectedFiles();
            String json = "[\n";
            for (File file : files)
            {
                String content = "";
                try
                {
                    List<String> contentLines = Files.readAllLines(file.toPath());
                    for (String line : contentLines)
                        content += line + "\n";
                    //cutoff square brackets and corresponding \n and last \n
                    content = content.substring(3,content.length()-3) + ",\n";
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
                json += content;
            }
            json += "]";

            JFileChooser saver = new JFileChooser(_decksFolder);
            saver.setFileFilter(new FileNameExtensionFilter("JSON",".json"));
            int returnValueSaver = saver.showSaveDialog(null);
            File deck;
            if (returnValueSaver == JFileChooser.APPROVE_OPTION)
                deck = saver.getSelectedFile();
            System.out.println(json);
        }
    }

    public static void main(String[] args)
    {
        //Test if Cards Folder exists, else make it
        if (!_cardsFolder.exists())
            _cardsFolder.mkdir();
        //Test if Decks Folder exists, else make it
        if (!_decksFolder.exists())
            _decksFolder.mkdir();

        //open menu
        runMenu();
    }
}
