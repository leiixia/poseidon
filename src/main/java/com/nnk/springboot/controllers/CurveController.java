package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@Slf4j
public class CurveController {
    @Autowired
    private CurvePointRepository curvePointRepository;

    @RequestMapping("/curvePoint/list")
    public String home(Model model)
    {
        model.addAttribute("curvePoint", curvePointRepository.findAll());
        log.info("List of curvePoint item.");
        return "curvePoint/list";
    }

    @GetMapping("/curvePoint/add")
    public String addCurvePointForm(CurvePoint curvePoint) {
        return "curvePoint/add";
    }

    @PostMapping("/curvePoint/validate")
    public String validate(@Valid CurvePoint curvePoint, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            curvePointRepository.save(curvePoint);
            model.addAttribute("curvePoints", curvePointRepository.findAll());
            log.info("Creation success, return curvePoint list items.");
            return "redirect:/curvePoint/list";
        }
        log.error("Creation failed for curvePoint item." + curvePoint.getCurveId());
        return "curvePoint/add";
    }

    @GetMapping("/curvePoint/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        CurvePoint curvePoint = curvePointRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("curvePoint", curvePoint);
        return "curvePoint/update";
    }

    @PostMapping("/curvePoint/update/{id}")
    public String updateBid(@PathVariable("id") Integer id, @Valid CurvePoint curvePoint,
                            BindingResult result, Model model) {
        if (result.hasErrors()) {
            log.error("Validation failed for curvePoint item." + curvePoint.getCurveId());
            return "curvePoint/update";
        }
        curvePoint.setCurveId(id);
        curvePointRepository.save(curvePoint);
        log.info("Update success for curvePoint item.");
        model.addAttribute("curvePoints", curvePointRepository.findAll());
        return "redirect:/curvePoint/list";
    }

    @GetMapping("/curvePoint/delete/{id}")
    public String deleteBid(@PathVariable("id") Integer id, Model model) {
        CurvePoint curvePoint = curvePointRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        curvePointRepository.delete(curvePoint);
        log.info("Delete curvePoint item.");
        model.addAttribute("curvePoints", curvePointRepository.findAll());
        return "redirect:/curvePoint/list";
    }
}
