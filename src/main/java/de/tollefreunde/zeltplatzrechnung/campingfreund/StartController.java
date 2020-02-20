package de.tollefreunde.zeltplatzrechnung.campingfreund;

import de.tollefreunde.zeltplatzrechnung.jpa.user.User;
import de.tollefreunde.zeltplatzrechnung.jpa.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Mike Schulze on 19.02.18.
 */
@Controller
public class StartController {

  final private UserRepository userRepository;

  @Autowired
  public StartController(final UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @RequestMapping(method = RequestMethod.GET, path = "/campingfreund/start")
  public String greeting(Model model) {

    StartDO obj = new StartDO();

    final List<User> listOfUserEntities = userRepository.findByUsername("zepalei");
    obj.setNumberOfUsers(listOfUserEntities.size());
    obj.setSurname(listOfUserEntities.get(0).getSurname());

    model.addAttribute("startDTO", obj);
    return "campingfreund/start";
  }


}
