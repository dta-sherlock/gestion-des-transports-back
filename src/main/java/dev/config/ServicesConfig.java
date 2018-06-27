package dev.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DataSourceMySQLConfig.class)

@ComponentScan({"dev.repository"})
public class ServicesConfig {
}