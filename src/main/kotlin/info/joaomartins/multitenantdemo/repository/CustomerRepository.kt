package info.joaomartins.multitenantdemo.repository

import info.joaomartins.multitenantdemo.domain.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface CustomerRepository : JpaRepository<Customer, UUID> {

    override fun findAll(): List<Customer>

    override fun <S : Customer?> save(entity: S): S
}
