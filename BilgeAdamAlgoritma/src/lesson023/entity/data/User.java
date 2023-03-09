package lesson023.entity.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import lesson023.entity.enums.EStatus;

public class User extends Person {

	private String name;
	private LocalDate bhirtDay;
	private List<User> following;
	private String activateCode;
	private EStatus eStatus;
	private HashMap<User, String> dmList;

	public User(String id, String email, String password, String name, LocalDate bhirtDay) {
		super(id, email, password);
		this.name = name;
		this.bhirtDay = bhirtDay;
		this.following = new ArrayList<>();
		this.dmList = new HashMap<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBhirtDay() {
		return bhirtDay;
	}

	public void setBhirtDay(LocalDate bhirtDay) {
		this.bhirtDay = bhirtDay;
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

	public HashMap<User, String> getDmList() {
		return dmList;
	}

	public void setDmList(HashMap<User, String> dmList) {
		this.dmList = dmList;
	}

}
