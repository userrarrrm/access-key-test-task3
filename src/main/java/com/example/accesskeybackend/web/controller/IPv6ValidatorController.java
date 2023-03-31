package com.example.accesskeybackend.web.controller;

import com.example.accesskeybackend.web.dto.IPv6DTO;
import com.example.accesskeybackend.web.service.IPv6Service;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.net.UnknownHostException;

@Controller
@RequestMapping("/api/web")
public class IPv6ValidatorController {

    public IPv6ValidatorController(IPv6Service iPv6Service) {
        this.iPv6Service = iPv6Service;
    }

    IPv6Service iPv6Service;
    @GetMapping("/checkIpv6Support")
    public ResponseEntity<IPv6DTO> ipv6Validator(@RequestParam String siteUrl) throws UnknownHostException {
        IPv6DTO iPv6DTO = new IPv6DTO();
        iPv6DTO.setURL(siteUrl);
        iPv6DTO.setSuccessful(iPv6Service.validate(siteUrl));
        return ResponseEntity.ok().body(iPv6DTO);
    }
}
