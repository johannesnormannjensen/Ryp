Welcome to the RYP readme.

First a few things... 

Needed tools for building, running and deploying:

Installation of Apache Tomcat 8.5.X installed on your system (preferably 8.5.8).

### That's it for now! Add more as we continue! ### 


1. Building
	To make a clean build with maven run: mvn clean install.
	The project is by default packaged in a war file for ease of deployment.
	
2. Running
	Just run mvn tomcat7:run. This works in debug mode too. Just add the project as a source.
	
3. Deploying
	Environments:
	We deploy differently based on which environment we deploy to, but one file is 
	important to have included in your development system which is settings.xml. This
	file you will need to have in your M2 directory (normally the directory is hidden 
	and called .m2). 
	A model for settings.xml is provided in this project, copy this to you M2 folder.
	(Note that you should encrypt your password in settings.xml using your master password.
	Follow this tutorial for more: https://maven.apache.org/guides/mini/guide-encryption.html)
	
		Development env:
		Once you've setup your settings.xml for your local tomcat instance, you need to run
		the following command: mvn tomcat:deploy -P devserverConfig
		This uploads the packaged project to your tomcat instance and deploys it. 
		Voilá! You're done.
		
		Production:
		Coming soon... (This means we do it manually right now, through SFTP)
	