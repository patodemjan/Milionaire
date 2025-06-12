# Milionaire

## 🇩🇪 Deutsch

### 📝 Projektbeschreibung
Milionaire ist eine kleine Quiz-Webanwendung im Stil von „Wer wird Millionär“. Benutzer:innen können Themen-Profile anlegen, zu jedem Profil eine feste Anzahl von Fragen mit vier Antwortoptionen erstellen und anschließend im Spielmodus die Fragen in zufälliger Reihenfolge beantworten.

### 🎯 Ziele
Das Ziel dieses Spiels ist es, ein Quiz zu erstellen, das sich sehr gut für Unterrichtszwecke eignet und dabei hilft, neues Wissen aus bestimmten Bereichen zu erlernen oder besser einzuprägen.

### 🛠️ Technologien
- **Java 17**  
- **Spring Boot** (Web, Thymeleaf, Data JPA)  
- **Thymeleaf** als Template-Engine  
- **Spring Data JPA** mit einer In-Memory-Datenbank (H2)  
- **HTML5**, **CSS3**, **JavaScript**  
- **Maven** als Build- und Dependency-Tool  

### 🚀 Installation & Start
1. Repository klonen  
   ```bash
   git clone https://github.com/DEIN_USERNAME/milionaire.git
   cd milionaire
   
Abhängigkeiten auflösen und Anwendung starten

bash
Kopieren
Bearbeiten
mvn spring-boot:run
Im Browser öffnen


Kopieren
Bearbeiten
http://localhost:8080

### ⚙️ Verwendung
- Erstellen und Verwalten von Profilen (Themenbereiche)
- Hinterlegen von Fragen & Antworten je Profil
- Zufälliges Quiz mit Zählung richtiger/­falscher Antworten


## 📂 Projekt Struktur
milionaire/
│
├─ src/
│  ├─ main/
│  │  ├─ java/com/example/milionaire/
│  │  │  ├─ controller/
│  │  │  │   ├─ IndexController.java       # Handles "/", "/index", "/newgame", "/setgame"…
│  │  │  │   ├─ ProfileController.java     # "/createprofile" + delete
│  │  │  │   └─ SetGameController.java     # "/setgame" GET + POST
│  │  │  ├─ entity/
│  │  │  │   ├─ Profile.java               # JPA entity for profiles
│  │  │  │   └─ Question.java              # JPA entity for questions
│  │  │  ├─ form/
│  │  │  │   └─ GameForm.java              # DTO for setgame form
│  │  │  ├─ repository/
│  │  │  │   ├─ ProfileRepository.java
│  │  │  │   └─ QuestionRepository.java
│  │  │  ├─ service/
│  │  │  │   ├─ ProfileService.java
│  │  │  │   └─ QuestionService.java
│  │  │  └─ MilionaireApplication.java    # Spring Boot main class
│  │  └─ resources/
│  │     ├─ templates/
│  │     │   ├─ index.html
│  │     │   ├─ createprofile.html
│  │     │   ├─ setgame.html
│  │     │   └─ newgame.html
│  │     └─ static/
│  │        ├─ css/
│  │        │   ├─ style.css
│  │        │   ├─ setgame.css
│  │        │   └─ newgame.css
│  │        └─ js/
│  │            ├─ setgame.js
│  │            └─ newgame.js
│  └─ test/
│     └─ java/...                          # Optional unit tests
│
├─ pom.xml                               # Maven configuration
└─ README.md                             # Project documentation



### ⚖️ Lizenz
Dieses Projekt steht unter der MIT License.
