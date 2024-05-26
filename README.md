# Kotlin-Gradle SparkJava Web Microframework example

Exploring creating a Kotlin implementation of *hello-world* using SparkJava web microframework using the [Gradle](https://gradle.org/) build-task toolchain. 

The tools from [SDKMan](https://sdkman.io/ were used for for managing Java JDKs and SDKs.

## Installing

### Install SDKMan

```bash
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
```

### Install Java with SDKMan

There are a variety of popular Java JDKs listed at https://sdkman.io/jdks.  

JetBrains TeamCity uses [Amazon Corretto](https://aws.amazon.com/corretto/) for Windows and Docker images and for Mac using Apple Silicon (ARM64), [Azul OpenJDK (Zulu)](https://www.azul.com/downloads/#zulu)  builds are popular and recommended.  One team I am working with recomends [Temurin](https://projects.eclipse.org/projects/adoptium.temurin)] by Eclipse foundation.

As an example, for Macbook M1, you can install JDK11 with:

```bash
sdk install java 21.0.3-zulu
```

### Install Kotlin Groovy and Gradle

```bash
# small helper function to fetch latest version
latest_version() {
  sdk list $1 \
   | grep -vE '.*-.*' \
   | grep -oE '\b[0-9]+\.[0-9]+\.[0-9]+\b' \
   | sort \
   | tail -1
}

GRADLE_VERSION=$(latest_version gradle)
KOTLIN_VERSION=$(latest_version kotlin)

# install 
sdk install gradle $GRADLE_VERSION
sdk install kotlin $KOTLIN_VERSION
```

## Running

You can build with the auto-generated [Gradle](https://gradle.org/) wrapper using `./gradlew run &` or run the build commands separately: 

```bash
gradle build
gradle test
gradle run &
```

## Testing

```bash
curl http://127.0.0.1:4567/
curl http://127.0.0.1:4567/hello
curl http://127.0.0.1:4567/hello/あけみ
```
