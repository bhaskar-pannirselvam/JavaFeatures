# Java Features Exploration

This project aims to demonstrate various features of the Java programming language through simple and illustrative code examples. Currently, the project covers the usage of switch cases.

## Features Covered

- **Switch Cases**: Demonstrates the use of switch expressions with integers, strings, enums, and records.

## Project Structure

- `src/main/java/com/bhaskar/java/features/switchcase/ModernSwitchExpressionExamples.java`: Contains the implementation of various switch case examples.
- `src/test/java/com/bhaskar/java/features/switchcase/ModernSwitchExpressionExamplesTest.java`: Contains the unit tests for the switch case examples.

## How to Run

1. **Clone the repository**:
    ```sh
    git clone https://github.com/bhaskar-pannirselvam/java-features-exploration.git
    cd java-features-exploration
    ```

2. **Build the project**:
    ```sh
    mvn clean install
    ```

3. **Run the tests**:
    ```sh
    mvn test
    ```

## Examples

### Switch Case with Integers

```java
public static String printDay(int dayNumber) {
    return switch (dayNumber) {
        case 1 -> "Monday";
        case 2 -> "Tuesday";
        case 3 -> "Wednesday";
        case 4 -> "Thursday";
        case 5 -> "Friday";
        case 6 -> "Saturday";
        case 7 -> "Sunday";
        default -> "Invalid day";
    };
}
