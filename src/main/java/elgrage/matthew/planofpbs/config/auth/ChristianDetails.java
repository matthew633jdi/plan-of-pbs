package elgrage.matthew.planofpbs.config.auth;

import elgrage.matthew.planofpbs.domain.Christian;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Getter
public class ChristianDetails implements UserDetails, OAuth2User {

    private Christian christian;
    private Map<String, Object> attributes;

    public ChristianDetails(Christian christian) {
        this.christian = christian;
    }

    public ChristianDetails(Christian christian, Map<String, Object> attributes) {
        this.christian = christian;
        this.attributes = attributes;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return christian.getRole();
            }
        });
        return collection;
    }

    @Override
    public String getPassword() {
        return christian.getPassword();
    }

    @Override
    public String getUsername() {
        return christian.getName();
    }
}
