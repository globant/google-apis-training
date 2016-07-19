# Maps POC - UI
An app engine application used as UI of Maps POC.

#Environment Setup

## Install requirements
- [Gradle](http://gradle.org/) 2.9+
- [nodejs](https://nodejs.org/en/) > 6.2.1
- [bower](https://bower.io/) > 1.6.5
- [gcloud](https://cloud.google.com/sdk/)

## Configure it
```sh
gradle  -PappengineId=<<appengineId>> -PclientId=<<clientId>> -PapiKey=<<apiKey>> config
```
This task write the gradle.properties file.

or if you prefer put a gradle.properties file in the maps root folder with following configurations
```
appengineId=<<appengineId>>
clientId=<<clientId>>
apiKey=<<apiKey>>
```
appengineId: AppEngine app id.
clientId: OAuth 2.0 Client id from [Google Cloud Console](https://console.cloud.google.com/apis/credentials)
apiKey: Api Key from [Google Cloud Console](https://console.cloud.google.com/apis/credentials)

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
