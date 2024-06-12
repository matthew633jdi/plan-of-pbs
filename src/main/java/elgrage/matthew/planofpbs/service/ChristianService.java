package elgrage.matthew.planofpbs.service;

import elgrage.matthew.planofpbs.domain.Christian;
import elgrage.matthew.planofpbs.repository.ChristianRepository;
import elgrage.matthew.planofpbs.request.ChristianCreate;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChristianService {

    private final ChristianRepository christianRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void signup(ChristianCreate request) {
        Christian christian = Christian.builder()
                .role("ROLE_USER")
                .name(request.getUsername())
                .mail(request.getEmail())
                .password(bCryptPasswordEncoder.encode(request.getPassword()))
                .build();

        christianRepository.save(christian);
    }
}
