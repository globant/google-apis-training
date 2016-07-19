# Maps POC - Backend
An app engine application used as backend of Maps POC.

#Environment Setup

## Install requirements
- [Gradle](http://gradle.org/) 2.9+
- [gcloud](https://cloud.google.com/sdk/)

# Developer guide

## Compile it
```sh
gradle build
```
## Run it
```sh
gradle run
```
## Deploy it
```sh
gradle deploy
```

## HTTP Proxy Settings

If you are behind an corporate http proxy.

#### Method One ==> add environment variables

```sh
export HTTP_PROXY=http://mycompanyproxy.com:3128
export HTTPS_PROXY=http://mycompanyproxy.com:3128
```

#### Method Two ==> add properties to command line

```sh
gradle build -Dhttp.proxyHost=mycompanyproxy.com -Dhttp.proxyPort=3128 -Dhttps.proxyHost=mycompanyproxy.com -Dhttps.proxyPort=3128
```
## Checkstyle & Formatter Configuration
We will follow the following google guide with guidelines in terms of coding: https://github.com/google/styleguide/blob/gh-pages/javaguide.html 
There are several tools that will help us in order to accomplish that.These are checkstyle, a checkstyle eclipse plugin and formatter for the IDEs (Eclipse and IntelliJ).

### Checkstyle 
This will be in charge of checking the source code at compiling/building stage. It is located at
```sh
/backend/src/main/resources/maps_checkstyle.xml
```

#### Checkstyle Eclipse plugin
This is an IDE’s plugin which offers check and suggestion at coding time in the IDE. Donwload checkstyle plugin from eclipse from
```sh
http://eclipse-cs.sourceforge.net/update/
```



