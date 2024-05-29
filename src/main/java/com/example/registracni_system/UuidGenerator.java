package com.example.registracni_system;
import org.springframework.stereotype.Service;


import java.util.UUID;
@Service
public class UuidGenerator {
    public UUID generateUuid(){
        UUID uuid = UUID.randomUUID();


        return uuid;
    }

}