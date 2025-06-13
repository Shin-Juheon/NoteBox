import java.util.Scanner;

public class InputManager
{
    public final Scanner sc;

    public InputManager()
    {
        sc = new Scanner(System.in);
    }
    public String getLine(String userMemo)
    {
        System.out.print(userMemo);
        return sc.nextLine();
    }

    public int getInt(String userMemo)
    {
        System.out.print(userMemo);
        while (!sc.hasNextInt()) {
            System.out.print("숫자를 입력해주세요(단어 입력 X): ");
            sc.next();
        }
        int num = sc.nextInt();
        sc.nextLine();
        return num;
    }

}