# Recipe App

![Recipe App - Jetpack Compose](https://github.com/ahuamana/Yaku-Lab-Official/assets/60039961/0e3d4820-df61-4984-8515-ea6346b149f9)

## Introduction
This is a Recipe App that allows users to explore a collection of delicious recipes. The app includes three main screens: Home Screen, Detail Screen, and Map Screen.

## Architecture and Design Patterns

For the architecture of the Android app, I used the MVVM (Model-View-ViewModel) design pattern. MVVM separates the app into three main components: Model (data and business logic), View (user interface), and ViewModel (handles data presentation and communication between Model and View). MVVM promotes a clean separation of concerns and makes the codebase more maintainable.

Common Patterns that have been used on the project

- Observer
- Singleton
- Builder

## Libraries and Dependencies

I used the following external libraries and dependencies in the Android project:

- Retrofit: For handling API requests to fetch recipe data.
- Coil: To load recipe images efficiently.
- Flow and ViewModel: To implement the MVVM architecture and observe data changes.
- Compose: To display the ui Screens.

## Testing

I have written unit tests to cover critical parts of the app, such as ViewModel and Repository classes. The tests ensure that data retrieval, filtering, and presentation are functioning correctly.

## Features

### Home Screen

- Displays a list of recipes with their images and names.
- Provides a search bar to filter recipes based on name or ingredients.

### Detail Screen

- Shows the selected recipe's image, name, and description.
- Includes a button to navigate to the Map Screen.

### Map Screen

- Displays a map with a marker at the recipe's origin location.

## Mocks and APIs

For testing purposes, I used the mockable.io API to simulate API responses. This API provides mock data that allows me to test the app's functionality without making actual network requests.

For the Map Screen, I used the Google Maps API to display the geolocation of the recipe's origin.

## Known Limitations and Future Improvements

- Currently, the app doesn't support offline mode. Implementing caching and handling offline scenarios could improve the user experience.
- The app only includes a basic search feature. Enhancements like advanced filters and sorting options could be added.
- More testing coverage could be implemented for edge cases and UI interactions.


