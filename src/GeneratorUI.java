import javax.swing.*;

public class GeneratorUI extends JFrame
    {

        //All UI generated via GeneratorUI

        private JPanel rootPanel;
        private JTextField nameTextField;
        private JTextField typeTextField;
        private JSpinner spinnerSpeed;
        private JSpinner hitDieCountSpinner;
        private JComboBox hitDieComboBox;
        private JSpinner hpBonusSpinner;
        private JSpinner spinnerSTR;
        private JSpinner spinnerDEX;
        private JSpinner spinnerCON;
        private JSpinner spinnerINT;
        private JSpinner spinnerWIS;
        private JSpinner spinnerCHA;
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
        public JButton getOutputJSONButton() {
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
        private JCheckBox exhaustedCheckBox1;
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

        //Constructor
        public GeneratorUI()
        {
            super("RPG Cards Generator");

            setContentPane(rootPanel);

            setDefaultCloseOperation(EXIT_ON_CLOSE);

            try{
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored){}

            setup();
            pack();
            setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH);

            setVisible(true);

        }

        //sets up default values for Spinners and ComboBoxes
        private void setup()
        {

            sizeComboBox.setSelectedIndex(2);
            armorClassSpinner.setValue(15);

            SpinnerNumberModel walkSpinnerSpeedModel = new SpinnerNumberModel(30,0,1000,5);
            SpinnerNumberModel flySpinnerSpeedModel = new SpinnerNumberModel(0,0,1000,5);
            SpinnerNumberModel swimSpinnerSpeedModel = new SpinnerNumberModel(0,0,1000,5);
            SpinnerNumberModel climbSpinnerSpeedModel = new SpinnerNumberModel(0,0,1000,5);
            SpinnerNumberModel burrowSpinnerSpeedModel = new SpinnerNumberModel(0,0,1000,5);
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
        public String getJSONString()
        {
            //String start
                String json = "";
                json += "[\n" +
                        "{\n" +
                        "\"count\": 1,\n" +
                        "\"color\": \"Maroon\",\n";

            //Name
                json += "\"title\": \"" + nameTextField.getText() + "\",\n";

            //Icon and Content Start
                json += "\"icon\": \"imp-laugh\",\n" +
                        "\"contents\": [\n";

            //subtitle
                json += "\"subtitle | " + sizeComboBox.getSelectedItem() + " " +  typeTextField.getText().toLowerCase() + ", " + alignmentComboBox.getSelectedItem() + "\",\n";
                json += "\"\",\n\"rule\",\n";

            //Armor Class
                json += "\"property | Armor class | " + armorClassSpinner.getValue().toString();
                if (!armorClassTextField.getText().isEmpty())
                    json += " (" + armorClassTextField.getText() + ")";
                json += "\",\n";

            //Hit Dice
                double[] dieAvarageArray = {2.5, 3.5, 4.5, 5.5, 6.5, 10.5};
                double dieAvarage = dieAvarageArray[(Integer) hitDieComboBox.getSelectedIndex()];
                int dieCount = (int) hitDieCountSpinner.getValue();
                int bonusHP = (int) hpBonusSpinner.getValue();
                int averageHP = (int) Math.floor(dieCount * dieAvarage + bonusHP);

                json += "\"property | Hit points | " + averageHP + " (" + dieCount + hitDieComboBox.getSelectedItem().toString() + " + " + bonusHP + ")\",\n";

            //Speed
                json += "\"property | Speed | " + walkSpinner.getValue() + " ft.";
                //optional non-walking speeds
                    if (((int)flySpinner.getValue()) != 0)
                        json += ", fly " + flySpinner.getValue() + " ft.";
                    if (((int)swimSpinner.getValue()) != 0)
                        json += ", swim " + swimSpinner.getValue() + " ft.";
                    if (((int)climbSpinner.getValue()) != 0)
                        json += ", climb " + climbSpinner.getValue() + " ft.";
                    if (((int)burrowSpinner.getValue()) != 0)
                        json += ", burrow " + burrowSpinner.getValue() + " ft.";
                json += "\",\n\"\",\n\"rule\",\n";

            //Ability Scores
                json += "\"dndstats | "
                        + STRSpinner.getValue() + " | "
                        + DEXSpinner.getValue() + " | "
                        + CONSpinner.getValue() + " | "
                        + INTSpinner.getValue() + " | "
                        + WISSpinner.getValue() + " | "
                        + CHASpinner.getValue()
                        + "\",\n\"\",\n\"rule\",\n";

            //Properties

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
                        vulnString = vulnString.substring(0,vulnString.length()-2);
                        json += "\"property | Damage Vulnerabilities | " + vulnString + "\",\n";
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
                        resString = resString.substring(0,resString.length()-2);
                        json += "\"property | Damage Resistances | " + resString + "\",\n";
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
                        immuString = immuString.substring(0,immuString.length()-2);
                        json += "\"property | Damage Immunities | " + immuString + "\",\n";
                    }

                        //Close and return
                json += "],\n\"tags\": []\n}\n]";
                return json;
        }
    }
