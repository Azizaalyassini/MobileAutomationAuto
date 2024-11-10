
# MobileAutomationAuto
Selenium Webdriver Pajeobject/Testng/json

# Project README

## Overview
This project consists of a suite of automated tests and page classes for testing mobile applications using Appium. The framework includes various page classes, utility classes, and test scripts designed for seamless interaction with mobile elements.

## Structure
The project is structured as follows:

- **BasePage.java**: A foundational class that provides common methods and utilities for all page classes. It includes methods such as element interaction, waiting for visibility, and retrieving element text.
- **Homepage.java**: Represents the homepage of the application and extends `BasePage` to inherit common methods. It contains methods to interact with elements such as the login, form, and swipe buttons.
- **FormComponentsPage.java**: Manages form-related components within the app. This class includes methods for filling forms, interacting with switches, and selecting options from dropdowns.
- **LoginAndSignupPage.java**: Handles interactions for login and signup functionalities. It extends `BasePage` for consistent functionality across page classes.
- **SwipePage.java**: Represents the swipe functionality and contains methods to perform and validate swipe actions.
- **BaseTest.java**: A base class for test cases that ensures a consistent test environment setup and teardown.
- **AssignmentTest.java**: Contains specific test cases related to assignment requirements.
- **signUp.json**: A JSON file with test data for signup operations, including sample email, password, and form inputs.
- **Util Folder**:
    - **JsonReader.java**: A utility class for reading data from JSON files, providing support for data-driven testing.
    - **RandomUtils.java**: A utility class that offers methods to generate random data such as strings and numbers, which can be used to enhance test scenarios.
    - **TestListener.java**: Implements a test listener for tracking and managing test execution events, useful for logging and reporting.

## Key Features
- **Reusable Components**: The `BasePage` class provides common utilities, ensuring that all page classes have access to essential methods for element handling and navigation.
- **Modular Structure**: Each page class and utility class represents a specific functionality or support system, allowing for easy maintenance and updates.
- **Data-Driven Testing**: The inclusion of `signUp.json` and `JsonReader.java` facilitates data-driven tests for form submissions and validation.
- **Enhanced Testing Support**: The `RandomUtils.java` class helps create varied test data, improving test coverage. The `TestListener.java` class aids in monitoring and logging test executions.

## How to Run
1. Ensure that Appium is set up and running on your machine.
2. Open the project in an IDE that supports Java.
3. Configure the `AppiumDriver` with the necessary capabilities.
4. Run the test classes (e.g., `AssignmentTest.java`) to execute the test cases.

## Requirements
- Java Development Kit (JDK)
- Appium Server
- Appium Java Client Library
- A compatible mobile device or emulator

## Installation
1. Clone the repository.
2. Install the necessary dependencies using Maven or your preferred build tool.
3. Configure the Appium server and device capabilities.

## Usage
- **Homepage Interactions**: Use `Homepage.java` to automate navigation and interactions on the main page of the app.
- **Form Testing**: `FormComponentsPage.java` provides methods to automate form submissions and validations.
- **Login and Signup**: `LoginAndSignupPage.java` handles user authentication processes.
- **Swiping Actions**: `SwipePage.java` helps test swipe-based features in the app.
- **Utility Methods**: Use `JsonReader.java` for reading test data from JSON files and `RandomUtils.java` for generating random data.
- **Test Monitoring**: Utilize `TestListener.java` for better tracking and logging of test case executions.

## License
This project is licensed under the [Aziza Hasan].

---

**Note**: Ensure that all sensitive data such as passwords in `signUp.json` are handled securely.

