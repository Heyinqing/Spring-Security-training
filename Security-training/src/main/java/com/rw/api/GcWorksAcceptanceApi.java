package com.rw.api;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @author Heyinqing
 * @date 2025/1/8
 */
@RequestMapping("/gcWorksAcceptance")
public class GcWorksAcceptanceApi {

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date.getYear() + 1900);
    }

}
