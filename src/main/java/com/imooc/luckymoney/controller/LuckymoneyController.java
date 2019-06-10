package com.imooc.luckymoney.controller;

import com.imooc.luckymoney.entity.Luckymoney;
import com.imooc.luckymoney.repository.LuckymoneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class LuckymoneyController {

    @Autowired
    private LuckymoneyRepository luckymoneyRepository;

    /*
    创建红包
     */
    @PostMapping("/luckymoneys")
    public Luckymoney create(@RequestParam("producer") final String producer,
                             @RequestParam("money") final BigDecimal money) {
        Luckymoney luckymoney = new Luckymoney();
        luckymoney.setProducer(producer);
        luckymoney.setMoney(money);
        luckymoneyRepository.save(luckymoney);
        return luckymoney;
    }

    /*
    查询红包
     */
    @GetMapping("/luckymoneys")
    public List<Luckymoney> list() {
        return luckymoneyRepository.findAll();
    }

    /*
    通过id查询红包
     */
    @GetMapping("/luckymoneys/{id}")
    public Luckymoney findById(@PathVariable("id") final Integer id) {
        return luckymoneyRepository.findById(id).orElse(null);
    }

    /*
    接收红包
     */

    @PutMapping("/luckymoneys/{id}")
    public Luckymoney update(@PathVariable("id") final Integer id,
                             @RequestParam("consumer") final String consumer) {
        Optional<Luckymoney> byId = luckymoneyRepository.findById(id);

        if (byId.isPresent()) {
            Luckymoney luckymoney = byId.get();
            luckymoney.setConsumer(consumer);
            return luckymoneyRepository.save(luckymoney);
        }

        return null;
    }
}
