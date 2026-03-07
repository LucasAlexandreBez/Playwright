<div align="center">

# 💻 Playwright Framework With Java ☕

</div>

<div align="center">

![Java](https://img.shields.io/badge/Java-17-orange)
![Playwright](https://img.shields.io/badge/Playwright-Java-green)
![JUnit5](https://img.shields.io/badge/JUnit-5-blue)
![Allure](https://img.shields.io/badge/Allure-Reports-purple)
![HikaryCP](https://img.shields.io/badge/HikaryCP-DB_Connection-yellow)

</div>

An End-to-End automation testing framework built with **Playwright + Java + JUnit 5 + Allure + Docker**.

The goal of this project is to provide a reliable and structured automation framework that simplifies debugging test failures by automatically collecting test artifacts such as videos, screenshots, and network logs.

⚠️ **This framework was designed with thread safety in mind!**
`<br>`
⚠️ **The entire project structure and core classes were implemented to support safe parallel test execution!**

### 👨‍💻 Author

Lucas Alexandre - QA SDET Engineer

🔗 [My Linkedin]([https://onlinemarkdown.com](https://www.linkedin.com/in/lucasalexandrebezpiancoski/))

---

# 🔶 Index

1. [Frameworks](#-frameworks)
2. [Key Features](#-key-features)
3. [Open Source Usage](#-open-source-usage)
4. [Understanding The Structure](#️️-understanding-the-structure)
   - [Releses Folder](#-releses-folder)
   - [Helper Folder](#-helper-folder)
   - [Engine Fodler](#-engine-folder)
   - [Config Folder](#-config-folder)
   - [App&#39;s Folder](#-apps-folder)
5. [Running the Tests](#️-running-the-tests)
6. [Generating the Allure Report](#-generating-the-allure-report)
7. [](#)

---

# 📚 Frameworks

- Java
- Playwright
- JUnit 5
- Maven
- Allure Reports
- Docker (Playwright Server)

---

# 📌 Key Features

- End-to-End UI automation
- Database validation for test assertions
- Integration with **Allure Reports**
- Execution using **Playwright Server with Docker**
- Thread-safe artifact handling using **JUnit TestWatcher**
- Clean and modular framework structure
- Automatic artifact collection:
  - 🎥 Video recording
  - 📷 Screenshots
  - 🌐 HAR network logs

---

# 🤝 Open Source Usage

If anyone wants to use this project as a **starting point for their own automation frameworks**, feel free to clone it and adapt it for your own projects.

---

# 🕵️‍♂️ Understanding the Structure

The project structure was designed to be easy to navigate and to help maintain a well-organized codebase.

<div align="center">

![Structure](https://github.com/LucasAlexandreBez/Playwright/blob/main/DocImages/Structure_1.png)

> Project structure overview

</div>

---

### 📂 Releases Folder

The `releases` folder is used to organize the test cases executed for each release.

Following the same structure is not mandatory, but this was the pattern I adopted to keep test execution organized.

Inside each release package, test classes are grouped by the type of test being executed, for example:

- `E2E.java`
- `Regression.java`
- `Smoke.java`

For every release, I create a new package and a dedicated **TestSuite**. This allows tests to be executed selectively using **JUnit Tags**, making it possible to include or exclude specific test cases depending on the test scope.

<div align="center">

![Releases Structure](https://github.com/LucasAlexandreBez/Playwright/blob/main/DocImages/ReleasesStruture.png)

> Release structure overview

![Test Suite Example](https://github.com/LucasAlexandreBez/Playwright/blob/main/DocImages/TestSuiteExample.png)

> Test suite example

</div>

---

### 🤖 Helper Folder

The `helper` folder contains auxiliary utilities used across the framework.
All helper methods are implemented as **static functions** to simplify usage and avoid unnecessary object instantiation.

<div align="center">

![Helpers Structure](https://github.com/LucasAlexandreBez/Playwright/blob/main/DocImages/HelpersStruture.png)

> Helper structure overview

</div>

Inside this folder we currently have:

- `EmployeeFactory`: This class generates random employee data used in the OrangeHRM test flows. It uses predefined lists of **first names, middle names, and last names**, and combines them with the **current thread number** to generate a unique username with a default password. The method returns a randomized **employee object** that can be used during test execution.

<div align="center">

![Employee Factory](https://github.com/LucasAlexandreBez/Playwright/blob/main/DocImages/EmployeeFactory.png)

> Employee factory class

</div>

- `AllureAttachmentHelper`: This class is responsible for attaching **images, videos, files, and text logs** to the **Allure Report** once a test execution finishes. For image attachments, if a specific file extension is not available when using the `SupportedImageTypes` enum, you can simply add the new extension following the existing enum structure.

<div align="center">

![Allure Attachment](https://github.com/LucasAlexandreBez/Playwright/blob/main/DocImages/AllureAttachmentHelper.png)

> Allure attachment helper class

![Supported Image Types](https://github.com/LucasAlexandreBez/Playwright/blob/main/DocImages/SupportedImageTypeEnum.png)

> Supported image types enum

</div>

- `DBQueryExecutorHelper`: This helper class centralizes the execution of SQL queries in the framework and abstracts the boilerplate code usually required when working with JDBC. The class uses **HikariCP connection pooling** through the `HikariDBManager` and provides a generic method that executes a SQL query and maps the result into a custom object using a functional mapper. The `executeQuery` method receives:
  - A [DBConnInfo](#Database-Info) object containing database connection details
  - The SQL query string (If has paramenters let the then as ? instead of the value since the Helper already resolve the params and add then to the query)
  - A `Function<ResultSet, T>` mapper that converts the query result into a desired object
  - Optional parameters for the prepared statemen

Example:

```java
String empNumber = DBQueryExecutorHelper.executeQuery(
    dbInfo,
    "SELECT emp_number FROM hs_hr_employee WHERE employee_id = ?",
    rs -> rs.getString("emp_number"),
    employeeId
);
```

<div align="center">

![SQL Query executor](https://github.com/LucasAlexandreBez/Playwright/blob/main/DocImages/DBQueryExecutorHelper.png)

> Database query executor helper class

</div>

- `PropertiesConfigLoader`: The `PropertiesConfigLoader` class is responsible for loading **environment-specific configuration values** used across the framework. Instead of hardcoding configuration values directly in the test code, the framework reads them from **properties files** located in the project resources. This allows the same tests to run in different environments (for example: `dev`, `qa`, or `prod`) without requiring code changes.

  The configuration file is selected based on the active **Maven profile** and each environment must follow the naming convention:

  `application-<profile>-<cloud or local>.properties`

  Example:

  - application-dev-cloud.properties
  - application-qa-qlab02.properties
  - application-prod-local.properties

  Example execution:

  ```bash
  mvn clean test -P qa-local
  ```

  Once loaded, the configuration is cached in memory and reused for the remainder of the test execution. The framework follows a fail-fast strategy for configuration handling and execution will stop if:

  - Execution will stop if:
  - No environment profile is defined
  - The configuration file cannot be found
  - A required property key is missing or empty

  Configuration values can be accessed using the getPropertyValue method:

  ```java
  String baseUrl = PropertiesConfigLoader.getPropertyValue("app.orangehrm.url");
  ```

<div align="center">

![Property's config loader](https://github.com/LucasAlexandreBez/Playwright/blob/main/DocImages/PropertiesConfigLoader.png)

> Database query executor helper class

</div>

---

### ⚙ Engine Folder

The `engine` folder contains the core components responsible for managing the execution of tests across the framework. Most classes in this package implement the **core execution logic**, including browser lifecycle management, test infrastructure setup, and artifact handling. Because these components were designed with **thread-safe execution in mind**, it is generally recommended **not to modify them unless you fully understand the framework architecture**.

⚠️ **Modifying these classes without understanding their role may break parallel execution or core framework behavior.**

<div align="center">

![Engine Structure](https://github.com/LucasAlexandreBez/Playwright/blob/main/DocImages/EngineStructure.png)

> Engine structure overview

</div>

Inside this folder we currently have:

- `PlaywrightThreadManager`: This class is responsible for managing the lifecycle of **Playwright** and **Browser** instances across the framework. It can be considered the **core component** that initializes and provides access to the browser used during test execution.

  To support **safe parallel execution**, the class uses `ThreadLocal` variables to ensure that each test thread receives its own isolated Playwright and Browser instances.

  Two main thread-local objects are used:

  - `PLAYWRIGHT_THREAD`
  - `BROWSER_THREAD`

  Both are lazily initialized using `ThreadLocal.withInitial(...)`. This means that a new instance is only created when the thread accesses it for the first time. This approach prevents the framework from creating multiple unnecessary Playwright or Browser instances, which would otherwise consume significant **memory and CPU resources**.

  Another important design decision is that the framework only exposes **getter methods** for these instances and there are no public setters. This guarantees that instance creation is fully controlled by the framework and avoids accidental overrides:

  - `getPlaywrightThreadInstance()`
  - `getBrowserThreadIntance()`

  When a test execution finishes, the method `cleanPlaywrightAndBrowserThreadInstances()` is used to safely close and remove the thread-local instances. This ensures:

  - Proper browser shutdown
  - Prevention of memory leaks
  - Isolation between parallel test executions

  By using this thread-local architecture, the framework ensures that **test threads do not share browser state**, preventing race conditions and cross-test contamination during parallel execution.

<div align="center">

![Playwright Thread Manager](https://github.com/LucasAlexandreBez/Playwright/blob/main/DocImages/PlaywrightThreadManager.png)

> Playwright thread manager overview

</div>

- `HikariDBManager`: The `HikariDBManager` class is responsible for managing **database connection pools** used across the framework and instead of creating a new database connection every time a query is executed, this class uses **HikariCP**, a high-performance JDBC connection pool, to efficiently manage and reuse database connections.

  This approach significantly improves performance and reduces the overhead associated with repeatedly opening and closing database connections during test execution.

  The manager maintains a **ConcurrentHashMap** that stores a pool of `HikariDataSource` objects which each connection pool is uniquely identified using a key built from the database configuration **databaseType + server + port + database**

  If a connection pool for a specific configuration already exists, it will be reused or if don't exist then a new pool will be created automatically and stored in the map.
  Currently the manager supports:

  - `MYSQL`
  - `POSTGRES`
  - `ORACLE`

  The JDBC connection URL is dynamically created based on the selected `DatabaseType` but if required it can be added for extra DB's just updating the `DatabaseType enum` and adding a new `CASE` on the `createDatasourceForDatabaseConnection` function at `HikariDBManager.class`. The following HikariCP settings are used to balance performance and resource usage based on the Hikary recomedations [See the video](https://www.youtube.com/watch?v=_C77sBcAtSQ):

  - `maximumPoolSize = 4`
  - `minimumIdle = 1`
  - `connectionTimeout = 5000ms`
  - `idleTimeout = 30000ms`
  - `maxLifetime = 1800000ms`

<div align="center">

![Hikary Database Manager](https://github.com/LucasAlexandreBez/Playwright/blob/main/DocImages/HikariDBManager.png)

> Hikari Database manager overview

</div>

- `TestBaseManager`: The `TestBaseManager` class is responsible for managing the **lifecycle of Playwright resources during test execution**.  It acts as the base infrastructure for test classes, ensuring that browser contexts, pages, and test artifacts are properly created, collected, and cleaned after each test run.
  This class also integrates with `TestStatusWatcher` to handle test artifacts such as **videos, screenshots, and HAR network logs**, which are later attached to the **Allure Report**. The class uses JUnit lifecycle annotations to control resource creation and cleanup:

  - `@AfterEach`: Responsible for collecting test artifacts and closing the Playwright `Page` and `BrowserContext`.
  - `@AfterAll`: Responsible for cleaning the thread-local Playwright and Browser instances managed by `PlaywrightThreadManager`.

  This guarantees that resources are properly released and prevents **memory leaks during long test executions**. To ensure **thread-safe artifact handling**, the class stores artifact references and exposes them to `TestStatusWatcher` using `Supplier` functions. This lazy evaluation strategy ensures that artifacts are only accessed **after they have been fully generated during the `@AfterEach` phase**.

  When tests run using **Playwright Server/Docker**, videos are generated on the remote browser instance and because of this, the framework attempts to retrieve the video path using `video.path()` and If the path is not accessible locally, the framework falls back to   `video.saveAs(...)` which guarantees that the video artifact is always copied to the local test results directory.

  If HAR capture on failure is enabled in `GlobalTestRunConfig`, the framework prepares the path where the HAR file will be generated  `target/hars/<test-name>.har`. This allows the framework to attach network logs to the test report when failures occur.

<div align="center">

![Test Base Manager](https://github.com/LucasAlexandreBez/Playwright/blob/main/DocImages/TestBaseManager.png)

> Test Base manager overview

</div>

- `TestStatusWatcher`: The `TestStatusWatcher` class is a **JUnit TestWatcher extension** responsible for reacting to test execution results and attaching test artifacts to the **Allure Report**.

  This class listens to test outcomes and automatically processes artifacts such as **videos, screenshots, network logs, and failure details**, ensuring that every test execution produces useful debugging information.

  When a test finishes, the watcher retrieves artifacts produced during execution through `Supplier` references provided by `TestBaseManager`,
  which avoids shared state and ensures that artifacts are only accessed **after they are fully generated**, making it safe for **parallel test execution**.

  ### Video Processing

  Videos generated by Playwright are automatically renamed to include:


  - the test name
  - execution status (`SUCCESS` or `FAILED`)
  - a timestamp

  Example: `target/videos/LoginTest_FAILED_1700000000000.webm`

  This makes it easier to identify test runs when multiple executions happen in parallel.

  ### Failure Logging

  When a test fails, the class generates a **detailed failure log** that includes:

  - Test name
  - Thread name
  - Exception message
  - Full stack trace

  This information is attached to the Allure report as a text artifact, allowing quick inspection of test failures without opening external logs.

<div align="center">

![Test Status Watcher](https://github.com/LucasAlexandreBez/Playwright/blob/main/DocImages/TestStatusWatcher.png)

> Test Status watcher overview

![Success & Failure functions](https://github.com/LucasAlexandreBez/Playwright/blob/main/DocImages/TestStatusWatcherSuccessFailed.png)

> Test Status Success/Failure overview

</div>

- `Devices Folder`: The `devices` folder contains predefined **browser context templates** used to simulate different devices during test execution with a set of **Playwright `Browser.NewContextOptions` configurations** that emulate a specific device by defining parameters:

  - User agent
  - Viewport size
  - Device scale factor
  - Mobile behavior
  - Touch support

  This allows tests to easily run under different device conditions without having to manually configure these settings for each test.

  ```java
  Browser.NewContextOptions options = LGOptimusL70Context.LG_Optimus_L70();
  BrowserContext context = browser.newContext(options);
  ```

<div align="center">

![Devices Structure](https://github.com/LucasAlexandreBez/Playwright/blob/main/DocImages/DevicesFolderStructure.png)

> Device's folder Structure overview

![Device](https://github.com/LucasAlexandreBez/Playwright/blob/main/DocImages/LGOptimusL70ContextDeviceExample.png)

> Device function overview

</div>

- `BrowserRunManager`: The `BrowserRunManager` class is responsible for creating and configuring the **Playwright Browser instance** used during test execution. Instead of initializing browsers directly inside test classes, the framework centralizes all browser setup logic in this manager. This ensures that browser configuration remains **consistent, maintainable, and easy to extend**.

  The manager supports multiple execution environments and browser configurations, allowing the same tests to run in different environments without requiring any code changes. The execution mode is resolved using `PropertiesConfigLoader`, which reads the configuration from environment-specific properties files. Currently, the framework supports two execution modes:

  - `LOCAL` – Launches the browser directly on the local machine.
  - `CLOUD` – Connects to a remote Playwright server (for example a Docker container or cloud execution environment).

<div align="center">

![Browser Run Manager Structure](https://github.com/LucasAlexandreBez/Playwright/blob/main/DocImages/BrowserRunManager.png)

> Browser Run Manager overview

![Local Browser Config](https://github.com/LucasAlexandreBez/Playwright/blob/main/DocImages/LocalBrowserConfig.png)

> Local browser configuration overview

![Cloud Browser Config](https://github.com/LucasAlexandreBez/Playwright/blob/main/DocImages/CloudBrowserConfig.png)

> Cloud browser configuration overview

</div>

---

### 🛠 Config Folder

The `config` folder contains the global configuration classes used across the framework.
These classes define the **runtime behavior of test executions**, including browser settings and artifact capture configuration.

<div align="center">

![Configuration Structure](https://github.com/LucasAlexandreBez/Playwright/blob/main/DocImages/ConfigStructure.png)

> Configuration structure overview

</div>

Inside this folder we currently have:

- `GlobalTestRunConfig`: The `GlobalTestRunConfig` class centralizes **global runtime configurations** used across the entire framework. This class defines a single location where common execution parameters can be adjusted. The configuration is divided into two main groups: **browser runtime settings** and **artifact capture settings**.

  These parameters control how the Playwright browser instance behaves during test execution:

  - `HEADLESS` – Defines whether the browser should run in headless mode.
  - `SLOWMOTION` – Adds a delay between Playwright actions, useful for debugging test behavior.
  - `TIMEOUT` – Default timeout used by Playwright operations.
  - `SELECTED_BROWSER` – Defines which browser will be used during execution.
  - `CHROMIUM_SANDBOX` – Enables or disables the Chromium sandbox when launching Chromium-based browsers.

  These parameters control which artifacts should be generated during test execution:

  - `VIDEO_CAPTURE` – Enables Playwright video recording for test sessions.
  - `SCREENSHOT_CAPTURE` – Enables automatic screenshot capture.
  - `HAR_CAPTURE_ON_FAILURE` – Enables network log (HAR) capture when a test fails.

<div align="center">

![Global Test Run Configuration](https://github.com/LucasAlexandreBez/Playwright/blob/main/DocImages/GlobalTestRunConfig.png)

> Global Test Run Configuration overview

</div>

---

### 📱 App's Folder

The `apps` folder contains the test structure and pre-configuration classes used to build the test cases located in the `releases` folder.

<div align="center">

![Configuration Structure](https://github.com/LucasAlexandreBez/Playwright/blob/main/DocImages/AppStructure.png)

> Configuration structure overview

</div>

For each app we divide in different folders, and for each app folder we have:

- `<App>TestBase.class`: This class acts as the **base setup class for a specific application**. It contains the common configuration required before running tests, including the `@BeforeEach` setup logic. If additional configuration is required, such as running tests with a different device or context configuration, this class can be updated or a new class following the same pattern can be created. This approach allows the framework to support **multiple test configurations** while keeping test cases clean and reusable.

<div align="center">

![Configuration Structure](https://github.com/LucasAlexandreBez/Playwright/blob/main/DocImages/OrangeHRMTestBaseExample.png)

> Test base configuration example

</div>

- `<App>DBInfo.class`: The `<App>DBInfo` class is responsible for providing the **database connection configuration for a specific application**. Instead of scattering database connection details throughout the test code, this class centralizes the retrieval of database configuration values from the properties files. The configuration values are loaded using `PropertiesConfigLoader`, which reads the environment-specific properties file.

These values are used to create a `DBConnInfo` object, which is later consumed by `DBQueryExecutorHelper` to execute SQL queries in Flows folder. Each application can define its own `DBInfo` class to provide the required database connection parameters, such as:

- Database type
- Server address
- Port
- Database name
- Username
- Password

<div align="center">

![Orange HRMDB Info class](https://github.com/LucasAlexandreBez/Playwright/blob/main/DocImages/OrangeHRMDBInfo.png)

> OrangeHRMDBInfo class overview

![Usage Example](https://github.com/LucasAlexandreBez/Playwright/blob/main/DocImages/CreateNewEmployeeDB.png)

> Usage Example on a Flow class

</div>

- `Flow's folder`: The `flows` folder contains the **business logic layer of the automation framework**. Instead of placing all interactions directly inside test classes, the framework uses flows to represent **complete user actions or business operations** within the application. This approach helps keep test cases **clean and readable**, while encapsulating complex interactions inside reusable flow classes.

<div align="center">

![Usage Example](https://github.com/LucasAlexandreBez/Playwright/blob/main/DocImages/LoginUserFlow.png)

> Usage Example on a Flow class

</div>

- `Model folder`: The `models` folder contains the **data structures used across the framework**.These classes represent entities used during test execution and are responsible for transporting structured data between different layers of Test cases, Flows, Page objects or Database queries. Instead of passing multiple individual variables between methods, the framework uses model objects to group related data into a single structure.

<div align="center">

![Usage Example](https://github.com/LucasAlexandreBez/Playwright/blob/main/DocImages/OHRMUser.png)

> Model class overview

</div>

- `Page Folder`: The `page` folder contains the **Page Object Model (POM) implementation** used by the framework. Each class in this folder represents a **specific page or UI component of the application**, encapsulating all interactions with that page. This includes elements such as buttons, inputs, menus, and any actions that can be performed within that screen.

<div align="center">

![Usage Example](https://github.com/LucasAlexandreBez/Playwright/blob/main/DocImages/LoginPage.png)

> Login class overview

</div>

---

# ▶️ Running the Tests

Run tests using Maven: **mvn clean test -P 'desired profile'**

# 📈 Generating the Allure Report

If you check the test cases, flow classes, and page classes, you will notice several annotations being used. These annotations are used by **Allure** to collect metadata and generate the test execution report. If you are interested in learning more about how Allure works, I highly recommend checking the official [Allure Documentation](https://allurereport.org/docs/).

After running the tests:
- Open the folder conataining the allure-results
- Run the command ``allure serve``

This will open a local Allure report with test results and artifacts.

<div align="center">

![Usage Example](https://github.com/LucasAlexandreBez/Playwright/tree/main/DocImages/AllureReportExample.png)

> Allure report example

</div>

---

# 🐳 Running with Playwright Server (Docker)

This framework supports execution with **Playwright Server running inside Docker**.

For more details check the Compose.yaml on this project as well the [Docker project](https://github.com/LucasAlexandreBez/Docker) on my [Github Repository](https://github.com/LucasAlexandreBez?tab=repositories).

Example setup:
browserType.connect("ws://playwright:3000")

When running remotely, videos are generated on the remote browser instance and copied locally using:

video.saveAs()
