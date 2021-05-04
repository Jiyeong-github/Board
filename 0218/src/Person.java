
public class Person {//사람 클래스
	void breath() {
		em.out.println("숨쉬기");
	}
	void eat() {
		System.out.println("밥 먹기");
	}
	void say() {
		System.out.println("말하기");
	}

	class Teacher extends Person{//사람 클래스를 상속한 선생 클래스
		void teach() {
			System.out.println("가르치기");
		}
	}
	public class Inheritance1{
	public static void main(String[] args) {
		Student s1=new Student();//학생 인스턴스 s1 생성
		s1.breath();//사람 클래스의 breath 메서드를 상속받았음
		s1.learn();
		
		Teacher t1=new Teacher();//선생 인스턴스 t1 생성
		t1.eat();//사람 클래스의 eat 메서드를 상속받았음
		t1.teach();

	}

}
