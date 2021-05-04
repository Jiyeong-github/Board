
class Leader extends Student{
	void lead() {
	}
	void say() {
		System.out.println("선생님께 인사");
		super.say();//상위 클래스의 메서드 참조
	}
}
public class Inheritance2 {

	public static void main(String[] args) {
		Leader leader1=new Leader();
		leader1.say();//오버라이딩한 메서드 사용
	}

}
