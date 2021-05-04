
interface Providable{
	void leisureSports();
	void sightseeing();
	void food();
}

class KoreaTour implements Providable{
	
	@Override
	public void leisureSports() {
		System.out.println("한강에서 수상스키 투어");
	}
	
	@Override
	public void sightseeing() {
		System.out.pritnln("경복궁 관란 투어";)
	}
	
	@Override
	public void food() {
		System.out.println("전주 비빔밥 투어");
	}
}

class TourGuide{
	private Providable tour=new Korea Tour();
	//인터페이스로 타입선언
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
