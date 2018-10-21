public class Word {
    private String word_target;
    private String word_explain;

    public Word(){
    }

    public Word(String eng, String viet) {
        this.word_target = eng;
        this.word_explain = viet;
    }

    public Word(String line){
        this.word_target = line.substring(0,line.indexOf('|'));
        this.word_explain = line.substring(line.indexOf('|')+1);
    }

    public String getWord_target() {
        return word_target;
    }


    public String getWord_explain() {
        return word_explain;
    }

}