import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.util.List;

public class RPGCardsMonsterUIMain
{

    private static CardCreationUI _cardCreationUI;
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
                ae -> runDeckCompiler());
        _menuUI.getOpenRPGCardsInButton().addActionListener(
                ae ->
                {
                    StringSelection selection = new StringSelection(new File("").getAbsolutePath());
                    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, selection);
                    _menuUI.setVisible(false);
                    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
                    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE))
                    {
                        try
                        {
                            File generateHTML = new File("C:\\Users\\Tobi\\IdeaProjects\\RPG Cards Generator\\rpg-cards.vigil\\generator\\generate.html");
                            desktop.browse(generateHTML.toURI());
                            System.exit(1);
                        } catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }

                }
        );
    }

    private static void runGenerator()
    {
        _cardCreationUI = new CardCreationUI();

        _cardCreationUI.getOutputJSONButton().addActionListener
                (
                        ae -> saveCard()
                );
    }

    private static void saveCard()
    {
        String json = _cardCreationUI.getJSONString();
        String cardName = _cardCreationUI.getCardName().toLowerCase();
        JFileChooser saver;
        String cardPath = _cardsFolder.getPath() + "\\" + cardName + ".json";
        saver = new JFileChooser(_cardsFolder);
        saver.setFileFilter(new FileNameExtensionFilter(".json", "json"));
        saver.setSelectedFile(new File(cardPath));
        int returnValue = saver.showSaveDialog(null);
        //noinspection Duplicates
        if (returnValue == JFileChooser.APPROVE_OPTION)
        {
            File cardFile = saver.getSelectedFile();
            if (cardFile.exists())
            {
                int result = JOptionPane.showConfirmDialog(null, "The file exists, overwrite?", "Existing file",
                                                           JOptionPane.YES_NO_CANCEL_OPTION);
                switch (result)
                {
                    case JOptionPane.YES_OPTION:
                        saver.approveSelection();
                        return;
                    case JOptionPane.NO_OPTION:
                        saveCard();
                        return;
                    case JOptionPane.CLOSED_OPTION:
                        return;
                    case JOptionPane.CANCEL_OPTION:
                        saver.cancelSelection();
                        return;
                }
            }
            Writer writer = null;
            try
            {
                writer = new FileWriter(cardFile.getPath());
                writer.write(json);
            } catch (IOException e)
            {
                System.err.println("Could not write to File " + cardFile.getPath() + ".");
            } finally
            {
                if (writer != null)
                    try
                    {
                        writer.close();
                    } catch (IOException e)
                    {
                        e.printStackTrace();
                    }
            }

            _cardCreationUI.setVisible(false);
            _menuUI.setVisible(true);
        }
    }

    private static void runDeckCompiler()
    {
        JFileChooser chooser = new JFileChooser(_cardsFolder);
        chooser.setMultiSelectionEnabled(true);
        int returnValueOpener = chooser.showOpenDialog(null);
        //noinspection Duplicates
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
                    content = content.substring(3, content.length() - 3) + ",\n";
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
                json += content;
            }
            json = json.substring(0, json.length() - 2) + "\n]";

            JFileChooser saver = new JFileChooser(_decksFolder);
            saver.setFileFilter(new FileNameExtensionFilter(".json", "json"));
            saver.setSelectedFile(new File("deck" + _decksFolder.listFiles().length + ".json"));
            int returnValueSaver = saver.showSaveDialog(null);
            File deck;
            if (returnValueSaver == JFileChooser.APPROVE_OPTION)
            {
                if (saver.getSelectedFile().getPath().endsWith(".json"))
                    deck = saver.getSelectedFile();
                else
                {
                    String baseName = saver.getSelectedFile().getPath().split("[.]")[0];
                    System.out.println(baseName);
                    deck = new File(baseName + ".json");
                }
                Writer writer = null;
                try
                {
                    writer = new FileWriter(deck.getPath());
                    writer.write(json);
                } catch (IOException e)
                {
                    System.err.println("Could not create deck file");
                } finally
                {
                    if (writer != null)
                        try
                        {
                            writer.close();
                        } catch (IOException e)
                        {
                            e.printStackTrace();
                        }
                }
            }
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
