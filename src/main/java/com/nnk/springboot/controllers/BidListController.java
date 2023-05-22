package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
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
public class BidListController {
    @Autowired
    private BidListRepository bidListRepository;

    @RequestMapping("/bidList/list")
    public String home(Model model)
    {
        model.addAttribute("bidList", bidListRepository.findAll());
        log.info("List of bid items.");
        return "bidList/list";
    }

    @GetMapping("/bidList/add")
    public String addBidForm(BidList bid) {
        return "bidList/add";
    }

    @PostMapping("/bidList/validate")
    public String validate(@Valid BidList bid, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            bidListRepository.save(bid);
            model.addAttribute("bids", bidListRepository.findAll());
            log.info("Creation success, return bid list items.");
            return "redirect:/bidList/list";
        }
        log.error("Creation failed for bid item." + bid.getBidListId());
        return "bidList/add";
    }

    @GetMapping("/bidList/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        BidList bid = bidListRepository.findById(id).orElseThrow(() -> new IllegalArgumentException ("Invalid bidList Id:" + id));
        model.addAttribute("bid", bid);
        return "bidList/update";
    }

    @PostMapping("/bidList/update/{id}")
    public String updateBid(@PathVariable("id") Integer id, @Valid BidList bid,
                            BindingResult result, Model model) {
        if (result.hasErrors()) {
            log.error("Validation failed for bid item." + bid.getBidListId());
            return "bidList/update";
        }
        bid.setBidListId(id);
        bidListRepository.save(bid);
        log.info("Update success for bid item.");
        model.addAttribute("bids", bidListRepository.findAll());
        return "redirect:/bidList/list";
    }

    @GetMapping("/bidList/delete/{id}")
    public String deleteBid(@PathVariable("id") Integer id, Model model) {
        BidList bid = bidListRepository.findById(id).orElseThrow(()  -> new IllegalArgumentException("Invalid user Id:" + id));
        bidListRepository.delete(bid);
        log.info("Delete bid item.");
        model.addAttribute("bids", bidListRepository.findAll());
        return "redirect:/bidList/list";
    }
}
