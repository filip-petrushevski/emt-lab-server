package com.emt.lab.model;

import com.emt.lab.enums.BookCategory;
import com.emt.lab.exception.BadRequestException;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private BookCategory bookCategory;

    @ManyToOne
    private Author author;

    private Integer availableCopies;

    public void decreaseCopies() {
        if (availableCopies > 0) {
            this.availableCopies--;
        } else {
            throw new BadRequestException("No more available copies");
        }
    }
}
