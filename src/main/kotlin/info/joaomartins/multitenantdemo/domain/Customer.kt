package info.joaomartins.multitenantdemo.domain

import java.util.UUID
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.AUTO
import javax.persistence.Id

@Entity
data class Customer(
    @Id
    @GeneratedValue(strategy = AUTO)
    val id: UUID?,

    val name: String

) : TenantSupport()
