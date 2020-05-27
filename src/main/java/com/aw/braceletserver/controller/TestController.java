package com.aw.braceletserver.controller;

import org.springframework.web.bind.annotation.*;


/**
 * 临时用，删除s
 */
@RestController
@RequestMapping("/api")
public class TestController {

    @PostMapping("/ExceptionMessage/ExcdeptionListWhitoutCode")
    @ResponseBody
    public String exceptionMessage() {
        return "";
    }
}
