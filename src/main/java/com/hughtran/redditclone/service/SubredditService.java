package com.hughtran.redditclone.service;

import com.hughtran.redditclone.dto.SubredditDto;
import com.hughtran.redditclone.exceptions.SubredditNotFoundException;
import com.hughtran.redditclone.mapper.SubredditMapper;
import com.hughtran.redditclone.model.Subreddit;
import com.hughtran.redditclone.repository.SubredditRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubredditService {

    private final SubredditRepository subredditRepository;
    private final SubredditMapper subredditMapper;

    @Transactional
    public SubredditDto save(SubredditDto subredditDto) {
        Subreddit save = subredditRepository.save(subredditMapper.mapDtoToSubreddit(subredditDto));
        subredditDto.setId(save.getId());
        return subredditDto;
    }

    @Transactional
    public List<SubredditDto> getAll(){
        return subredditRepository
                .findAll()
                .stream()
                .map(subredditMapper::mapSubredditToDto)
                .collect(Collectors.toList());
    }

    public SubredditDto getSubreddit(Long id){
        Subreddit subreddit = subredditRepository.findById(id)
                .orElseThrow(()->new SubredditNotFoundException("No subreddit found"));
        return subredditMapper.mapSubredditToDto(subreddit);
    }





}
