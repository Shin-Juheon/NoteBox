import java.util.ArrayList;
import java.util.Scanner;

public class NoteClass {
    private final ArrayList<Note> noteBox = new ArrayList<>();

    //유효성 검사
    private boolean checkNum(int num, int min) {
        return num >= min && num <= noteBox.size();
    }
    // 삭제,수정 이후 메뉴 종료 묻기
    private boolean askExit(Scanner sc) {
        while (true) {
            System.out.print("1: 메뉴, 2: 종료");
            int choose = sc.nextInt();
            sc.nextLine();

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
    public void addNote(Scanner sc) {
        String memo = getMemo(sc);
        Note note = new Note(memo);
        noteBox.add(note);
        System.out.println("메모가 추가되었습니다: " + memo + "\n");
    }

    private String getMemo(Scanner sc) {
        System.out.println("추가할 메모를 입력하세요");
        return sc.nextLine();
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
    public boolean deleteNote(Scanner sc) {
        if (showAllNotes())
            return true;

        int num = getDeleteMemo(sc);

        if (!checkNum(num, 0)) {
            System.out.println("옳은 번호로 입력해주세요.\n");
            return true;
        }
        if (num == 0) {
            noteBox.clear();
            System.out.println("모든 메모가 삭제되었습니다.");
            return askExit(sc);
        }
        Note erase = noteBox.remove(num - 1);
        printDeleteMemo(num, erase);
        return askExit(sc);
    }

    private int getDeleteMemo(Scanner sc) {
        System.out.println("삭제할 번호를 입력하세요 " +
                "(0 입력 시 전체 삭제)");
        int num = sc.nextInt();
        sc.nextLine();
        return num;
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
        if (showAllNotes())
            return true;
        int num = getEditMemo(sc);

        if (!checkNum(num, 1)) {
            System.out.println("옳은 번호로 입력해주세요.\n");
            return true;
        }

        Note note = noteBox.get(num - 1);
        System.out.println("기존 내용: " + note.getNoteMemo());

        System.out.println("새 내용을 입력하세요 ");
        String newNoteMemo = sc.nextLine();
        note.setNoteMemo(newNoteMemo);

        printEditMemo();
        return askExit(sc);
    }
    private int getEditMemo(Scanner sc)
    {
        System.out.print("수정할 번호를 입력하세요: ");
        int num = sc.nextInt();
        sc.nextLine();
        return num;
    }
    private void printEditMemo()
    {
        System.out.println("수정되었습니다.\n");
        showAllNotes();
        System.out.println();
    }




//    // 검색 메서드
//    public void findNotes(Scanner sc) {
//        if (showAllNotes()) return;
//
//        System.out.println("검색할 단어를 입력하세요: ");
//        String keyword = sc.nextLine();
//
//        System.out.println("=== 검색 결과 ===");
//        boolean f = false;
//        for (int i = 0; i < noteBox.size(); i++) {
//            String memo = noteBox.get(i);
//            if (memo.contains(keyword)) {
//                System.out.println((i + 1) + ". " + memo);
//                f = true;
//            }
//        }
//
//        if (!f) {
//            System.out.println("검색 결과가 없습니다.");
//        }
//        System.out.println();
//    }

}