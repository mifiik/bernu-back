package ru.dobraccoon.painmarket.brands;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("brand")
public class BrandController {
    private final BrandService brandService;

    @PostMapping
    public Brand create(@RequestBody Brand newBrand) {
        return brandService.create(newBrand);
    }

    @GetMapping("{brandId}")
    public Brand loadById(@PathVariable long brandId) {
        return brandService.loadById(brandId);
    }

    @PutMapping
    public void update(@RequestBody Brand brand) {
        brandService.update(brand);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable long id) {
        brandService.deleteById(id);
    }

    @GetMapping("/by-name-sub-str/{nameSubStr}")
    public List<Brand> loadByNameSubStr(@PathVariable String nameSubStr) {
        return brandService.loadByNameSubStr(nameSubStr);
    }

}
