package com.example.accesskeybackend.web.controller;

import com.example.accesskeybackend.web.dto.WebsiteIPv6SupportDTO;
import com.example.accesskeybackend.web.service.WebUtilsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/web")
@AllArgsConstructor
public class WebUtilsController {

    private final WebUtilsService webUtilsService;

    @GetMapping("/checkIpv6Support")
    public WebsiteIPv6SupportDTO ipv6Validator(@RequestParam final String siteUrl) {
        final boolean support = webUtilsService.isWebsiteSupportIPv6(siteUrl);

        return new WebsiteIPv6SupportDTO(siteUrl, support);
    }
}
