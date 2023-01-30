package com.seyda.springelastictiny.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "campaigns")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Campaign {
    @Id
    private String id;
    @Field(name = "name",type = FieldType.Text)
    private String name;
    @Field
    private String details;
    @Field
    private String startDate;
    @Field
    private String endDate;
}
