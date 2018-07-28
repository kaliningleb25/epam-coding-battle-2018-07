package com.epam.client.widgets;

import com.google.gwt.user.client.ui.*;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class SearchDialogBox  extends DialogBox {

    List<String> operations = Arrays.asList("UserProfile");

    public SearchDialogBox(Consumer<String> onFindButtonAction){
        setText("Search popup");

        setAnimationEnabled(true);
        VerticalPanel dialogVPanel = new VerticalPanel();
        dialogVPanel.setSpacing(6);
        dialogVPanel.addStyleName("dialogVPanel");

        ListBox listBox = new ListBox();

        operations.forEach(listBox::addItem);
        dialogVPanel.add(listBox);

        TextBox argumentField = new TextBox();
        dialogVPanel.add(argumentField);

        final Button buttonFind = new Button("Find");
        buttonFind.addClickHandler(clickEvent -> onFindButtonAction.accept(argumentField.getText()));

        buttonFind.getElement().setId("findButton");
        dialogVPanel.add(buttonFind);
        setWidget(dialogVPanel);
    }
}
