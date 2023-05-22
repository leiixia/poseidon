package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;
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
public class RatingController {
    @Autowired
    private RatingRepository ratingRepository;

    @RequestMapping("/rating/list")
    public String home(Model model)
    {
        model.addAttribute("ratings", ratingRepository.findAll());
        log.info("List of rating items.");
        return "rating/list";
    }

    @GetMapping("/rating/add")
    public String addRatingForm(Rating rating) {
        return "rating/add";
    }

    @PostMapping("/rating/validate")
    public String validate(@Valid Rating rating, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            ratingRepository.save(rating);
            model.addAttribute("ratings", ratingRepository.findAll());
            log.info("Creation success, return rating list items.");
            return "redirect:/rating/list";
        }
        log.error("Creation failed for rating item." + rating.getId());
        return "rating/add";
    }

    @GetMapping("/rating/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Rating rating = ratingRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("rating", rating);
        return "rating/update";
    }

    @PostMapping("/rating/update/{id}")
    public String updateRating(@PathVariable("id") Integer id, @Valid Rating rating,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            log.error("Validation failed for rating item." + rating.getId());
            return "rating/update";
        }
        rating.setId(id);
        ratingRepository.save(rating);
        log.info("Update success for rating item.");
        model.addAttribute("ratings", ratingRepository.findAll());
        return "redirect:/rating/list";
    }

    @GetMapping("/rating/delete/{id}")
    public String deleteRating(@PathVariable("id") Integer id, Model model) {
        Rating rating = ratingRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        ratingRepository.delete(rating);
        log.info("Delete rating item.");
        model.addAttribute("ratings", ratingRepository.findAll());
        return "redirect:/rating/list";
    }
}
