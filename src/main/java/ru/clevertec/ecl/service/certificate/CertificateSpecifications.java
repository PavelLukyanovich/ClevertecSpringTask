package ru.clevertec.ecl.service.certificate;

import org.springframework.data.jpa.domain.Specification;
import ru.clevertec.ecl.model.dtos.CertificateParamDto;
import ru.clevertec.ecl.model.entities.GiftCertificate;

import java.text.MessageFormat;

public final class CertificateSpecifications {

    public static Specification<GiftCertificate> tagNameContains(CertificateParamDto certificateParamDto) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.join("tagList").get("name"), contains(certificateParamDto.getTagName())));
    }

    public static Specification<GiftCertificate> certNameContains(CertificateParamDto certificateParamDto) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), contains(certificateParamDto.getCertName())));
    }

    public static Specification<GiftCertificate> certDescriptionContains(CertificateParamDto certificateParamDto) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("description"), contains(certificateParamDto.getCertDescription())));
    }

    public static Specification<GiftCertificate> sortDateContainsASC() {
        return (root, query, criteriaBuilder) -> {
            query.orderBy(criteriaBuilder.asc(root.get("createDate")));
            return query.getRestriction();
        };
    }

    public static Specification<GiftCertificate> sortDateContainsDESC() {
        return (root, query, criteriaBuilder) -> {
            query.orderBy(criteriaBuilder.desc(root.get("createDate")));
            return query.getRestriction();
        };
    }

    public static Specification<GiftCertificate> sortNameContainsASC() {
        return (root, query, criteriaBuilder) -> {
            query.orderBy(criteriaBuilder.asc(root.get("name")));
            return query.getRestriction();
        };
    }

    public static Specification<GiftCertificate> sortNameContainsDESC() {
        return (root, query, criteriaBuilder) -> {
            query.orderBy(criteriaBuilder.desc(root.get("name")));
            return query.getRestriction();
        };
    }

    private static String contains(String expression) {
        return MessageFormat.format("%{0}%", expression);
    }
}
