package br.com.uniamerica.passwordmanager.service;

import br.com.uniamerica.passwordmanager.exceptions.PasswordNotFound;
import br.com.uniamerica.passwordmanager.model.Password;
import br.com.uniamerica.passwordmanager.repository.PasswordRepository;
import org.hibernate.procedure.ParameterStrategyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class PasswordService {

    @Autowired
    PasswordRepository passwordRepository;

    public Password findById(Long id){
        return this.passwordRepository.findById(id).orElse(new Password());
    }

    public Page<Password> listAll(Pageable pageable){
        return this.passwordRepository.findAll(pageable);
    }

    @Transactional
    public void insert(Password password){
        this.passwordRepository.save(password);
    }

    @Transactional
    public void update(Long idPassword, Password password){
        if(idPassword == password.getId()){
            this.passwordRepository.save(password);
        } else {
            throw new RuntimeException();
        }


    }

    @Transactional
    public void deleteById(Long id){
        passwordRepository.findById(id)
                .orElseThrow(PasswordNotFound::new);

        this.passwordRepository.deleteById(id);
    }




}
