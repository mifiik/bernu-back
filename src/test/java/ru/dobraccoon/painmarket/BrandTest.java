package ru.dobraccoon.painmarket;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.dobraccoon.painmarket.brands.Brand;
import ru.dobraccoon.painmarket.brands.BrandService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BrandTest {

    @Autowired
    private BrandService brandService;
    private Set<Long> idsForDelete = new HashSet<>();

    @AfterAll
    public void cleanTestData() {
        for (Long iterId : idsForDelete) {
            brandService.deleteById(iterId);
        }
    }

    @Test
    public void createTest() {
        Brand createdBrand = brandService.create(new Brand(
                null,
                "testImageUrl",
                "testName"
        ));
        idsForDelete.add(createdBrand.getId());

        Assertions.assertNotNull(createdBrand);
        Assertions.assertNotNull(brandService.loadById(createdBrand.getId()));
    }

    @Test
    public void loadByNameSubStrTest() {
        Brand brand1 = brandService.create(new Brand(
                null,
                "testImage2",
                "qwerty1"
        ));
        idsForDelete.add(brand1.getId());

        Brand brand2 = brandService.create(new Brand(
                null,
                "testImage3",
                "qwerty2"
        ));
        idsForDelete.add(brand2.getId());

        List<Brand> loadBrandsList = brandService.loadByNameSubStr("qwerty");

        Assertions.assertNotNull(loadBrandsList);
        Assertions.assertEquals(2, loadBrandsList.size());

    }
}
