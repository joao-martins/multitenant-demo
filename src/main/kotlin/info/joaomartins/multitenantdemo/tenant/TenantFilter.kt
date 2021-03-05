package info.joaomartins.multitenantdemo.tenant

import org.springframework.core.Ordered.HIGHEST_PRECEDENCE
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest

@Component
@Order(HIGHEST_PRECEDENCE)
class TenantFilter : Filter {
    companion object {
        const val TENANT_HEADER = "X-TenantID"
    }

    override fun doFilter(
        servletRequest: ServletRequest,
        servletResponse: ServletResponse,
        filterChain: FilterChain
    ) {
        with(servletRequest as HttpServletRequest) {
            val tenantHeader = getHeader(TENANT_HEADER)
            if (tenantHeader.isNullOrEmpty()) {
                return
            } else {
                TenantContext.setCurrentTenant(tenantHeader)
            }
        }
        filterChain.doFilter(servletRequest, servletResponse)
    }
}
