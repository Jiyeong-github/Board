
public class Cellphone {
	String model="Galaxy 8";
	String color;
	int capacity;
	
	Cellphone(String color, int capacity){//매개변수가 있는 생성장
		this.color=color
		this.capacity=capacity;
	}
}

	public static void main(String[] args) {
		// Cellphone myphone1=new Cellphone();//에러발생
		
		Cellphone myphone=new Cellphone("Silver",64);//생성자 호출
		
		System.out.println(myphone.model);
		System.out.println(myphone.color);
		System.out.println(myphone.capacity);

	}

}
