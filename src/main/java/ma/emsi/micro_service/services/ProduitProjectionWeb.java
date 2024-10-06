package ma.emsi.micro_service.services;

import ma.emsi.micro_service.entities.Produit;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "web",types = Produit.class)
public interface ProduitProjectionWeb {
    String getName();
    double getPrice();
}
