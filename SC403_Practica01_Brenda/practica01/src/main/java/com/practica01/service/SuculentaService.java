package com.practica01.service;

import com.practica01.domain.Suculenta;
import java.util.List;

public interface SuculentaService {

    List<Suculenta> getSuculentas();

    Suculenta getSuculenta(Long idSuculenta);

    void save(Suculenta suculenta);

    void delete(Long idSuculenta);
}
