package com.practica01.service;

import com.practica01.domain.Suculenta;
import com.practica01.repository.SuculentaRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SuculentaServiceImpl implements SuculentaService {

    private final SuculentaRepository suculentaRepository;

    public SuculentaServiceImpl(SuculentaRepository suculentaRepository) {
        this.suculentaRepository = suculentaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Suculenta> getSuculentas() {
        return suculentaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Suculenta getSuculenta(Long idSuculenta) {
        return suculentaRepository.findById(idSuculenta).orElse(null);
    }

    @Override
    @Transactional
    public void save(Suculenta suculenta) {
        suculentaRepository.save(suculenta);
    }

    @Override
    @Transactional
    public void delete(Long idSuculenta) {
        suculentaRepository.deleteById(idSuculenta);
    }
}
