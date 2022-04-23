package com.iplease.infra.gateway

import org.springdoc.core.SwaggerUiConfigParameters
import org.springframework.boot.CommandLineRunner
import org.springframework.cloud.gateway.route.RouteDefinition
import org.springframework.cloud.gateway.route.RouteDefinitionLocator
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class OpenApiConfig {
    @Bean
    fun openApi(locator: RouteDefinitionLocator, parameters: SwaggerUiConfigParameters): CommandLineRunner
    = CommandLineRunner {
        locator.routeDefinitions.collectList().block()!!
            .map (RouteDefinition::getId)
            .forEach(parameters::addGroup)
    }
}