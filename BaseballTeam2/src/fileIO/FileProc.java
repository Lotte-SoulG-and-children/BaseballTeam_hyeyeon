package fileIO;

import dto.Human;

import java.io.*;
import java.util.List;

public class FileProc {

    public FileProc() {

    }

    // file 생성
    public static void createFile() {
        String filename = "baseballMember";

        File newfile = new File("c:\\Temp\\" + filename + ".txt");

        // 파일 존재 여부
        if (isFile(newfile)) {
            System.out.println("파일이 존재합니다.");
        } else {
            try {
                newfile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 파일 입출력
    public static void saveFile(List<Human> list) throws IOException {
        String filename = "baseballMember";

        File savefile = new File("c:\\Temp\\" + filename + ".txt");

        if (!isFile(savefile)) {
            System.out.println("저장할 파일이 존재하지 않습니다.");
        }

        //파일에 쓰기
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(savefile)));
        for(Human h:list) {
//            System.out.println(h.toString());
            pw.println(h.toString());
        }
        pw.close();

        System.out.println("데이터 저장 완료");
    }

    public static String[] readFile() {
        String datas[] = null;
        String filename = "baseballMember";

        File file = new File("c:\\Temp\\" + filename + ".txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            // data 총수를 구한다
            int count = 0;
            String str = "";

            while((str = br.readLine()) != null) {
                count++;
            }
            br.close();

            // datas 할당
            datas = new String[count];

            // data를 취합 -> datas
            br = new BufferedReader(new FileReader(file));
            int w = 0;
            while((str = br.readLine()) != null) {
                datas[w] = str;
                w++;
            }
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return datas;
    }

    //file 존재 여부
    public static boolean isFile(File file) {
        //파일이 존재하지 않으면
        if(!file.exists()) {
            return false;
        }

        return true;
    }
}
