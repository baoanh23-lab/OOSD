package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String trangChu() {
        return "/Giaodienmain/index";
    }
    @GetMapping("/sach")
    public String sach() {
        return "/Giaodienmain/sach";
    }

    @GetMapping("/muontra")
    public String muonTra() {
        return "/Giaodienmain/trasach";
    }
    @GetMapping("/danhmuc")
    public String danhmuc() {
        return "Giaodienmain/danhmuc";
    }
    @GetMapping("/docgia")
    public String docgia() {
        return "Giaodienmain/docgia";
    }
    @GetMapping("/thongke")
    public String thongke() {
        return "Giaodienmain/thongke";
    }
    
}