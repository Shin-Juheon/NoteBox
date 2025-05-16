import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static ArrayList<String> NoteBox = new ArrayList<>();

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
                            4. 할 일 수정                       
                            5. 종료
                            메뉴 선택: """);
            num = sc.nextInt();
            sc.nextLine();

            switch (num) {
                case 1:
                    System.out.println("추가할 할 일 입력: ");
                    String memo = sc.nextLine();
                    addTask(memo);
                    break;
                case 2:
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("옳은 번호로 다시 시도해주세요.");

            }
        } while (num != 2);

        sc.close();
    }
    public static void addTask(String memo) {
        NoteBox.add(memo);
        System.out.println("할 일이 추가되었습니다: " + memo);
    }
}


