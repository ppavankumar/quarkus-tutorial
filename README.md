# quarkus-tutorial

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./gradlew quarkusDev
```

To set up profile-specific property files and run Quarkus with a custom profile using Gradle, follow these steps:
Create Profile-Specific Property Files
Quarkus allows you to define separate property files for different profiles. Instead of using %profile.property=value in application.properties, you can create distinct files:
- application-dev.properties
- application-test.properties
- application-prod.properties
  Each file contains configurations specific to that profile.

Activating a Profile in Gradle
To run Quarkus with a custom profile using Gradle, you can pass the profile as a system property:
```shell script
./gradlew quarkusDev -Dquarkus.profile=customProfile
```

Alternatively, you can set an environment variable:
```shell script
export QUARKUS_PROFILE=customProfile
./gradlew quarkusDev
```

Define Profile in build.gradle
If you want to specify a profile within your Gradle build script, you can modify build.gradle:
```shell script
tasks.named("quarkusDev") {
    doFirst {
      systemProperty "quarkus.profile", "customProfile"
    }
}
```

This ensures that the profile is applied when running ```shell script./gradlew quarkusDev```.
Verify Active Profile in Code
To check which profile is currently active, use:
```shell script
import io.quarkus.runtime.configuration.ProfileManager;

String activeProfile = ProfileManager.getActiveProfile();
System.out.println("Active Profile: " + activeProfile);
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Packaging and running the application

The application can be packaged using:

```shell script
./gradlew build
```

It produces the `quarkus-run.jar` file in the `build/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `build/quarkus-app/lib/` directory.

The application is now runnable using `java -jar build/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./gradlew build -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar build/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./gradlew build -Dquarkus.native.enabled=true
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./gradlew build -Dquarkus.native.enabled=true -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./build/quarkus-tutorial-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/gradle-tooling>.

## Related Guides

- REST ([guide](https://quarkus.io/guides/rest)): A Jakarta REST implementation utilizing build time processing and Vert.x. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it.
- REST Jackson ([guide](https://quarkus.io/guides/rest#json-serialisation)): Jackson serialization support for Quarkus REST. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it
- Hibernate ORM with Panache ([guide](https://quarkus.io/guides/hibernate-orm-panache)): Simplify your persistence code for Hibernate ORM via the active record or the repository pattern
- JDBC Driver - MySQL ([guide](https://quarkus.io/guides/datasource)): Connect to the MySQL database via JDBC

## Provided Code

### Hibernate ORM

Create your first JPA entity

[Related guide section...](https://quarkus.io/guides/hibernate-orm)

[Related Hibernate with Panache section...](https://quarkus.io/guides/hibernate-orm-panache)


### REST

Easily start your REST Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
