package org.sid.customercommandside.aggregate;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.sid.coreapi.command.CreateCustomerCommand;
import org.sid.coreapi.event.CreateCustomerEvent;

@Aggregate
@Slf4j
public class CustomerAggregate {
    @AggregateIdentifier
    private String customerId;
    private String name;
    private String email;

    public CustomerAggregate(){

    }

    @CommandHandler
    public CustomerAggregate(CreateCustomerCommand command){
       log.info("created cusomer command");
        AggregateLifecycle.apply(new CreateCustomerEvent(
                command.getId(),
                command.getName(),
                command.getEmail()
        ));
    }
    @EventSourcingHandler
    public void on(CreateCustomerEvent event){
     log.info("created custemr event");
        this.customerId= event.getId();
        this.email=event.getEmail();
        this.name= event.getName();
    }
}
