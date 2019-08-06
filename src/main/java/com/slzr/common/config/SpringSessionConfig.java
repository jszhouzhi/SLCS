package com.slzr.common.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

@ConditionalOnProperty(prefix = "slzr", name = "spring-session-open", havingValue = "true")
public class SpringSessionConfig {

}
