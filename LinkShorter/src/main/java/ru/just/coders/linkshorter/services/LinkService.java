package ru.just.coders.linkshorter.services;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Link;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.just.coders.linkshorter.dto.LinkDto;
import ru.just.coders.linkshorter.models.LinkModel;
import ru.just.coders.linkshorter.repositories.LinkRepository;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
@Transactional
public class LinkService {

    private final LinkRepository linkRepository;

    private MessageDigest md = MessageDigest.getInstance("SHA-256");
    private final ModelMapper modelMapper;
    public LinkService(LinkRepository linkRepository, ModelMapper modelMapper) throws NoSuchAlgorithmException {
        this.modelMapper = modelMapper;
        this.linkRepository = linkRepository;
    }

    public LinkDto addLink(LinkDto dto){
        LinkModel model = new LinkModel();
        model.setRedirect_url(dto.getRedirect_url());

        linkRepository.save(model);
        return convertModelToDto(model);
    }



    public LinkDto convertModelToDto(LinkModel model){
        return modelMapper.map(model, LinkDto.class);
    }
}
