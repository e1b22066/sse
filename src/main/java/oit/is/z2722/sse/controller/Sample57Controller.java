package oit.is.z2722.sse.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

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

  @GetMapping("step8")
  @Transactional
  public String sample58(@RequestParam Integer id, ModelMap model) {
    // 選択したフルーツを削除し，削除対象のフルーツをmodelに登録
    final Fruit fruit8 = this.shop57.syncBuyFruits(id);
    model.addAttribute("fruit8", fruit8);

    // 残りのフルーツリストを取得してmodelに登録
    final ArrayList<Fruit> fruits7 = shop57.syncShowFruitsList();
    model.addAttribute("fruits7", fruits7);

    return "sample57.html";
  }

  @GetMapping("step9")
  public SseEmitter sample59() {
    final SseEmitter sseEmitter = new SseEmitter();
    this.shop57.asyncShowFruitsList(sseEmitter);
    return sseEmitter;
  }
}
