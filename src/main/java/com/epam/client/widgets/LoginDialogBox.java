package com.epam.client.widgets;

import com.google.gwt.user.client.ui.*;

import java.util.function.BiConsumer;

public class LoginDialogBox extends DialogBox {


    public LoginDialogBox(BiConsumer<String, String> onLoginButonClickAction, RegisterDialogBox registerDialogBox) {
        TextBox nameField = new TextBox();
        PasswordTextBox passwordField = new PasswordTextBox();
        Button loginButton = new Button();
        loginButton.setText("Login");
        loginButton.addClickHandler(clickEvent -> {
            onLoginButonClickAction.accept(nameField.getText(), passwordField.getText());
        });

        VerticalPanel verticalPanel = new VerticalPanel();
        verticalPanel.add(new HTML("<br><b>" + "user field" + "</b>"));
        verticalPanel.add(nameField);
        verticalPanel.add(new HTML("<br><b>" + "password field" + "</b>"));
        verticalPanel.add(passwordField);

        HorizontalPanel horizontalPanel = new HorizontalPanel();
        horizontalPanel.add(loginButton);
        Button registerButton = new Button();
        registerButton.setText("Register");
        registerButton.addClickHandler(clickEvent -> {
            registerDialogBox.show();
        });
        horizontalPanel.add(registerButton);
        verticalPanel.add(horizontalPanel);


        setAnimationEnabled(true);
        add(verticalPanel);
    }
}
