package edu.pageWrapper;

public class PDAPost {
    String title;
    String info;
    int number;

    String CARD_ID = "//div[@class='tc-orgpotential_wrapper-card margin-right-16 margin-bottom-16 ']";
    String TITLE_ID = "//div[@class='title font-normal-15 font-bold-15 black-card']";




    public PDAPost(String info, String title) {
        this.title = title;
        this.info = info;
    }

    @Override
    public String toString() {
        return "PDAPost{" +
                "title='" + title + '\'' +
                ", info='" + info + '\'' +
                ", number=" + number +
                '}';
    }
}
