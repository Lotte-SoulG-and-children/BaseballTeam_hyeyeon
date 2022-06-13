package main;

import dao.BaseballDao;

import java.io.IOException;
import java.util.Scanner;

public class MainClass  {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        BaseballDao dao = new BaseballDao();

        int cho;

        while(true) {

            System.out.println("====================menu=================");
            System.out.println("1.선수 정보 입력");
            System.out.println("2.선수 정보 삭제");
            System.out.println("3.선수 정보 검색");
            System.out.println("4.선수 정보 수정");
            System.out.println("5.선수 데이터 모두 출력");
            System.out.println("6.파일 저장");
//            System.out.println("8.정렬하기");
            System.out.println("7.종료");
            System.out.print("입력 >> ");
            cho = sc.nextInt();

            switch(cho) {
                case 1://선수 정보 입력
                    dao.insert();
                    break;
                case 2://선수 정보 삭제
                    dao.delete();
                    break;
                case 3://선수 정보 검색
                    dao.select();
                    break;
                case 4://선수 정보 수정
                    dao.update();
                    break;
                case 5://데이터 모두 출력
                    dao.dataPrint();
                    break;
                case 6://파일에 저장
                    dao.writeFile();
                    break;
//                case 8://정렬
//                    dao.sort();
//                    break;
                default:
                    System.exit(0);
            }


        }
    }
}
