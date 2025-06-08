import java.net.URI

plugins {
	java
	id("org.springframework.boot") version "3.5.0"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.marcos"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
	maven { url = URI.create("https://repo.spring.io/milestone") }
	maven { url = URI.create("https://repo.spring.io/snapshot") }
	maven { url = URI.create("https://pkgs.dev.azure.com/ModelContextProtocolAI/mcp/_packaging/ModelContextProtocol/maven/v1") }
}

extra["springAiVersion"] = "1.0.0-M6"

dependencies {
	implementation("org.springframework.ai:spring-ai-mcp-server-spring-boot-starter:${property("springAiVersion")}")

	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}