import java.util.ArrayList;
import java.util.Scanner;

public class NoteClass {
    public ArrayList<String> noteBox = new ArrayList<>();

    // 추가 메서드
    public void addNote(Scanner sc) {
        System.out.println("추가할 할 일 입력: ");
        String memo = sc.nextLine();
        noteBox.add(memo);
        System.out.println("할 일이 추가되었습니다: " + memo + "\n");
    }


    //전체 출력 메서드
    public void showAllNotes() {
        System.out.println("=== 전체 목록 ===");
        if (noteBox.isEmpty()) {
            System.out.println("비어있습니다.\n");

        }
        for (int i = 0; i < noteBox.size(); i++) {
            System.out.println((i + 1) + ". " + noteBox.get(i) + "\n");
        }
    }


    //삭제 메서드
    public void deleteNote(Scanner sc) {
        showAllNotes();

        if (noteBox.isEmpty()) {
            return;
        }

        System.out.println("\n삭제할 번호를 입력하세요 " +
                "(0 입력 시 전체 삭제): ");
        int num = sc.nextInt();
        sc.nextLine();

        //유효성 검사
        if (num < 0 || num > noteBox.size()) {
            System.out.println("옳은 번호로 다시 시도해주세요.\n");
        }

        if (num == 0) {
            noteBox.clear();
            System.out.println("모든 할 일이 삭제되었습니다.");
        }

        //개별 삭제
        String erase = noteBox.remove(num -1);
        System.out.println("삭제된 할 일: " + num + "번 =>  " + erase);
        showAllNotes();
    }

    // 수정 메서드
    public void editNote(Scanner sc) {
        showAllNotes();

        if (noteBox.isEmpty()) {
            return;
        }

        System.out.println("\n수정할 번호를 입력하세요: ");
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
}

