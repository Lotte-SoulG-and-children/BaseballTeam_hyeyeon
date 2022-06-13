package dto;

public class Pitcher extends Human{
    private  int win;
    private int lose;
    private double defence;

    public Pitcher(int id, String name, int age, double height, String position, int win, int lose, double defence) {
        super(id, name, age, height, position);
        this.win = win;
        this.lose = lose;
        this.defence = defence;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public double getDefence() {
        return defence;
    }

    public void setDefence(double defence) {
        this.defence = defence;
    }

    @Override
    public String toString() {
        return super.toString()+
                " " + win +
                " " + lose +
                " " + defence;
    }
}
