package br.com.artisianmanager.artisianmanager.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public interface UtilsService {

    public String formatDate(LocalDateTime date);

    String getDate();

    boolean verifyNullField(String string);
}

