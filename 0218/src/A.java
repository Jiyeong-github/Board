
 class A {
	 static class Stainclnner{}
	 class Instancelnner{}
	 //����ƽ ������� ���� ����
	 StaticInner st1=new StaticInner();
	 //�ν��Ͻ� ������� ���� ����
	 InstanceInner ii1=nw InstanceInner();
	 
	 static void StaticMethod() {
		 //����ƽ ����� ����ƽ ���� Ŭ������ ���� ����
		 StaticInner st2=new StaticInner();
		 //����ƽ ����� �ν��Ͻ� ����� ���� �Ұ�
		 //Instancelnner ii2=new instancelnner();//���� �߻�
	 }
	 
	 void InstanceMethod() {
		 //�ν��Ͻ� ����� ��� ���� ����
		 StaticInner st3=new StaticInner();
		 InstanceInner ii3=new InstanceInner();
	 }
}
