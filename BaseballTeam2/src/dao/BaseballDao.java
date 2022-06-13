package dao;

import dto.Batter;
import dto.Human;
import dto.Pitcher;
import fileIO.FileProc;

import java.awt.*;
import java.io.IOException;
import java.net.SocketImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaseballDao {

    Scanner sc = new Scanner(System.in);
    public static int id=1;

    List<Human> list = new ArrayList<Human>();
    //시작하면 파일만들기
    public BaseballDao() throws IOException {
        FileProc.createFile();
        //load시키기
        loadFile();
    }

    //추가
    public void insert() {
        System.out.print("이름: ");
        String name = sc.next();
        System.out.print("나이: ");
        int age = sc.nextInt();
        System.out.print("키: ");
        double height = sc.nextDouble();
        System.out.print("포지션: pitcher(1) batter(2) ");
        int position = sc.nextInt();

        Human human=null;

        if(position==1){
            //투수 관련 정보 받기
            human=pitcherInfoInsert(name,age,height);
        }else{
            //타자 관련 정보 받기
            human=batterInfoInsert(name,age,height);
        }

        list.add(human);
    }


    public Human pitcherInfoInsert(String name, int age, double height){
        System.out.print("승: ");
        int win = sc.nextInt();
        System.out.print("패: ");
        int lose = sc.nextInt();
        System.out.print("방어율: ");
        double defence = sc.nextDouble();

        Human human = new Pitcher(id++,name,age,height,"투수",win,lose,defence);

        return human;
    }

    public Human batterInfoInsert(String name, int age, double height){
        System.out.print("타수: ");
        int bat = sc.nextInt();
        System.out.print("안타수: ");
        int hit = sc.nextInt();
        System.out.print("타율: ");
        double batAvg = sc.nextDouble();

        Human human = new Pitcher(id++,name,age,height,"타자",bat,hit,batAvg);

        return human;
    }

    public void delete() {
        System.out.println(list.toString());
        List<Integer> findIdx = allSearch();

        if(findIdx.isEmpty()) {
            System.out.println("삭제할 데이터가 없습니다.");
            return;
        }

        //삭제하면 idx가 바뀜
        int n=0;
        for(int i:findIdx){
            list.remove(i-n);
            n++;
        }

        System.out.println("삭제가 완료되었습니다.");

    }

    //찾기
    public List<Integer> allSearch() {
        List<Integer> findIdx = new ArrayList<>();
        int i=0;

        System.out.print("선수명: ");
        String name = sc.next();

        for(Human h:list) {
            if(name.equals(h.getName())) {
                findIdx.add(h.getId() - 1);
            }
        }

        return findIdx;

    }

    public int search() {
        int idx=-1;

        System.out.print("선수명: ");
        String name = sc.next();

        for(Human h:list) {
            if(name.equals(h.getName())) {
                idx = h.getId() - 1;
                return idx;
            }
        }

        return idx;
    }

    public void update() {
        int findIdx = search();

        if(findIdx==-1) {
            System.out.println("수정할 데이터가 없습니다.");
            return;
        }

        Human human = list.get(findIdx);
        //투수이면
        if(human instanceof Pitcher) {
            System.out.print("승: ");
            int win = sc.nextInt();
            System.out.print("패: ");
            int lose = sc.nextInt();
            System.out.print("방어율: ");
            double defence = sc.nextDouble();

            Pitcher p = (Pitcher) human;
            p.setWin(win);
            p.setLose(lose);
            p.setDefence(defence);
        }else{
            System.out.print("타수: ");
            int bat = sc.nextInt();
            System.out.print("안타수: ");
            int hit = sc.nextInt();
            System.out.print("타율: ");
            double batAvg = sc.nextDouble();

            Batter b = (Batter) human;
            b.setBat(bat);
            b.setHit(hit);
            b.setBatAvg(batAvg);
        }

        System.out.println("수정 완료");
    }

    public void dataPrint() {
        if(list.size()==0) {
            System.out.println("저장된 데이터가 없습니다.");
            return;
        }

        for(Human h:list){
            System.out.println(h.toString());
        }
    }

    //검색결과 출력
    public void select(){
        List<Integer> findIdx = allSearch();

        if(findIdx.isEmpty()){
            System.out.println("검색한 선수를 찾을 수 없습니다.");
            return;
        }

        for(int i:findIdx){
            String s = list.get(i).toString();
            System.out.println(s);
        }
    }

    public void writeFile() throws IOException {
        FileProc.saveFile(list);
    }

    public void loadFile() throws IOException {
        String[] datas = FileProc.readFile();
        list.clear();

        for (String data : datas) {
            String[] d = data.split(" ");

            Human readHuman = null;
            if(d[4].equals("투수")){
                readHuman = new Pitcher(Integer.parseInt(d[0]),
                        d[1],
                        Integer.parseInt(d[2]),
                        Double.parseDouble(d[3]),
                        d[4],
                        Integer.parseInt(d[5]),
                        Integer.parseInt(d[6]),
                        Double.parseDouble(d[7]));
            }else{
                readHuman = new Batter(Integer.parseInt(d[0]),
                        d[1],
                        Integer.parseInt(d[2]),
                        Double.parseDouble(d[3]),
                        d[4],
                        Integer.parseInt(d[5]),
                        Integer.parseInt(d[6]),
                        Double.parseDouble(d[7]));
            }
            list.add(readHuman);
        }
    }
}
