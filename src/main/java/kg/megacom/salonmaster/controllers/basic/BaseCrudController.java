package kg.megacom.salonmaster.controllers.basic;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface BaseCrudController <S,T>{
    @PostMapping("/save")
    S save(@RequestBody S s);
    @PutMapping("/update")
    S update(@RequestBody S s);
    @GetMapping("/all")
    List<S> findAll();
    @GetMapping("/{id}")
    S findById(@PathVariable T id);
}
