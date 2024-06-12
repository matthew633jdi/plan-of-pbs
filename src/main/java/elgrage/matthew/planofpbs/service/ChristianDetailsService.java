package elgrage.matthew.planofpbs.service;

import elgrage.matthew.planofpbs.config.auth.ChristianDetails;
import elgrage.matthew.planofpbs.domain.Christian;
import elgrage.matthew.planofpbs.repository.ChristianRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChristianDetailsService implements UserDetailsService {

    private final ChristianRepository christianRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("=== Login Username: {}", username);
        Christian christian = christianRepository.findByName(username).orElseThrow(() -> {
            log.error("=== Not found user name: {}", username);
            return new UsernameNotFoundException(username);
        });
        return new ChristianDetails(christian);
    }
}
