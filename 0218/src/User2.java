
class User{
	Private String name;
	private int age;
	User(String name,int age){//매개변수를 가진 생성자
		this.nmae=name;
		this.age=age;
	}
	
	public void setName(String name) {
		this.nmae=name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAge(int age) {
		this.age=age;
	}
	
	public int getAge() {
		return age;
	}
	
	public class AccessModifier1{
		public static void main(String[] args) {
			User user1=new User("철수",20);//인스턴스 생성
			User user2=new User("영희",19);//인스턴스 생성
			
			//user2.age=99;//에러 발생/ 직접적 접근 불가
			
			user2.setAge(20);
				System.out.println(user2.getName()+"의 나이는"+user2.getAge());
		}
	}
}
