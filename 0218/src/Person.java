
public class Person {//��� Ŭ����
	void breath() {
		em.out.println("������");
	}
	void eat() {
		System.out.println("�� �Ա�");
	}
	void say() {
		System.out.println("���ϱ�");
	}

	class Teacher extends Person{//��� Ŭ������ ����� ���� Ŭ����
		void teach() {
			System.out.println("����ġ��");
		}
	}
	public class Inheritance1{
	public static void main(String[] args) {
		Student s1=new Student();//�л� �ν��Ͻ� s1 ����
		s1.breath();//��� Ŭ������ breath �޼��带 ��ӹ޾���
		s1.learn();
		
		Teacher t1=new Teacher();//���� �ν��Ͻ� t1 ����
		t1.eat();//��� Ŭ������ eat �޼��带 ��ӹ޾���
		t1.teach();

	}

}
