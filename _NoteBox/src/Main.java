import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static ArrayList<String> NoteBox = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

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
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("추가할 할 일 입력: ");
                    String memo = sc.nextLine();
                    // 메모 추가
                    NoteBox.add(memo);
                    System.out.println("할 일이 추가되었습니다: " + memo + "\n");
                    break;
                case 2:
                    // 메모 삭제
                    delete(sc);
                    break;
                case 3:
                    // 전체 목록
                    myList();
                    break;
                case 4:
                    edit(sc);
                    break;
                case 5:
                    // 종료
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("옳은 번호로 다시 시도해주세요.\n");

            }
        }
    }

    //전체 저장 항목 메서드
    public static void myList() {
        System.out.println("=== 전체 목록 ===");
        if (NoteBox.isEmpty()) {
            System.out.println("비어있습니다.\n");
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

        System.out.println("\n삭제할 번호를 입력하세요 " +
                "(0 입력 시 전체 삭제): ");
        int num = sc.nextInt();
        sc.nextLine();

        //유효성 검사
        if (num < 0 || num > NoteBox.size()) {
            System.out.println("옳은 번호로 다시 시도해주세요.\n");
            return;
        }

        //
        if (num == 0) {
            NoteBox.clear();
            System.out.println("모든 할 일이 삭제되었습니다.");
            return;
        }

        //개별 삭제
        String parteraser = NoteBox.remove(num -1);
        System.out.println("삭제된 할 일: " + num + "번 =>  " + parteraser);
        myList();
    }

    // 수정 메서드
    public static void edit(Scanner sc) {
        myList();

        if (NoteBox.isEmpty()) {
            return;
        }

        System.out.println("\n수정할 번호를 입력하세요: ");
        int num = sc.nextInt();
        sc.nextLine();

        // 유효성 검사
        if (num < 1 || num > NoteBox.size()) {
            System.out.println("옳은 번호로 다시 시도해주세요.\n");
            return;
        }

        // 기존 내용
        String oldM  = NoteBox.get(num - 1);
        System.out.println("기존 내용: + " + oldM);

        System.out.println("새 내용을 입력하세요: ");
        String newM = sc.nextLine();
    }
}

