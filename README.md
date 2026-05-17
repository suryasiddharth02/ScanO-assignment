# SauceDemo – QA Automation Project

**Application Under Test:** [https://www.saucedemo.com](https://www.saucedemo.com)
**Automation Framework:** Selenium WebDriver (Java)
**Assignment Scope:** Exploratory Testing · Test Case Design · Automation

---

## Table of Contents

1. [Project Overview](#1-project-overview)
2. [Test Credentials](#2-test-credentials)
3. [Project Structure](#3-project-structure)
4. [Prerequisites](#4-prerequisites)
5. [Setup & Installation](#5-setup--installation)
6. [Running the Automation](#6-running-the-automation)
7. [What the Automation Covers](#7-what-the-automation-covers)
8. [Test Cases Summary](#8-test-cases-summary)
9. [Bug Report Summary](#9-bug-report-summary)
10. [Known Issues](#10-known-issues)

---

## 1. Project Overview

This project contains the complete QA deliverables for the SauceDemo take-home assignment:

| Deliverable | File |
|---|---|
| Bug Report & Test Cases | `SauceDemo_Test_Case_and_Bug_Report.xlsx` |
| Automation Script | `SauceDemo.java` |
| Setup Instructions | `README.md` (this file) |

The automated test script covers the core happy-path flow:

- Login with valid credentials
- Add multiple products to the cart (T-Shirt, Fleece Jacket, Backpack)
- Proceed to Checkout and fill in customer details
- Complete the order and return to the Products page

---

## 2. Test Credentials

These credentials are available on the SauceDemo login page:

| Username | Password | Notes |
|---|---|---|
| `standard_user` | `secret_sauce` | Used in automation; full access |
| `locked_out_user` | `secret_sauce` | Cannot log in (locked account) |
| `problem_user` | `secret_sauce` | Displays broken product images |
| `performance_glitch_user` | `secret_sauce` | Simulates slow network responses |
| `error_user` | `secret_sauce` | Triggers various error states |
| `visual_user` | `secret_sauce` | Visual layout issues |

---

## 3. Project Structure

```
saucedemo-qa/
│
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── saucedemo/
│                   └── SauceDemo.java          # Main automation script
│
├── SauceDemo_Test_Case_and_Bug_Report.xlsx     # Bug Report + Test Cases
├── README.md                                   # This file
└── pom.xml                                     # Maven dependencies
```

---

## 4. Prerequisites

Ensure the following are installed before running the project:

| Tool | Version | Download |
|---|---|---|
| Java JDK | 11 or higher | https://adoptium.net |
| Maven | 3.6+ | https://maven.apache.org |
| Google Chrome | Latest stable | https://www.google.com/chrome |
| ChromeDriver | Must match Chrome version | https://googlechromelabs.github.io/chrome-for-testing |

> **Tip:** Check your Chrome version at `chrome://settings/help` and download the matching ChromeDriver version.

---

## 5. Setup & Installation

### Step 1 – Clone or Download the Project

```bash
git clone https://github.com/your-username/saucedemo-qa.git
cd saucedemo-qa
```

Or unzip the submitted ZIP file and navigate into the folder.

### Step 2 – Set ChromeDriver Path

**Option A – Add ChromeDriver to System PATH (Recommended)**

Place `chromedriver.exe` (Windows) or `chromedriver` (Mac/Linux) in a folder that is on your system PATH.

```bash
# Verify it's accessible
chromedriver --version
```

**Option B – Set path in code directly**

In `SauceDemo.java`, add this line before `new ChromeDriver()`:

```java
System.setProperty("webdriver.chrome.driver", "C:/path/to/chromedriver.exe");
```

### Step 3 – Add Maven Dependencies

If using Maven, add the following to your `pom.xml`:

```xml
<dependencies>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.18.1</version>
    </dependency>
</dependencies>
```

Then run:

```bash
mvn clean install
```

### Step 4 – Compile the Project

```bash
mvn compile
```

---

## 6. Running the Automation

### Using Maven

```bash
mvn exec:java -Dexec.mainClass="com.saucedemo.SauceDemo"
```

### Using an IDE (IntelliJ IDEA / Eclipse)

1. Open the project in your IDE
2. Navigate to `src/main/java/com/saucedemo/SauceDemo.java`
3. Right-click the file → **Run 'SauceDemo.main()'**

### Expected Behaviour

When executed, the script will:

1. Open Chrome and navigate to `https://www.saucedemo.com`
2. Log in as `standard_user`
3. Navigate to the **Test.allTheThings() T-Shirt (Red)** product and add it to cart
4. Navigate to the **Sauce Labs Fleece Jacket** product and add it to cart
5. Navigate to the **Sauce Labs Backpack** product and add it to cart
6. Open the cart and click **Checkout**
7. Fill in: First Name: `Rohit`, Last Name: `Sharma`, Zip: `600089`
8. Click **Continue** → **Finish**
9. Click **Back to Products** — script completes

> The browser window will remain open after the script finishes. Close it manually or add `driver.quit()` at the end of the `application()` method.

---

## 7. What the Automation Covers

| Scenario | Automated | TC Reference |
|---|---|---|
| Successful login | ✅ Yes | TC-L-001 |
| Add product to cart (single) | ✅ Yes | TC-C-001 |
| Add multiple products to cart | ✅ Yes | TC-C-002 |
| Navigate to cart | ✅ Yes | TC-C-001 |
| Complete checkout with valid data | ✅ Yes | TC-CH-001 |
| Return to products after order | ✅ Yes | TC-CH-001 |
| Invalid login | ❌ Manual only | TC-L-002 |
| Empty field validation | ❌ Manual only | TC-L-003, TC-CH-002 |
| Whitespace input validation | ❌ Manual only | TC-CH-003 |
| Session/logout behaviour | ❌ Manual only | TC-L-007 |

---

## 8. Test Cases Summary

20 test cases covering three modules. Full details in `SauceDemo_Test_Case_and_Bug_Report.xlsx` → **Test Case** sheet.

| Module | Total | Pass | Fail |
|---|---|---|---|
| Login | 7 | 6 | 1 |
| Cart | 6 | 6 | 0 |
| Checkout | 7 | 5 | 2 |
| **Total** | **20** | **17** | **3** |

**Failed Test Cases:**

- **TC-L-007** – Back button after logout re-shows inventory page → linked to BUG-008
- **TC-CH-003** – Checkout form accepts whitespace-only inputs → linked to BUG-004
- **TC-CH-007** – Cart badge not reset after successful checkout → linked to BUG-003

---

## 9. Bug Report Summary

8 bugs documented. Full details in `SauceDemo_Test_Case_and_Bug_Report.xlsx` → **Bug Report** sheet.

| Bug ID | Title | Module | Severity | Priority | Status |
|---|---|---|---|---|---|
| BUG-001 | Locked-out user receives generic error with no guidance | Login | Medium | Medium | Open |
| BUG-002 | Products page accessible without login via direct URL | Auth / Security | High | High | Open |
| BUG-003 | Cart badge count not reset after checkout completes | Cart / Checkout | Medium | Medium | Open |
| BUG-004 | Checkout form accepts whitespace-only inputs | Checkout | High | High | Open |
| BUG-005 | Price (High to Low) sort order is incorrect | Product Listing | Medium | High | Open |
| BUG-006 | No confirmation dialog on cart item removal | Cart | Low | Low | Open |
| BUG-007 | `problem_user` sees wrong product images across catalog | Product Listing | High | Medium | Open |
| BUG-008 | Browser Back button after logout re-exposes inventory page | Session Mgmt | High | High | Open |

---

## 10. Known Issues

**Java `Robot` class usage**

The script uses `java.awt.Robot` to simulate pressing the `Enter` key after login. This is generally unnecessary since `LoginBtn.click()` already submits the form. If you encounter issues with the Robot class (e.g., on headless environments), the following lines can be safely removed:

```java
Robot robot = new Robot();
robot.keyPress(KeyEvent.VK_ENTER);
robot.keyRelease(KeyEvent.VK_ENTER);
```

**`Thread.sleep()` usage**

The script uses fixed `Thread.sleep()` delays for synchronisation. For more robust execution, these can be replaced with explicit WebDriver waits:

```java
// Replace Thread.sleep(3000) with:
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("element-id")));
```

**No `driver.quit()` at end**

The browser window stays open after the script completes. Add `driver.quit();` at the end of the `application()` method to close it automatically.

---

## Tools & Technologies

| Tool | Purpose |
|---|---|
| Selenium WebDriver 4.x | Browser automation |
| Java 11+ | Programming language |
| ChromeDriver | Chrome browser driver |
| Maven | Dependency management |
| Microsoft Excel | Test case and bug report documentation |

---

*Prepared as part of QA Engineer Take-Home Assignment — Sauce Demo (https://www.saucedemo.com)*
