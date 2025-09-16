package org.pcheltas.inf_sec_1.repository;

import org.pcheltas.inf_sec_1.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
