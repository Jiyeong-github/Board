
class User{
	Private String name;
	private int age;
	User(String name,int age){//�Ű������� ���� ������
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
			User user1=new User("ö��",20);//�ν��Ͻ� ����
			User user2=new User("����",19);//�ν��Ͻ� ����
			
			//user2.age=99;//���� �߻�/ ������ ���� �Ұ�
			
			user2.setAge(20);
				System.out.println(user2.getName()+"�� ���̴�"+user2.getAge());
		}
	}
}
