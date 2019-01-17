package com.ur.project.HotelApp.views;

import com.ur.project.HotelApp.ManageUI;
import com.ur.project.HotelApp.model.Person;
import com.ur.project.HotelApp.model.Rezerwacja;
import com.ur.project.HotelApp.repositories.PersonRepository;
import com.ur.project.HotelApp.repositories.RezerwacjaRepository;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringUI;

import java.util.List;

@SpringUI
public class ManageView extends ManageUI implements View {

    private PersonRepository personRepository;
    private RezerwacjaRepository rezerwacjaRepository;

    Person currentSelectedPerson;

    public ManageView(PersonRepository personRepository, RezerwacjaRepository rezerwacjaRepository){
        this.personRepository = personRepository;

        personGrid.addColumn(Person::getEmail).setCaption("E-mail");
        personGrid.addColumn(Person::getImie).setCaption("Imie");
        personGrid.addColumn(Person::getNazwisko).setCaption("Nazwisko");

        rezerwacjaGrid.addColumn(Rezerwacja::getMiasto).setCaption("Miasto");
        rezerwacjaGrid.addColumn(Rezerwacja::getHotel).setCaption("Hotel");
        rezerwacjaGrid.addColumn(Rezerwacja::getOdKiedy).setCaption("Zameldowanie");
        rezerwacjaGrid.addColumn(Rezerwacja::getDoKiedy).setCaption("Wymeldowanie");
        rezerwacjaLabel.setVisible(false);
        rezerwacjaGrid.setVisible(false);


        List<Person> personList = personRepository.findAll();
        personGrid.setItems(personList);

        personGrid.addSelectionListener(item ->{
            item.getFirstSelectedItem().ifPresent(selectedItem ->{
                currentSelectedPerson = selectedItem;

                List<Rezerwacja> rezerwacjaList = rezerwacjaRepository.findByPerson(currentSelectedPerson);
                rezerwacjaGrid.setItems(rezerwacjaList);
                rezerwacjaLabel.setVisible(true);
                rezerwacjaGrid.setVisible(true);
            });
        });

        rezerwacjaGrid.addSelectionListener(item ->{
            item.getFirstSelectedItem().ifPresent(selectedItem ->{
                cancelBookButton.setEnabled(true);
            });
        });

        cancelBookButton.addClickListener(clickEvent -> {

            long r_id = rezerwacjaGrid.getSelectionModel().getFirstSelectedItem().get().getId();
            rezerwacjaRepository.deleteById(r_id);
            cancelBookButton.setEnabled(false);
            rezerwacjaLabel.setVisible(false);
            rezerwacjaGrid.setVisible(false);

            List<Person> personList1 = personRepository.findAll();
            personGrid.setItems(personList1);
            List<Rezerwacja> rezerwacjaList1 = rezerwacjaRepository.findByPerson(currentSelectedPerson);
            rezerwacjaGrid.setItems(rezerwacjaList1);
        });

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent e) {
        personGrid.setItems(personRepository.findAll());
        rezerwacjaLabel.setVisible(false);
        rezerwacjaGrid.setVisible(false);
        cancelBookButton.setEnabled(false);


    }
}
