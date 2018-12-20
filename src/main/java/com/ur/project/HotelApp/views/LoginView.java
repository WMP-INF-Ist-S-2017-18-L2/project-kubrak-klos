package com.ur.project.HotelApp.views;

import com.ur.project.HotelApp.Login;
import com.ur.project.HotelApp.repositories.PersonRepository;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Notification;
import org.springframework.beans.factory.annotation.Autowired;


@SpringUI
public class LoginView extends Login implements View {

    @Autowired
    public LoginView(PersonRepository personRepository){

        loginButton.addClickListener(clickEvent -> {
            if(personRepository.findByLogin(loginField.getValue()).getLogin().equals(loginField.getValue())){
                Notification.show("Logowanie udane!!", Notification.Type.HUMANIZED_MESSAGE);
            }else{
                Notification.show("Nie ma takiego uzytkownika!", Notification.Type.WARNING_MESSAGE);
            }
        });

        registrationButton.addClickListener(clickEvent -> {
            getUI().getNavigator().navigateTo("SignupView");
        });



    }
}
