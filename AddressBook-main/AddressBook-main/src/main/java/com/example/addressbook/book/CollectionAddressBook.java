package com.example.addressbook.book;

import com.example.addressbook.person.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class CollectionAddressBook implements AdressBook{

    private ObservableList<Person> personList = FXCollections.observableArrayList();



    public void print(){
        int number = 0;
        System.out.println();
        for (Person person: personList){
            number++;
            System.out.println(number+") ПІП: "+person.getName()+"; Телефон: "+ person.getPhone());
        }
    }
    public void fillTestData(){
        personList.add(new Person("Yulia", "12231"));
        personList.add(new Person("Oksana", "02365"));
        personList.add(new Person("Petro", "465875"));
        personList.add(new Person("Petro", "465132"));
        personList.add(new Person("Petro", "465234245"));

    }

    public ObservableList<Person> getPersonList() {
        return personList;
    }

    @Override
   public void  add (Person person){

    }
    @Override
    public void  delete(Person person){

    }

    @Override
    public void updata(Person person) {

    }
}
