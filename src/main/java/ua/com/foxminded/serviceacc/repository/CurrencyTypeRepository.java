package ua.com.foxminded.serviceacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.foxminded.serviceacc.model.CurrencyType;

public interface CurrencyTypeRepository extends JpaRepository<CurrencyType, Long>{
    CurrencyType findOneByTitle(String currencyName);
}

