package de.tollefreunde.zeltplatzrechnung.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Mike Schulze on 14.07.18.
 */
@Controller
public class LoginController {

  @GetMapping("login")
  public String login() {
    return "login";
  }
}
