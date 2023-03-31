package com.example.accesskeybackend.web.service;

import org.springframework.stereotype.Service;

import java.net.*;
import java.util.Optional;

@Service
public class WebUtilsService {

    private static final String DUMMY_SCHEME = "https://";


    public boolean isWebsiteSupportIPv6(final String URI) {
        return hostFromUri(URI).map(this::hasAAAARecord).orElse(false);
    }


    private boolean hasAAAARecord(final String domain) {
        try {
            for (final InetAddress address : InetAddress.getAllByName(domain)) {
                if (address instanceof Inet6Address) {
                    return true;
                }
            }
        } catch (final UnknownHostException ignored) {
        }

        return false;
    }

    private static Optional<String> hostFromUri(final String input) {
        URI uri;
        try {
            uri = new URI(input);

            final String scheme = uri.getScheme();
            if (scheme == null) {
                uri = new URI(DUMMY_SCHEME + input);
            }

            return Optional.ofNullable(uri.getHost());
        } catch (final URISyntaxException ignored) {
        }

        return Optional.empty();
    }
}
