package br.com.uniamerica.passwordmanager.repository;

import br.com.uniamerica.passwordmanager.model.Password;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordRepository extends JpaRepository<Password, Long> {

}
