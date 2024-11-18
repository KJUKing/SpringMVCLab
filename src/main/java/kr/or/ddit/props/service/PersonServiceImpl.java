package kr.or.ddit.props.service;

import kr.or.ddit.props.dao.PersonDAO;
import kr.or.ddit.props.exception.PersonNotFoundException;
import kr.or.ddit.vo.PersonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{

    @Inject
    private PersonDAO dao;

    @Override
    public boolean createPerson(PersonVO person) {
        return dao.insertPerson(person) > 0;
    }

    @Override
    public PersonVO readPerson(String id) throws PersonNotFoundException {
        PersonVO person = dao.selectPerson(id);
        if (person == null)
            throw new PersonNotFoundException(id);
        return person;
    }

    @Override
    public List<PersonVO> readPersonList() {
        return dao.selectPersonList();
    }

    @Override
    public boolean modifyPerson(PersonVO person) {
        return dao.updatePerson(person) > 0;
    }

    @Override
    public boolean removePerson(String id) {
        return dao.deletePerson(id) > 0;
    }
}
