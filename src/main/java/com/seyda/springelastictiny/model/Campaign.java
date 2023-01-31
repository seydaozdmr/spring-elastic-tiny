package com.seyda.springelastictiny.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

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
    @Field(name = "name",type = FieldType.Keyword)
    private String name;
    @Field(name="details",type = FieldType.Keyword)
    private String details;
    @Field(type =FieldType.Date,format = DateFormat.basic_date_time)
    private Date startDate;
    @Field(type = FieldType.Date,format = DateFormat.basic_date_time)
    private Date endDate;
}
