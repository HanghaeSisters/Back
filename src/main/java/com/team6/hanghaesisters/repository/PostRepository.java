package com.team6.hanghaesisters.repository;

import com.team6.hanghaesisters.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findByIdAndUsername(Long id, String username);
    void deleteByIdAndUsername(Long id, String username);

    List<Post> findByCategory(String category);
}
