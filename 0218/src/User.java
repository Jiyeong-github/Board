class User{
	public String name;
	public int age;
	User(String name, int age){//매개변수를 가진 생성자
		this.name=name;
		this.age=age;
	}
}
public class AccessModifier1 {

	public static void main(String[] args) {
		User user1= new User("철수",20);//인스턴스 생성
		User user2= new User("영희",19);//인스턴스 생성
		
		System.out.println(user2.name+"의 나이는"+user2.age);
		user2.age=99;
		System.out.println(user2.name+"의 나이는"+user2.age);
	}

}
