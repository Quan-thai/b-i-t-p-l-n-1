import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Del extends DictionaryManagement{
    @SuppressWarnings("empty-statement")
    private final JFrame delFrame = new JFrame();
    private JButton okButton;
    private JButton cancelButton;
    public JLabel Eng,Vie ;
    public JTextField engText, vieText;
    public void delete() throws IOException{
        // init
        engText = new JTextField();                 //khoi tao + ten
        vieText = new JTextField();
        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");;
        Eng = new JLabel("English");
        Vie = new JLabel("Vietnam");

        okButton.setBounds(115,220,80,30);          //set vi tri + kich thuoc
        cancelButton.setBounds(210,220,80,30);      // 
        Eng.setBounds(10, 5, 50, 50);               //
        engText.setBounds(75, 15, 200, 30);         //
        Vie.setBounds(10, 40, 70, 50);              //
        vieText.setBounds(75, 50, 150, 30);         //

        delFrame.add(Eng);
        delFrame.add(engText);
        delFrame.add(okButton);                     //
        delFrame.add(cancelButton);
        delFrame.setTitle("Delete Your Word");      //
        delFrame.setSize(300, 300);                 //
        delFrame.setLocation(500, 200);             //
        delFrame.setResizable(false);               //
        delFrame.setLayout(null);                   //
        delFrame.setVisible(true);                  //
        // action
        cancelButton.addActionListener((ActionEvent e) -> {
            delFrame.setVisible(false);
        });
        okButton.addActionListener((ActionEvent e) -> {
            try {
                deleteWordFrame(engText.getText());
            } catch (IOException ex) {
            }
            delFrame.setVisible(false);
        });
    }
}