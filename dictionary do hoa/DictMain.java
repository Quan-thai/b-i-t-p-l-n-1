import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javazoom.jl.player.Player;
import javazoom.jl.decoder.JavaLayerException;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class DictMain extends DictionaryManagement implements ActionListener {
    private JFrame frame ;
    private JButton exit;
    private JButton dich;
    private JButton phatAm;
    private JButton xoaTu;
    private JButton themTu;
    private JButton suaTu;
    private JTextField input;
    public JTextArea output;
    private JMenuBar menuBar = new JMenuBar();
    private final DefaultListModel<String> readJL = new DefaultListModel<>();
    private JList dicList = new JList(readJL);
    private JScrollPane listWord = new JScrollPane(dicList);
    public final void Init() throws IOException{
        frame = new JFrame();

        suaTu = new JButton("Sửa Từ");
        exit = new JButton("Thoát");       //thoat
        exit.setBounds(200, 130, 90, 30);
        dich = new JButton("Dịch");       // dich
        dich.setBounds(200, 30, 90, 30);
        phatAm = new JButton("Phát Âm");  // phat am
        phatAm.setBounds(200, 80, 90, 30);
        xoaTu = new JButton("Xóa Từ");    // xoa tu
        themTu = new JButton("Thêm Từ");  //them tu
        input = new JTextField("");             //input
        input.setBounds(10, 30, 170, 50);
        listWord.setBounds(10, 90, 170, 240 );
        output = new JTextArea();               //output
        output.setBounds(310, 30, 170,300);
        frame.setTitle("Dictionary");
        readFile();                     //doc vao file
        frame.setSize(500, 400);        //
        frame.setLocation(400, 200);    //set frame
        frame.setLayout(null);          //
        frame.setVisible(true);         //
        frame.setResizable(false);      //
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.add(output);          //   add vao frame hien ra man hinh
        frame.add(input);           //
        frame.add(themTu);    //
        frame.add(xoaTu);     //
        frame.add(phatAm);    //
        frame.add(dich);      //
        frame.add(exit);      //
        frame.add(suaTu);     //
        frame.add(listWord);
        menuBar.add(themTu);
        menuBar.add(suaTu);
        menuBar.add(xoaTu);
        menuBar.setSize(500,20);
        menuBar.setLocation(0,0);
        frame.add(menuBar);
    }
    public void speak(String word){

    }
    public void Action(){
        exit.addActionListener(this);
        dich.addActionListener(this);
        phatAm.addActionListener(this);
        themTu.addActionListener(this);
        xoaTu.addActionListener(this);
        suaTu.addActionListener(this);
        dicList.addMouseListener(new ActionJList(dicList));
    }
    @Override
    public void actionPerformed(ActionEvent e) {    //xu ly khi nhan vao nut
        if ((JButton) e.getSource() == dich){
            dictionaryLookup(input.getText(), readJL);      //ham lookup
        }
        if ((JButton) e.getSource() == phatAm){
            try {
                FileInputStream fis = new FileInputStream("pronunciation/" + input.getText() + ".mp3");
                Player player = new Player(fis);
                player.play();
            } catch (FileNotFoundException ex) {
                System.out.println(ex.toString());
            } catch (JavaLayerException ex1) {
                System.out.println(ex1.toString());
            }
        }
        if ((JButton) e.getSource() == exit){
            System.exit(0);
        }
        if ((JButton) e.getSource() == themTu){
            Add ad = new Add();
            ad.addWord();
        }
        if ((JButton) e.getSource() == xoaTu){
            try {
                Del de = new Del();
                de.delete();
            } catch (IOException ex) {
                Logger.getLogger(DictMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if ((JButton) e.getSource() == suaTu){
            Edit re = new Edit();
            re.repair();
        }

    }
    public void readFile() throws IOException{        //doc dau vao file = insertFromFile
        super.insertFromFile();
    }

    class ActionJList extends MouseAdapter{ //ob check con tro chuot
        protected JList list;
        public ActionJList(JList l){
            list = l;
        }
        @Override
        public void mouseClicked(MouseEvent e){
            int Index =0;
            boolean check =false;
            if(e.getClickCount() == 1){
                int index = list.locationToIndex(e.getPoint());
                ListModel dlm = list.getModel();
                Object item = dlm.getElementAt(index);
                list.ensureIndexIsVisible(index);
                for(int i=0;i<Words.size();++i)
                    if(item.equals(Words.get(i).getWord_target())){
                        Index=i;
                        check = true;
                        break;
                    }
                output.setText(Words.get(Index).getWord_explain());
            }
            if (check == false){
                output.setText(input.getText());
            }
        }
    }
    public DictMain() throws IOException{

        Init();
        Action();
    }
    public static void main(String[] args) throws IOException{
        DictMain dicJF = new DictMain();
    }
}
