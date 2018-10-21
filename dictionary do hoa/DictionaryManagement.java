import java.io.*;
import java.nio.file.Paths;
import java.util.*;
import javax.swing.DefaultListModel;

public class DictionaryManagement extends Dictionary{
    Scanner sc = new Scanner(System.in);
    public int getSize(){
        return Dictionary.Words.size();
    }
    public void insertFromFile() throws IOException{        //code them doc file
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("dictionary.txt"), "UTF-8"));
            String str, strE, strV;
            int i = 0;

            while ((str=bufferedReader.readLine())!=null){
                strE = str.substring(0,str.indexOf('|'));
                strV = str.substring(str.indexOf('|')+1);
                Dictionary.Words.add(new Word(strE,strV));
                i++;
            }
            bufferedReader.close();
        }catch (Exception e){System.out.print(e);}
    }
    public void dictionaryLookup(String lookWord, DefaultListModel<String> a) {
        a.clear();
        boolean check = false;
        for (int i = 0; i < Dictionary.Words.size(); i++) {
            if (Dictionary.Words.get(i).getWord_target().indexOf(lookWord)==0){
                a.addElement(Dictionary.Words.get(i).getWord_target());
                check = true;
            }
        }
        if (!check){
            a.addElement(lookWord);
        }
    }
    public void deleteWordFrame(String deleteWord ) throws IOException {//xoa tu

        for (int i = 0; i < Dictionary.Words.size(); i++) {
            if (deleteWord.equalsIgnoreCase(Dictionary.Words.get(i).getWord_target())) {
                Dictionary.Words.remove(i);
            }
        }
        dictionaryExportToFile();
    }

    public void repairWordFrame(String str, String eng, String viet) { // sua tu
        Word reWord = new Word(eng, viet);
        for (int i = 0; i < Dictionary.Words.size(); i++) {
            if (str.equalsIgnoreCase(Dictionary.Words.get(i).getWord_target())) {
                Words.remove(i);
                Words.add(i, reWord);
            }
        }
    }

    public void dictionaryExportToFile() throws IOException  {     //thuc hien tren file

        try{
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("dictionary.txt"), "UTF-8"));
            int n = Dictionary.Words.size();
            for(int i=0; i<n; i++) {
                writer.write(Dictionary.Words.get(i).getWord_target() + "|" + Dictionary.Words.get(i).getWord_explain() + "\n");
            }
            writer.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

}
//write.println(Dictionary.Words.get(i).getWord_target() + " " + Dictionary.Words.get(i).getWord_explain() );