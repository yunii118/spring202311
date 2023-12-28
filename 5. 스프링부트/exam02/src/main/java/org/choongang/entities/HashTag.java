package org.choongang.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class HashTag {
    @Id
    private String tag;

    @ManyToMany(mappedBy = "tags", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<BoardData> items = new ArrayList<>();
}
