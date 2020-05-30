package com.sudria.demo;

import com.sudria.demo.infrastructure.CarEntity;
import com.sudria.demo.infrastructure.GarageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@SpringBootApplication
@EnableScheduling
public class DemoApplication implements CommandLineRunner {

  @Autowired
  private GarageRepository garageRepository;

  public DemoApplication(GarageRepository garageRepository) {
    this.garageRepository = garageRepository;
  }

  public static void main(String[] args) {

    SpringApplication.run(DemoApplication.class, args);
    System.out.println("Hello SUDRIA !");
  }

  @Override
  public void run(String... args) {

    log.info("Data initilisation...");
    saveCar(1, "Volkswagen", "Polo", "Compacte", "Jean ISIUL");
    saveCar(2, "Volkswagen", "Passat", "Berline", "Matthieu TEVLAC");
    saveCar(3, "Tesla", "X", "Electrique", "Yannick HAON");
    saveCar(4, "Opel", "Cargo L1", "Utilitaire", "François NONGIP");
    saveCar(5, "Renault", "Zoe", "Electrique", "Yannick HAON");
    saveCar(6, "Lexus", "IS 300h", "Berline","Matthieu TEVLAC");
    saveCar(7, "Skoda", "Octavia", "SUV", "Danny OTIVED");
    saveCar(8, "Fiat", "Doblo", "Utilitaire", "François NONGIP");
    saveCar(9, "Nissan", "Micra", "Compacte", "Jean ISIUL");
    saveCar(10, "BMW", "i3", "Electrique", "Yannick HAON");
    saveCar(11, "Toyota", "C-HR", "SUV", "Danny OTIVED");
    saveCar(12, "Nissan", "Acenta", "Berline", "Matthieu TEVLAC");
    saveCar(13, "Renault", "Kangoo", "Monospace", "Roberto SOLRAC");
    saveCar(14, "Dacia", "Duster", "SUV", "Danny OTIVED");
    saveCar(15, "Citroën", "C4", "Compacte", "Jean ISIUL");
    saveCar(16, "Nissan", "X-Trail", "Monospace", "Roberto SOLRAC");
    saveCar(17, "Peugeot", "3008", "Monospace", "Roberto SOLRAC");
    saveCar(18, "Citroën", "Nemo", "Utilitaire", "François NONGIP");
  }

  private void saveCar(long id, String marque, String modele, String categorie, String superviseur) {
    this.garageRepository.save(
        CarEntity
            .builder()
            .id(id)
            .marque(marque)
            .modele(modele)
            .categorie(categorie)
            .superviseur(superviseur)
            .build());
  }

}
