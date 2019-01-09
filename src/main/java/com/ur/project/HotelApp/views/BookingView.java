package com.ur.project.HotelApp.views;

import com.ur.project.HotelApp.BookingUI;
import com.ur.project.HotelApp.model.Rezerwacja;
import com.ur.project.HotelApp.repositories.RezerwacjaRepository;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;

import java.sql.Date;

@SpringView
public class BookingView extends BookingUI implements View {

    public BookingView(RezerwacjaRepository rezerwacjaRepository) {

        bookSubmitButton.addClickListener(clickEvent -> {
            Rezerwacja rezerwacja = new Rezerwacja(String.valueOf(bookGenderComboBox.getValue()), bookNameTextField.getValue(), bookLastNameTextField.getValue(), bookEmailTextField.getValue(),
                    String.valueOf(bookCityComboBox.getValue()), String.valueOf(bookHotelComboBox.getValue()), String.valueOf(bookRoomType.getValue()),
                    String.valueOf(bookBedConboBox.getValue()), Date.valueOf(bookFromDateField.getValue()), Date.valueOf(bookToDateField.getValue())
            );
            rezerwacjaRepository.save(rezerwacja);
        });

    }
}
