package de.tollefreunde.zeltplatzrechnung.zeperlei;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Mike Schulze on 22.03.18.
 */
@Controller
public class ZepavStartController {

  @RequestMapping(method = RequestMethod.GET, path = "/zeperlei/start")
  public String start(Model model) {

    model.addAttribute("role", "Zepav");
    model.addAttribute("anderes", "Wert");
    return "zeperlei/start";
  }
}
