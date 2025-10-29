# 🧪 Test Automation Framework

A **Java-based Test Automation Framework** designed for scalable, maintainable, and cross-platform testing.  
It supports **data-driven**, **headless**, and **cloud-based testing** using **LambdaTest**, with detailed **logging** and **reporting**.

---

## ⚙️ Prerequisites

Before running this framework, ensure the following are installed on your system:

- **Java 11** → Make sure Java is installed and `JAVA_HOME` is set  
- **Maven** → Ensure Maven is installed and added to the system path  
  🔗 [Download Maven](https://maven.apache.org/download.cgi)

---

## 🚀 Features

- ✅ **Data-Driven Testing** — Uses **OpenCSV**, **Apache POI**, and **Gson** to read test data from CSV, Excel, and JSON files  
- ✅ **Cross-Browser Testing** — Run tests on multiple browsers  
- ✅ **Headless Mode** — Faster execution without UI rendering  
- ✅ **Cloud Testing (LambdaTest)** — Run tests on cloud environments  
- ✅ **Logging** — Detailed runtime logs using **Log4j**  
- ✅ **Reporting** — Beautiful HTML reports generated using **Extent Reports**

---

## 🧰 Technologies Used

| Component | Library |
|------------|----------|
| Language | Java 11 |
| Test Runner | TestNG |
| Data Handling | OpenCSV, Apache POI, Gson |
| Test Data Generation | Faker |
| Logging | Log4j |
| Reporting | Extent Reports |
| Cloud Platform | LambdaTest |

---

## 🛠️ Setup Instructions

###  Clone the Repository

  git clone https://github.com/RahulShilimkarCodes/SeleniumAutomationFramework.git
  cd SeleniumAutomationFramework

🧪 ### Running the tests
▶️ Run Tests on LambdaTest
  mvn test -Dbrowser=chrome -DisLambdaTest=true -DisHeadless=false -X

▶️ Run Tests Locally on Chrome (Headless Mode)
  mvn test -Dbrowser=chrome -DisLambdaTest=false -DisHeadless=true -X

**📊 Reports & Logs
📁 HTML Report**

After execution, a detailed HTML report is generated at:
./testExtentReport.html

**The report includes:**
Total tests executed
Passed / Failed / Skipped counts
Screenshots for failed tests

**🧾 Logs**

Logs are stored at:
./logs/

🤖 GitHub Actions Integration

This project is integrated with GitHub Actions for continuous testing.

🕒 Execution Time: Every day at 11:30 PM IST
📦 Reports: Automatically archived in the gh-pages branch

🌐 View HTML Reports: https://rahulshilimkarcodes.github.io/SeleniumAutomationFramework/testExtentReport.html



