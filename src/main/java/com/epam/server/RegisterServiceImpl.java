package com.epam.server;
import com.epam.client.service.GreetingService;
import com.epam.client.service.RegisterService;
import com.epam.server.services.AppConfig;
import com.epam.server.services.UserService;
import com.epam.shared.model.User;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.util.HashMap;


/**
 * The server-side implementation of the RPC service.
 */

@Component
@SuppressWarnings("serial")
public class RegisterServiceImpl extends RemoteServiceServlet implements RegisterService {

    AnnotationConfigApplicationContext context;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        context = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    UserService userService;


    @Override
    public void register(User user) {
       userService = context.getBean(UserService.class);

         userService.saveUser(user);
    }
}
