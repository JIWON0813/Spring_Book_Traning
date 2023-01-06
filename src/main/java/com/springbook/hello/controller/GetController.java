package com.springbook.hello.controller;

import com.springbook.hello.dto.MemberDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    private final Logger LOGGER = LoggerFactory.getLogger(GetController.class);

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        LOGGER.info("hello 메서드가 호출되었습니다.");
        return "Hello World";
    }

    @GetMapping(value = "/name")
    public String name() {
        return "Flature";
    }

    @GetMapping(value = "/variable/{variable}")
    public String variable(@PathVariable String variable) {
        return variable;
    }

    @GetMapping(value = "/variable2/{variable}")
    public String variable2(@PathVariable("variable") String var) {
        return var;
    }

    @GetMapping(value = "/param1")
    public String requestParam1(
            @RequestParam String name,
            @RequestParam String email
    ) {
        return name + " " + email;
    }

    @GetMapping(value = "/param2")
    public String param2(@RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    @GetMapping("/param3")
    public String param3(MemberDto memberDto){
        return memberDto.toString();
    }
}
