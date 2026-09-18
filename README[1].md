# Campus Expense Manager

A command-line Java 17 application for college students to record expenses, manage monthly budgets, and generate spending analytics. It demonstrates OOP, interfaces, collections, streams, file I/O, validation, exception handling, logging, Maven and JUnit testing.

## Major Modules
1. **Expense Management:** add, list, search, update and delete expenses.
2. **Budget Management:** set/update a monthly budget and view utilization.
3. **Analytics & Reports:** monthly total and category-wise spending.

## Technologies
- Java 17
- Maven
- JUnit 5
- Java Collections / Streams
- `java.time`
- CSV file persistence
- `java.util.logging`

## Requirements
Install JDK 17+ and Maven 3.8+. Verify with `java -version` and `mvn -version`.

## Setup and Run
```bash
git clone https://github.com/YOUR_GITHUB_USERNAME/campus-expense-manager.git
cd campus-expense-manager
mvn clean compile
mvn exec:java
```

No database, GUI or external service is required. Runtime files are created in `data/`.

## Test
```bash
mvn test
```

## Menu
- Add expense
- List expenses
- Search expenses
- Update expense
- Delete expense
- Set monthly budget
- View budget status
- View monthly analytics
- Exit

Categories: `FOOD`, `TRAVEL`, `EDUCATION`, `SHOPPING`, `HEALTH`, `ENTERTAINMENT`, `OTHER`.

## Structure
```text
campus-expense-manager/
├── data/
├── docs/diagrams/
├── src/main/java/com/campus/expense/
├── src/test/java/com/campus/expense/
├── statement.md
├── pom.xml
└── README.md
```

## Academic Mapping
The project applies classes/objects, encapsulation, interfaces, collections, streams, exception handling, file handling, date/time APIs, modular design, logging and unit testing. It contains more than the required 5–10 meaningful source files.

## Originality
Review, run, understand and modify this project before submission. Add screenshots produced from your own run and replace the GitHub username placeholder.
