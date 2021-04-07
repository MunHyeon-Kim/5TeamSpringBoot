package org.cnu.realcoding.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Dog {
    private String name;
    private String kind;
    private String owenerName;
    private String owenerPhoneNumber;
    private List<String> medicalRecords;
    private int age;
}


