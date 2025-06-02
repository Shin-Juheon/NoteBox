import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Scanner sc = new Scanner(System.in);
        NoteClass noteClass = new NoteClass();
        int choice;

        while (true) {
            printMenu();

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    // 메모 추가
                    noteClass.addNote(sc);
                    break;
                case 2:
                    // 메모 삭제
                    noteClass.deleteNote(sc);
                    break;
                case 3:
                    // 전체 목록
                    noteClass.showAllNotes();
                    break;
                case 4:
                    // 메모 수정
                    noteClass.editNote(sc);
                    break;
                case 5:
                    // 검색
                    noteClass.findNotes(sc);
                    break;
                case 6:
                    // 종료
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("옳은 번호로 다시 시도해주세요.\n");

            }
        }

    }

    private static void printMenu() {
        System.out.print(
                """
                        -- NoteBox --
                        1. 메모 추가
                        2. 메모 삭제
                        3. 전체 목록 보기
                        4. 메모 수정
                        5. 검색                     
                        6. 종료
                        메뉴 선택: """);
    }
}

