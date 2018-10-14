

public class word{
    String word_target, word_explain;
    public word(){}

    public word(String line){
        this.word_target = line.substring(0,line.indexOf('|'));
        this.word_explain = line.substring(line.indexOf('|')+1);
    }

    public word(String eng, String vie){
        this.word_target = eng;
        this.word_explain = vie;
    }
}
