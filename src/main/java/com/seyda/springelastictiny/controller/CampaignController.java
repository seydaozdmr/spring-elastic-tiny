package com.seyda.springelastictiny.controller;

import com.seyda.springelastictiny.model.Campaign;
import com.seyda.springelastictiny.repository.CampaignRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
                .startDate("01-01-1023")
                .endDate("01-01-2051")
                .build();

        Campaign campaign1=Campaign.builder()
                .name("Uzay mekiği kampanyası")
                .details("Yeni uzay mekiği alacakları için 0.69 dan 50 yıllık kredi")
                .startDate("01-01-1023")
                .endDate("01-01-2051")
                .build();
        Campaign campaign2=Campaign.builder()
                .name("Yat Kampanyası")
                .details("Yeni yat alacakları için 0.69 dan 50 yıllık kredi")
                .startDate("01-01-1023")
                .endDate("01-01-2051")
                .build();

        //campaignRepository.saveAll(List.of(campaign,campaign1,campaign2));

    }

    @GetMapping("/campaign/{search}")
    public ResponseEntity<List<Campaign>> findCampaigns(@PathVariable String search){
        return ResponseEntity.ok(campaignRepository.searchByCustomQuery(search));
    }


}
