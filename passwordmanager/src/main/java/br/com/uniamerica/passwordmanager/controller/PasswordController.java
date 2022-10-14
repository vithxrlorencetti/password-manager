package br.com.uniamerica.passwordmanager.controller;

import br.com.uniamerica.passwordmanager.model.Password;
import br.com.uniamerica.passwordmanager.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/password")
public class PasswordController {

    @Autowired
    PasswordService passwordService;

    @GetMapping("/{idPassword}")
    public ResponseEntity<Password> findById(@PathVariable("idPassword") Long idPassword) {
        return ResponseEntity.ok().body(this.passwordService.findById(idPassword));
    }

    @GetMapping
    public ResponseEntity<Page<Password>> listByAllPage(Pageable pageable) {
        return ResponseEntity.ok().body(this.passwordService.listAll(pageable));
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody Password password) {
        this.passwordService.insert(password);
        return ResponseEntity.ok().body("Senha cadastrada com sucesso.");
    }

    @PutMapping("/{idPassword}")
    public ResponseEntity<?> update(@PathVariable Long idPassword, @RequestBody Password password) {
        this.passwordService.update(idPassword, password);
        return ResponseEntity.ok().body("Senha atualizada com sucesso.");
    }

    @DeleteMapping("/{idPassword}")
    public ResponseEntity<?> delete(@PathVariable Long idPassword) {
        this.passwordService.deleteById(idPassword);
        return ResponseEntity.ok().body("Senha deletada com sucesso.");
    }


}
