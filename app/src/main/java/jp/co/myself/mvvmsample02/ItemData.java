package jp.co.myself.mvvmsample02;

public class ItemData {

    private String name;

    private String maker;

    public ItemData(String name, String maker) {
        this.name = name;
        this.maker = maker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

}
