package ru.clevertec.ecl.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.clevertec.ecl.dao.TagDao;

import javax.swing.text.html.HTML;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private static final Logger LOGGER = Logger.getLogger(TagServiceImpl.class.getName());
    private final TagDao tagRepository;
}
