package kr.or.ddit.props.dao;

import kr.or.ddit.vo.PersonVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Persistence Layer에 대한 접근 방법의 추상화
 * Create
 * Read
 * Update
 * Delete
 */
@Mapper
public interface PersonDAO {

    /**
     * 새로운 person 등록
     * @param person
     * @return 등록된 person 수
     */
    public int insertPerson(PersonVO person);


    /**
     * 하나의 person 조회
     * @param id : 식별자
     * @return 존재하지 않다면 null 반환
     */
    public PersonVO selectPerson(String id);

    /**
     * 전체 person 조회
     * @return 데이터가 없더라도 empty list 반환 null은안줌
     */
    public List<PersonVO> selectPersonList();

    /**
     * 하나의 person 수정
     * @param person 수정할 대상
     * @return 수정된 person수
     */
    public int updatePerson(PersonVO person);

    /**
     * 하나의 person 삭제
     * @param id 삭제할 person 식별자
     * @return 삭제된 person의 수
     */
    public int deletePerson(String id);
}
