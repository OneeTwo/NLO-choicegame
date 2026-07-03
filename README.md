#NLO Choice Game

A simple choice-based web game where every decision changes the direction of the story. The player explores a mysterious encounter with an unknown civilization and reaches one of several possible endings.

Features
Multiple story paths
Several unique endings
Interactive choice system
Data-driven story stored in JSON
Responsive interface using Bootstrap
Technologies
Java
Jakarta Servlets
JSP
JSTL
Jackson
Maven
Apache Tomcat 10
Bootstrap 5

How It Works
The player starts a new game.
Every choice leads to another question.
Questions are loaded from questions.json.
GameService searches questions by their identifier.
GameServlet sends the selected question to the JSP page.
The game continues until one of the endings is reached.
Running the Project
Requirements
Java 17+
Maven
Apache Tomcat 10
Build
mvn clean package
Deploy

Copy the generated WAR file to the Tomcat webapps directory.

cp target/*.war ~/tomcat/webapps/

Restart Tomcat.

~/tomcat/bin/shutdown.sh
~/tomcat/bin/startup.sh

Open in your browser:

http://localhost:8080/NLO-choicegame-1.0-SNAPSHOT/
