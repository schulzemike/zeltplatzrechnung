package de.tollefreunde.zeltplatzrechnung.jpa.user;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Mike Schulze on 23.02.18.
 */
public interface UserRepository extends CrudRepository<User, Integer> {

  List<User> findByUsername(final String username);
}
