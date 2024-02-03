package com.lerancodewithsankalp.fileoperation.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="ImageData")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImageData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String type;

    @Lob
    @Column(name="imageData")
    private byte[] imageData;

}
