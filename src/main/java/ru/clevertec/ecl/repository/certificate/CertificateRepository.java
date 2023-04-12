package ru.clevertec.ecl.repository.certificate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.clevertec.ecl.model.entities.GiftCertificate;

import java.util.List;

@Repository
public interface CertificateRepository extends JpaRepository<GiftCertificate, Long> {

    List<GiftCertificate> findAllByNameOrDescription(String name, String description);

}
