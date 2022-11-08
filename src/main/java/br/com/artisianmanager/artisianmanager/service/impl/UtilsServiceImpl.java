package br.com.artisianmanager.artisianmanager.service.impl;

import br.com.artisianmanager.artisianmanager.service.UtilsService;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class UtilsServiceImpl implements UtilsService {


    @Override
    public String getNewDate() {
        return OffsetDateTime.now().toString();
    }

    @Override
    public OffsetDateTime dateParseString(String date) {
        return OffsetDateTime.parse(date);
    }
}
