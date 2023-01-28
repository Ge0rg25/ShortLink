package ru.just.coders.linkshorter.services;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.just.coders.linkshorter.dto.LinkDto;
import ru.just.coders.linkshorter.models.LinkModel;
import ru.just.coders.linkshorter.repositories.LinkRepository;

import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@Service
@Transactional
public class LinkService {

    private final LinkRepository linkRepository;

    private final ModelMapper modelMapper;
    public LinkService(LinkRepository linkRepository, ModelMapper modelMapper) throws NoSuchAlgorithmException {
        this.modelMapper = modelMapper;
        this.linkRepository = linkRepository;
    }

    public LinkDto addLink(LinkDto dto){
        LinkModel model = new LinkModel();
        model.setRedirect_url(dto.getRedirect_url());
        model.setShort_url(UUID.randomUUID().toString());
        linkRepository.save(model);
        return convertModelToDto(model);
    }



    public LinkDto convertModelToDto(LinkModel model){
        return modelMapper.map(model, LinkDto.class);
    }
}
