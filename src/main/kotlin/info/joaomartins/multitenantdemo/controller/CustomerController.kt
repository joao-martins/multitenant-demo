package info.joaomartins.multitenantdemo.controller

import info.joaomartins.multitenantdemo.domain.Customer
import info.joaomartins.multitenantdemo.interactor.CreateNewCustomer
import info.joaomartins.multitenantdemo.interactor.GetAllCustomers
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController(
    val createNewCustomer: CreateNewCustomer,
    val getAllCustomers: GetAllCustomers
) {
    @GetMapping
    fun get() = getAllCustomers.call()

    @PostMapping
    fun post(@RequestBody customer: Customer) = createNewCustomer.call(customer)
}
