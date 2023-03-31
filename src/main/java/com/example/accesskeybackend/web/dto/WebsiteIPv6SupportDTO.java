package com.example.accesskeybackend.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WebsiteIPv6SupportDTO {
    private String URI;
    private boolean successful;
}
