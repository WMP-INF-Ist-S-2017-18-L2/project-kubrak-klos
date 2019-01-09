package com.ur.project.HotelApp.views;


import com.ur.project.HotelApp.repositories.PersonRepository;
import com.ur.project.HotelApp.repositories.RezerwacjaRepository;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@SpringUI
@Title("Zaczynajmy")
@Theme("darktheme")
@Component
public class MainView extends UI{

    @Autowired
    PersonRepository personRepository;

    @Autowired
    RezerwacjaRepository rezerwacjaRepository;


    @Override
    protected void init(VaadinRequest request){

        Label menuTitle = new Label("HotelApp");
        menuTitle.addStyleName(ValoTheme.MENU_TITLE);

        Button bookingView = new Button("Zarezerwuj", e -> getNavigator().navigateTo("BookView"));
        bookingView.addStyleNames(ValoTheme.BUTTON_LINK,ValoTheme.MENU_ITEM);
        Button bookingManagement = new Button("Twoje rezerwacje");
        bookingManagement.addStyleNames(ValoTheme.BUTTON_LINK,ValoTheme.MENU_ITEM);
        Button logout = new Button("Wyloguj", e-> getNavigator().navigateTo("LoginView"));
        logout.addStyleNames(ValoTheme.BUTTON_LINK,ValoTheme.MENU_ITEM);

        CssLayout menu = new CssLayout(menuTitle, bookingView, bookingManagement, logout);
        menu.addStyleName(ValoTheme.MENU_ROOT);
        CssLayout viewContainer = new CssLayout();

        HorizontalLayout mainLayout = new HorizontalLayout(menu, viewContainer);
        mainLayout.setWidthUndefined();
        mainLayout.setHeight("100%");

        setContent(mainLayout);
        this.setSizeFull();

        Navigator navigator = new Navigator(this, viewContainer);
        navigator.addView("", DefaultView.class);
        navigator.addView("LoginView", new LoginView(personRepository));
        navigator.addView("SignupView",new SignupView(personRepository));
        navigator.addView("BookView", new BookingView(rezerwacjaRepository));
    }
}
