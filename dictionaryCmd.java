import java.io.*;
import java.util.*;

public class dictionaryCmd extends dictionary {

    public void showAll(){
        for(word i : data){
            System.out.println(i.word_target + ": " + i.word_explain);
        }
    }

    public void insertFromFile(){
        try{
            File f = new File("dictionary.txt");
            FileReader fr = new FileReader(f);
            BufferedReader brd = new BufferedReader(fr);
            String line, eng, vie;
            while ((line = brd.readLine())!=null){
                data.add(new word(line));
            }
            fr.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void exportToFile(){
        try {
            File f = new File("dictionary.txt");
            FileWriter fw = new FileWriter(f);
            for(word i : data){
                fw.write(i.word_target + "|" + i.word_explain + "\n");
            }
            fw.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    public void addWord(){
        Scanner sc = new Scanner(System.in);
        String eng, vie;
        System.out.println("Nhap tu tieng Anh:");
        eng = sc.nextLine();
        System.out.println("Nhap tu tieng Viet:");
        vie = sc.nextLine();
        data.add(new word(eng,vie));
        exportToFile();
    }

    public void editWord(){
        Scanner sc = new Scanner(System.in);
        String w;
        System.out.println("Nhap tu can sua: ");
        w = sc.nextLine();
        for(word i : data){
            if (i.word_target.equals(w)){
                System.out.println("Nhap nghia moi: ");
                i.word_explain =sc.nextLine();
                exportToFile();
                return;
            }
        }
        System.out.println("Khong thay tu!");
    }

    public void deleteWord(){
        Scanner sc = new Scanner(System.in);
        String w;
        System.out.println("Nhap tu can xoa: ");
        w = sc.nextLine();
        for(word i : data){
            if (i.word_target.equals(w)) {data.remove(i); break;}
        }
        exportToFile();
    }

    public void search(){
        Scanner sc = new Scanner(System.in);
        List<word> searchData = new ArrayList<word>(data);
        char kiTu;
        int viTri = 0;
        String tuDangTim = "";
        while(searchData.size()!=0 && searchData.size()!=1){
            System.out.print("Tim: " + tuDangTim);
            kiTu = sc.next().charAt(0);
            tuDangTim+=kiTu;
            for(int i = 0; i < searchData.size(); i++){
                if (searchData.get(i).word_target.charAt(viTri) != kiTu) {searchData.remove(i); i--;}
            }
            viTri++;
            for(word w : searchData){
                System.out.println(w.word_target);
            }
            System.out.println("--------------------------------------");
        }
        if (searchData.size() == 1)System.out.println("Tu can tim: " + searchData.get(0).word_target + ": " +searchData.get(0).word_explain);
         else System.out.println("Khong tim thay");
    }

}
