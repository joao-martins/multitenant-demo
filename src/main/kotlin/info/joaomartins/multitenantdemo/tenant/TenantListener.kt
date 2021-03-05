package info.joaomartins.multitenantdemo.tenant

import info.joaomartins.multitenantdemo.domain.TenantSupport
import javax.persistence.PrePersist
import javax.persistence.PreRemove
import javax.persistence.PreUpdate

class TenantListener {

    @PreUpdate
    @PreRemove
    @PrePersist
    fun setTenant(entity: TenantSupport) {
        val tenantId = TenantContext.getCurrentTenant()
        entity.tenantId = tenantId
    }
}
