package com.epam.tests;

import com.epam.server.services.AppConfig;
import com.epam.server.services.UserService;
import com.epam.shared.model.User;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ContextConfiguration(classes = AppConfig.class)
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
@Transactional
public class UserServiceTest {

  @Autowired
  private UserService service;

  @Test
  public void serviceGetTest() {

    User user = new User();
    user.setFirstName("Bill");
    user.setLastName("Murei");
    user.setLoginName("BSD777");

    User user2 = new User();
    user2.setFirstName("Jim");
    user2.setLastName("Mall");
    user2.setLoginName("JML777");

    service.saveUser(user);
    service.saveUser(user2);

    User user1 = service.getUser(1L);

    System.out.println(user1);
  }
}
