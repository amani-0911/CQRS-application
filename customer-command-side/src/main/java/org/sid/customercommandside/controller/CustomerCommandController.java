package org.sid.customercommandside.controller;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.sid.coreapi.command.CreateCustomerCommand;
import org.sid.coreapi.dtos.CustmerRequestDto;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/customers/command")
public class CustomerCommandController {
    private EventStore eventStore;
    private CommandGateway commandGateway;
   @PostMapping("/create")
    public CompletableFuture<Object> newCustomer(CustmerRequestDto request){
CompletableFuture<Object> respnse= commandGateway.send(new CreateCustomerCommand(
        UUID.randomUUID().toString()  ,
        request.getName(),
        request.getEmail()
));
return respnse;
    }
    @GetMapping("/eventStore/{customerId}")
    public Stream eventStore(@PathVariable String customerId){
       return eventStore.readEvents(customerId).asStream();
    }
}
