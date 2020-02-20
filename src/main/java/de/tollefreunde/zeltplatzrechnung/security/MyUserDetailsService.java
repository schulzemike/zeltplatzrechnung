package de.tollefreunde.zeltplatzrechnung.security;

import de.tollefreunde.zeltplatzrechnung.jpa.user.User;
import de.tollefreunde.zeltplatzrechnung.jpa.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mike Schulze on 24.02.18.
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  @Autowired
  public MyUserDetailsService(final UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) {
    List<User> userList = userRepository.findByUsername(username);
    if (userList == null || userList.size() != 1) {
      throw new UsernameNotFoundException(username);
    } else {
      return new MyUserPrincipal(userList.get(0));
    }
  }
}
