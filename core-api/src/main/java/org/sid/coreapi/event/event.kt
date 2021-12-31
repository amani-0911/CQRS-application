package org.sid.coreapi.event

import org.axonframework.modelling.command.TargetAggregateIdentifier

abstract class BaseEvent<T>(
  @TargetAggregateIdentifier  open val id : T
)
data class CreateCustomerEvent(
   override val id : String ,
    val name:String,
    val email: String
):BaseEvent<String>(id)
data class UpdateCustomerEvent(
        override val id : String ,
        val name:String,
        val email: String
):BaseEvent<String>(id)