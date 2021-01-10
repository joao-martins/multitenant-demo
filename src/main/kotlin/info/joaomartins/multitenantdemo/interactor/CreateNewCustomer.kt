package info.joaomartins.multitenantdemo.interactor

import info.joaomartins.multitenantdemo.domain.Customer
import info.joaomartins.multitenantdemo.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CreateNewCustomer(
    val customerRepository: CustomerRepository
) {
    fun call(customer: Customer) = customerRepository.save(customer)
}
