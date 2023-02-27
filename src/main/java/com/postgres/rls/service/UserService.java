package com.postgres.rls.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postgres.rls.entity.UserEntity;
import com.postgres.rls.model.User;
import com.postgres.rls.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	public User createUser(User user) {
		UserEntity userEntity = modelMapper.map(user, UserEntity.class);
		UserEntity newUserEntity = userRepository.save(userEntity);
		return modelMapper.map(newUserEntity, User.class);
	}

	public List<User> getAllUsers() {

		return userRepository.findAll().stream().map(entity -> modelMapper.map(entity, User.class))
				.collect(Collectors.toList());

	}

	public void deleteUser(String id) {

		userRepository.deleteById(id);

	}

	public User updateUser(User user, String id) {
		UserEntity existingUser = userRepository.findById(id).get();
		existingUser.setName(user.getName());
		existingUser.setEmail(user.getEmail());
		UserEntity updatedEntity = userRepository.save(existingUser);

		return modelMapper.map(updatedEntity, User.class);
	}

	public User getUser(String id) {
		UserEntity entity = userRepository.findById(id).get();

		return modelMapper.map(entity, User.class);
	}

}
