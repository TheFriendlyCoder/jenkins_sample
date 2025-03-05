plugins {
    groovy
    kotlin("jvm") version "2.1.10"
}

repositories {
    mavenCentral()
    maven { url = uri("https://repo.jenkins-ci.org/releases/") }
    maven {url = uri("https://repo.jenkins-ci.org/public/") }
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

dependencies {
    // Unit testing dependencies
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.11.4")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.11.4")
    testImplementation("com.lesfurets:jenkins-pipeline-unit:1.24")
    testImplementation("org.mockito:mockito-core:3.3.3")

    // Runtime Dependencies
    implementation("org.codehaus.groovy:groovy-all:3.0.8")

    // Jenkins Dependencies
    implementation("org.jenkins-ci.main:jenkins-core:2.498")
    implementation("org.jenkins-ci.plugins.workflow:workflow-cps:4018.vf02e01888da_f")
    // https://mvnrepository.com/artifact/org.jenkins-ci.plugins.workflow/workflow-job
    implementation("org.jenkins-ci.plugins.workflow:workflow-job:1505.vea_4b_20a_4a_495")
    // https://mvnrepository.com/artifact/org.jenkins-ci.plugins.workflow/workflow-api
    implementation("org.jenkins-ci.plugins.workflow:workflow-api:1363.v03f731255494")
    // https://mvnrepository.com/artifact/org.jenkins-ci.plugins.workflow/workflow-support
    implementation("org.jenkins-ci.plugins.workflow:workflow-support:946.v2a_79d8a_4b_e14")
    // https://mvnrepository.com/artifact/org.jenkins-ci.plugins.workflow/workflow-step-api
    implementation("org.jenkins-ci.plugins.workflow:workflow-step-api:686.v603d058a_e148")
    // https://mvnrepository.com/artifact/org.jenkins-ci.plugins.workflow/workflow-basic-steps
    implementation("org.jenkins-ci.plugins.workflow:workflow-basic-steps:1079.vce64b_a_929c5a_")
    // https://mvnrepository.com/artifact/org.jenkins-ci.plugins.workflow/workflow-durable-task-step
    implementation("org.jenkins-ci.plugins.workflow:workflow-durable-task-step:1405.v1fcd4a_d00096")
    // https://mvnrepository.com/artifact/org.jenkins-ci.plugins.workflow/workflow-cps-global-lib
    implementation("org.jenkins-ci.plugins.workflow:workflow-cps-global-lib:612.v55f2f80781ef")
}

sourceSets {
    main {
        groovy {
            setSrcDirs(listOf("vars"))
        }
    }

    test {
        groovy {
            setSrcDirs(listOf("pipelineTests/groovy"))
        }
    }
}