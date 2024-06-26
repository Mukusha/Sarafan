package smile.sarafan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import smile.sarafan.repo.MessageRepo;

import java.util.HashMap;

@Controller
@RequestMapping("/")
public class MainController {
    private final MessageRepo messageRepo;

    @Autowired
    public MainController(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    @GetMapping
    public String main(Model model, @AuthenticationPrincipal Object user) { //(expression = "attrubute")
        HashMap<Object, Object> data = new HashMap<>();

        data.put("profile", user);
        data.put("messages",messageRepo.findAll());//

        model.addAttribute("frontendData", data);

        return "index";
    }
}
