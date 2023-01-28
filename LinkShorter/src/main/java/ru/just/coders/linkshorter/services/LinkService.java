package ru.just.coders.linkshorter.services;

import jakarta.transaction.Transactional;
import org.apache.commons.lang.RandomStringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.just.coders.linkshorter.dto.LinkDtoAnonimous;
import ru.just.coders.linkshorter.dto.LinkDtoAuthorized;
import ru.just.coders.linkshorter.errors.LinkDoNotExistException;
import ru.just.coders.linkshorter.models.LinkModel;
import ru.just.coders.linkshorter.repositories.LinkRepository;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
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

    public LinkDtoAnonimous addLink(LinkDtoAuthorized dto){
        LinkModel model = new LinkModel();
        model.setRedirecturl(dto.getRedirecturl());
        do{
            model.setShorturl(RandomStringUtils.randomNumeric(7));
        } while (linkRepository.existsByShorturl(model.getShorturl()));
        model.setOwnertoken(dto.getOwnertoken());
        linkRepository.save(model);
        return convertModelToDtoAnonimous(model);
    }


    public Boolean removeLink(LinkDtoAuthorized dto){
        LinkModel model = linkRepository.findByShorturl(dto.getShorturl());
        if (model == null){
            throw new LinkDoNotExistException();
        }
        linkRepository.delete(model);
        return true;
    }



    public List<LinkDtoAnonimous> getlinks(LinkDtoAuthorized dtoAuthorized){
        List<LinkModel> models = linkRepository.findAllByOwnertoken(dtoAuthorized.getOwnertoken());
        List<LinkDtoAnonimous> dtos = new ArrayList<>();
        for(LinkModel model: models){
            dtos.add(convertModelToDtoAnonimous(model));
        }
        return dtos;
    }

    public LinkDtoAnonimous getLongUrl(LinkDtoAnonimous dto){
        LinkModel model = linkRepository.findByShorturl(dto.getShorturl());
        if (model == null){
            model = new LinkModel();
        }
        return convertModelToDtoAnonimous(model);
    }


    public LinkDtoAnonimous convertModelToDtoAnonimous(LinkModel model){
        return modelMapper.map(model, LinkDtoAnonimous.class);
    }
}
