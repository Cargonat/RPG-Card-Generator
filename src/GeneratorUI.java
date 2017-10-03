import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeneratorUI extends JFrame
    {

        private JPanel rootPanel;
        private JTextField nameTextField;
        private JTextField typeTextField;
        private JSpinner spinnerSpeed;
        private JSpinner hpSpinner1;
        private JComboBox comboBox1;
        private JSpinner hpSpinner2;
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
        private JButton outputJSONButton;
        private JSpinner spinner1;
        private JTextField skillsTextField;
        private JCheckBox bludgeoningCheckBox;
        private JCheckBox piercingCheckBox;
        private JCheckBox slashingCheckBox;
        private JCheckBox acidCheckBox;
        private JCheckBox necroticCheckBox;
        private JCheckBox coldCheckBox;
        private JCheckBox poisonCheckBox;
        private JCheckBox fireCheckBox;
        private JCheckBox psychicCheckBox;
        private JCheckBox forceCheckBox;
        private JCheckBox radiantCheckBox;
        private JCheckBox lightningCheckBox;
        private JCheckBox thunderCheckBox;
        private JSpinner darkvisionInFtSpinner;
        private JSpinner blindsightInFtSpinner;
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
        private JComboBox comboBox2;
        private JTextField challengeTextField;
        private JTextArea traitsTextArea;
        private JTextArea actionsTextArea;
        private JTextArea reactionsTextArea;
        private JTextArea legendaryActionsTextArea;

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
            outputJSONButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
        }

        private void setup()
        {

            sizeComboBox.setSelectedIndex(2);
            armorClassSpinner.setValue(15);

            walkSpinner.setValue(30);

            STRSpinner.setValue(10);
            DEXSpinner.setValue(10);
            CONSpinner.setValue(10);
            INTSpinner.setValue(10);
            WISSpinner.setValue(10);
            CHASpinner.setValue(10);
        }
    }
