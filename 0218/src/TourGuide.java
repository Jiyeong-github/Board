
interface Providable{
	void leisureSports();
	void sightseeing();
	void food();
}

class KoreaTour implements Providable{
	
	@Override
	public void leisureSports() {
		System.out.println("�Ѱ����� ����Ű ����");
	}
	
	@Override
	public void sightseeing() {
		System.out.pritnln("�溹�� ���� ����";)
	}
	
	@Override
	public void food() {
		System.out.println("���� ����� ����");
	}
}

class TourGuide{
	private Providable tour=new Korea Tour();
	//�������̽��� Ÿ�Լ���
	public void leisureSports() {
		tour.leisureSports();
	}
	public void sightseeing() {
		tour.sightseeing();
	}
	public void food() {
		tour.food();
	}
}
public class Interface3 {
		public static void main(String[]args) {
			TourGuide guide=new TourGuide();
			guide.leisureSports();
			guide.sightseeing();
			guide.food();
		}

}
