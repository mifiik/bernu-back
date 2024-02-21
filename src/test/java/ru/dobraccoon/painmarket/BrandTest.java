package ru.dobraccoon.painmarket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.dobraccoon.painmarket.brands.Brand;
import ru.dobraccoon.painmarket.brands.BrandService;

import java.util.List;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BrandTest {
    @Autowired

    private BrandService brandService;

    private Brand createdBrand;

    @Test
    public void createTest() {
        createdBrand = brandService.create(new Brand(
                null,
                "testImageUrl",
                "testName"
        ));

        Assertions.assertNotNull(createdBrand);
        Assertions.assertNotNull(brandService.loadById(createdBrand.getId()));
        brandService.deleteById(createdBrand.getId());
    }

    @Test
    public void loadByNameSubStrTest() {
        Brand brand1 = brandService.create(new Brand(
                null,
                "testImage2",
                "qwerty1"
        ));

        Brand brand2 = brandService.create(new Brand(
                null,
                "testImage3",
                "qwerty2"
        ));
        List<Brand> loadBrandsList = brandService.loadByNameSubStr("qwerty");

        Assertions.assertNotNull(loadBrandsList);
        Assertions.assertEquals(2, loadBrandsList.size());

        brandService.deleteById(brand1.getId());
        brandService.deleteById(brand2.getId());
    }
}
