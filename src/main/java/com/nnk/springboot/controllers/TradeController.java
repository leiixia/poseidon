package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
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
public class TradeController {
    @Autowired
    private TradeRepository tradeRepository;

    @RequestMapping("/trade/list")
    public String home(Model model)
    {
        model.addAttribute("trade", tradeRepository.findAll());
        log.info("List of trade items.");
        return "trade/list";
    }

    @GetMapping("/trade/add")
    public String addUser(Trade trade) {

        return "trade/add";
    }

    @PostMapping("/trade/validate")
    public String validate(@Valid Trade trade, BindingResult result, Model model) {
        if (result.hasErrors()) {
            log.error("Creation failed for trade item." + trade.getTradeId());
            return "redirect:/trade/list";
        }
        tradeRepository.save(trade);
        model.addAttribute("trade", tradeRepository.findAll());
        log.info("Creation success, return trade list items.");
        return "trade/list";
    }

    @GetMapping("/trade/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Trade trade = tradeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("trade", trade);
        return "trade/update";
    }

    @PostMapping("/trade/update/{id}")
    public String updateTrade(@PathVariable("id") Integer id, @Valid Trade trade,
                              BindingResult result, Model model) {
        if (result.hasErrors()) {
            log.error("Validation failed for trade item." + trade.getTradeId());
            return "trade/update";
        }
        trade.setTradeId(id);
        tradeRepository.save(trade);
        log.info("Update success for trade item.");
        model.addAttribute("trades", tradeRepository.findAll());
        return "redirect:/trade/list";
    }

    @GetMapping("/trade/delete/{id}")
    public String deleteTrade(@PathVariable("id") Integer id, Model model) {
        Trade trade = tradeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        tradeRepository.delete(trade);
        log.info("Delete trade item.");
        model.addAttribute("trade", tradeRepository.findAll());
        return "redirect:/trade/list";
    }
}
