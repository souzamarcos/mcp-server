# MCP Server Example

This is an example implementation of an MCP (Model Context Protocol) server using Spring AI. The application demonstrates how to create tools that can be called through the MCP protocol.

## Prerequisites

- Java 21 or higher
- Gradle 8.x (or use the wrapper included in the project)

## Project Structure

```
src/
├── main/
│   └── java/
│       └── com/
│           └── marcos/
│               └── mcpserver/
│                   ├── McpServerApplication.java
│                   └── core/
│                       └── service/
│                           └── WeatherService.java
└── test/
    └── java/
        └── com/
            └── marcos/
                └── mcpserver/
                    └── core/
                        └── service/
                            └── WeatherServiceTest.java
```

## Features

The project includes an example service (`WeatherService`) that exposes three MCP tools:

1. `getWeather`: Returns weather information for a specific city
2. `getWeatherForecastByLocation`: Returns weather forecast for specific coordinates
3. `getAlerts`: Returns weather alerts for a US state

## How to Run

### Using Gradle Wrapper

```bash
# Run the application
./gradlew bootRun
```

### Using the JAR

```bash
# Generate the JAR
./gradlew build

# Run the JAR
java -jar build/libs/mcp-server-0.0.1-SNAPSHOT.jar
```

## Tests

To run unit tests:

```bash
# Run all tests
./gradlew test

# Run a specific test
./gradlew test --tests "com.marcos.mcpserver.core.service.WeatherServiceTest"
```

## Configuration

The MCP server configuration is in the `application.yml` file:

```yaml
spring:
  ai:
    mcp:
      server:
        enabled: true
        stdio: true
        name: mcp-server
        version: 1.0.0
```

## Using MCP Server with Copilot

![example.png](doc/example.png)

To use this MCP server with GitHub Copilot, you need to configure the `mcp.json` file located at:

- Windows: `%LOCALAPPDATA%\github-copilot\intellij\mcp.json`
- macOS: `~/Library/Application Support/github-copilot/intellij/mcp.json`
- Linux: `~/.config/github-copilot/intellij/mcp.json`

Add the following configuration to the file:

```json
{
    "servers": {
        "weather-mcp-server": {
            "type": "stdio",
            "command": "java -jar",
            "args": [".\\build\\libs\\mcp-server-0.0.1-SNAPSHOT.jar"],
            "cwd": "C:/Repository/mcp-server"
        }
    }
}
```

Alternatively, you can use Gradle to run the server:

```json
{
    "servers": {
        "weather-mcp-server": {
            "type": "stdio",
            "command": "C:/Repository/mcp-server/gradlew.bat",
            "args": ["bootRun"],
            "cwd": "C:/Repository/mcp-server"
        }
    }
}
```

### Configuration Details

- `weather-mcp-server`: Unique name to identify your server
- `type`: Server type (use "stdio" for standard input/output communication)
- `command`: Command to run the server (can be `java -jar` or the gradlew path)
- `args`: Arguments to run the application (JAR path or `bootRun`)
- `cwd`: Working directory where the server will run

**Note**: Adjust the paths according to your project location.

## Build

To perform a complete project build:

```bash
# Clean and rebuild the project
./gradlew clean build

# Build without running tests
./gradlew build -x test
```

## Development

To add new tools to the MCP server:

1. Create a new service class
2. Annotate methods with `@Tool`
3. Configure the tool name and description
4. Spring AI will handle exposing these tools through the MCP protocol

Example:

```java
@Service
public class MyService {
    @Tool(name = "myTool", description = "Tool description")
    public String myTool(String input) {
        return "Result";
    }
}
```

## Technologies Used

- Spring Boot 3.5.0
- Spring AI (MCP Server) 1.0.0-M6
- JUnit 5 for testing
- Gradle as build system

## References

- [Spring AI Documentation](https://docs.spring.io/spring-ai/reference/)
- [Model Context Protocol Specification](https://github.com/ModelContextProtocol/spec)
