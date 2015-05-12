##Optimus Prime

Prerequisites: 
settings.xml server configuration: 
<server>
    <id>myserver</id>
    <username>tomcat</username>
    <password>tomcat</password>
</server>

1. Open in IntelliJ, "Add as Maven project" when prompted.
2. CTRL+SHIFT+A -> "Maven Projects"
3. Lifecycle -> "install" -> "Reimport All Maven Projects" 
4. Plugins -> tomcat -> "tomcat:run"
5. Open a web browser and access the application at http://localhost:8080/
