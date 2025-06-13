// 메인 클래스
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Scanner sc = new Scanner(System.in);
        NoteClass noteClass = new NoteClass();
        int choice;
        boolean exit = true;

        while (exit) {
            printMenu();

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    //메모 추가하기
                    noteClass.addNote(sc);
                    break;
                case 2:
                    //메모 삭제하기
                    exit = noteClass.deleteNote(sc);
                    break;
                case 3:
                    //전체 목록 출력하기
                    noteClass.showAllNotes();
                    break;
                case 4:
                    //메모 수정하기
                    exit = noteClass.editNote(sc);
                    break;
                case 5:
                    //메모 키워드로 검색하기
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


    private static void printMenu()
    {
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
