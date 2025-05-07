# 📁 Java File Organizer by Extension

This Java program scans a directory and automatically organizes the files into subfolders based on their file extensions.

---

## 📌 Purpose

The goal of this utility is to **declutter folders** by moving files into categorized directories, making the structure cleaner and more manageable.

For example:

document.pdf → D:\Datos\Downloads\pdf\document.pdf
image.jpg → D:\Datos\Downloads\jpg\image.jpg
script.js → D:\Datos\Downloads\js\script.js
README → D:\Datos\Downloads\sin_extension\README


---

## 🧠 How It Works

1. Scans all files in a specified directory.
2. Uses a regular expression to extract the file extension.
3. Groups the files by their extensions.
4. Creates a subfolder for each extension (if not already existing).
5. Moves each file into its corresponding folder.

---

## 🧩 APIs and Features Used

### 🔹 `java.nio.file` Package

- `Path.of(...)`: Constructs paths in a platform-independent way.
- `Files.list(...)`: Lists directory contents as a stream.
- `Files.createDirectories(...)`: Creates subfolders when needed.
- `Files.move(...)`: Moves files between directories.
- `StandardCopyOption.REPLACE_EXISTING`: Overwrites if the file exists in the target location.

### 🔹 Regular Expressions

- `Pattern.compile("\\.([^.]+)$")`: Extracts the file extension.
- `Matcher.find()` / `Matcher.group(1)`: Retrieves the matched extension text.

### 🔹 Java Streams & Collectors

- `filter(...)`: Ensures only regular files are processed.
- `Collectors.groupingBy(...)`: Groups files by extension into a `Map<String, List<Path>>`.

### 🔹 Try-with-resources

- Ensures the file stream is automatically closed after processing.

---

## 📂 Example Directory Before
D:\Datos\Downloads
├── resume.pdf
├── photo.jpg
├── archive.zip
├── script.py
├── LICENSE

## 📂 Example Directory After
D:\Datos\Downloads
├── pdf
│ └── resume.pdf
├── jpg
│ └── photo.jpg
├── zip
│ └── archive.zip
├── py
│ └── script.py
├── sin_extension
│ └── LICENSE
│ └── LICENSE
