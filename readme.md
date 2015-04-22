##Optimus Prime

1. mvn install
2. configure settings.xml:

    <servers>
        <server>
            <id>enter_servername_here</id>
            <username>enter_username_here</username>
            <password>enter_password_here</password>
        </server>
    </servers>

3. create a folder with read/write permissions for everyone @ C:/logs
4. mvn tomcat:run (making sure tomcat runs at :8080)
5. acceoss at root of localhost
