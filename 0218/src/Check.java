
class Check {
//instanceVariable:iv
//classVariable:cv
//instanceMethod:im
//classMathod:cm
	
	static int cv=5;//Ŭ���� ����
	int iv=4; //�ν��Ͻ� ����
	
	static void cm() {//Ŭ���� �޼���
}
	
	void im() {//�ν��Ͻ� �޼���
	}
	
	static void cm_lmember() {
		//Ŭ���� �޼��尡 �ν��Ͻ� ����� ����
		//System.out.println(iv);//�̷� �߻�
		//im();//�����߻�
	}
	
	void im_Cmember() {
		//�ν��Ͻ� �޼��尡 Ŭ���� ����� ����
	System.out.println(cv);
	cm();
	}
	
	static void cm_Cmember() {
		//Ŭ���� �޼��尡 Ŭ���� ����� ����
		System.out.println(iv);
		im();
	}
}

public class Method3{
	public static void main(String[ args]) {
		//Check.com_lmember();//����
		Check.cm_Cmemeber();//����
		
		Check myinstance=new Check();
		myinstance.im_Cmember();//����
		myinstance.cm_Cmember();//����
	}
}
	
