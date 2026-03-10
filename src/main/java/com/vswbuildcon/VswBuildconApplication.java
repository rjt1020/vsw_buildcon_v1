package com.vswbuildcon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration; // [MODIFIED] Added import for exclusion

// [MODIFIED] Exclude database auto-configuration to allow start-up without MySQL
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class VswBuildconApplication {

    public static void main(String[] args) {
        // Syntax corrected to .class in previous turn
        SpringApplication.run(VswBuildconApplication.class, args);
    }

}