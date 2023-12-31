package com.hughtran.redditclone.repository;


import com.hughtran.redditclone.model.Post;
import com.hughtran.redditclone.model.User;
import com.hughtran.redditclone.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
    Optional<Vote> findTopByPostAndUserOrderByVoteIdDesc(Post post, User currentUser);
}
