package com.ur.project.HotelApp.views;

import com.ur.project.HotelApp.Signup;
import com.ur.project.HotelApp.model.Person;
import com.ur.project.HotelApp.repositories.PersonRepository;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Notification;
import org.springframework.beans.factory.annotation.Autowired;

@SpringView
public class SignupView extends Signup implements View {

    private final PersonRepository personRepository;

    @Autowired
    public SignupView(PersonRepository personRepository){
        this.personRepository = personRepository;

        signcancelButton.addClickListener(clickEvent -> {
            getUI().getNavigator().navigateTo("LoginView");
        });

        signconfButton.addClickListener(clickEvent -> {

            try{
                if (signpasswordField.getValue().equals(confpasswordField.getValue())){
                    Person person = new Person(signloginField1.getValue(),signpasswordField.getValue(),nameField.getValue(),lastnameField.getValue(),emailField.getValue(),telnumField.getValue());
                    personRepository.save(person);
                    Notification.show("Zarejestrowano pomyslnie!!", Notification.Type.HUMANIZED_MESSAGE);
                    getUI().getNavigator().navigateTo("LoginView");
                }else{
                    Notification.show("Uwaga!", "Podane hasła nie sa jednakowe!", Notification.Type.WARNING_MESSAGE);
                }
            }catch (Exception e){
                Notification.show(e.getClass().getName(), e.getMessage(), Notification.Type.ERROR_MESSAGE);
                e.printStackTrace();
            }
        });
    }
}
