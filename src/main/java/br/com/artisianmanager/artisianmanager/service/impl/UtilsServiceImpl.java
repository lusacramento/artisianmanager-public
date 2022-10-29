package br.com.artisianmanager.artisianmanager.service.impl;

import br.com.artisianmanager.artisianmanager.service.UtilsService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class UtilsServiceImpl implements UtilsService {

    String datePattern = "dd-MM-yyyy HH:mm:ss";

    @Override
    public String formatDate(LocalDateTime date) {
        return date.format(DateTimeFormatter.ofPattern(datePattern)).toString();
    }

    @Override
    public String getDate() {
        LocalDateTime date =  LocalDateTime.now();
        String dateString = formatDate(date);
        return dateString;
    }

    @Override
    public boolean verifyNullField(String string) {
        if(string == null || string == "")
            return true;
        return false;
    }
}
