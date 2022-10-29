package br.com.artisianmanager.artisianmanager.service;

import br.com.artisianmanager.artisianmanager.service.impl.UtilsServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
@RunWith(SpringRunner.class)
class UtilsServiceTest {
    @Autowired
  public UtilsService utilsService;

  @Before
  void setUp(){
      utilsService = new UtilsServiceImpl();
  }

    @Test
    void formatDate() {
      setUp();
      LocalDateTime unformatedDate = LocalDateTime.now();
      String formatedDate = utilsService.formatDate(unformatedDate);
      System.out.printf("Unformated Date: %s%n", unformatedDate);
      System.out.printf("Formated Date %s%n", formatedDate);
    }
}