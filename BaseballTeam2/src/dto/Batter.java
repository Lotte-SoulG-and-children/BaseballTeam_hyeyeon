package dto;

public class Batter extends Human{
    private int bat;//타수
    private int hit;//안타수
    private double batAvg; //타율

    public Batter(int id, String name, int age, double height, String position, int bat, int hit, double batAvg) {
        super(id, name, age, height, position);
        this.bat = bat;
        this.hit = hit;
        this.batAvg = batAvg;
    }

    public int getBat() {
        return bat;
    }

    public void setBat(int bat) {
        this.bat = bat;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public double getBatAvg() {
        return batAvg;
    }

    public void setBatAvg(double batAvg) {
        this.batAvg = batAvg;
    }

    @Override
    public String toString() {
        return super.toString()+
                " " + bat +
                " " + hit +
                " " + batAvg;
    }


}
