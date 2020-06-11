package com.M029113.FinalProject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/materias")
public class MateriaController {
    final MateriaRepository materiaRepository;

    public MateriaController(MateriaRepository materiaRepository) {
        this.materiaRepository = materiaRepository;
        materiaRepository.save(new Materia("Matemáticas"));
        materiaRepository.save(new Materia("Programación"));
        materiaRepository.save(new Materia("Electrónica"));
    }

    @GetMapping("/")
    String listMaterias(@RequestParam(name = "name", defaultValue = "") String name, Model model) {
        if (!name.isEmpty()) {
            model.addAttribute("materias", materiaRepository.findByNameOrderByNameDesc(name));
        } else {
            model.addAttribute("materias", materiaRepository.findAll());
        }
        return "materias-list";
    }
    @GetMapping("/register")
    String registration(Materia materia, Model model){
        model.addAttribute("materia",materia);
        return "materia-add";
    }


    @PostMapping("/add")
    ModelAndView addMateria(Materia materia, ModelMap model){
        materiaRepository.save(materia);
        model.addAttribute("materias", materiaRepository.findAll());
        return new ModelAndView("redirect:/materias/"); //revisar si se va a la pgina correcta
    }

    @GetMapping("/edit/{id}")
    String editMateria(@PathVariable("id") int id, Model model){
        var materia = materiaRepository.findById(id).get();
        model.addAttribute("materia",materia);
        return "materia-edit";
    }

    @PostMapping("/update/{id}")
    ModelAndView updateMateria(@PathVariable("id") int id,Materia editedmateria, Model model){
        materiaRepository.save(editedmateria);
        model.addAttribute("materias",materiaRepository.findAll());
        return new ModelAndView("redirect:/materias/");
    }

    @GetMapping("/delete/{id}")
    ModelAndView deleteMateria (@PathVariable("id") int id, Model model){
        materiaRepository.deleteById(id);
        model.addAttribute("materias",materiaRepository.findAll());
        return new ModelAndView("redirect:/materias/");
    }






}
