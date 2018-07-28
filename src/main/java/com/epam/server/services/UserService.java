package com.epam.server.services;

import com.epam.shared.model.User;
import com.epam.shared.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  public void saveUser(User user){
    userRepository.save(user);
  }

  public User getUser(Long id) {
    return userRepository.getOne(id);
  }

}
