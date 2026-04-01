package com.cg.demo.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.demo.entity.Track;
import com.cg.demo.repo.TrackRepository;


@RestController
@RequestMapping("/tracks")
public class TrackController {

	@Autowired
	private TrackRepository repo;
	
	@PostMapping
	public ResponseEntity<String>addTrack(@RequestBody Track track){
		repo.save(track);
		return new ResponseEntity<>("Track added successfully", HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<List<Track>> getTracks() {
      List<Track> list = repo.findAll();

      if (list.isEmpty()) {
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(list, HttpStatus.OK);
  }
	
	@GetMapping("/byTitle")
  public ResponseEntity<List<Track>> getTracksByTitle(@RequestParam("title") String title) {
      List<Track> list = repo.findByTitle(title);

      if (list.isEmpty()) {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }

      return new ResponseEntity<>(list, HttpStatus.OK);
  }
	
	@GetMapping("/{id}")
	public ResponseEntity<Object>getTrack(Long id){
		Optional<Track> track = repo.findById(id);
		
		      if (track.isPresent()) {
		          return new ResponseEntity<>(track.get(), HttpStatus.OK);
		      } else {
		          return new ResponseEntity<>("Track not found", HttpStatus.NOT_FOUND);
		      }
	}
	
}