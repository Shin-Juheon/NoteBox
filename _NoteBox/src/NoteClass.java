/**
 * 기능을 담당하는 클래스 (메서드가 많아 가독성이 떨어져 주석으로 정리)
 * addNote(InputManager input) - 메모를 입력받아 리스트에 추가한다
 * showAllNotes() - 전체 목록을 출력한다.
 * deleteNote(InputManager input) - 메모를 삭제한다
 * editNote(InputManager input) - 메모를 수정한다
 * findNotes(InputManager input) - 키워드로 리스트에 저장되어있는 메모를 검색해 출력한다
 * -------------------------------------------------
 * 클래스 내부 메서드
 * checkNum() - 유효성 검사
 * promptNoteNumber() - 코드 단축화 목적
 * askExit - 삭제, 수정이후 메뉴 or 종료 기능
 * printDeleteMemo(), printEditMemo(), printKeywordResult() - 입력 받은 이후 출력을 당담함
 */
import java.util.ArrayList;
import java.util.Scanner;

public class NoteClass {
    private final ArrayList<Note> noteBox = new ArrayList<>();


    //유효성 검사
    private boolean checkNum(int num, int min) {
        return num >= min && num <= noteBox.size();
    }
    //유효성 검사 호출할때 코드 단축화
    private int promptNoteNumber(InputManager input, String adminInput , int min) {
        showAllNotes();
        if (noteBox.isEmpty()) return -1;

        int num = input.getInt(adminInput + "할 번호를 입력하세요: ");

        if (!checkNum(num, min)) {
            System.out.print("옳은 번호로 다시 시도해주세요.\n");
            return -1;
        }
        return num;
    }
    // 삭제,수정 이후 메뉴 종료 묻기
    private boolean askExit(InputManager input) {
        while (true) {
            int choose = input.getInt("1: 메뉴, 2: 종료");
            System.out.println();

            switch (choose) {
                case 1:
                    return true;
                case 2:
                    System.out.println("프로그램을 종료합니다.");
                    return false;
                default:
                    System.out.println("1 또는 2를 입력해주세요.\n");
            }
        }
    }
    //메모 추가하기
    public void addNote(InputManager input) {
        String memo = input.getLine("추가할 메모를 입력하세요");
        Note note = new Note(memo);
        noteBox.add(note);
        System.out.println("메모가 추가되었습니다: " + memo + "\n");
    }
    //전체 목록 출력하기
    public boolean showAllNotes() {
        System.out.println("=== 전체 목록 ===");
        if (noteBox.isEmpty()) {
            System.out.println("비어있습니다.\n");
            return true;
        }
        for (int i = 0; i < noteBox.size(); i++) {
            System.out.println((i + 1) + ". " + noteBox.get(i).getNoteMemo());
        }
        System.out.println();
        return false;
    }
    //메모 삭제하기
    public boolean deleteNote(InputManager input) {
        int num = promptNoteNumber(input, "삭제(0은 전체삭제)", 0);
        if (num == -1) return true;

        if (num == 0) {
            noteBox.clear();
            System.out.println("모든 메모가 삭제되었습니다.");
            return askExit(input);
        }
        Note erase = noteBox.remove(num - 1);
        printDeleteMemo(num, erase);
        return askExit(input);
    }

    private void printDeleteMemo(int num, Note erase)
    {
        System.out.println("삭제된 메모: " + num + "번 =>  " + erase.getNoteMemo() + "\n");
        showAllNotes();
        System.out.println();
    }
    // 메모 수정하기
    public boolean editNote(Scanner sc)
    {
        int num = promptNoteNumber(sc, "수정", 1);
        if (num == -1) return true;

        Note note= noteBox.get(num - 1);
        System.out.println("기존 내용: " + note.getNoteMemo());

        System.out.println("새 내용을 입력하세요 ");
        String newNoteMemo = sc.nextLine();
        note.setNoteMemo(newNoteMemo);

        printEditMemo();
        return askExit(sc);
    }

    private void printEditMemo()
    {
        System.out.println("수정되었습니다.\n");
        showAllNotes();
        System.out.println();
    }
    //메모 키워드로 검색하기
    public void findNotes(Scanner sc) {
        if (showAllNotes())
            return;

        System.out.println("검색하고 싶은 문장의 키워드를 입력하세요");
        String keyword = sc.nextLine().trim();

        System.out.println("=== 검색 결과 ===");
        printKeywordResult(keyword);
        System.out.println();
    }

    private void printKeywordResult (String keyword) {
        boolean inputKeyword = false;
        for (int i = 0; i < noteBox.size(); i++) {
            String memo = noteBox.get(i).getNoteMemo();
            if (memo.contains(keyword)) {
                System.out.println((i + 1) + ". " + memo);
                inputKeyword = true;
            }
        }
        if (!inputKeyword)
        {
            System.out.println("검색 결과가 없습니다.");
        }
    }
}