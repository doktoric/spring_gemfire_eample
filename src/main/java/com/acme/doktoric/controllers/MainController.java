package com.acme.doktoric.controllers;

import com.acme.doktoric.GemfireSample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: Ricsi
 * Date: 2013.07.27.
 * Time: 14:39
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class MainController {

    @Autowired
    private GemfireSample gemfireSample;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        gemfireSample.getNameForId();
        return "home";
    }
}
