
final class FinalClass {
	final int number=4;//���
}

	class Parents//extends FinalClass//�����߻�
	{
		final void finalMethod() {//�������̵� �Ұ��� �޼���
			System.out.println("��ӺҰ��� �޼���");
		}
	}
	
	class Son extends Parents{
		//void finalMethod(){} // �����߻�
	}
	
	public class FinalModifier{
	public static void main(String[] args) {
		FinalClass number1=new FinalClass();
		System.out.println(member1.number);
		//member1.number=4;
	}

}
