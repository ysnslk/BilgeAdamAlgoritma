package lesson016.interfaceOrnek;

public class Araba extends Arac {

	@Override
	public void ilerle() {
		System.out.println("Araba hareket ediyor");
	}

	@Override
	public void dur() {
		System.out.println("Araba durdu");
	}

	@Override
	public void bin() {
		System.out.println("Arabaya bindin.");
	}

}
