package com.seyda.springelastictiny.repository;

import com.seyda.springelastictiny.model.Campaign;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignRepository extends ElasticsearchRepository<Campaign,String> {

    @Query("{\"bool\": {\"must\": [{\"match\": {\"name\": \"?0\"}}]}}")
    List<Campaign> searchByCustomQuery(String searchKey);
}
