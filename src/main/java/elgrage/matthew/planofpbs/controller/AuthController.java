package elgrage.matthew.planofpbs.controller;

import elgrage.matthew.planofpbs.config.auth.ChristianDetails;
import elgrage.matthew.planofpbs.request.ChristianCreate;
import elgrage.matthew.planofpbs.service.ChristianService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AuthController {

    private final ChristianService christianService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/join")
    public String join() {
        return "join";
    }

    @PostMapping("/join")
    public String join(ChristianCreate request) {
        christianService.signup(request);
        return "redirect:/login";
    }
}
