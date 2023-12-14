package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users= new ArrayList<>();
	private static int usersCount=0;
	
	static {
		users.add(new User(++usersCount,"Adam",LocalDate.now().minusYears(30)));
		users.add(new User(++usersCount,"Pr",LocalDate.now().minusYears(25)));
		users.add(new User(++usersCount,"Ug",LocalDate.now().minusYears(20)));
	}
	
	public List<User> findAll()
	{
		return users;
	}
	
//	public User findOne(Integer id)
//	{
//	for(User i:users)
//{
//		if(id==i.getId())
//		return i;
//	}
//	return null;
//	}
	public User findOne(int id)
	{
		Predicate<? super User> predica	=user -> user.getId().equals(id);
	
		return users.stream().filter(predica).findFirst().orElse(null);
	}
	
	public void deleteById(int id)
	{
		Predicate<? super User> predica	=user -> user.getId().equals(id);
	
		 users.removeIf(predica);
	}
	
	public User save(User user)
	{
		user.setId(++usersCount);
	users.add(user);
	return user;
	}
}

