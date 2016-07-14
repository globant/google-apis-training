# Maps POC - UI
An app engine application used as UI of Maps POC.

#Environment Setup

## Install requirements
- [Gradle](http://gradle.org/) 2.9+

- [nodejs](https://nodejs.org/en/) > 6.2.1
- [bower](https://bower.io/) > 1.6.5
- [gcloud](https://cloud.google.com/sdk/)

## Compile it
```sh
./gradlew build
```
## Run it
```sh
./gradlew run
```
## Deploy it
```sh
./gradlew deploy
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
