# CityExplorer

## Overview

CityExplorer is a feature-rich Android application designed to help users discover and explore cities around the world. The app provides a user-friendly interface to search for cities, view detailed information, and interact with city data using integrated maps.

The application leverages modern Android development practices to ensure clean, maintainable, and scalable code. It uses a local JSON file to provide city data, making it a self-contained solution without relying on external APIs. Key architectural components such as Dependency Injection (DI) with Dagger Hilt, RecyclerView for efficient data display, and Kotlin Coroutines for managing asynchronous tasks are employed to enhance both development and runtime performance.

## Features

- **Search for Cities by Name:**
  Users can efficiently search for cities by typing city names into a search bar. The app utilizes a trie data structure to enable fast and accurate search results.
  As users type, the trie structure dynamically filters the list of cities and provides real-time search results based on the input prefix.


- **Display Cities on Google Maps:**
  The app integrates with Google Maps to visually display the locations of cities. Users can interact with the map to view cities in their geographical context, making it easier to understand their locations.


- **Dependency Injection (Dagger Hilt):**
  Dagger Hilt is used for Dependency Injection to streamline the process of providing dependencies throughout the app. This approach improves testability by allowing easy replacement of dependencies and enhances code manageability by adhering to the principles of inversion of control.


- **Asynchronous Operations with Kotlin Coroutines:**
  Kotlin Coroutines are used to handle asynchronous operations efficiently. This includes tasks like data loading and filtering, ensuring that the user interface remains responsive and fluid while background tasks are processed.


- **Lottie Animations:**
  Lottie is used to integrate high-quality vector animations into the app. These animations enhance user experience by providing visually appealing and smooth animations for various UI elements, such as loading indicators and transition effects.


- **Navigation:**
  The app uses Android's Navigation Component to handle in-app navigation. This ensures a seamless user experience by managing fragment transactions and navigation flow in a structured manner. It allows users to easily navigate between different parts of the app.
