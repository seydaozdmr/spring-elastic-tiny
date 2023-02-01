package com.seyda.springelastictiny.controller;

import com.seyda.springelastictiny.model.Campaign;
import com.seyda.springelastictiny.repository.CampaignRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CampaignController {
    private final CampaignRepository campaignRepository;


    @PostConstruct
    public void init(){
        Campaign campaign=Campaign.builder()
                .name("Uçak kampanyası")
                .details("Yeni uçak alacakları için 0.69 dan 50 yıllık kredi")
                .startDate(new Date())
                .endDate(new Date())
                .build();

        Campaign campaign1=Campaign.builder()
                .name("Uzay mekiği kampanyası")
                .details("Yeni uzay mekiği alacakları için 0.69 dan 50 yıllık kredi")
                .startDate(new Date())
                .endDate(new Date())
                .build();
        Campaign campaign2=Campaign.builder()
                .name("Yat Kampanyası")
                .details("Yeni yat alacakları için 0.69 dan 50 yıllık kredi")
                .startDate(new Date())
                .endDate(new Date())
                .build();

        //campaignRepository.saveAll(List.of(campaign,campaign1,campaign2));

    }

    @GetMapping("/campaign")
    public ResponseEntity<List<Campaign>> findCampaigns(@RequestParam String search){
        return ResponseEntity.ok(campaignRepository.findByNameLike(search));
    }

    @GetMapping("/campaign/all")
    public ResponseEntity<List<Campaign>> findAll(){
        List<Campaign> result = new ArrayList<>();
        campaignRepository.findAll().forEach(result::add);
        return ResponseEntity.ok(result);
    }




}
