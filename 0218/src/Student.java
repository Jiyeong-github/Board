
public class Student {//�л� Ŭ����
	void learn() {
		System.out.println("����");
	}
	
	void eat() {
		System.out.println("�� �Ա�");
	}
	
	void say() {
		System.out.println("������ �ȳ��ϼ���!");//������ �л�
	}
	
	class Leader extebds Student{
		void lead() {
		}
		void say() {
			System.out.println("�����Բ� �λ�");//�������̵�
		}
	}

		public class Inheritance2{
	public static void main(String[] args) {
		Leader leader1=new Leader();
		leader1.eat();//��ӹ��� �޼��� ���
		leader1.say();//�������̵��� �޼��� ���
	}

}
