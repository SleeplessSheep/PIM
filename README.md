# Personal Information Management (PIM) System

A command-line Java application for managing personal information including notes, tasks, events, and contacts. Built with clean architecture principles and design patterns.

[![Java Version](https://img.shields.io/badge/Java-15.0.1-blue.svg)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/License-Academic-green.svg)]()

## 🌟 Features

- **Four Record Types**: TextNote, Task, Event, and Contact
- **Full CRUD Operations**: Create, Read (Print), Update (Modify), and Delete
- **Advanced Search**: Search by type, text content, or date with AND/OR logic operators
- **Data Persistence**: Export and import records in .pim format
- **Clean Architecture**: Implements MVC, Factory, and Command design patterns
- **Well-Documented**: Comprehensive user and developer manuals included

## 🚀 Quick Start

### Prerequisites

- Java 15.0.1 or higher
- Command-line interface (Terminal/Command Prompt)

### Installation & Running

#### On Windows:
```bash
run.bat
```

#### On Linux/Mac:
```bash
./run.sh
```

#### Manual Compilation:
```bash
javac -d build src/Model/*.java
javac -cp build -d build src/View/*.java
javac -cp build -d build src/Controller/*.java
javac -cp build -d build src/*.java
java -cp build Main
```

## 📚 Documentation

- **[User Manual](UserManual.md)**: Complete guide for using the PIM system
- **[Developer Manual](DeveloperManual.md)**: Setup and development guidelines
- **[Project Analysis](PROJECT_ANALYSIS.md)**: Comprehensive project assessment and improvement recommendations

## 🏗️ Architecture

This project implements several software design patterns:

- **Model-View-Controller (MVC)**: Separates data, presentation, and business logic
- **Factory Pattern**: Creates command objects dynamically
- **Command Pattern**: Encapsulates operations as objects
- **Open-Closed Principle**: Easy to extend without modifying existing code

### Project Structure

```
PIM/
├── src/
│   ├── Model/          # Data models (PIR, Contact, Event, Task, TextNote)
│   ├── View/           # UI components (Menu, Display)
│   ├── Controller/     # Business logic (Commands and Factories)
│   ├── Test/           # Unit tests
│   └── Main.java       # Application entry point
├── build/              # Compiled classes (generated)
├── pim/                # Import/Export .pim files
├── DeveloperManual.md  # Development guide
├── UserManual.md       # User guide
└── README.md           # This file
```

## 📝 Usage Examples

### Creating a Task
```
Personal Information Manager (PIM)-Menu
Please enter command: [ Create | Modify | Delete | Export | Import | Print | Search ]
Create
Create module - Enter record type [ Event | Contact | Task | TextNote ]:
Task
Enter description for Task:
Buy groceries
Enter deadline for Task (YYYY-MM-DD HH:MM):
2023-11-12 18:00
New record created | 1 | Task | description: Buy groceries | deadline: 2023-11-12 18:00
```

### Searching Records
```
Please enter command: [ Create | Modify | Delete | Export | Import | Print | Search ]
Search
Search module - Please enter the criteria you want to use to search for personal information records (PIRs):
[ date | text | type ]
type
Please enter the type: [ Event | Contact | Task | TextNote ]
Task
Is the criteria with NegationIndicator (NOT): [ Y | N ]
N
Current result:
There is 1 record.
1 | Task | description: Buy groceries | deadline: 2023-11-12 18:00
```

## 🧪 Testing

Unit tests are provided for all Model classes:
- `ContactTest.java`
- `EventTest.java`
- `TaskTest.java`
- `TextNoteTest.java`
- `PIRTest.java`

Run tests using your preferred IDE (VS Code with Java Extension Pack recommended).

## 📊 Project Statistics

- **50 Java files** (~2,153 lines of code)
- **4 Model classes**
- **2 View classes**
- **38+ Controller classes**
- **5 Unit test classes**

## 🤝 Contributing

This is an academic project. Contributions for educational purposes are welcome!

## 📄 License

Academic/Educational use only.

## 🔧 Improvements & Roadmap

See [PROJECT_ANALYSIS.md](PROJECT_ANALYSIS.md) for a detailed assessment and improvement recommendations.

Quick wins already implemented:
- ✅ Added `.gitignore` for build artifacts
- ✅ Fixed "Invaild" typo to "Invalid"
- ✅ Added `run.sh` for Linux/Mac users
- ✅ Created comprehensive project analysis

## 📞 Support

For issues or questions, please refer to:
- [User Manual](UserManual.md) for usage help
- [Developer Manual](DeveloperManual.md) for development setup
- [Project Analysis](PROJECT_ANALYSIS.md) for improvement ideas

## 🎓 Academic Disclosure

This project was developed with assistance from GenAI tools. See [AIToolsDeclaration.txt](AIToolsDeclaration.txt) for details.

---

**Note**: This is a well-designed academic project demonstrating MVC architecture and design patterns. See PROJECT_ANALYSIS.md for detailed assessment and future directions.

