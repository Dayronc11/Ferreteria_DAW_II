package com.ferreteria.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Configuración del API Gateway.
 * Define rutas de fallback y manejo de errores personalizados.
 */
@Configuration
public class GatewayConfig {

    /**
     * Ruta de health check del gateway.
     * GET /gateway/health → 200 OK con info del servicio
     */
    @Bean
    public RouterFunction<ServerResponse> healthRoute() {
        return RouterFunctions.route()
                .GET("/gateway/health", request -> ServerResponse.ok()
                        .bodyValue(Map.of(
                                "service", "ms-gateway",
                                "status", "UP",
                                "port", 8080,
                                "timestamp", LocalDateTime.now().toString())))
                .build();
    }
}
