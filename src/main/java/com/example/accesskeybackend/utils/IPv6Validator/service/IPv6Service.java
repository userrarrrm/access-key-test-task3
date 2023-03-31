package com.example.accesskeybackend.utils.IPv6Validator.service;

import org.springframework.stereotype.Service;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;


@Service
public class IPv6Service {
    public boolean validate(String URL) throws UnknownHostException {
             InetAddress[] resolvedAddresses = InetAddress.getAllByName(URL);
            for (InetAddress address : resolvedAddresses) {
                if (address instanceof Inet6Address) {
                    return true;
                }
            }
        return false;
    }
}
