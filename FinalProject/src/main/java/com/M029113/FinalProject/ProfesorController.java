package com.M029113.FinalProject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/profesores")
public class ProfesorController {

    final ProfesorRepository profesorRepository;
    final MateriaRepository materiaRepository;

    public ProfesorController(ProfesorRepository profesorRepository, MateriaRepository materiaRepository) {
        this.profesorRepository = profesorRepository;
        this.materiaRepository = materiaRepository;
        profesorRepository.save(new Profesor("Eduardo", "Cota", "lalocota@gmail.com", 30));
        profesorRepository.save(new Profesor("Pedro", "Gomez", "pgomez@gmail.com", 27));
    }

    @GetMapping("/")
    String listProfesores(@RequestParam(name = "email", defaultValue = "") String email, @RequestParam(name = "age", defaultValue = "0") int age, Model model) {
        if (!email.isEmpty() && age > 0) {
            model.addAttribute("profesores", profesorRepository.findByEmailContainingAndEdadGreaterThanEqual(email, age));
        } else if (age > 0) {
            model.addAttribute("profesores", profesorRepository.findByEdadGreaterThanEqual(age));
        } else if (!email.isEmpty()) {
            model.addAttribute("profesores", profesorRepository.findByEmailContainingOrderByNameDesc(email));
        } else {
            model.addAttribute("profesores", profesorRepository.findAll());
        }
        return "profesores-list";
    }
    @GetMapping("/register")
    String registration(Profesor profesor, Model model){
        model.addAttribute("profesor",profesor);
        return "profesor-add";
    }


    @PostMapping("/add")
    ModelAndView addProfesor(Profesor profesor, ModelMap model){
        profesorRepository.save(profesor);
        model.addAttribute("profesores", profesorRepository.findAll());
        return new ModelAndView("redirect:/profesores/"); //revisar si se va a la pgina correcta
    }

    @GetMapping("/edit/{id}")
    String editProfesor(@PathVariable("id") int id, Model model){
        var profesor = profesorRepository.findById(id).get();
        model.addAttribute("profesor",profesor);
        var materias = materiaRepository.findAll();
        model.addAttribute("materias", materias);
        return "profesor-edit";
    }

    @PostMapping("/update/{id}")
    ModelAndView updateProfesor(@PathVariable("id") int id,Profesor editedProfesor, Model model){

        profesorRepository.save(editedProfesor);
        model.addAttribute("profesores",profesorRepository.findAll());
        return new ModelAndView("redirect:/profesores/");
    }

    @GetMapping("/delete/{id}")
    ModelAndView deleteProfesor (@PathVariable("id") int id, Model model){

        profesorRepository.deleteById(id);
        model.addAttribute("profesores",profesorRepository.findAll());
        return new ModelAndView("redirect:/profesores/");
    }


}
