package com.ur.project.HotelApp.views;

import com.ur.project.HotelApp.BookingUI;
import com.ur.project.HotelApp.model.Hotel;
import com.ur.project.HotelApp.model.Miasto;
import com.ur.project.HotelApp.model.Person;
import com.ur.project.HotelApp.model.Rezerwacja;
import com.ur.project.HotelApp.repositories.HotelRepository;
import com.ur.project.HotelApp.repositories.MiastoRepository;
import com.ur.project.HotelApp.repositories.PersonRepository;
import com.ur.project.HotelApp.repositories.RezerwacjaRepository;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Notification;

import java.sql.Date;
import java.util.List;

@SpringUI
public class BookingView extends BookingUI implements View {

    public BookingView(RezerwacjaRepository rezerwacjaRepository, PersonRepository personRepository, MiastoRepository miastoRepository, HotelRepository hotelRepository) {


        List<Miasto> miastoList = miastoRepository.findAll();
        bookCityComboBox.setItems(miastoList);
        bookCityComboBox.setItemCaptionGenerator(Miasto::getNazwa);

        bookCityComboBox.addSelectionListener(singleSelectionEvent -> {
            List<Hotel> hotelList = hotelRepository.findHotelsByMiasto(bookCityComboBox.getValue());
            bookHotelComboBox.getEmptySelectionCaption();
            bookHotelComboBox.setItems(hotelList);
            bookHotelComboBox.setItemCaptionGenerator(Hotel::getNazwa);

        });

        bookCancelButton.addClickListener(clickEvent -> {
            bookNameTextField.setValue("");
            bookLastNameTextField.setValue("");
            bookEmailTextField.setValue("");
            bookTelNumTextField.setValue("");
            bookCityComboBox.getEmptySelectionCaption();
            bookHotelComboBox.getEmptySelectionCaption();
            bookRoomType.getEmptySelectionCaption();
            bookBedConboBox.getEmptySelectionCaption();

        });

        bookSubmitButton.addClickListener(clickEvent -> {

            try {

                if(bookEmailTextField.getValue().equals(personRepository.findByEmail(bookEmailTextField.getValue()))) {

                    Rezerwacja r = new Rezerwacja();
                    r.setMiasto(bookCityComboBox.getValue().getNazwa());
                    r.setHotel(bookHotelComboBox.getValue().getNazwa());
                    r.setPokoj(bookRoomType.getValue());
                    r.setLozka(bookBedConboBox.getValue());
                    r.setOdKiedy(Date.valueOf(bookFromDateField.getValue()));
                    r.setDoKiedy(Date.valueOf(bookToDateField.getValue()));
                    r.setPerson(personRepository.findByEmail(bookEmailTextField.getValue()));

                    rezerwacjaRepository.save(r);
                    Notification.show("Rezerwacja udana!", Notification.Type.HUMANIZED_MESSAGE);

                }else{
                    Person p = new Person();
                    p.setImie(bookNameTextField.getValue());
                    p.setNazwisko(bookLastNameTextField.getValue());
                    p.setEmail(bookEmailTextField.getValue());
                    p.setNr_tel(bookTelNumTextField.getValue());

                    Rezerwacja r = new Rezerwacja();
                    r.setMiasto(bookCityComboBox.getValue().getNazwa());
                    r.setHotel(bookHotelComboBox.getValue().getNazwa());
                    r.setPokoj(bookRoomType.getValue());
                    r.setLozka(bookBedConboBox.getValue());
                    r.setOdKiedy(Date.valueOf(bookFromDateField.getValue()));
                    r.setDoKiedy(Date.valueOf(bookToDateField.getValue()));
                    r.setPerson(p);

                    if (bookNameTextField.getValue() != null && bookLastNameTextField.getValue() != null && bookEmailTextField.getValue() != null && bookTelNumTextField.getValue() !=null
                            && bookCityComboBox.getValue() != null && bookHotelComboBox.getValue() != null && bookRoomType.getValue() != null && bookBedConboBox.getValue() != null
                            && bookFromDateField.getValue() != null && bookToDateField.getValue() != null) {

                        personRepository.save(p);
                        rezerwacjaRepository.save(r);

                        Notification.show("Rezerwacja udana!", Notification.Type.HUMANIZED_MESSAGE);
                    }else{
                        Notification.show("Wypełnij wszystkie pola!", Notification.Type.WARNING_MESSAGE);
                    }

                }

            } catch (Exception e) {
                Notification.show(e.getClass().getName(), e.getMessage(), Notification.Type.ERROR_MESSAGE);
                e.printStackTrace();
            }
        });

    }
}
