
class StaticPractice {
		public static int number=3;
		public static void say() {
			System.out.println("인스턴스 생성하지 않고도 사용 가능합니다");
		}
}

	public class StaticModifier{
	public static void main(String[] args) {
		System.out.println(StaticPractice.number);
		StaticPractice.say();
	}

}
