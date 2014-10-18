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

#Configuration

1. Setup Message Storage Directory

privoto needs to know where to drop messages on the system. Set this property in `/src/main/resources/application.properties`.

#License

privoto is provided under the MIT License. [Read it here](https://raw.githubusercontent.com/mitch-b/privoto/master/LICENSE).

privoto is built on the following open source libraries:

1. Google Gson - [Apache v2](https://google-gson.googlecode.com/svn/trunk/gson/LICENSE)
1. Apache Commons IO - [Apache v2](http://www.apache.org/licenses/LICENSE-2.0)
1. Apache Commons FileUpload - [Apache v2](http://www.apache.org/licenses/LICENSE-2.0)

