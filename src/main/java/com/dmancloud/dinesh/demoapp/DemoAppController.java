package com.dmancloud.dinesh.demoapp;

import java.io.File;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoAppController {

    @GetMapping("/")
    public String hello(Model model) {
        model.addAttribute("message", "Hello World! This is a sample application to demonstrate an end-2-end DevOps Pipeline");
 
        return "index";
    }

    @GetMapping("/error")
    public String handleError() {
        return "error";
    }

    public Set<String> listFilesUsingJavaIO(String dir) {
        return Stream.of(new File(dir).listFiles())
        .filter(file -> !file.isDirectory())
        .map(File::getName)
        .collect(Collectors.toSet());
    }
}

