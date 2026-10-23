package com.practica01.controller;

import com.practica01.domain.Suculenta;
import com.practica01.service.SuculentaService;
import jakarta.validation.Valid;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/suculenta")
public class SuculentaController {

    private static final Logger log = LoggerFactory.getLogger(SuculentaController.class);
    private static final List<String> NIVELES_RIEGO = List.of("Bajo", "Moderado", "Alto");

    private final SuculentaService suculentaService;

    public SuculentaController(SuculentaService suculentaService) {
        this.suculentaService = suculentaService;
    }

    @GetMapping("/listado")
    public String listado(Model model) {
        List<Suculenta> suculentas = suculentaService.getSuculentas();
        log.trace("Listando {} suculentas", suculentas.size());
        model.addAttribute("suculentas", suculentas);
        model.addAttribute("totalSuculentas", suculentas.size());
        return "suculenta/listado";
    }

    @GetMapping("/nueva")
    public String nueva(Model model) {
        model.addAttribute("suculenta", new Suculenta());
        model.addAttribute("nivelesRiego", NIVELES_RIEGO);
        return "suculenta/nueva";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute("suculenta") Suculenta suculenta,
                          BindingResult result, Model model, RedirectAttributes redirect) {
        boolean esNueva = suculenta.getIdSuculenta() == null;
        if (result.hasErrors()) {
            model.addAttribute("nivelesRiego", NIVELES_RIEGO);
            return esNueva ? "suculenta/nueva" : "suculenta/modifica";
        }
        suculentaService.save(suculenta);
        redirect.addFlashAttribute("mensaje", esNueva
                ? "La suculenta se registró correctamente."
                : "La suculenta se actualizó correctamente.");
        return "redirect:/suculenta/listado";
    }

    @GetMapping("/modificar/{idSuculenta}")
    public String modificar(@PathVariable Long idSuculenta, Model model, RedirectAttributes redirect) {
        Suculenta suculenta = suculentaService.getSuculenta(idSuculenta);
        if (suculenta == null) {
            redirect.addFlashAttribute("error", "La suculenta solicitada no existe.");
            return "redirect:/suculenta/listado";
        }
        model.addAttribute("suculenta", suculenta);
        model.addAttribute("nivelesRiego", NIVELES_RIEGO);
        return "suculenta/modifica";
    }

    @PostMapping("/eliminar/{idSuculenta}")
    public String eliminar(@PathVariable Long idSuculenta, RedirectAttributes redirect) {
        if (suculentaService.getSuculenta(idSuculenta) == null) {
            redirect.addFlashAttribute("error", "La suculenta que intenta eliminar no existe.");
        } else {
            suculentaService.delete(idSuculenta);
            redirect.addFlashAttribute("mensaje", "La suculenta se eliminó correctamente.");
        }
        return "redirect:/suculenta/listado";
    }
}
