package lesson010;

public class Profile {

	// attribute , property ,field
	// Gerekli attributeleri tanımlayalım

	public String uName;
	public String name;
	public String description;
	public String profilePicture;
	public int follows;
	public int followers;
	public String[] posts = new String[10];
	public int postValue = posts.length;
	public String[] stories = new String[10];
	public int storiesValue = stories.length;
	public boolean maviTik;

	@Override
	public String toString() {
		return "Profil : Kullanıcı Adı : " + uName + ", İsim : " + name + ", Açıklama : " + description
				+ ", Profil Resmi : " + profilePicture + ", Takip Edilen : " + follows + ", Takipçiler : " + followers
				+ ", Gönderiler : " + postValue + ", Hikayeler : " + storiesValue + " , MaviTik : " + maviTik;
	}

	public void bilgilerGoster() {
		System.out.println(this.toString());
	}

	public void postOlustur() {
		System.out.println(name + " Post oluşturdu.");
	}

	public void profilIsminiGuncelle(String name) {
		this.name = name;
	}

	public void gelenIstegiKabulEt() {
		this.followers++;
		System.out.println(this.maviTik());
	}

	public void kullaniciSil() {
		this.followers--;
		System.out.println(this.maviTik());
	}

	// post oluştur metodu
	// isim--> Post oluşturdu

	// profilIsminiGuncelle metdo
	// Metod isim alacak ismini güncelleyecek

	// gelenIstegiKabulEt
	// Takipçi sayısı artacak

	// Takipçi sayııs 5 ten fazla ise mavi tik verelim

	private boolean maviTik() {
		if (this.followers >= 5) {
			this.maviTik = true;
		} else {
			this.maviTik = false;
		}
		return this.maviTik;
	}

	public String getByInfo() {
		return "Kullanıcı Adı : " + this.uName + " Takipçi Sayısı : " + this.followers + " Mavi Tik : " + maviTik
				+ " Post Sayısı : " + this.postValue;
	}

}
