
class Leader extends Student{
	void lead() {
	}
	void say() {
		System.out.println("�����Բ� �λ�");
		super.say();//���� Ŭ������ �޼��� ����
	}
}
public class Inheritance2 {

	public static void main(String[] args) {
		Leader leader1=new Leader();
		leader1.say();//�������̵��� �޼��� ���
	}

}
