package com.team6.hanghaesisters.repository;

import com.team6.hanghaesisters.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
