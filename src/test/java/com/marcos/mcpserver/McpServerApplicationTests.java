package com.marcos.mcpserver;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {
    "spring.ai.mcp.server.enabled=false"
})
class McpServerApplicationTests {

    @Test
    void contextLoads() {
    }

}
