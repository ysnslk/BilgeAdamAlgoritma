package lesson022;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamApiOrnek2 {

	// User sınıfı oluşturalım
	// id name
	// ToString
	// Bilgileri Goster

	public static void main(String[] args) {
		List<User> users = new ArrayList<>();
		users.add(new User("Ahmet", 1));
		users.add(new User("Aslı", 2));
		users.add(new User("zeynep", 3));
		users.add(new User("Deniz", 4));
		users.add(new User("Mehmet", 5));

		// Bütün userların to string metodunu çağıralım

		users.forEach(user -> System.out.println(user.toString()));
		users.stream().forEach(user -> user.bilgilerGoster());

		// id si 3 ten büyük olanları listeye atalım
		// Ve bu liste içindeki userların bilgilerini göster metodnu yazdıralım.
		
		List<User> users2 = users.stream()
				.filter(user -> user.getId() > 3)
				//.toList();
				.collect(Collectors.toList());

		users2.forEach(User::bilgilerGoster);
		
		//id si 3ten küçük olanları set e atalım
		
		Set<User> set  = users.stream()
				.filter(user -> user.getId() <3)
				.collect(Collectors.toSet());
		
		set.forEach(User::bilgilerGoster);
		
		//İsmi ahmet olanları listeye atıyoruz
		
		List<User> ahmetler = users.stream()
				.filter(user -> user.getName().equalsIgnoreCase("Ahmet")).toList();
		

		ahmetler.forEach(User::bilgilerGoster);
		
		//Her bir user için yeni bir user nesnes oluşturalım
		//isimlerin sonuna !! koy
		
		List<User> mappedList = users.stream().map(user -> new User(user.getName()+"!!",user.getId()))
				.collect(Collectors.toList());
		mappedList.stream().forEach(usr -> System.out.println(usr));
		
		
	}
}
