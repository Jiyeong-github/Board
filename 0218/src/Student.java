
public class Student {//학생 클래스
	void learn() {
		System.out.println("배우기");
	}
	
	void eat() {
		System.out.println("밥 먹기");
	}
	
	void say() {
		System.out.println("선생님 안녕하세요!");//보통의 학생
	}
	
	class Leader extebds Student{
		void lead() {
		}
		void say() {
			System.out.println("선생님께 인사");//오버라이딩
		}
	}

		public class Inheritance2{
	public static void main(String[] args) {
		Leader leader1=new Leader();
		leader1.eat();//상속받은 메서드 사용
		leader1.say();//오버라이딩한 메서드 사용
	}

}
