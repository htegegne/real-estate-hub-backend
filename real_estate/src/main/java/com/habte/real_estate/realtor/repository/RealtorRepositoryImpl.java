package com.habte.real_estate.realtor.repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;

import com.habte.real_estate.realtor.model.Realtor;

//@Repository(value="realtorRepository")
public class RealtorRepositoryImpl {
	
}
/*
 * public class RealtorRepositoryImpl implements RealtorRepository {
 * 
 * @Override public void flush() { // TODO Auto-generated method stub
 * 
 * }
 * 
 * @Override public <S extends Realtor> S saveAndFlush(S entity) { // TODO
 * Auto-generated method stub return null; }
 * 
 * @Override public <S extends Realtor> List<S> saveAllAndFlush(Iterable<S>
 * entities) { // TODO Auto-generated method stub return null; }
 * 
 * @Override public void deleteAllInBatch(Iterable<Realtor> entities) { // TODO
 * Auto-generated method stub
 * 
 * }
 * 
 * @Override public void deleteAllByIdInBatch(Iterable<Integer> ids) { // TODO
 * Auto-generated method stub
 * 
 * }
 * 
 * @Override public void deleteAllInBatch() { // TODO Auto-generated method stub
 * 
 * }
 * 
 * @Override public Realtor getOne(Integer id) { // TODO Auto-generated method
 * stub return null; }
 * 
 * @Override public Realtor getById(Integer id) { // TODO Auto-generated method
 * stub return null; }
 * 
 * @Override public Realtor getReferenceById(Integer id) { // TODO
 * Auto-generated method stub return null; }
 * 
 * @Override public <S extends Realtor> List<S> findAll(Example<S> example) { //
 * TODO Auto-generated method stub return null; }
 * 
 * @Override public <S extends Realtor> List<S> findAll(Example<S> example, Sort
 * sort) { // TODO Auto-generated method stub return null; }
 * 
 * @Override public <S extends Realtor> List<S> saveAll(Iterable<S> entities) {
 * // TODO Auto-generated method stub return null; }
 * 
 * @Override public List<Realtor> findAll() { // TODO Auto-generated method stub
 * return null; }
 * 
 * @Override public List<Realtor> findAllById(Iterable<Integer> ids) { // TODO
 * Auto-generated method stub return null; }
 * 
 * @Override public <S extends Realtor> S save(S entity) { // TODO
 * Auto-generated method stub return null; }
 * 
 * @Override public Optional<Realtor> findById(Integer id) { // TODO
 * Auto-generated method stub return Optional.empty(); }
 * 
 * @Override public boolean existsById(Integer id) { // TODO Auto-generated
 * method stub return false; }
 * 
 * @Override public long count() { // TODO Auto-generated method stub return 0;
 * }
 * 
 * @Override public void deleteById(Integer id) { // TODO Auto-generated method
 * stub
 * 
 * }
 * 
 * @Override public void delete(Realtor entity) { // TODO Auto-generated method
 * stub
 * 
 * }
 * 
 * @Override public void deleteAllById(Iterable<? extends Integer> ids) { //
 * TODO Auto-generated method stub
 * 
 * }
 * 
 * @Override public void deleteAll(Iterable<? extends Realtor> entities) { //
 * TODO Auto-generated method stub
 * 
 * }
 * 
 * @Override public void deleteAll() { // TODO Auto-generated method stub
 * 
 * }
 * 
 * @Override public List<Realtor> findAll(Sort sort) { // TODO Auto-generated
 * method stub return null; }
 * 
 * @Override public Page<Realtor> findAll(Pageable pageable) { // TODO
 * Auto-generated method stub return null; }
 * 
 * @Override public <S extends Realtor> Optional<S> findOne(Example<S> example)
 * { // TODO Auto-generated method stub return Optional.empty(); }
 * 
 * @Override public <S extends Realtor> Page<S> findAll(Example<S> example,
 * Pageable pageable) { // TODO Auto-generated method stub return null; }
 * 
 * @Override public <S extends Realtor> long count(Example<S> example) { // TODO
 * Auto-generated method stub return 0; }
 * 
 * @Override public <S extends Realtor> boolean exists(Example<S> example) { //
 * TODO Auto-generated method stub return false; }
 * 
 * @Override public <S extends Realtor, R> R findBy(Example<S> example,
 * Function<FetchableFluentQuery<S>, R> queryFunction) { // TODO Auto-generated
 * method stub return null; }
 * 
 * }
 */