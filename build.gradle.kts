plugins {
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("io.micronaut.application") version "4.1.0"
    id("io.micronaut.test-resources") version "4.1.0"
//    id("io.micronaut.aot") version "4.1.0"
}

version = "0.1"
group = "example.micronaut"

repositories {
    mavenCentral()
}

dependencies {
    annotationProcessor("io.micronaut.serde:micronaut-serde-processor")
    implementation("io.micronaut.redis:micronaut-redis-lettuce")
    implementation("io.micronaut.serde:micronaut-serde-jackson")
    runtimeOnly("ch.qos.logback:logback-classic")
    testImplementation("io.micronaut:micronaut-http-client")
}


application {
    mainClass.set("example.micronaut.Application")
}
java {
    sourceCompatibility = JavaVersion.toVersion("17")
    targetCompatibility = JavaVersion.toVersion("17")
}

graalvmNative.toolchainDetection.set(false)
micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("example.micronaut.*")
    }
//    aot {
//    // Please review carefully the optimizations enabled below
//    // Check https://micronaut-projects.github.io/micronaut-aot/latest/guide/ for more details
//        optimizeServiceLoading.set(false)
//        convertYamlToJava.set(false)
//        precomputeOperations.set(true)
//        cacheEnvironment.set(true)
//        optimizeClassLoading.set(true)
//        deduceEnvironment.set(true)
//        optimizeNetty.set(true)
//    }
}



