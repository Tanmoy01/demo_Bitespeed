package com.example.demo_Bitespeed.Service;

import com.example.demo_Bitespeed.Enitity.Contact;
import com.example.demo_Bitespeed.Enitity.Dto;
import com.example.demo_Bitespeed.Enitity.Model;
import com.example.demo_Bitespeed.Enitity.ResponseDto;
import com.example.demo_Bitespeed.Enum.value;
import com.example.demo_Bitespeed.Repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataService {

    @Autowired
    DataRepository dataRepository;

    public String createData(Dto dto){
        Model newEntry = new Model();
        newEntry.setEmail(dto.getEmail());

        newEntry.setPhoneNumber(dto.getPhoneNumber());

        Model model = findphoneNo(dto.getPhoneNumber());
        Model model1 = findEmailId(dto.getEmail());

        if (model != null) {
            newEntry.setLinkPrecedence(String.valueOf(value.secondarary));
            newEntry.setLinkedId(String.valueOf(model.getId()));
        } else if (model1 != null) {
            newEntry.setLinkPrecedence(String.valueOf(value.secondarary));
            newEntry.setLinkedId(String.valueOf(model1.getId()));
        } else {
            newEntry.setLinkPrecedence(String.valueOf(value.primary));
        }
        dataRepository.save(newEntry);

        return "Saved Successful";
    }

    public ResponseDto identifyDto(Dto dto){
        Contact contact = new Contact();

        Model model = findphoneNo(dto.getPhoneNumber());
        Model model1 = findEmailId(dto.getEmail());

        List<String> emails = new ArrayList<>();
        List<String> phoneNo = new ArrayList<>();

        if (model != null) {
            if (!emails.contains(model.getEmail()))
                emails.add(model.getEmail());
            if (!phoneNo.contains(model.getPhoneNumber()))
                phoneNo.add(model.getPhoneNumber());
        }
        if (model1 != null) {
            if (!emails.contains(model1.getEmail()))
                emails.add(model1.getEmail());
            if (!phoneNo.contains(model1.getPhoneNumber()))
                phoneNo.add(model1.getPhoneNumber());

        }
        contact.setEmails(emails);
        contact.setPhoneNumbers(phoneNo);
        List<Integer> secondaryContact = new ArrayList<>();

        if (model.getId() < model1.getId()) {
            secondaryContact.add(model1.getId());
            contact.setSecondaryContactIds(secondaryContact);
            contact.setPrimaryContatctId(model.getId());
        } else {
            secondaryContact.add(model.getId());
            contact.setSecondaryContactIds(secondaryContact);
            contact.setPrimaryContatctId(model1.getId());
        }
        ResponseDto responseDto = new ResponseDto();
        responseDto.setContact(contact);

        return responseDto;
    }

    public Model findphoneNo(String phoneNo){
        Model model = dataRepository.findByPhoneNumber(phoneNo);
        return model;
    }

    public Model findEmailId(String email){
        Model model = dataRepository.findByEmail(email);
        return model;
    }
}
