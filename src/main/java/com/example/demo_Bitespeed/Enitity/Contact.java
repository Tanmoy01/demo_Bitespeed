package com.example.demo_Bitespeed.Enitity;

import lombok.Data;
import java.util.List;
@Data
public class Contact {
        private int primaryContatctId;
        private List<String> emails;
        private List<String> phoneNumbers;
        private List<Integer> secondaryContactIds;
    }

