package com.epam.client.widgets;

import com.epam.shared.model.User;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;

import java.util.function.Consumer;

public class RegisterDialogBox extends DialogBox {

    public RegisterDialogBox(Consumer<User> onRegisterButtonAction){


        setText("Register popup");
        setAnimationEnabled(true);
        VerticalPanel dialogVPanel = new VerticalPanel();
        dialogVPanel.setSpacing(6);
        dialogVPanel.addStyleName("dialogVPanel");
        TextBox emailField = new TextBox();
        dialogVPanel.add(emailField);
        emailField.getElement().setPropertyString("placeholder","email..");
        TextBox firstName = new TextBox();
        firstName.setTitle("firstName");
        firstName.getElement().setPropertyString("placeholder","first name..");
        dialogVPanel.add(firstName);
        TextBox lastName = new TextBox();
        lastName.getElement().setPropertyString("placeholder","last name..");
        dialogVPanel.add(lastName);
        TextBox userName = new TextBox();
        dialogVPanel.add(userName);
        userName.getElement().setPropertyString("placeholder","login..");
        PasswordTextBox password1Tb = new PasswordTextBox();
        dialogVPanel.add(password1Tb);
        password1Tb.getElement().setPropertyString("placeholder","password..");
        PasswordTextBox password2Tb = new PasswordTextBox();
        dialogVPanel.add(password2Tb);
        password2Tb.getElement().setPropertyString("placeholder","repeat password..");
        final Button registerButton = new Button("Register");
        registerButton.addClickHandler(clickEvent -> {
            if (!password1Tb.getText().equals(password2Tb.getText())){
                Window.alert("Passwords are different");
            }
            else {
                User user = new User();
                user.setEmail(emailField.getText());
                user.setFirstName(firstName.getText());
                user.setLastName(lastName.getText());
                user.setLoginName(userName.getText());
                user.setPassword(password1Tb.getText());
                onRegisterButtonAction.accept(user);
            }
        });

        registerButton.getElement().setId("registerButton");
        dialogVPanel.add(registerButton);
        setWidget(dialogVPanel);
    }
}
