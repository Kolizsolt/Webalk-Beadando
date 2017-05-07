package iit.me.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iit.me.entity.UserEntity;
import iit.me.repository.UserRepository;
import iit.me.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	
	@Override
	public Iterable<UserEntity> listUsers() {
		return userRepository.findAll();
	}

	@Override
	public void newUser(UserEntity newUser) {
		userRepository.save(newUser);
	}

	@Override
	public void deleteUser(long id) {
		userRepository.delete(id);
	}

	@Override
	public void editUser(long id, String newFirstName, String newLastName) {
		userRepository.findOne(id).setFirstName(newFirstName);
		userRepository.findOne(id).setLastName(newLastName);
		userRepository.save(userRepository.findOne(id));
	}
	
	public UserEntity findUser(long id) {
		return userRepository.findOne(id);
	}

}
