
class animal{//동물 클래스
	void breath() {
		System.out.println("숨쉬기");
	}
}

class Lion extends Animal{//동물 클래스를 상속한 사자 클래스
	public String toString() {
		return"사자";
	}
}

class Zookeeper{//사육사 클래스
	void feed(Lion lion) {//사자에게 먹이주는 클래스
		System.out.println(lion+"에게 고기 주기");
	}
}
public class Polymorphism3 {
	public static void main(String[] args) {
		Lion lion1=new Lion();//Lion 인스턴스 생성
		ZooKeeper james=new Zookeeper();//james 이름의 사육사 인스턴스 생성
		james.feed(lion1);//james가 lion1에게 먹이를 줌
	}

}
