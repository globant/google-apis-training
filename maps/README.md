# Maps POC
A POC Webapp for GEO tracking.

## Download Source Code
```sh
git clone https://github.com/globant/google-apis-training.git
cd maps
```
#Getting started

## Install requirements
- [Gradle](http://gradle.org/) 2.9+
- [nodejs](https://nodejs.org/en/) > 6.2.1
- [bower](https://bower.io/) > 1.6.5
- [gcloud](https://cloud.google.com/sdk/)

## Compile it
```sh
gradle build
```
## Run backend
```sh
cd backend
gradle run
```
## Run ui
```sh
cd backend
gradle run
```
## Use it
Open your brower in http://localhost:5000

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
