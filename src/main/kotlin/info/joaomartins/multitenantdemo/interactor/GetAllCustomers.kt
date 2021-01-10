package info.joaomartins.multitenantdemo.interactor

import info.joaomartins.multitenantdemo.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class GetAllCustomers(
    val customerRepository: CustomerRepository
) {
    fun call() = customerRepository.findAll()
}
