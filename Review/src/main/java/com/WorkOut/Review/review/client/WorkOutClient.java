package com.WorkOut.Review.review.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value ="catalogservice", url="${catalog.url}")
public interface WorkOutClient {
    @RequestMapping(method = RequestMethod.GET, value = "/api/catalog/{id}")
    WorkOutDTO getWorkOutById(@PathVariable("id") String id);
}
