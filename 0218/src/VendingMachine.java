import java.util.Scanner;

public class VendingMachine {

	public static void main(String[] args) {
		// 변수 선언 - 스캐너 - 금액 입력 - 메뉴 - 선택 - 메뉴(가격) - 잔액

		String[] menuNmArr = { "콜라", "사이다", "환타" };
		int[] menuPriceArr = { 1000, 1200, 1300 };

		Scanner scan = new Scanner(System.in);

		System.out.println("금액을 입력하세요");
		int money = scan.nextInt();

		while (true) {// 반복의 시작
			System.out.println("<메뉴>\n");
			for (int i = 0; i < menuNmArr.length; i++) {
				System.out.printf("%d.%s(%,d원\n)", (i + 1), menuNmArr[i], menuPriceArr[i]);
			}
			System.out.println("선택>");
			int choice = scan.nextInt();
			
			if (choice == 0) {
				break;
			} else if (choice < 0 || choice > menuNmArr.length) {
				System.out.println("다시 선택해주세요.");
				continue;
			}

			int selectedIdx = choice - 1;
			System.out.printf("%s를 선택하셨습니다.", menuNmArr[selectedIdx]);
			
			if (choice > 0 && choice < menuNmArr.length) {
				System.out.println(menuNmArr[selectedIdx]);
				money = money - menuPriceArr[selectedIdx];
				System.out.printf("잔고:%d원\n", money);
			}
			System.out.println("종료");
		}

	}

}
