
public class Cellphone {
	String model="Galaxy 8";
	String color;
	int capacity;
	
	Cellphone(String color, int capacity){//�Ű������� �ִ� ������
		this.color=color
		this.capacity=capacity;
	}
}

	public static void main(String[] args) {
		// Cellphone myphone1=new Cellphone();//�����߻�
		
		Cellphone myphone=new Cellphone("Silver",64);//������ ȣ��
		
		System.out.println(myphone.model);
		System.out.println(myphone.color);
		System.out.println(myphone.capacity);

	}

}
