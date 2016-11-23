package org.rest.persistence;

import org.rest.representations.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientDao extends JpaRepository<Client, Long> {
}
