package oit.is.z2722.sse.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import oit.is.z2722.sse.model.Fruit;
import oit.is.z2722.sse.model.FruitMapper;
import oit.is.z2722.sse.service.AsyncShopService57;

@Controller
@RequestMapping("/sample5")
public class Sample57Controller {

  @Autowired
  FruitMapper fMapper;

  @Autowired
  AsyncShopService57 shop57;

  @GetMapping("step7")
  public String sample57(ModelMap model) {
    final ArrayList<Fruit> fruits7 = shop57.syncShowFruitsList();
    model.addAttribute("fruits7", fruits7);
    return "sample57.html";
  }
}
