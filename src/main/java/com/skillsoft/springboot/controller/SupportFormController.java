package com.skillsoft.springboot.controller;

import java.util.*;

import com.skillsoft.springboot.model.SupportForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SupportFormController {

    @GetMapping("/support")
    public String complainForm(Model model) {
        model.addAttribute("supportDetails", new SupportForm());

        List<String> membershipList = Arrays.asList("Platinum", "Gold", "Silver");
        model.addAttribute("membershipList", membershipList);

        return "support";
    }

    @PostMapping("/support")
    public String submitComplain(@ModelAttribute SupportForm supportDetails, Model model) {
        model.addAttribute("supportDetails", supportDetails);

        return "submit";
    }
}
