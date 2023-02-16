package lesson010;

public class Main {

	public static void main(String[] args) {
		Profile profile1 = new Profile();
		profile1.uName = "mehmet123";
		profile1.name = "Mehmet";
		profile1.description = "------";
		profile1.profilePicture = "jpg";
		profile1.follows = 0;
		profile1.followers = 5;
		profile1.postValue = 0;
		profile1.storiesValue = 0;

		System.out.println(profile1);
		profile1.postOlustur();
		profile1.profilIsminiGuncelle("Ahmet");
		System.out.println(profile1.name);
		profile1.gelenIstegiKabulEt();
		System.out.println(profile1.followers);
		profile1.kullaniciSil();
		profile1.kullaniciSil();
		profile1.gelenIstegiKabulEt();
		System.out.println(profile1.followers);
		System.out.println(profile1.getByInfo());

		profile1.bilgilerGoster();
		
		profile1.posts[0]="resim1";
		profile1.posts[1]="resim2";
		profile1.posts[2]="resim3";
		
		for (int i = 0; i < profile1.posts.length; i++) {
			if(profile1.posts[i]!=null) {
				System.out.println(profile1.posts[i]);
			}
		}

	}

}
