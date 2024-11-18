package doubleplay.playbaseball.view.domain.auth;

import org.springframework.lang.Nullable;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Map;

public interface OAuth2AuthenticatedPrincipal extends AuthenticatedPrincipal {
    @Nullable
    default <A> A getAttribute(String name) {
        return (A) this.getAttributes().get(name);
    }

    Map<String, Object> getAttributes();

    Collection<? extends GrantedAuthority> getAuthorities();
}
