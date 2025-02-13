# 📖 Word Recommendator

## 📌 Overview
The **Word Recommendator** is a Java-based application that provides word recommendations using a **Trie** data structure with **Robin Hood Hashing** for efficient word storage and retrieval. This project takes input from a file, processes the words, and allows users to find similar words or identify the most important words based on occurrences.

## 🚀 Features
- **Efficient Word Lookup** using a **Trie** structure.
- **Robin Hood Hashing** for optimized data storage.
- **File-based Input Processing** for word storage.
- **Interactive CLI** to search for word recommendations.
- **Java-based implementation** with standard input handling.

## 🛠️ Technologies Used
- **Java** (Core Programming Language)
- **Trie Data Structure** (Word Storage and Lookup)
- **Robin Hood Hashing** (Optimized Searching)

## 🎯 How to Use

### **1️⃣ Build & Run the Project**
Ensure you have **Java 17 or later** installed.

```bash
mvn clean install
mvn spring-boot:run
```

### **2️⃣ Input Word Data**
- The program will prompt you to enter a filename.
- Ensure the file contains words separated by spaces or new lines.

### **3️⃣ Choose an Option**
Upon running, the application provides two options:
1. **Find Similar Words**
2. **Find Most Important Words**

#### Example:
```bash
1 -> Find Similar Words
2 -> Most Important Words
Enter your choice: 1
```

### **4️⃣ Find Similar Words**
- Enter the number of suggestions followed by a word.
- Type `exit` to quit.

Example input:
```bash
5 apple
```

### **5️⃣ Find Most Important Words**
- Enter the number of most frequent words you want to retrieve.

Example input:
```bash
10
```

## 🏗 Project Structure
```
WordRecommendator/
│── src/
│   ├── main/
│   │   ├── java/com/wordrecommendator/
│   │   │   ├── DemoApplication.java
│   │   │   ├── TrieWithRobinhood.java
│   │   │   ├── WordRecommendator.java
│   │   ├── resources/
│   │   │   ├── application.properties
│── pom.xml
│── README.md
```

## 🔧 Configuration
The application runs **without a database**, but if needed, the configuration can be modified in `application.properties`.

For example, disabling database dependencies:
```properties
spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
```

## 📝 Future Improvements
- Implement a **REST API** version using **Spring Boot**.
- Add a **Web Frontend** using **React.js**.
- Optimize **memory usage** for large text files.

## 📄 License
This project is open-source and available under the **MIT License**.

