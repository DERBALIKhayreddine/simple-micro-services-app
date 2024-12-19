package tn.home.student.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "address-service", path = "/api/address")
public interface AddressFeignClient {
    @GetMapping("/{id}")
    Object getAddressById(@PathVariable Long id);
}
