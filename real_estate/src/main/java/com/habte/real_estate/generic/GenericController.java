/**
 * 
 */
package com.habte.real_estate.generic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author habta
 *
 */
public class GenericController<T, ID> {

//	@Autowired
//   private GenericService<T, ID> genericService;
////	 private final GenericService<T, ID> service;
////
////	    public GenericController(GenericService<T, ID> service) {
////	        this.service = service;
////	    }
//
//	@GetMapping("/all/{entity}")
//    public ResponseEntity<List<T>> getAllEntities(@PathVariable String entity) {
//        try {
//            List<T> entities = genericService.findAll();
//            return ResponseEntity.ok(entities);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    @GetMapping("/{entity}/{id}")
//    public ResponseEntity<T> getEntityById(@PathVariable String entity, @PathVariable ID id) {
//        try {
//            T entityObj = genericService.findById(id);
//            if (entityObj != null) {
//                return ResponseEntity.ok(entityObj);
//            } else {
//                return ResponseEntity.notFound().build();
//            }
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    @PostMapping("/add/{entity}")
//    public ResponseEntity<T> addEntity(@PathVariable String entity, @RequestBody T entityObj) {
//        try {
//            T savedEntity = genericService.save(entityObj);
//            return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    @DeleteMapping("/delete/{entity}/{id}")
//    public ResponseEntity<String> deleteEntity(@PathVariable String entity, @PathVariable ID id) {
//        try {
//            genericService.deleteById(id);
//            return ResponseEntity.ok("Entity deleted successfully");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
}
