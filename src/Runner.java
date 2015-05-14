import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Runner {

    private static final Map<Character, String> characterStringMap = new HashMap<Character, String>();

    static {
        characterStringMap.put('а', "a");
        characterStringMap.put('б', "b");
        characterStringMap.put('в', "v");
        characterStringMap.put('г', "g");
        characterStringMap.put('д', "d");
        characterStringMap.put('е', "e");
        characterStringMap.put('ё', "–");
        characterStringMap.put('ж', "j");
        characterStringMap.put('з', "z");
        characterStringMap.put('и', "i");
        characterStringMap.put('й', "–");
        characterStringMap.put('к', "k");
        characterStringMap.put('л', "l");
        characterStringMap.put('м', "m");
        characterStringMap.put('н', "n");
        characterStringMap.put('о', "o");
        characterStringMap.put('п', "p");
        characterStringMap.put('р', "r");
        characterStringMap.put('с', "s");
        characterStringMap.put('т', "t");
        characterStringMap.put('у', "u");
        characterStringMap.put('ф', "f");
        characterStringMap.put('х', "h");
        characterStringMap.put('ц', "c");
        characterStringMap.put('ч', "ch");
        characterStringMap.put('ш', "sh");
        characterStringMap.put('щ', "sc");
        characterStringMap.put('ъ', "–");
        characterStringMap.put('ы', "y");
        characterStringMap.put('ь', "–");
        characterStringMap.put('э', "e");
        characterStringMap.put('ю', "iu");
        characterStringMap.put('я', "i");
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        final JFrame jFrame = new JFrame();
        jFrame.setTitle("Transliterator");
        jFrame.setSize(320, 240);
        jFrame.setLocationRelativeTo(null);
        jFrame.setLayout(new FlowLayout());
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        final JTextField jTextFieldIn = new JTextField();
        jTextFieldIn.setPreferredSize(new Dimension(272, 24));

        final JTextField jTextFieldOut = new JTextField();
        jTextFieldOut.setPreferredSize(new Dimension(272, 24));

        final JButton jButtonTranslit = new JButton();
        jButtonTranslit.setPreferredSize(new Dimension(72, 24));
        jButtonTranslit.setText("Translit");
        jButtonTranslit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextFieldOut.setText(translit(jTextFieldIn.getText()));
            }
        });

        final JButton jButtonClear = new JButton();
        jButtonClear.setText("Clear");
        jButtonClear.setPreferredSize(new Dimension(72, 24));
        jButtonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextFieldIn.setText("");
                jTextFieldOut.setText("");
            }
        });

        jFrame.add(jTextFieldIn);
        jFrame.add(jTextFieldOut);
        jFrame.add(jButtonTranslit);
        jFrame.add(jButtonClear);
        jFrame.setVisible(true);

    }

    private static String translit(String text) {
        String resultString = "";
        final char[] chars = text.toCharArray();
        for (char c : chars) {
            final char lowerCaseChar = Character.toLowerCase(c);
            if (characterStringMap.containsKey(lowerCaseChar)) {
                final String translitCharValue = characterStringMap.get(lowerCaseChar);
                if (Character.isLowerCase(c)) {
                    resultString = resultString + translitCharValue;
                } else {
                    resultString = resultString + translitCharValue.toUpperCase();
                }
            } else {
                resultString += c;
            }
        }
        return resultString;
    }

}
