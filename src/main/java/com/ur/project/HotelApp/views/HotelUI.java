package com.ur.project.HotelApp.views;

import com.ur.project.HotelApp.repositories.PersonRepository;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@SpringUI
@Title("Zaczynajmy")
@Theme("valo")
@Component
public class HotelUI extends UI{

    Navigator navigator;

    @Autowired
    PersonRepository personRepository;

    @Override
    protected void init(VaadinRequest request){
        VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();

        Label startLabel = new Label("Zarezerwuj swój pokój!");
        layout.addComponent(startLabel);
        layout.setComponentAlignment(startLabel, Alignment.BOTTOM_CENTER);
        Button startButton = new Button("Rozpocznij");
        layout.addComponent(startButton);
        layout.setComponentAlignment(startButton, Alignment.TOP_CENTER);
        setContent(layout);

        startButton.addClickListener(clickEvent -> getNavigator().navigateTo("LoginView"));
        navigator = new Navigator(this, this);
        //navigator.addView("", (View) new HotelUI());
        navigator.addView("LoginView", new LoginView(personRepository));
        navigator.addView("SignupView",new SignupView(personRepository));


    }
}
