package com.fastcampus.ch4.dao;

import com.fastcampus.ch4.domain.BoardDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BoardDaoImpl implements BoardDao {
    @Autowired
    SqlSession session;

    String namespace = "com.fastcampus.ch4.dao.BoardMapper.";

//    내가 작성한 SQL문은 주석으로 처리했음 비교해봅시다

    //    @Override
//    public Integer count()throws Exception {
//        return session.selectOne(namespace + "count");
//    }
    @Override
    public int count() throws Exception {
        return session.selectOne(namespace + "count");
    }

    //
//    @Override
//    public void deleteAll() throws  Exception {
//        session.selectOne(namespace + "deleteAll");
//    }
    @Override
    public int deleteAll() {
        return session.delete(namespace + "deleteAll");
    }

    //
//    @Override
//    public int delete(Map<Integer, String> map) {
//        return session.selectOne(namespace + "delete" + map);
//    }
    @Override
    public int delete(Integer bno, String writer) throws Exception {
        Map map = new HashMap();
        map.put("bno", bno);
        map.put("writer", writer);
        return session.delete(namespace + "delete", map);
    }

    //
//    @Override
//    public int insert(BoardDto dto) {
//        return session.selectOne(namespace + "insert" + dto);
//    }
    @Override
    public int insert(BoardDto dto) throws Exception {
        return session.insert(namespace + "insert", dto);
    }

    //
//    @Override
//    public BoardDto selectAll()throws Exception {
//        return session.selectOne(namespace + "selectAll");
//    }
    @Override
    public List<BoardDto> selectAll() throws Exception {
        return session.selectList(namespace + "selectAll");
    }

    //    @Override
//    public BoardDto select(int bno) throws Exception {
//        return session.selectOne(namespace+"select", bno);
//    }
    @Override
    public BoardDto select(Integer bno) throws Exception {
        return session.selectOne(namespace + "select", bno);
    }

    //
//    @Override
//    public BoardDto selectPage(Map<Date, Integer> map) throws Exception {
//        return session.selectOne(namespace + "selectPage" + map);
//    }
    @Override
    public List<BoardDto> selectPage(Map map) throws Exception {
        return session.selectList(namespace + "selectPage", map);
    }

    //    @Override
//    public int update(BoardDto dto)throws Exception {
//        return session.selectOne(namespace + "update" + dto);
//    }
    @Override
    public int update(BoardDto dto) throws Exception {
        return session.update(namespace + "update", dto);
    }

    //
//    @Override
//    public int increaseViewCnt(Integer bno) throws Exception {
//        return session.selectOne(namespace + "increaseViewCnt" + bno);
//    }
    @Override
    public int increaseViewCno(Integer bno) throws Exception {
        return session.update(namespace + "increaseViewCnt", bno);
    }
//    @Override
//    public BoardDto selectFromBoard() throws Exception {
//        return session.selectOne(namespace + "selectFromBoard");
//    }
//    @Override
//    public int searchResultCnt(SearchCondition sc)throws Exception {
//        System.out.println("sc in searchResultCnt() = " + sc);
//        System.out.println("session = " + session);
//        return session.selectOne(namespace + "searchResultCnt", sc);
//    }
//
//    @Override
//    public List<BoardDto> searchSelectPage(SearchCondition sc)throws Exception {
//        return session.selectList(namespace + "searchSelectPage", sc);
//    }
//
//
//    @Override
//    public int updateCommentCnt(Map<Integer, Integer> map) throws Exception {
//       return session.selectOne(namespace + "updateCommentCnt" + map);
//    }
//


}
