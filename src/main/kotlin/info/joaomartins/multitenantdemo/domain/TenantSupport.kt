package info.joaomartins.multitenantdemo.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import info.joaomartins.multitenantdemo.tenant.TenantListener
import org.hibernate.annotations.Filter
import org.hibernate.annotations.FilterDef
import org.hibernate.annotations.ParamDef
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@FilterDef(name = "tenantFilter", parameters = [ParamDef(name = "tenantId", type = "string")])
@Filter(name = "tenantFilter", condition = "tenant_id = :tenantId")
@EntityListeners(TenantListener::class)
open class TenantSupport {

    @JsonIgnore
    lateinit var tenantId: String
}
