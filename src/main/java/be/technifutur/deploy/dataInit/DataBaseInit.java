package be.technifutur.deploy.dataInit;

import be.technifutur.deploy.entity.Flower;
import be.technifutur.deploy.service.FlowerService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataBaseInit implements InitializingBean {

    private final FlowerService flowerService;

    private final List<Flower> flowers = Arrays.asList(
            Flower.builder()
                    .name("Rose")
                    .build(),
            Flower.builder()
                    .name("Tulipe")
                    .build(),
            Flower.builder()
                    .name("Pensée")
                    .build()
    );

    public DataBaseInit(FlowerService flowerService) {
        this.flowerService = flowerService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        flowers.forEach(flowerService::insert);
    }
}
