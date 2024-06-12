package elgrage.matthew.planofpbs.service;

import elgrage.matthew.planofpbs.config.auth.ChristianDetails;
import elgrage.matthew.planofpbs.config.oauth.provider.GoogleUserInfo;
import elgrage.matthew.planofpbs.config.oauth.provider.OAuth2UserInfo;
import elgrage.matthew.planofpbs.config.properties.PropertiesConfig;
import elgrage.matthew.planofpbs.domain.Christian;
import elgrage.matthew.planofpbs.repository.ChristianRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChristianOAuth2Service extends DefaultOAuth2UserService {

    private final ChristianRepository christianRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oauth2User = super.loadUser(userRequest);
        OAuth2UserInfo userInfo = null;

        if (userRequest.getClientRegistration().getClientName().equalsIgnoreCase("google")) {
            log.info("=== Google Login ===");
            userInfo = new GoogleUserInfo(oauth2User.getAttributes());
        }

        String provider = userInfo.getProvider();
        String providerId = userInfo.getProviderId();
        String email = userInfo.getEmail();
        String role = "ROLE_USER";

        String name = provider + "_" + providerId;
        String password = bCryptPasswordEncoder.encode(PropertiesConfig.key);

        Optional<Christian> optional = christianRepository.findByName(name);

        Christian christian = null;
        if (optional.isEmpty()) {
            christian = Christian.builder()
                    .name(name)
                    .mail(email)
                    .password(password)
                    .role(role)
                    .provider(provider)
                    .providerId(providerId)
                    .build();

            christianRepository.save(christian);
        } else {
            christian = optional.get();
        }

        return new ChristianDetails(christian, oauth2User.getAttributes());
    }

}
