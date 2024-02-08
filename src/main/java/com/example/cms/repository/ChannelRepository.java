package com.example.cms.repository;

import com.example.cms.model.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {

    // SELECT * FROM channal WHERE title=?
    Channel findChannelByTitle(String title);

}
