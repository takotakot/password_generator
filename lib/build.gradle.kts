
plugins {
    `java-library`
}

repositories {
    mavenCentral()
}

/*
// OK
dependencies {
    // https://mvnrepository.com/artifact/javax.validation/validation-api
    implementation("javax.validation:validation-api:2.0.1.Final")

    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
    // https://mvnrepository.com/artifact/org.hibernate.validator/hibernate-validator
    // testRuntimeOnly("org.hibernate.validator:hibernate-validator:7.0.4.Final")// NG
    testRuntimeOnly("org.hibernate.validator:hibernate-validator:6.2.3.Final")// OK
    // https://mvnrepository.com/artifact/org.glassfish/javax.el
    testRuntimeOnly("org.glassfish:javax.el:3.0.0")
}
*/

dependencies {
    // https://mvnrepository.com/artifact/jakarta.validation/jakarta.validation-api
    implementation("jakarta.validation:jakarta.validation-api:3.1.0")

    // https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter
    testImplementation("org.junit.jupiter:junit-jupiter:5.11.3")

    // https://mvnrepository.com/artifact/org.glassfish/jakarta.el
    testImplementation("org.glassfish:jakarta.el:4.0.2")

    // https://mvnrepository.com/artifact/org.hibernate.validator/hibernate-validator
    testRuntimeOnly("org.hibernate.validator:hibernate-validator:8.0.1.Final")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
