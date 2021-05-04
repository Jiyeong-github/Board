import java.util.Scanner;

public class VendingMachine {

	public static void main(String[] args) {
		// ���� ���� - ��ĳ�� - �ݾ� �Է� - �޴� - ���� - �޴�(����) - �ܾ�

		String[] menuNmArr = { "�ݶ�", "���̴�", "ȯŸ" };
		int[] menuPriceArr = { 1000, 1200, 1300 };

		Scanner scan = new Scanner(System.in);

		System.out.println("�ݾ��� �Է��ϼ���");
		int money = scan.nextInt();

		while (true) {// �ݺ��� ����
			System.out.println("<�޴�>\n");
			for (int i = 0; i < menuNmArr.length; i++) {
				System.out.printf("%d.%s(%,d��\n)", (i + 1), menuNmArr[i], menuPriceArr[i]);
			}
			System.out.println("����>");
			int choice = scan.nextInt();
			
			if (choice == 0) {
				break;
			} else if (choice < 0 || choice > menuNmArr.length) {
				System.out.println("�ٽ� �������ּ���.");
				continue;
			}

			int selectedIdx = choice - 1;
			System.out.printf("%s�� �����ϼ̽��ϴ�.", menuNmArr[selectedIdx]);
			
			if (choice > 0 && choice < menuNmArr.length) {
				System.out.println(menuNmArr[selectedIdx]);
				money = money - menuPriceArr[selectedIdx];
				System.out.printf("�ܰ�:%d��\n", money);
			}
			System.out.println("����");
		}

	}

}
