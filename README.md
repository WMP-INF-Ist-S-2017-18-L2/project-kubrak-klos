# HotelApp

## Spis treści:

1. Cele projektu.
2. Wykorzystane technologie
3. Opis projektu
4. Autorzy


## 1. Cele projektu

Celem projektu było stworzenie prostej aplikacji webowej umożliwiającej rezerwację pokoju hotelowego. 

## 2. Wykorzystane technologie

Aplikacja została napisana w języku Java z wykorzystaniem frameworka Vaadin oraz pluginu Vaadin Designer. Całość oparta jest na platformie Spring z dołączonym SpringBootem. Projekt wykorzystuje również lokalną bazę danych PostgreSQL.

## 3. Opis projektu

### Struktura projektu:

*Menu aplikacji:*

*	Zarezerwuj – zawiera formularz do złożenia rezerwacji
*	Rezerwacje – umożliwia podgląd dokonanych rezerwacji oraz ich anulowanie

*Zarezerwuj:*

W tym panelu użytkownik dokonuje rezerwacji. ComboBoxy Miasto i Hotel zawierają dane pobrane z odpowiadających im tabel w bazie. W zależności od wybranego miasta, ComboBox Hotel wypełniany jest nazwami hoteli przypisanymi do danego miasta. Baza zawiera 16 miast (stolice województw) oraz 160 hoteli (po 10 dla każdego miasta).

Przycisk „Zarezerwuj” zapisuje do bazy informacje o użytkowniku (tabela person), dokonanej przez niego rezerwacji (tabela rezerwacja) i wyświetla stosowne powiadomienie. Aby uniknąć redundancji aplikacja sprawdza czy w tabeli person znajduje się już osoba z adresem email podanym w formularzu. Jeśli tak, przypisuje do rezerwacji jej id. W przypadku gdy jedno lub więcej pól jest pustych, wyświetlany jest komunikat z prośbą o uzupełnienie danych.

Przycisk „Anuluj” służy do wyczyszczenia pól tekstowych.

*Rezerwacje:*

Po zaznaczeniu osoby z tabeli Osoba pojawia się tabela Rezerwacja wyświetlająca złożone przez tą osobę rezerwacje. Jeśli zaznaczone są pozycje w obu tabelach aktywuje się przycisk „Anuluj”, którego naciśnięcie skutkuje usunięciem z bazy podświetlonej rezerwacji. Następnie przycisk zostaje dezaktywowany, a tabela Rezerwacja jest ukrywana.

## 4. Autorzy

Autorami projektu są Konrad Kubrak i Piotr Kłos.
