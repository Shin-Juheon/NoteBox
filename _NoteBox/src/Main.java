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

                switch (num) {
                    case 1:
                        System.out.println("추가할 할 일 입력: ");
                    case 2:
                        System.out.println("프로그램을 종료합니다.");
                        break;
                    default:
                        System.out.println("옳은 번호로 다시 시도해주세요.");

                }
            } while (num != 2);
        }
}