package ru.dobraccoon.painmarket.brands;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BrandService {
    private final BrandRepository brandRepository;

    public Brand create(Brand newBrand) {
        return brandRepository.create(newBrand);
    }

    public Brand loadById(long brandId) {
        return brandRepository.loadById(brandId);
    }

    public void update(Brand brand) {
        brandRepository.update(brand);
    }

    public void deleteById(long id) {
        brandRepository.deleteById(id);
    }

    public List<Brand> loadByNameSubStr(String nameSubStr) {
        return brandRepository.loadByNameSubStr(nameSubStr);
    }

}
