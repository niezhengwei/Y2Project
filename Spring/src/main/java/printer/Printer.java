package printer;

import ink.Ink;
import paper.Paper;

/**
 * Created by leon on 2018/3/3.
 */
public class Printer {
    private Ink ink;
    private Paper paper;

    public  void print(){
        System.out.println("使用"+ink.getColorInk()+"和"+paper.getPaper()+"打印出Bug徐");
    }

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    public Ink getInk() {

        return ink;
    }

    public void setInk(Ink ink) {
        this.ink = ink;
    }
}
