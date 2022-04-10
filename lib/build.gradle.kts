
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
    // https://mvnrepository.com/artifact/javax.validation/validation-api
    implementation("javax.validation:validation-api:2.0.1.Final")

    // https://mvnrepository.com/artifact/jakarta.validation/jakarta.validation-api
    // implementation("jakarta.validation:jakarta.validation-api:3.0.0")

    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
    // https://mvnrepository.com/artifact/org.hibernate.validator/hibernate-validator
    // testRuntimeOnly("org.hibernate.validator:hibernate-validator:7.0.4.Final")// NG
    // implementation("org.hibernate.validator:hibernate-validator:7.0.4.Final")
    testRuntimeOnly("org.hibernate.validator:hibernate-validator:6.2.3.Final")// OK
    // https://mvnrepository.com/artifact/org.glassfish/javax.el
    // testImplementation("org.glassfish:javax.el:3.0.1-b12")
    // testImplementation("org.glassfish:javax.el:3.0.0")
    testRuntimeOnly("org.glassfish:javax.el:3.0.0")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
