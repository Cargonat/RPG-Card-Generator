import javax.swing.*;

public class GeneratorUI extends JFrame
{

    //All UI generated via GeneratorUI

    private JPanel rootPanel;
    private JTextField nameTextField;
    private JTextField typeTextField;
    private JSpinner hitDieCountSpinner;
    private JComboBox hitDieComboBox;
    private JSpinner hpBonusSpinner;
    private JSpinner STRSpinner;
    private JSpinner DEXSpinner;
    private JSpinner CONSpinner;
    private JSpinner INTSpinner;
    private JSpinner WISSpinner;
    private JSpinner CHASpinner;
    private JSpinner walkSpinner;
    private JSpinner armorClassSpinner;
    private JComboBox alignmentComboBox;
    private JComboBox sizeComboBox;
    private JSpinner flySpinner;
    private JSpinner swimSpinner;
    private JSpinner climbSpinner;
    private JSpinner burrowSpinner;

    //JSON Button Getter for ActionListener in Generator.java
    JButton getOutputJSONButton()
    {
        return outputJSONButton;
    }

    private JButton outputJSONButton;
    private JSpinner saveSTRSpinner;
    private JTextField skillsTextField;
    private JCheckBox vulnBludgeoningCheckBox;
    private JCheckBox vulnPiercingCheckBox;
    private JCheckBox vulnSlashingCheckBox;
    private JCheckBox vulnAcidCheckBox;
    private JCheckBox vulnNecroticCheckBox;
    private JCheckBox vulnColdCheckBox;
    private JCheckBox vulnPoisonCheckBox;
    private JCheckBox vulnFireCheckBox;
    private JCheckBox vulnPsychicCheckBox;
    private JCheckBox vulnForceCheckBox;
    private JCheckBox vulnRadiantCheckBox;
    private JCheckBox vulnLightningCheckBox;
    private JCheckBox vulnThunderCheckBox;
    private JSpinner darkvisionSpinner;
    private JSpinner blindsightSpinner;
    private JCheckBox blindBeyondCheckBox;
    private JSpinner passivePerceptionSpinner;
    private JTextField otherSensesTextField;
    private JCheckBox blindedCheckBox;
    private JCheckBox grappledCheckBox;
    private JCheckBox poisonedCheckBox;
    private JCheckBox charmedCheckBox;
    private JCheckBox incapacitatedCheckBox;
    private JCheckBox proneCheckBox;
    private JCheckBox deafenedCheckBox;
    private JCheckBox invisibleCheckBox;
    private JCheckBox restrainedCheckBox;
    private JCheckBox exhaustedCheckBox;
    private JCheckBox paralysedCheckBox;
    private JCheckBox stunnedCheckBox;
    private JCheckBox frightenedCheckBox;
    private JCheckBox petrifiedCheckBox;
    private JCheckBox unconsciousCheckBox;
    private JTextField languagesTextField;
    private JComboBox challengeRatingSpinner;
    private JTextField xpTextField;
    private JTextArea traitsTextArea;
    private JTextArea actionsTextArea;
    private JTextArea reactionsTextArea;
    private JTextArea legendaryActionsTextArea;
    private JSpinner saveDEXSpinner;
    private JSpinner saveCONSpinner;
    private JSpinner saveINTSpinner;
    private JSpinner saveWISSpinner;
    private JSpinner saveCHASpinner;
    private JCheckBox resBludgeoningCheckBox;
    private JCheckBox resPiercingCheckBox;
    private JCheckBox resSlashingCheckBox;
    private JCheckBox resAcidCheckBox;
    private JCheckBox resNecroticCheckBox;
    private JCheckBox resColdCheckBox;
    private JCheckBox resPoisonCheckBox;
    private JCheckBox resFireCheckBox;
    private JCheckBox resPsychicCheckBox;
    private JCheckBox resForceCheckBox;
    private JCheckBox resRadiantCheckBox;
    private JCheckBox resLightningCheckBox;
    private JCheckBox resThunderCheckBox;
    private JCheckBox immuBludgeoningCheckBox;
    private JCheckBox immuPiercingCheckBox;
    private JCheckBox immuSlashingCheckBox;
    private JCheckBox immuAcidCheckBox;
    private JCheckBox immuNecroticCheckBox;
    private JCheckBox immuColdCheckBox;
    private JCheckBox immuPoisonCheckBox;
    private JCheckBox immuFireCheckBox;
    private JCheckBox immuPsychicCheckBox;
    private JCheckBox immuForceCheckBox;
    private JCheckBox immuRadiantCheckBox;
    private JCheckBox immuLightningCheckBox;
    private JCheckBox immuThunderCheckBox;
    private JTextField armorClassTextField;
    private JCheckBox hoverCheckBox;

    //Constructor
    GeneratorUI()
    {
        super("RPG Cards Generator");

        setContentPane(rootPanel);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setup();
        pack();
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);

        setVisible(true);

    }

    //sets up default values for Spinners and ComboBoxes
    private void setup()
    {

        sizeComboBox.setSelectedIndex(2);
        armorClassSpinner.setValue(15);

        SpinnerNumberModel walkSpinnerSpeedModel = new SpinnerNumberModel(30, 0, 1000, 5);
        SpinnerNumberModel flySpinnerSpeedModel = new SpinnerNumberModel(0, 0, 1000, 5);
        SpinnerNumberModel swimSpinnerSpeedModel = new SpinnerNumberModel(0, 0, 1000, 5);
        SpinnerNumberModel climbSpinnerSpeedModel = new SpinnerNumberModel(0, 0, 1000, 5);
        SpinnerNumberModel burrowSpinnerSpeedModel = new SpinnerNumberModel(0, 0, 1000, 5);
        walkSpinner.setModel(walkSpinnerSpeedModel);
        flySpinner.setModel(flySpinnerSpeedModel);
        swimSpinner.setModel(swimSpinnerSpeedModel);
        climbSpinner.setModel(climbSpinnerSpeedModel);
        burrowSpinner.setModel(burrowSpinnerSpeedModel);

        STRSpinner.setValue(10);
        DEXSpinner.setValue(10);
        CONSpinner.setValue(10);
        INTSpinner.setValue(10);
        WISSpinner.setValue(10);
        CHASpinner.setValue(10);
    }

    //generates JSON String
    String getJSONString()
    {
        //String start
        String json = "";
        json += "[\n" +
                "  {\n" +
                "    \"count\": 1,\n" +
                "    \"color\": \"Maroon\",\n";

        //Name
        json += "    \"title\": \"" + nameTextField.getText() + "\",\n";

        //Icon and Content Start
        json += "    \"icon\": \"imp-laugh\",\n" +
                "    \"contents\": [\n";

        //subtitle
        json += "      \"subtitle | " + sizeComboBox.getSelectedItem() + " "
                + typeTextField.getText().toLowerCase() + ", "
                + alignmentComboBox.getSelectedItem() + "\",\n      ";
        json += "\"rule\",\n      ";

        //Armor Class
        json += "\"property | Armor class | " + armorClassSpinner.getValue().toString();
        if (!armorClassTextField.getText().isEmpty())
            json += " (" + armorClassTextField.getText() + ")";
        json += "\",\n      ";

        //Hit Dice
        double[] dieAvarageArray = {2.5, 3.5, 4.5, 5.5, 6.5, 10.5};
        double dieAvarage = dieAvarageArray[hitDieComboBox.getSelectedIndex()];
        int dieCount = (int) hitDieCountSpinner.getValue();
        int bonusHP = (int) hpBonusSpinner.getValue();
        int averageHP = (int) Math.floor(dieCount * dieAvarage + bonusHP);

        json += "\"property | Hit points | " + averageHP + " ("
                + dieCount + hitDieComboBox.getSelectedItem().toString();
        if (bonusHP != 0)
            json += " + " + bonusHP;
        json += ")\",\n      ";

        //Speed
        json += "\"property | Speed | " + walkSpinner.getValue() + " ft.";
        //optional non-walking speeds
        if (((int) flySpinner.getValue()) != 0)
            json += ", fly " + flySpinner.getValue() + " ft.";
        if (hoverCheckBox.isSelected())
            json += " (hover)";
        if (((int) swimSpinner.getValue()) != 0)
            json += ", swim " + swimSpinner.getValue() + " ft.";
        if (((int) climbSpinner.getValue()) != 0)
            json += ", climb " + climbSpinner.getValue() + " ft.";
        if (((int) burrowSpinner.getValue()) != 0)
            json += ", burrow " + burrowSpinner.getValue() + " ft.";
        json += "\",\n      \"rule\",\n      ";

        //Ability Scores
        json += "\"dndstats | "
                + STRSpinner.getValue() + " | "
                + DEXSpinner.getValue() + " | "
                + CONSpinner.getValue() + " | "
                + INTSpinner.getValue() + " | "
                + WISSpinner.getValue() + " | "
                + CHASpinner.getValue()
                + "\",\n      \"rule\",\n      ";

        //Properties
        //Saving Throws
        String saveString = "";
        if (((int) saveSTRSpinner.getValue()) != 0)
            saveString += "Str +" + saveSTRSpinner.getValue() + ", ";
        if (((int) saveDEXSpinner.getValue()) != 0)
            saveString += "Dex +" + saveDEXSpinner.getValue() + ", ";
        if (((int) saveCONSpinner.getValue()) != 0)
            saveString += "Con +" + saveCONSpinner.getValue() + ", ";
        if (((int) saveINTSpinner.getValue()) != 0)
            saveString += "Int +" + saveINTSpinner.getValue() + ", ";
        if (((int) saveWISSpinner.getValue()) != 0)
            saveString += "Wis +" + saveWISSpinner.getValue() + ", ";
        if (((int) saveCHASpinner.getValue()) != 0)
            saveString += "Cha +" + saveCHASpinner.getValue() + ", ";
        if (!saveString.isEmpty())
        {
            //cutting off last comma and space
            saveString = saveString.substring(0, saveString.length() - 2);
            json += "\"property | Saving Throws | " + saveString + "\",\n      ";
        }

        //Skills
        json += "\"property | Skills | " + skillsTextField.getText() + "\",\n      ";

        //Damage Vulnerabilities
        String vulnString = "";
        if (vulnBludgeoningCheckBox.isSelected())
            vulnString += "bludgeoning, ";
        if (vulnPiercingCheckBox.isSelected())
            vulnString += "piercing, ";
        if (vulnSlashingCheckBox.isSelected())
            vulnString += "slashing, ";
        if (vulnAcidCheckBox.isSelected())
            vulnString += "acid, ";
        if (vulnColdCheckBox.isSelected())
            vulnString += "cold, ";
        if (vulnFireCheckBox.isSelected())
            vulnString += "fire, ";
        if (vulnForceCheckBox.isSelected())
            vulnString += "force, ";
        if (vulnLightningCheckBox.isSelected())
            vulnString += "lightning, ";
        if (vulnNecroticCheckBox.isSelected())
            vulnString += "necrotic, ";
        if (vulnPoisonCheckBox.isSelected())
            vulnString += "poison, ";
        if (vulnPsychicCheckBox.isSelected())
            vulnString += "psychic, ";
        if (vulnRadiantCheckBox.isSelected())
            vulnString += "radiant, ";
        if (vulnThunderCheckBox.isSelected())
            vulnString += "thunder, ";

        if (!vulnString.isEmpty())
        {
            vulnString = vulnString.substring(0, vulnString.length() - 2);
            json += "\"property | Damage Vulnerabilities | " + vulnString + "\",\n      ";
        }

        //Damage Resistances
        String resString = "";
        if (resBludgeoningCheckBox.isSelected())
            resString += "bludgeoning, ";
        if (resPiercingCheckBox.isSelected())
            resString += "piercing, ";
        if (resSlashingCheckBox.isSelected())
            resString += "slashing, ";
        if (resAcidCheckBox.isSelected())
            resString += "acid, ";
        if (resColdCheckBox.isSelected())
            resString += "cold, ";
        if (resFireCheckBox.isSelected())
            resString += "fire, ";
        if (resForceCheckBox.isSelected())
            resString += "force, ";
        if (resLightningCheckBox.isSelected())
            resString += "lightning, ";
        if (resNecroticCheckBox.isSelected())
            resString += "necrotic, ";
        if (resPoisonCheckBox.isSelected())
            resString += "poison, ";
        if (resPsychicCheckBox.isSelected())
            resString += "psychic, ";
        if (resRadiantCheckBox.isSelected())
            resString += "radiant, ";
        if (resThunderCheckBox.isSelected())
            resString += "thunder, ";
        if (!resString.isEmpty())
        {
            resString = resString.substring(0, resString.length() - 2);
            json += "\"property | Damage Resistances | " + resString + "\",\n      ";
        }


        //Damage Immunities
        String immuString = "";
        if (immuBludgeoningCheckBox.isSelected())
            immuString += "bludgeoning, ";
        if (immuPiercingCheckBox.isSelected())
            immuString += "piercing, ";
        if (immuSlashingCheckBox.isSelected())
            immuString += "slashing, ";
        if (immuAcidCheckBox.isSelected())
            immuString += "acid, ";
        if (immuColdCheckBox.isSelected())
            immuString += "cold, ";
        if (immuFireCheckBox.isSelected())
            immuString += "fire, ";
        if (immuForceCheckBox.isSelected())
            immuString += "force, ";
        if (immuLightningCheckBox.isSelected())
            immuString += "lightning, ";
        if (immuNecroticCheckBox.isSelected())
            immuString += "necrotic, ";
        if (immuPoisonCheckBox.isSelected())
            immuString += "poison, ";
        if (immuPsychicCheckBox.isSelected())
            immuString += "psychic, ";
        if (immuRadiantCheckBox.isSelected())
            immuString += "radiant, ";
        if (immuThunderCheckBox.isSelected())
            immuString += "thunder, ";
        if (!immuString.isEmpty())
        {
            immuString = immuString.substring(0, immuString.length() - 2);
            json += "\"property | Damage Immunities | " + immuString + "\",\n      ";
        }

        //Condition Immunities
        String condiString = "";
        if (blindedCheckBox.isSelected())
            condiString += "blinded, ";
        if (charmedCheckBox.isSelected())
            condiString += "charmed, ";
        if (deafenedCheckBox.isSelected())
            condiString += "deafened, ";
        if (exhaustedCheckBox.isSelected())
            condiString += "exhausted, ";
        if (frightenedCheckBox.isSelected())
            condiString += "frightened, ";
        if (grappledCheckBox.isSelected())
            condiString += "grappled, ";
        if (incapacitatedCheckBox.isSelected())
            condiString += "incapacitated, ";
        if (invisibleCheckBox.isSelected())
            condiString += "invisible, ";
        if (paralysedCheckBox.isSelected())
            condiString += "paralysed, ";
        if (petrifiedCheckBox.isSelected())
            condiString += "petrified, ";
        if (poisonedCheckBox.isSelected())
            condiString += "poisoned, ";
        if (proneCheckBox.isSelected())
            condiString += "prone, ";
        if (restrainedCheckBox.isSelected())
            condiString += "restrained, ";
        if (stunnedCheckBox.isSelected())
            condiString += "stunned, ";
        if (unconsciousCheckBox.isSelected())
            condiString += "unconscious, ";
        if (!condiString.isEmpty())
        {
            condiString = condiString.substring(0,condiString.length()-2);
            json += "\"property | Condition Immunities | " + condiString + "\",\n      ";
        }

        //Senses
        String senseString = "";
        if (((int)blindsightSpinner.getValue()) != 0)
        {
            senseString += "blindsight " + blindsightSpinner.getValue() + " ft.";
            if (blindBeyondCheckBox.isSelected())
                senseString += "(blind beyond this radius)";
            senseString += ", ";
        }
        if (((int)darkvisionSpinner.getValue()) != 0)
            senseString += "darkvision " + darkvisionSpinner.getValue() + " ft., ";
        if (!otherSensesTextField.getText().isEmpty())
            senseString += otherSensesTextField.getText() + ", ";
        if (!senseString.isEmpty())
            senseString = senseString.substring(0,senseString.length()-2);
        json += "\"property | Senses | " + senseString
                + ", passive Perception " + passivePerceptionSpinner.getValue() + "\",\n      ";

        //Languages
        json += "\"property | Languages | ";
        if (languagesTextField.getText().isEmpty())
        {
            json += "-\",\n      ";
        }else
        {
            json += languagesTextField.getText() + "\",\n      ";
        }

        //Challenge
        json += "\"property | Challenge | " + challengeRatingSpinner.getSelectedItem() + " ("
                + xpTextField.getText() + ")\",\n      \"rule\",\n      ";

        //Traits
        if (!traitsTextArea.getText().isEmpty())
        {
            String traitLines[] = traitsTextArea.getText().split("\\r?\\n");
            for (String traitString : traitLines)
            {
                if (!traitString.isEmpty())
                    json += "\"description | " + traitString + "\",\n      ";
            }
        }

        //Actions
        if(!actionsTextArea.getText().isEmpty())
        {
            json += "\"section | Actions\",\n      ";
            String actionLines[] = actionsTextArea.getText().split("\\r?\\n");
            for (String actionString : actionLines)
            {
                if (!actionString.isEmpty())
                    json += "\"description | " + actionString + "\",\n      ";
            }
        }

        //Reactions
        if(!reactionsTextArea.getText().isEmpty())
        {
            json += "\"section | Reactions\",\n      ";
            String reactionLines[] = reactionsTextArea.getText().split("\\r?\\n");
            for (String reactionString : reactionLines)
            {
                if (!reactionString.isEmpty())
                    json += "\"description | " + reactionString + "\",\n      ";
            }
        }

        //Legendary Actions
        if(!legendaryActionsTextArea.getText().isEmpty())
        {
            json += "\"section | Legendary Actions\",\n      ";
            String legendaryActionLines[] = legendaryActionsTextArea.getText().split("\\r?\\n");
            for (String legendaryActionString : legendaryActionLines)
            {
                if (!legendaryActionString.isEmpty())
                    json += "\"description | " + legendaryActionString + "\",\n      ";
            }
        }

        //cutting last comma
        json = json.substring(0,json.length()-8) + "\n";

        //Close and return
        json += "    ],\n    \"tags\": []\n  }\n]";
        return json;
    }
}
