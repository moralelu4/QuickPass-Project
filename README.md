# QuickPass Management System

![Java](https://img.shields.io/badge/Java-17-blue.svg)
![License](https://img.shields.io/badge/License-MIT-green.svg)

A Java application for managing QuickPass entries with CRUD operations, reporting, and file persistence. This is an ongoing project, so it's subject to changes.

## Project Description (English)

QuickPass is a Java Swing-based management system that allows users to:
- Create and manage QuickPass entries (vehicle passes)
- Track pass status (active/inactive)
- Generate various reports
- Maintain a persistent record in a text file
- Search and filter passes by different criteria

*Note: While this README is in English, the actual source code (classes, variables, comments) is written in Spanish as it was developed for a Spanish-speaking context.*

## Features

- 📝 **CRUD Operations**:
  - Add new QuickPass entries with validation
  - Query existing passes (all, by branch, specific pass)
  - Deactivate or delete passes
  - Track deleted passes separately

- 📊 **Reporting**:
  - Total registered accesses
  - Accesses by branch/filial
  - Active vs inactive passes
  - Deleted passes count

- 💾 **Data Persistence**:
  - Automatic saving to `Historial.txt`
  - Timestamp recording for all operations
  - File-based data storage

- ✅ **Validation**:
  - QuickPass codes must start with "101" (10 digits total)
  - Input validation throughout the application
 
## Limitations

⚠️ **Current System Constraints**:

1. **Data Storage**:
   - Uses plain text files (no database)
   - Limited to 100 entries (array size constraint)
   - No data encryption

2. **Functionality**:
   - No user authentication/roles
   - Single-file storage (no backups)
   - No batch operations (add/delete multiple)

3. **Technical**:
   - Spanish hardcoded in UI (no i18n support)
   - Array-based storage (no dynamic collections)
   - No proper exception handling for file ops

4. **UI/UX**:
   - Basic Swing dialogs only
   - No data export (CSV/Excel)
   - No search/filter pagination

## Future Enhancements

🚀 **Planned Improvements**:

1. **Core Upgrades**:
   - Migrate to database (SQLite/MySQL)
   - Implement proper logging
   - Add data encryption

2. **Features**:
   - User authentication system
   - QR code generation for passes
   - Mobile companion app

3. **Technical Improvements**:
   - Convert to Java Collections Framework
   - Implement proper MVC architecture
   - Add unit testing (JUnit)

4. **UI/UX**:
   - Modern GUI (JavaFX)
   - Multilingual support
   - Data visualization charts

5. **DevOps**:
   - Build automation (Maven/Gradle)
   - CI/CD pipeline
   - Docker deployment

## Code Structure

| Class | Purpose |
|-------|---------|
| `AvanceFinal` | Main class with UI and program flow |
| `QuickPass` | Data model for pass entries |
| `ManejoArchivos` | File handling utilities |

## Technical Details

- **Language**: Java (JDK 17)
- **Paradigm**: Object-Oriented Programming
- **Storage**: Text file (`Historial.txt`)
- **UI**: Swing-based dialog interfaces
- **Patterns**: MVC-like separation

## Installation & Usage

1. **Requirements**:
   - Java JDK 17+
   - Basic Java environment setup

2. **Running the application**:
   ```bash
   javac prueba/quickpass/AvanceFinal.java
   java prueba.quickpass.AvanceFinal
3. **Using the application**
```bash
- Follow the menu prompts in the dialog boxes

- All data is automatically saved to Historial.txt
```

## Code Language Note
The source code is written in Spanish with:

- Spanish class/variable names (e.g., filial, placa)

- Spanish comments and UI messages

- Spanish method names (e.g., mostrarTotalAccesos)

This was a deliberate choice for the original development context. The architecture and logic follow standard Java conventions and can be understood by:

1. Spanish-speaking developers directly

2. Other developers via the clear structure and this English documentation

## License
MIT License - Free for educational and personal use. For commercial use, please contact the author.

*END OF README.md*
