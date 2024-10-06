package ma.emsi.micro_service;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.emsi.micro_service.entities.Produit;
import ma.emsi.micro_service.services.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class MicroServiceApplication {


    public static void main(String[] args) {
        SpringApplication.run(MicroServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProduitRepository produitRepository, RepositoryRestConfiguration repositoryRestConfiguration){
        return args -> {
            repositoryRestConfiguration.exposeIdsFor(Produit.class);
            produitRepository.save(new Produit(null,"Ord HP 41",5000,14));
            produitRepository.save(new Produit(null,"Ord HP 51",6000,12));
            produitRepository.save(new Produit(null,"Ord HP 61",8000,10));
            produitRepository.save(new Produit(null,"Ord HP 81",15000,4));
            produitRepository.findAll().forEach(produit -> {
                System.out.println(produit.getName());
            });
        };
    }



}
