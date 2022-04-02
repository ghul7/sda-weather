package com.sda.weather;

import com.sda.weather.entry.LocationController;

import java.util.Scanner;

public class UserInterface {
    private final LocationController locationController;

    public UserInterface(LocationController locationController) {
        this.locationController = locationController;
    }

    public void run() {
        System.out.println("Aplikacja jest uruchomiona\n");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWitaj w aplikacji pogodowej, co chcesz zrobić?");
            System.out.println("1. Dodać nową lokalizacje");
            System.out.println("2. Wyświetl dostępne lokalizacje");
            System.out.println("3. Wyświetlić dane pogodowe dla lokalizacji");
            System.out.println("0. Zamknąć aplikację");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    createLocation();
                    break;
                case 2:
                    showLocations();
                    break;
                case 3:
                    showData();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Nie ma takiej opcji");
            }
        }
    }

    private void showData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj lokalizacje: ");
        String location = scanner.nextLine();

    }

    private void showLocations() {
        System.out.println("pokaz lokalizacje");
    }

    private void createLocation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwę miasta: ");
        String city = scanner.nextLine();
        System.out.println("Podaj współrzędną X: ");
        String cordinateX = scanner.nextLine();
        System.out.println("Podaj współrzędną Y: ");
        String cordinateY = scanner.nextLine();
        System.out.println("Podaj region: ");
        String region = scanner.nextLine();
        System.out.println("Podaj kraj: ");
        String country = scanner.nextLine();

        // HTTP REQUEST -> POST: /entry
        String requestBody = String.format("{\"city\":\"%s\",\"cordinateX\":\"%s\", " +
                        "\"cordinateY\":\"%s\",\"region\":\"%s\", \"country\":\"%s\"}",
                city, cordinateX, cordinateY, region, country);

        System.out.println("Wysyłany http request: " + requestBody);

    }
}
