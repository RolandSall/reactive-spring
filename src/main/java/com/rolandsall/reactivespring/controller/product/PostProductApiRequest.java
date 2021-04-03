package com.rolandsall.reactivespring.controller.product;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostProductApiRequest {
    private String name;
    private String description;
}
