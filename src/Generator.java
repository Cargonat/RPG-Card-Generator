import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class Generator
{

    private static GeneratorUI _ui;

    private static void run()
    {
        _ui = new GeneratorUI();

        _ui.getOutputJSONButton().addActionListener
                (
                        ae ->
                        {
                            String json = _ui.getJSONString();
                            StringSelection selection = new StringSelection(json);
                            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                            clipboard.setContents(selection, selection);
                            JOptionPane.showMessageDialog(null, json, "RPG Cards Generator", JOptionPane.PLAIN_MESSAGE);
                        }
                );
    }


    public static void main(String[] args)
    {
        run();
    }
}
