```markdown
# BDD Cucumber Automation Framework

This project is a Behavior-Driven Development (BDD) automation framework built using Cucumber, Java, and the Page Object Model (POM) design pattern. The framework is designed to facilitate automated testing of web applications with a focus on maintainability and scalability.

## Project Structure

The project is organized into several key folders, each serving a specific purpose:

### 1. Pages
- **BasePage**: An abstract class that contains common methods and properties shared across all page classes.
- **Other Page Classes**: Specific page classes that extend `BasePage`, implementing page-specific actions and locators.

### 2. Runners
- **Runner Class**: This class is responsible for executing the Cucumber tests. It includes:
  - `@RunWith` annotation to specify the runner.
  - `@CucumberOptions` to configure the test execution:
    - `plugin`: Specifies the output format (e.g., HTML, JSON).
    - `features`: Path to the feature files.
    - `glue`: Path to the step definitions.
    - `dryRun`: Set to true for checking step definitions without running tests.
    - `tags`: Allows filtering of scenarios based on tags.
    - `publish`: Enables publishing of test results.

- **FailedTestRunner Class**: A specialized runner that executes only the failed tests by reading from `@target/rerun.txt`. This saves time by focusing on scenarios that need attention.

### 3. Step Definitions
- Contains Java classes that define the step definitions corresponding to the Gherkin steps in the feature files. Each class is responsible for implementing the logic behind each step.

### 4. Hooks
- **Hooks Class**: Contains lifecycle methods, including a `tearDown` method that captures screenshots when a scenario fails, aiding in debugging.

### 5. Utilities
- **BrowserUtils Class**: A utility class containing helper methods for browser interactions (e.g., navigation, waiting).
- **ConfigurationReader Class**: Manages reading configuration properties from a file.
- **Driver Class**: Implements the Singleton design pattern to manage WebDriver instances, ensuring a single instance throughout the test execution.

### 6. Resources
- Contains feature files written in Gherkin language. Each file describes scenarios in a human-readable format, making it easy for stakeholders to understand test cases.

### 7. Configuration
- **pom.xml**: The Maven configuration file containing dependencies required for the project and CLI run configurations.
- **configuration.properties**: A properties file storing sensitive data such as URLs and credentials securely.

## Getting Started

To get started with this framework:

1. **Clone the Repository**:
   ```
git clone <repository-url>
cd <project-directory>
   ```

2. **Install Dependencies**:
   Ensure you have Maven installed, then run:
   ```
mvn clean install
   ```

3. **Run Tests**:
   To execute all tests, use:
   ```
mvn test
   ```

4. **Run Failed Tests**:
   If some tests fail, rerun them using:
   ```
mvn test -Dcucumber.options="@target/rerun.txt"
   ```

## Conclusion

This BDD Cucumber framework provides a robust structure for automating web application testing using Java. Its modular design promotes code reuse and simplifies maintenance while ensuring that tests are easy to read and understand through Gherkin syntax.

For any questions or contributions, feel free to open an issue or submit a pull request!

```

## Author

[Halim Iltas](https://www.linkedin.com/in/halim-iltas/)