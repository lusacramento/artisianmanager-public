package br.com.artisianmanager.artisianmanager.service;

import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public interface UtilsService {

    String getNewDate();

    OffsetDateTime dateParseString(String date);

}

