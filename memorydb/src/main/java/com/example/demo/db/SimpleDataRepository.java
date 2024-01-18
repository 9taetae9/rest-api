package com.example.demo.db;

import com.example.demo.entity.Entity;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

abstract public class SimpleDataRepository<T extends Entity, ID extends Long> implements DataRepository<T, ID> {
    private List<T> dataList = new ArrayList<>();

    private static long index = 0; //unique한 id

    private Comparator<T> sort = new Comparator<T>() {
        @Override
        public int compare(T o1, T o2) {
            return Long.compare(o1.getId(), o2.getId());
        }
    };
    //create
    public T save(T data){
        if(Objects.isNull(data)){
            throw new RuntimeException("Data is null");
        }

        //db에 데이터가 있는가?
        var prevData = dataList.stream()
                .filter(it -> {
                   return it.getId().equals(data.getId()); //동일한 id
                }).findFirst();

        if(prevData.isPresent()){
            //기존 데이터 있는 경우
            //Optional<USerEntity>
            dataList.remove(prevData.get());
            dataList.add(data); //기존 데이터는 지우고 새데이터 삽입. id는 동일
        }else{
            //없는 경우
            index++;
            data.setId(index);
            dataList.add(data);
        }

        return data;
    }

    //read
    @Override
    public Optional<T> findById(ID id){
        return dataList.stream()
                .filter(it -> {
                    return it.getId().equals(id);
                })
                .findFirst();
    }

    @Override
    public List<T> findAll(){
        return dataList.stream()
                .sorted(sort)
                .collect(Collectors.toList());
    }


    //delete
    @Override
    public void delete(ID id){
        var deleteEntity = dataList.stream()
                .filter(it -> {
                    return it.getId().equals(id);
                })
                .findFirst();

        if(deleteEntity.isPresent()){
            dataList.remove(deleteEntity.get());
        }
    }
}
