//package com.ureca.sole_paradise.community.controller;
//
//import java.util.List;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
////import io.bootify.back_end01.model.CommunityDTO;
////import io.bootify.back_end01.service.CommunityService;
////import io.bootify.back_end01.util.ReferencedException;
////import io.bootify.back_end01.util.ReferencedWarning;
////import io.swagger.v3.oas.annotations.responses.ApiResponse;
////import jakarta.validation.Valid;
//
//@RestController
//@RequestMapping(value = "/api/communities", produces = MediaType.APPLICATION_JSON_VALUE)
//public class CommunityController {
//
//	
//	 private final CommunityService communityService;
//
//	    public CommunityResource(final CommunityService communityService) {
//	        this.communityService = communityService;
//	    }
//
//	    @GetMapping
//	    public ResponseEntity<List<CommunityDTO>> getAllCommunities() {
//	        return ResponseEntity.ok(communityService.findAll());
//	    }
//
//	    @GetMapping("/{postId}")
//	    public ResponseEntity<CommunityDTO> getCommunity(
//	            @PathVariable(name = "postId") final Integer postId) {
//	        return ResponseEntity.ok(communityService.get(postId));
//	    }
//
//	    @PostMapping
//	    @ApiResponse(responseCode = "201")
//	    public ResponseEntity<Integer> createCommunity(
//	            @RequestBody @Valid final CommunityDTO communityDTO) {
//	        final Integer createdPostId = communityService.create(communityDTO);
//	        return new ResponseEntity<>(createdPostId, HttpStatus.CREATED);
//	    }
//
//	    @PutMapping("/{postId}")
//	    public ResponseEntity<Integer> updateCommunity(
//	            @PathVariable(name = "postId") final Integer postId,
//	            @RequestBody @Valid final CommunityDTO communityDTO) {
//	        communityService.update(postId, communityDTO);
//	        return ResponseEntity.ok(postId);
//	    }
//
//	    @DeleteMapping("/{postId}")
//	    @ApiResponse(responseCode = "204")
//	    public ResponseEntity<Void> deleteCommunity(
//	            @PathVariable(name = "postId") final Integer postId) {
//	        final ReferencedWarning referencedWarning = communityService.getReferencedWarning(postId);
//	        if (referencedWarning != null) {
//	            throw new ReferencedException(referencedWarning);
//	        }
//	        communityService.delete(postId);
//	        return ResponseEntity.noContent().build();
//	    }
//
//	
//}
