package org.sid.customercommandside;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerCommandSideApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerCommandSideApplication.class, args);
    }

    @Bean
    public CommandBus commandsBus(){
        return SimpleCommandBus.builder().build();
    }
}
