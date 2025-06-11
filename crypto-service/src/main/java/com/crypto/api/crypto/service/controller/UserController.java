package com.crypto.api.crypto.service.controller;

import com.crypto.api.crypto.service.constant.AppConstant;
import com.crypto.api.crypto.service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/users"})
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping({"/v1/balance"})
    ResponseEntity<?> getBalances() {
        return ResponseEntity.ok(userService.getBalances(AppConstant.USER_ID));
    }

}
