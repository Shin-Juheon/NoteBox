import java.util.ArrayList;
import java.util.Scanner;

public class NoteClass {
    private ArrayList<String> noteBox = new ArrayList<>();

    // 추가 메서드
    public void addNote(Scanner sc) {
        System.out.println("추가할 메모 입력: ");
        String memo = sc.nextLine();
        noteBox.add(memo);
        System.out.println("메모가 추가되었습니다: " + memo + "\n");
    }


    //전체 출력 메서드
    public boolean showAllNotes() {
        System.out.println("=== 전체 목록 ===");
        if (noteBox.isEmpty()) {
            System.out.println("비어있습니다.\n");
            return true;

        }
        for (int i = 0; i < noteBox.size(); i++) {
            System.out.println((i + 1) + ". " + noteBox.get(i));
        }
        return false;
    }


    //삭제 메서드
    public void deleteNote(Scanner sc) {
        if (showAllNotes()) return;


        System.out.println("삭제할 번호를 입력하세요 " +
                "(0 입력 시 전체 삭제): ");
        int num = sc.nextInt();
        sc.nextLine();

        //유효성 검사
        if (num < 0 || num > noteBox.size()) {
            System.out.println("옳은 번호로 다시 시도해주세요.\n");
        }

        if (num == 0) {
            noteBox.clear();
            System.out.println("모든 메모가 삭제되었습니다.");
            return;
        }

        //개별 삭제
        String erase = noteBox.remove(num -1);
        System.out.println("삭제된 메모: " + num + "번 =>  " + erase + "\n");
        showAllNotes();
        System.out.println();
    }

    // 수정 메서드
    public void editNote(Scanner sc) {
        if (showAllNotes()) return;

        System.out.println("수정할 번호를 입력하세요: ");
        int num = sc.nextInt();
        sc.nextLine();

        // 유효성 검사
        if (num < 1 || num > noteBox.size()) {
            System.out.println("옳은 번호로 다시 시도해주세요.\n");
        }

        String oldM = noteBox.get(num - 1);
        System.out.println("기존 내용: " + oldM);

        // 수정 내용
        System.out.println("새 내용을 입력하세요: ");
        String newM = sc.nextLine();

        noteBox.set(num - 1, newM);
        System.out.println("수정되었습니다.\n");
        showAllNotes();
        System.out.println();
    }

    // 검색 메서드
    public void findNotes(Scanner sc) {
        if (showAllNotes()) return;

        System.out.println("검색할 단어를 입력하세요: ");
        String keyword = sc.nextLine();

        System.out.println("=== 검색 결과 ===");
        boolean f = false;
        for (int i = 0; i < noteBox.size(); i++) {
            String memo = noteBox.get(i);
            if (memo.contains(keyword)) {
                System.out.println((i + 1) + ". " + memo);
                f = true;
            }
        }

        if (!f) {
            System.out.println("검색 결과가 없습니다.");
        }
        System.out.println();
    }

//    // 메뉴로 가기 or 종료하기 메서드(NoteClass내에서만 사용함)
//    private void askExit (Scanner sc) {
//        while (true) {
//            System.out.println("1: 메뉴, 2: 종료")
//        }
//    }
}

