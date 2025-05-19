import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static ArrayList<String> NoteBox = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;

        while (true) {
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
                    //할 일 추가
                    NoteBox.add(memo);
                    System.out.println("할 일이 추가되었습니다: " + memo);
                    break;
                case 2:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                case 3:
                    delete(sc);
                default:
                    System.out.println("옳은 번호로 다시 시도해주세요.");

            }
        }
    }

    //전체 저장 항목 메서드
    public static void myList() {
        System.out.println("=== 전체 목록 ===");
        if (NoteBox.isEmpty()) {
            System.out.println("비어있습니다.");
            return;
        }
        for (int i = 0; i < NoteBox.size(); i++) {
            System.out.println((i + 1) + ". " + NoteBox.get(i));
        }
    }


    //삭제 메서드
    public static void delete(Scanner sc) {
        myList();

        if (NoteBox.isEmpty()) {
            return;
        }

        //
        System.out.println("삭제할 할 일 번호를 입력하세요 " +
                "(0 입력 시 전체 삭제): ");
        int eraser = sc.nextInt();
        sc.nextLine();

        //if (num < 0)
            //System.out.println("옳은 번호로 다시 시도해주세요.");
            //return;


        if (eraser == 0) {
            NoteBox.clear();
            System.out.println("모든 할 일이 삭제되었습니다.");
        }
    }
}

