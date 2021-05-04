
final class FinalClass {
	final int number=4;//상수
}

	class Parents//extends FinalClass//에러발생
	{
		final void finalMethod() {//오버라이딩 불가한 메서드
			System.out.println("상속불가한 메서드");
		}
	}
	
	class Son extends Parents{
		//void finalMethod(){} // 에러발생
	}
	
	public class FinalModifier{
	public static void main(String[] args) {
		FinalClass number1=new FinalClass();
		System.out.println(member1.number);
		//member1.number=4;
	}

}
