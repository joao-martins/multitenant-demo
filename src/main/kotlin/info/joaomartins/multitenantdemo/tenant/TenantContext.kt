package info.joaomartins.multitenantdemo.tenant

object TenantContext {

    private val currentTenant = ThreadLocal<String>()

    fun getCurrentTenant(): String =
        currentTenant.get()

    fun setCurrentTenant(tenant: String) =
        currentTenant.set(tenant)

    fun clear() =
        currentTenant.set(null)
}
