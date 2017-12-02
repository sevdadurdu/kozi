package com.sevda.kozi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;

@Controller
public class HomeController {


    @Autowired
    MakeupItemRepository makeupItemRepository;

    @RequestMapping(value = "/home")
    public ModelAndView home() {

        ModelAndView modelAndView = new ModelAndView("index");
       /* MakeupItem makeupItem=new MakeupItem();
        makeupItem.setDescription("Deneme Ürün");
        makeupItem.setName("Ruj Rimmel");
        makeupItem.setRate(4.3);
        makeupItemList.add(makeupItem);

        MakeupItem makeupItem2=new MakeupItem();
        makeupItem2.setDescription("Deneme Ürün");
        makeupItem2.setName("Rimel Rimmel");
        makeupItem2.setRate(3.2);
        makeupItemList.add(makeupItem2);*/

        modelAndView.addObject("makeupList", makeupItemRepository.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST,consumes = MediaType.ALL_VALUE)
    public ModelAndView save(@ModelAttribute MakeupItem makeupItem) {
        ModelAndView modelAndView=new ModelAndView("index");
        makeupItemRepository.save(makeupItem);
        modelAndView.addObject("makeupList", makeupItemRepository.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public ModelAndView saveGet() {
        ModelAndView modelAndView=new ModelAndView("save");
        modelAndView.addObject("makeupItem",new MakeupItem());
        return modelAndView;
    }

    @RequestMapping(value = "/detail/{id}",method = RequestMethod.GET)
    public ModelAndView detail(@PathVariable Long id) {
        ModelAndView modelAndView=new ModelAndView("detail");
        modelAndView.addObject("makeupItem",makeupItemRepository.findOne(id));
        return modelAndView;
    }
}
