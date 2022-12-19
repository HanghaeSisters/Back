package com.team6.hanghaesisters.repository;

import com.team6.hanghaesisters.entity.Comment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	//postId 로 Comment 와 UserId 정보 가져오기
	@Query("select distinct c from Comment c join fetch c.userId where c.postId = :postId order by c.modifiedAt desc")
	List<Comment> findAllByPostIdWithUser(@Param("postId")Long postId);

	//post 에 붙은 모든 comment 의 id 찾기
	@Query("select c.id from Comment c where c.postId = :postId")
	List<Long> findIdsByPostId(@Param("postId") Long id);

	//해당 commentId 를 가진 comment 삭제
	@Modifying  //update delete 쿼리만 사용
	@Query("delete from Comment c where c.id in :commentId")
	void deleteByCommentId(@Param("commentId") List<Long> id);
}
