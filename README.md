# automation-exercise

## Project Description
The **automation-exercise** project is a framework for automating tests for the web application **automationexercise.com**. It is written in **Java** using **Selenium WebDriver**, **TestNG**, and **Maven**.

The project uses the **Page Object Model** design pattern. The project structure is divided into classes representing the application's pages, test classes, and utility classes:

- Page object classes are located in the `src/main/java/pageobject` directory.
- Test classes are located in the `src/main/java` directory.
- Helper classes are located in the `src/main/java/helpers` directory.

Additionally, there are configuration files located in the `src/main/resources` directory:
- Browser configuration: `configuration.properties`
- Test data configuration: `testData.properties`

## Technologies (Versions I Worked With)
- Java 23.0
- Selenium WebDriver 4.27
- TestNG 7.11
- Maven 3.9

## Running the Project
1. Clone the repository:
   ```bash
   git clone https://github.com/PiotrT4/automation-exercise.git
   ```
2. Open IntelliJ IDEA
Launch **IntelliJ IDEA**.

3. Open the downloaded project
Open the previously downloaded **automation-exercise** project in IntelliJ IDEA.

4. Wait for the project to load completely
Wait until IntelliJ has fully loaded the project and all dependencies have been configured.

5. Select the configuration
Choose the configuration to run all test cases: **“All in automation-exercise”**.

6. Run the tests
Run the tests by clicking the **play** button or using the keyboard shortcut:
```bash
Shift + F10
```

## License

MIT License

Copyright (c) [2025] [Piotr Tarnawski]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
