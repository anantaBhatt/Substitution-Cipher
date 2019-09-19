import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class subtitutionCipher {

    private JFrame frame;
    //Global Initialization
    char[] key = {
        'g',
        'l',
        'a',
        'b',
        'y',
        'r',
        'd',
        'f',
        'i',
        'q',
        't',
        'p',
        'c',
        'x',
        'n',
        'o',
        'u',
        'v',
        'w',
        'e',
        'm',
        'j',
        'k',
        'h',
        's',
        'z',
        '|',
        '^',
        '?'
    };

    char[] str = new char[800];
    char[] tempVar = new char[800];
    int i, j, p;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    subtitutionCipher window = new subtitutionCipher();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public subtitutionCipher() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame("Substitution Cipher Encryptor & Decryptor");
        frame.getContentPane().setLayout(null);

        JLabel lblPlainText = new JLabel("Enter Plaintext : ");
        lblPlainText.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblPlainText.setBounds(22, 9, 104, 73);
        frame.getContentPane().add(lblPlainText);

        final JTextArea textPlainText = new JTextArea();
        textPlainText.setBounds(147, 34, 546, 88);
        frame.getContentPane().add(textPlainText);
        textPlainText.setLineWrap(true);
        textPlainText.setWrapStyleWord(true);

        JLabel lblEnterKey = new JLabel("Enter Key : ");
        lblEnterKey.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblEnterKey.setBounds(59, 170, 78, 73);
        frame.getContentPane().add(lblEnterKey);

        final JTextArea textCipher = new JTextArea();
        textCipher.setBounds(147, 321, 546, 94);
        frame.getContentPane().add(textCipher);
        textCipher.setLineWrap(true);
        textCipher.setWrapStyleWord(true);


        JLabel lblPlainText_1 = new JLabel("Plain Text");
        lblPlainText_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblPlainText_1.setBounds(59, 497, 86, 50);
        frame.getContentPane().add(lblPlainText_1);

        final JTextArea textOutPlainText = new JTextArea();
        textOutPlainText.setBounds(147, 493, 546, 94);
        frame.getContentPane().add(textOutPlainText);
        textOutPlainText.setLineWrap(true);
        textOutPlainText.setWrapStyleWord(true);

        final JButton decrypt = new JButton("Decrypt Cipher Text");
        
        final JTextArea textKey = new JTextArea();
        textKey.setBounds(147, 195, 546, 61);
        frame.getContentPane().add(textKey);

        JButton btnGenerateCipherText = new JButton("Generate Cipher Text");
        btnGenerateCipherText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                
            	
            	key = textKey.getText().toCharArray();
            	
            	str = textPlainText.getText().toCharArray();
                tempVar = str;
              
                for (i = 0; i < str.length; i++) {
                    if (tempVar[i] >= 97 && tempVar[i] <= 122) {
                        p = tempVar[i] - 97;
                        tempVar[i] = key[p];
                    } else if (tempVar[i] == 32) {
                        tempVar[i] = '|';
                    } else if (tempVar[i] == 44) {
                        tempVar[i] = '^';
                    } else if (tempVar[i] == 46) {
                        tempVar[i] = '?';
                    } else if (tempVar[i] >= 65 && tempVar[i] <= 90) {
                        p = tempVar[i] - 65;
                        tempVar[i] = key[p];
                    } else {
                        tempVar[i] = tempVar[i];
                    }
                }
                textCipher.setText("");
                String cipherText = String.copyValueOf(tempVar);
                textCipher.append(cipherText);
                decrypt.setEnabled(true);
            }
        });

       
        btnGenerateCipherText.setBounds(184, 287, 168, 23);
        frame.getContentPane().add(btnGenerateCipherText);
        frame.setBounds(100, 100, 789, 636);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton btnUsePredefinedKey = new JButton("Use Predefined Key");
        btnUsePredefinedKey.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                	textKey.setText("");
                
                	 StringBuffer result = new StringBuffer();
                	 for (int i = 0; i < key.length; i++) {
                	    result.append( key[i] );
                	 }
                	 String keyDisplay = result.toString();
                	 textKey.append(keyDisplay);
                }   
        });
        btnUsePredefinedKey.setBounds(184, 139, 168, 23);
        frame.getContentPane().add(btnUsePredefinedKey);

        JLabel lblNewLabel = new JLabel("Cipher Text");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNewLabel.setBounds(59, 321, 86, 50);
        frame.getContentPane().add(lblNewLabel);

        decrypt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
               
            	key = textKey.getText().toCharArray();
            	str = textCipher.getText().toCharArray();
            	tempVar = str;
            	
                for (i = 0; i < str.length; i++) {
                    for (j = 0; j < 26; j++) {
                        if (tempVar[i] == key[j]) {
                            tempVar[i] = (char)(j + 97);
                            break;
                        }
                        if (tempVar[i] == '|') {
                            tempVar[i] = 32;
                            break;
                        }
                        if (tempVar[i] == '^') {
                            tempVar[i] = 44;
                            break;
                        }
                        if (tempVar[i] == '?') {
                            tempVar[i] = 46;
                            break;
                        }
                    }
                }
                textOutPlainText.setText("");
                String plainTextOut = String.copyValueOf(tempVar);
                textOutPlainText.append(plainTextOut);
                decrypt.setEnabled(false);
            }
        });
        decrypt.setBounds(184, 433, 168, 23);
        frame.getContentPane().add(decrypt);
        
        JLabel lblOr = new JLabel("OR");
        lblOr.setBounds(166, 170, 46, 14);
        frame.getContentPane().add(lblOr);
    }
}