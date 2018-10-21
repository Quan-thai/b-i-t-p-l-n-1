import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

public class Add extends DictionaryManagement {
    @SuppressWarnings("empty-statement")
    public void addWord(){
        JFrame addFrame = new JFrame();
        JButton okButton;
        JButton cancelButton;
        JButton openFile;
        JLabel Eng,Vie,tWord, link, status;
        JComboBox Type;
        JTextField engText, vieText;
        // init
        engText = new JTextField();
        vieText = new JTextField();
        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");;
        Eng = new JLabel("English");
        Vie = new JLabel("Vietnam");
        //tWord = new JLabel("Type");
        status = new JLabel("");
        Type = new JComboBox();
        Type.setModel(new DefaultComboBoxModel<>(new String[] { "Adj", "Adv", "Noun", "Verb" }));

        okButton.setBounds(115,220,80,30);
        cancelButton.setBounds(210,220,80,30);
        Eng.setBounds(10, 5, 50, 50);
        engText.setBounds(75, 15, 200, 30);
        Vie.setBounds(10, 40, 70, 50);
        vieText.setBounds(75, 50, 200, 30);

        addFrame.add(Eng);
        addFrame.add(Vie);
        //addFrame.add(tWord);
        addFrame.add(engText);
        addFrame.add(vieText);
        addFrame.add(okButton);
        addFrame.add(cancelButton);
        //addFrame.add(Type);
        //addFrame.add(status);
        addFrame.setTitle("Add Your Word");
        addFrame.setSize(300, 300);
        addFrame.setLocation(500, 200);
        addFrame.setResizable(false);
        addFrame.setLayout(null);
        addFrame.setVisible(true);
        // action
        okButton.addActionListener((ActionEvent e) -> {
            Word addWord = new Word(engText.getText(), vieText.getText() );
            Dictionary.Words.add(addWord );
            addFrame.setVisible(false);
            try {
                dictionaryExportToFile();
            } catch (IOException ex) {
            }
        });
        cancelButton.addActionListener((ActionEvent e) -> {
            addFrame.setVisible(false);
        });
    }
}