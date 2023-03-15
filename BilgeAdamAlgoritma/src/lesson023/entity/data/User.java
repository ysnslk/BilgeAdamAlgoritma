package lesson023.entity.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import lesson023.entity.enums.EStatus;
import lesson023.util.TakeId;

public class User extends Person{

	private String name;
	private LocalDate birthDay;
	private List<User> following;
	private String activateCode;
	private EStatus eStatus;
	private HashMap<User, String> dmListesi;
	
	public User(String email, String password, String name, LocalDate birthDay) {
		super(email, password);
		this.name = name;
		this.birthDay = birthDay;
		this.following = new ArrayList<>();
		this.dmListesi = new HashMap<>();
		String id = randomGenerateId();
		setId(id);
	}
	
	public User(String email, String password) {
		super(email, password);
		this.following = new ArrayList<>();
		this.dmListesi = new HashMap<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}

	public List<User> getFollowing() {
		return following;
	}

	public void setFollowing(List<User> following) {
		this.following = following;
	}

	public String getActivateCode() {
		return activateCode;
	}

	public void setActivateCode(String activateCode) {
		this.activateCode = activateCode;
	}

	public EStatus geteStatus() {
		return eStatus;
	}

	public void seteStatus(EStatus eStatus) {
		this.eStatus = eStatus;
	}

	public HashMap<User, String> getDmListesi() {
		return dmListesi;
	}

	public void setDmListesi(HashMap<User, String> dmListesi) {
		this.dmListesi = dmListesi;
	}

//	@Override
//	public String randomGenerateId2() {
//		Random random = new Random();
//		int intRandomNumber = random.nextInt(1000,10000);
//		String randomId = Integer.toString(intRandomNumber);
//		return randomId;
//	}
	@Override
	public String randomGenerateId() {
		int id = TakeId.ID ++;
		String randomId = Integer.toString(id);
		return randomId;
	}
}