package com.ws.gitlab.local.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import javax.net.SocketFactory;
import java.io.IOException;
import java.net.Socket;

@Slf4j
@Component
@RequiredArgsConstructor
public class ElkHealthChecker implements HealthIndicator {

    private final ElkProperties elkProperties;

    @Override
    public Health getHealth(boolean includeDetails) {
        return HealthIndicator.super.getHealth(includeDetails);
    }

    @Override
    public Health health() {
        try (Socket socket = SocketFactory.getDefault().createSocket(elkProperties.getHost(), elkProperties.getPort())) {
            logConnectionStatus(socket);

            return socket.isConnected() ? Health.up().build() : Health.unknown().build();
        } catch (IOException exception) {
            logConnectionStatus(new Socket());

            return Health.unknown().build();
        }
    }

    private void logConnectionStatus(Socket socket) {
        log.info(
                "Connection to elk-stack: {}, - {}",
                elkProperties.getHost(),
                socket.isConnected() ? "connected" : "disconnected"
        );
    }
}
