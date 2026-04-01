
package com.cg.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.demo.entity.Track;

public interface TrackRepository extends JpaRepository<Track, Long> {

    List<Track> findByTitle(String title);
}
