
class Check {
//instanceVariable:iv
//classVariable:cv
//instanceMethod:im
//classMathod:cm
	
	static int cv=5;//클래스 변수
	int iv=4; //인스턴스 변수
	
	static void cm() {//클래스 메서드
}
	
	void im() {//인스턴스 메서드
	}
	
	static void cm_lmember() {
		//클래스 메서드가 인스턴스 멤버에 접근
		//System.out.println(iv);//이러 발생
		//im();//에러발생
	}
	
	void im_Cmember() {
		//인스턴스 메서드가 클래스 멤버에 접근
	System.out.println(cv);
	cm();
	}
	
	static void cm_Cmember() {
		//클래스 메서드가 클래스 멤버에 접근
		System.out.println(iv);
		im();
	}
}

public class Method3{
	public static void main(String[ args]) {
		//Check.com_lmember();//에러
		Check.cm_Cmemeber();//성공
		
		Check myinstance=new Check();
		myinstance.im_Cmember();//성공
		myinstance.cm_Cmember();//성공
	}
}
	
