
class animal{//���� Ŭ����
	void breath() {
		System.out.println("������");
	}
}

class Lion extends Animal{//���� Ŭ������ ����� ���� Ŭ����
	public String toString() {
		return"����";
	}
}

class Zookeeper{//������ Ŭ����
	void feed(Lion lion) {//���ڿ��� �����ִ� Ŭ����
		System.out.println(lion+"���� ��� �ֱ�");
	}
}
public class Polymorphism3 {
	public static void main(String[] args) {
		Lion lion1=new Lion();//Lion �ν��Ͻ� ����
		ZooKeeper james=new Zookeeper();//james �̸��� ������ �ν��Ͻ� ����
		james.feed(lion1);//james�� lion1���� ���̸� ��
	}

}
