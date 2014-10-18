privoto
=======

Sharing private messages

#Getting Started

```bash
$ git clone https://github.com/mitch-b/privoto
```

#Setting Up Your Environment

privoto is built using:

1. IntelliJ IDEA ([Download](https://www.jetbrains.com/idea/download/))
1. JDK 7 ([Download](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html))
1. Tomcat 7 ([Download](http://tomcat.apache.org/download-70.cgi))
1. Spring MVC Framework (downloaded with Gradle)
1. Gradle (Gradle wrapper provided in source - no separate download needed)

#Opening the Project

Inside IntelliJ IDEA, choose 'Import Project', navigate to where you extracted **privoto**. Choose `build.gradle` in this folder during the import. This will make sure the project is imported with the Gradle window for building.

Keep the Gradle wrapper selected and continue through the prompt. The project should now be imported! You can open the Gradle tool window and click the refresh button. Any time you change dependencies in `build.gradle`, you can click the refresh button to update IntelliJ references.

To quickly run the project from IntelliJ IDEA, set up a Local Tomcat run configuration.

1. From the menu, choose `Run > Edit Configurations ...`
1. Click the `+` button to add a new configuration.
1. Choose Tomcat Server > Local
1. Scroll this window down and click the `+` button to add another step after Make.
1. Choose Build Artifact > `privoto.war` (not exploded).
1. Add a name to your configuration (optional) and which browser you want to open on Run (optional).

Now, you should see the Run icon available at the top of the editor. Give it a go.

#Configuration

1. Setup Message Storage Directory

privoto needs to know where to drop messages on the system. Set this property in `/src/main/resources/application.properties`.

#License

privoto is provided under the MIT License. [Read it here](https://raw.githubusercontent.com/mitch-b/privoto/master/LICENSE).

privoto is built on the following open source libraries:

1. Google Gson - [Apache v2](https://google-gson.googlecode.com/svn/trunk/gson/LICENSE)
1. Apache Commons IO - [Apache v2](http://www.apache.org/licenses/LICENSE-2.0)
1. Apache Commons FileUpload - [Apache v2](http://www.apache.org/licenses/LICENSE-2.0)

