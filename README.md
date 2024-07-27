# Automated Testing for Web Application
## Table of Contents

- [Description](#description)
- [Features](#features)
- [Project Structure](#project-structure)
- [Installation](#installation)
- [Usage](#usage)
- [Technologies Used](#technologies-used)



## Description

This project contains automated tests for a web application that facilitates user registration, profile management, city and hotel searches, and hotel filtering. Implemented using Java, Selenium, and TestNG, these tests ensure the application's functionality and performance. The project leverages the Page Object Model (POM) design pattern for maintainability and readability of the test scripts.

## Features

- **User Registration**: Tests for account creation with random and specific emails.
- **Profile Management**: Tests for updating user profile data.
- **Search Functionality**: Tests for searching cities and hotels.
- **Filter Functionality**: Tests for filtering hotels by price and adding them to the wishlist.
- **Negative Testing**: Tests for handling invalid email formats and weak passwords.

## Project Structure

```plaintext
.
├── POM
│   ├── Pages
│   │   ├── HomePage.java
│   │   ├── HotelsPage.java
│   │   ├── MyProfilePage.java
│   │   └── RegistrationPage.java
│   ├── Utils
│   │   ├── GenerateRandom.java
│   │   ├── Waits.java
│   │   └── WebDriverManager.java
├── Tests
│   ├── BaseTest.java
│   └── Tests.java
├── pom.xml
└── README.md
```

## Installation

1. Clone the repository:

```bash
git clone https://github.com/your-username/automated-testing-web-app.git
cd automated-testing-web-app
```

2. Install dependencies:

Ensure you have [Maven](https://maven.apache.org/install.html) installed. Then, run:

```bash
mvn clean install
```

3. Configure WebDriver:

Make sure you have the appropriate WebDriver for your browser installed and set up in your system's PATH.

## Usage

1. To run the tests, use the following command:

```bash
mvn test
```
## Technologies Used

- **Java**: Programming language for writing the test scripts.
- **Selenium**: Tool for automating web browsers.
- **TestNG**: Testing framework for running tests.
- **Allure**: Reporting tool for generating test reports.
- **Maven**: Build automation tool for managing dependencies and running tests.


