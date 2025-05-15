import java.util.Scanner;
import java.util.ArrayList;

public class Main {
        static ArrayList<String> memo = new ArrayList<>();

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int num;

            do {
                System.out.print(
                        """
                        -- NoteBox --
                        1. 할 일 추가
                        2. 할 일 삭제
                        3. 할 일 보기
                        4. 종료
                        메뉴 선택: """ );
                num = sc.nextInt();
                sc.nextLine();
            } while (num != 2);
        }
}