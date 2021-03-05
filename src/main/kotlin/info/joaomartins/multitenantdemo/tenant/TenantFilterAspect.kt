package info.joaomartins.multitenantdemo.tenant

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.hibernate.Session
import org.springframework.stereotype.Component
import javax.persistence.EntityManager

@Aspect
@Component
class TenantFilterAspect(
    private val entityManager: EntityManager
) {
    @Around("execution(* info.joaomartins.multitenantdemo.repository..*(..))")
    fun inWebLayer(joinPoint: ProceedingJoinPoint): Any {
        if (entityManager.isOpen) {
            val session: Session = entityManager.unwrap(Session::class.java)
            val id: String = TenantContext.getCurrentTenant()
            session.enableFilter("tenantFilter").setParameter("tenantId", id)
        }
        return joinPoint.proceed()
    }
}
