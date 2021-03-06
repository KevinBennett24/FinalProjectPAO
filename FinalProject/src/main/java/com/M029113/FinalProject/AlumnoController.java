package com.M029113.FinalProject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {
    final AlumnoRepository alumnoRepository;
    final MateriaRepository materiaRepository;

    public AlumnoController(AlumnoRepository alumnoRepository, MateriaRepository materiaRepository) {
        this.alumnoRepository = alumnoRepository;
        this.materiaRepository = materiaRepository;
        alumnoRepository.save(new Alumno("Edwin", "Salinas", "edwin@gmail.com", 30));
        alumnoRepository.save(new Alumno("Dania", "Licea", "Dania@gmail.com", 27));
    }

    @GetMapping("/")
    String listAlumnos(@RequestParam(name = "name", defaultValue = "") String name, @RequestParam(name = "edad", defaultValue = "0") int edad, Model model) {
        if (!name.isEmpty() && edad > 0) {
            model.addAttribute("alumnos", alumnoRepository.findByNameContainingAndEdadGreaterThanEqual(name, edad));
        } else if (edad > 0) {
            model.addAttribute("alumnos", alumnoRepository.findByEdadGreaterThanEqual(edad));
        } else if (!name.isEmpty()) {
            model.addAttribute("alumnos", alumnoRepository.findByNameOrderByNameDesc(name));
        } else {
            model.addAttribute("alumnos", alumnoRepository.findAll());
        }
        return "alumnos-list";
    }
    @GetMapping("/register")
    String registration(Alumno alumno, Model model){
        model.addAttribute("alumno",alumno);
        return "alumno-add";
    }


    @PostMapping("/add")
    ModelAndView addAlumno(Alumno alumno, ModelMap model){
        alumnoRepository.save(alumno);
        model.addAttribute("alumnos", alumnoRepository.findAll());
        return new ModelAndView("redirect:/alumnos/"); //revisar si se va a la pgina correcta
    }

    @GetMapping("/edit/{id}")
    String editAlumno(@PathVariable("id") int id, Model model){
        var alumno = alumnoRepository.findById(id).get();
        model.addAttribute("alumno",alumno);
        var materias = materiaRepository.findAll();
        model.addAttribute("materias", materias);
        return "alumno-edit";
    }

    @PostMapping("/update/{id}")
    ModelAndView updateAlumno(@PathVariable("id") int id,Alumno editedalumno, Model model){

        alumnoRepository.save(editedalumno);
        model.addAttribute("alumnos",alumnoRepository.findAll());
        return new ModelAndView("redirect:/alumnos/");
    }

    @GetMapping("/delete/{id}")
    ModelAndView deleteAlumno (@PathVariable("id") int id, Model model){

        alumnoRepository.deleteById(id);
        model.addAttribute("alumnos",alumnoRepository.findAll());
        return new ModelAndView("redirect:/alumnos/");
    }
}
