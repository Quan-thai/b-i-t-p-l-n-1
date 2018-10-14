import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        dictionaryCmd dcmd = new dictionaryCmd();
        dcmd.insertFromFile();
        int chon;
        while (true){
            System.out.println("Tu dien A-V");
            System.out.println("Menu: ");
            System.out.println("1) Them 1 tu.");
            System.out.println("2) Sua 1 tu.");
            System.out.println("3) Xoa 1 tu.");
            System.out.println("4) Tat ca cac tu.");
            System.out.println("5) Tim 1 tu.");
            System.out.println("6) Thoat.");
            chon = sc.nextInt();
            sc.nextLine();
            if (chon == 1) dcmd.addWord();
             else if (chon == 2) dcmd.editWord();
              else if (chon == 3) dcmd.deleteWord();
               else if (chon == 4) dcmd.showAll();
                else if (chon == 5) dcmd.search();
                 else if (chon == 6) break;
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        }

    }
}
