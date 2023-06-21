/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bokrecension.BookRecension;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(RecensionRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(
              new Recension("Stenbitsfloden",
                      "Vacker utdragen men ganska fuktig",
                      "Gurgel Midsommar")));
      log.info("Preloading " + repository.save(
              new Recension("Argbigan",
                      "Emotionellt upprivande",
                      "Stefan Klas")));
    };
  }
}
