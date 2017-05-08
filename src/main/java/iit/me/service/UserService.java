package iit.me.service;

import org.springframework.stereotype.Service;

import iit.me.entity.UserEntity;

@Service
public interface UserService {
	
	Iterable<UserEntity> listUsers();
	void newUser(UserEntity newUser);
	void deleteUser(long id);
	void editUser(long id, String newFirstName, String newLastName);
	UserEntity findUser(long id);
	UserEntity findUserByUsername(String username);

}
